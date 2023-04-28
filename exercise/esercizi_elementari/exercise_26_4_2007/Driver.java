public class Driver {

        public static void main(String[] args) {
                Person a = new Man("Mario", "Rossi");
                Person b = new Woman("Luisa", "Verdi");
                Person c = new Man("Luca", "Rossi");
                Person d = new Woman("Anna", "Rossi");
                Person e = new Woman("Daniela", "Rossi");
                a.marries(b);
                a.addChild(c);
                b.addChild(d);
                c.addChild(e);
                System.out.println(Person.areSiblings(a, b));
                System.out.println(Person.areSiblings(c, d));
        }

}
