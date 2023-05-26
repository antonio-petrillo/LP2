import java.util.*;

public class Program {

    private List<Action> program;

    public static interface Action {
        void action(Washer w);
    }

    public Program() {
        program = new ArrayList<>();
    }

    public static class SetSpeed implements Action {
        private int rpm;

        public SetSpeed(int rpm) {
            this.rpm = rpm;
        }

        @Override
        public void action(Washer w) {
            w.setSpeed(rpm);
        }
    }

    public static class SetTemp implements Action {
        private int temp;

        public SetTemp(int temp) {
            this.temp = temp;
        }

        @Override
        public void action(Washer w) {
            w.setTemp(temp);
        }
    }

    public static class Wait implements Action {
        private int delay;

        public Wait(int delay) {
            this.delay = delay * 1000;
        }

        @Override
        public void action(Washer w) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                return;
            }
        }
    }

    public static class AddSoap implements Action {

        @Override
        public void action(Washer w) {
            w.addSoap();
        }
    }

    public void addAction(Action a) {
        program.add(a);
    }

    public void execute(Washer w) {
        for (var a : program) {
            a.action(w);
        }
    }

    public static void main(String[] args) {
        Washer w = new Washer();
        Program p = new Program();
        p.addAction(new Program.SetTemp(30));
        p.addAction(new Program.SetSpeed(20));
        p.addAction(new Program.Wait(10));
        p.addAction(new Program.AddSoap());
        p.addAction(new Program.SetSpeed(100));
        p.addAction(new Program.Wait(10));
        p.addAction(new Program.SetSpeed(0));
        p.execute(w);
    }

}
