import java.util.*;

public class CompositeTask {

    private List<Runnable> tasks = new ArrayList<>();

    public void addSequential(Runnable r) {
        tasks.add(r);
    }

    public void addParallel(Runnable... rs) {
        tasks.add(() -> {
            Thread[] ts = new Thread[rs.length];
            for (int i = 0; i < ts.length; i++) {
                ts[i] = new Thread(rs[i]);
                ts[i].start();
            }
            for (int i = 0; i < ts.length; i++) {
                try {
                    ts[i].join();
                } catch (InterruptedException ie) {
                    return;
                }
            }
        });
    }

    public void run() {
        for (var r : tasks)
            r.run();
    }

    public static void main(String[] args) {
        CompositeTask ct = new CompositeTask();
        Random rng = new Random();
        ct.addSequential(() -> {
            System.out.println("Task sequential 1");
        });
        Runnable r = () -> {
            try {
                Thread.sleep(rng.nextInt(100, 1000));
            } catch (InterruptedException ie) {
                return;
            }
            System.out.println("Parallel Task");
        };
        ct.addParallel(r, r, r, r, r, r, r, r);
        ct.addSequential(() -> {
            try {
                Thread.sleep(rng.nextInt(100, 1000));
            } catch (InterruptedException ie) {
                return;
            }
            System.out.println("Task sequential 2");
        });
        ct.addSequential(() -> {
            System.out.println("Task sequential 3");
        });
        ct.run();
    }
}
