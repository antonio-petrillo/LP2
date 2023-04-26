public class SocialNetwork {

    public static void main(String[] args) {
        Person a = new Person("Antonio");
        Person c = new Person("Cleopatra");
        Person o = new Person("Ottaviano");
        a.addEnemy(o);
        a.addFriend(c);
        for (Person p : a.contacts())
            System.out.println(p);
    }

}
