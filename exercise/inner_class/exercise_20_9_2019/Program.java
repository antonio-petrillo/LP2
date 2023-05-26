import java.util.*;

public class Program {
    private List<Action> program;

    private Program() {
        program = new ArrayList<>();
    }

    public static Program make() {
        return new Program();
    }

    public Program on(int power) {
        program.add(m -> m.on(power));
        return this;
    }

    public Program off() {
        program.add(m -> m.off());
        return this;
    }

    public Program delay(int millis) {
        program.add(m -> {
            try {
                System.out.println("Wait for " + millis / 1000 + " seconds");
                Thread.sleep(millis);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        });
        return this;
    }

    public void executeOn(Microwave m) {
        for (Action a : program) {
            a.execute(m);
        }
    }

    @FunctionalInterface
    private interface Action {
        void execute(Microwave m);
    }

    public static void main(String[] args) {
        Program p = Program.make().on(500).delay(10000).on(700).delay(5000).off();
        p.executeOn(new Microwave() {
            @Override
            public void on(int power) {
                System.out.println("Turned on at " + power + " power");
            }

            public void off() {
                System.out.println("Turned off");
            }
        });
    }

}
