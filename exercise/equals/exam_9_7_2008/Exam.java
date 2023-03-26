public class Exam {

  public static void main(String[] args) {
      Z a = new Z(3);
      Z b = new Z(4);
      Z c = new Z(4);
      System.out.println("Reflexive => [a,a] : " + a.equals(a));
      System.out.println("Symmetric => [a,b] : " +  a.equals(b) + ", [b,a] : " + b.equals(a));
      System.out.println("Transitive => [a,b] : " +  a.equals(b) + ", [b,c] : " + b.equals(c) + ", implies : [a,c] : " + a.equals(c));
      System.out.println("");
      a = new Z(4, a);
      b = new Z(4, b);
      c = new Z(4, c);
      System.out.println("Reflexive => [a,a] : " + a.equals(a));
      System.out.println("Symmetric => [a,b] : " +  a.equals(b) + ", [b,a] : " + b.equals(a));
      System.out.println("Transitive => [a,b] : " +  a.equals(b) + ", [b,c] : " + b.equals(c) + ", implies : [a,c] : " + a.equals(c));
  }

}

class Z {
    private Z other;
    private int val;

    public Z(int val){
        this.val = val;
    }

    public Z(int val, Z z){
        other = z;
        this.val = val;
    }

    @Override
    public boolean equals(Object o){
        if(o == null) {
            return false;
        }
        if (o.getClass() != getClass()){
           return false;
        }
        Z z = (Z) o;
        if (z.other != null && other != null){
            return z.val == val;
        }
        return z.other == null && other == null;
    }
}
