import java.util.*;
import java.util.stream.*;

public class VoteBox {

    private Integer numOfVoters;
    private Integer votes = 0;

    private Set<Thread> alreadyVoted = new HashSet<>();

    public VoteBox(int numOfVoters) {
        this.numOfVoters = numOfVoters;
    }

    public synchronized void vote(boolean vote) {
        Thread t = Thread.currentThread();
        if (alreadyVoted.contains(t)) {
            throw new RuntimeException(t.getName() + " already voted");
        }
        if (alreadyVoted.size() == numOfVoters) {
            throw new RuntimeException(t.getName() + " all thread already voted");
        }
        alreadyVoted.add(t);
        System.out.println(t.getName() + " just voted");
        if (vote) {
            votes++;
        } else {
            votes--;
        }
        notifyAll();
    }

    public synchronized boolean isDone() {
        return alreadyVoted.size() == numOfVoters;
    }

    // public boolean isDone() {
    // return alreadyVoted.size() == numOfVoters;
    // }

    public synchronized boolean waitForResult() {
        while (!isDone()) {
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                throw new RuntimeException("Interrupted Thread");
            }
        }
        notifyAll();
        return votes > 0;
    }

    public static void main(String[] args) {
        // Random rng = new Random();
        // b.vote(true);
        // System.out.println(b.isDone());
        // b.vote(false);
        System.out.println("press return to start");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        scanner.close();
        runWithNThreads(10);
        runWithNThreads(20);
        runWithNThreads(200);
        runWithNThreads(3000);
        // runWithNThreads(30000);
        // con questo "test" mi é crashata la JVM
        //
        // ho ricontrollato con jconsole e non ha trovato nessun deadlock
        //
        // si blocca circa sui 4000 ~ 4500 thread contemporaneamente attivi
        // A quanto pare la jvm non riesce a creare altri thread
        //
        // Di seguito l'errore risultante
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
        VoteBox b = new VoteBox(n);
        IntStream.range(0, n).forEach((unused) -> {
            new Thread(() -> {
                Random rng = new Random();
                b.vote(rng.nextInt() % 2 == 0);
                System.out.println("Hey " + Thread.currentThread().getName() + " The result is: " + b.waitForResult());
            }).start();
        });
        System.out.println(
                "-------------------------------------\nThe result is: " + b.waitForResult()
                        + "\n---------------------------------");
    }

}
