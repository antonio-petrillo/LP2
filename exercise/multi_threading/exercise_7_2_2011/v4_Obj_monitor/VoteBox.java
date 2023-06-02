import java.util.*;
import java.util.stream.*;

public class VoteBox {

    private final int numOfVoters;
    private int votes = 0;

    private Set<Thread> alreadyVoted = new HashSet<>();
    private Object monitor = new Object();

    public VoteBox(int numOfVoters) {
        this.numOfVoters = numOfVoters;
    }

    public void vote(boolean vote) {
        synchronized (monitor) {
            Thread t = Thread.currentThread();
            if (alreadyVoted.contains(t)) {
                throw new RuntimeException(t.getName() + " already voted");
            }
            if (alreadyVoted.size() == numOfVoters) {
                throw new RuntimeException(t.getName() + " all threads already voted");
            }
            System.out.println(t.getName() + " just voted");
            if (vote) {
                votes++;
            } else {
                votes--;
            }
            alreadyVoted.add(t);
            monitor.notifyAll();
        }
    }

    public boolean isDone() {
        synchronized (monitor) {
            return alreadyVoted.size() == numOfVoters;
        }
    }

    public boolean waitForResult() throws InterruptedException {
        while (!isDone())
            synchronized (monitor) {
                monitor.wait();
            }
        return votes > 0;
    }

    public static void main(String[] args) {
        // Random rng = new Random();
        // b.vote(true);
        // System.out.println(b.isDone());
        // b.vote(false);
        runWithNThreads(10);
        runWithNThreads(20);
        runWithNThreads(200);
        runWithNThreads(3000);
        runWithNThreads(4000);
        // runWithNThreads(30000);
        // con questo "test" é crashata la JVM
        //
        // ho ricontrollato con jconsole e non ha trovato nessun deadlock
        //
        // si blocca circa sui 4000 ~ 4500 thread contemporaneamente attivi
        // A quanto pare la jvm non riesce a creare altri thread
        //
        // Di seguito l'errore:
        //
        // [25.687s][warning][os,thread] Failed to start thread "Unknown thread" -
        // pthread_create failed (EAGAIN) for attributes: stacksize: 2048k, guardsize:
        // 16k, detached.
        //
        // [25.687s][warning][os,thread] Failed to start the native thread for
        // java.lang.Thread "Thread-4288"
        //
        // Exception in thread "main" java.lang.OutOfMemoryError: unable to create
        // native thread: possibly out of memory or process/resource limits reached
        // at java.base/java.lang.Thread.start0(Native Method)
        // at java.base/java.lang.Thread.start(Thread.java:1535)
        // at VoteBox.lambda$runWithNThreads$1(VoteBox.java:95)
        // at
        // java.base/java.util.stream.Streams$RangeIntSpliterator.forEachRemaining(Streams.java:104)
        // at java.base/java.util.stream.IntPipeline$Head.forEach(IntPipeline.java:617)
        // at VoteBox.runWithNThreads(VoteBox.java:90)
        // at VoteBox.main(VoteBox.java:75)
    }

    public static void runWithNThreads(int n) {
        System.out.println("Test with " + n + " threads");
        Thread[] threads = new Thread[n];
        VoteBox b = new VoteBox(n);
        IntStream.range(0, n).forEach((index) -> {
            threads[index] = new Thread(() -> {
                Random rng = new Random();
                b.vote(rng.nextInt() % 2 == 0);
                try {
                    System.out.println(
                            "Hey " + Thread.currentThread().getName() + " the result is: " + b.waitForResult());
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                    return;
                }
            });
            threads[index].start();
        });
        IntStream.range(0, n).forEach(index -> {
            try {
                threads[index].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        });
        try {
            System.out.println("The final result is : " + b.waitForResult());
        } catch (InterruptedException ie) {
            ie.printStackTrace();
            return;
        }
    }

}
