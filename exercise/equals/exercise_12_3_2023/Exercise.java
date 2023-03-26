public class Exercise {
    public static void main(String[] args) {
       A a1 = new A(1);
       A a2 = new A(1);
       A a3 = new A(2);
       System.out.println("a1 == a2 => " + a1.equals(a2));
       System.out.println("a2 != a3 => " + a2.equals(a3));

       B b1 = new B(1, 2);
       B b2 = new B(1, 3);
       B b3 = new B(1, 3);
       B b4 = new B(0, 1);
       System.out.println("b1 != b2 => " + b1.equals(b2));
       System.out.println("b2 == b3 => " + b2.equals(b3));

       System.out.println("a1 != b1 => " + b1.equals(a1));
       System.out.println("b2 != a2 => " + b2.equals(a2));
       System.out.println("a2 == b4 => " + a2.equals(b4));
       System.out.println("b4 == a1 => " + b4.equals(a1));

    }
}

class A {
    private int n;

    public A(int n){
        this.n = n;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof A)){
            return false;
        }
        A a = (A) o;
        if (n != a.n) { // A != A
            return false;
        }
        if (getClass() == A.class){ // A with B
            return a.compatibleWithA();
        }
        if (a.getClass() == A.class){ // B with A
           compatibleWithA();
        }
        return true; // A == A
    }

    private boolean compatibleWithA(){
        return true;
    }
}

class B extends A {
    private int m;

    public B(int m, int n){
        super(n);
        this.m = m;
    }

    public boolean equals(Object o){
        if(!super.equals(o)){
            return false;
        }
        if (! (o instanceof B)){
            return true; // A == A
        }
        B b = (B) o;
        return m == b.m;
    }

    private boolean compatibleWithA(){
        return m == 0;
    }
}
