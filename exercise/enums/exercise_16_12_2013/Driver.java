public class Driver {

    public static void main(String[] args) {
        Note a = Note.DO;
        System.out.println(a.interval(Note.MI));
        System.out.println(Note.MI.interval(Note.LA));
        System.out.println(Note.LA.interval(Note.SOL));
        System.out.println(Note.LA.interval(Note.LA));
    }

}
