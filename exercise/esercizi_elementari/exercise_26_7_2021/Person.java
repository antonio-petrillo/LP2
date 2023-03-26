public class Person {

    public String name;
    public boolean firstDoseDone;

    public Person(String name){
        this.name = name;
        firstDoseDone = false;
    }

    public GreenPass vaccinate(int day){
        boolean old = firstDoseDone;
        firstDoseDone = true;
        if (old) {
            return new GreenPass(this, 270, day);
        } else {
            return new GreenPass(this, 180, day);
        }
    }

    public static class GreenPass {

        private int validFor;
        private int vaccineDay;
        private Person owner;

        private GreenPass(Person owner, int validFor, int vaccineDay){
            this.owner = owner;
            this.validFor = validFor;
            this.vaccineDay = vaccineDay;
        }

        public boolean isValidOn(int day){
            return (day >= vaccineDay && day <= vaccineDay + validFor) || (vaccineDay + validFor > 365 && (day <= (vaccineDay + validFor % 365 + 1)));
        }

        public boolean belongsTo(Person p){
            return owner.equals(p);
        }

    }

    public static void main(String[] args) {

        Person aldo = new Person("Aldo");
        Person barbara = new Person("Barbara");
        GreenPass p1 = aldo.vaccinate(10);
        GreenPass p2 = aldo.vaccinate(250);
        System.out.println(p1.isValidOn(20));
        System.out.println(p1.isValidOn(200));
        System.out.println(p1.belongsTo(barbara));
    }

}
