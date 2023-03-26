public class Exam {

    public static void main(String[] args) {
        double[] a1 = {1, 2, 3};
        double[] a2 = {0, 0, 0, 5};

        Polynomial p1 = new Polynomial(a1);
        Polynomial p2 = new Polynomial(a2);
        Polynomial p3 = new Monomial(3, 5);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p3.equals(p1));
        System.out.println(p3.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p2.equals((Object) p3));
    }

}

class Polynomial {
    private double[] coefficients;

    public Polynomial (double[] coefficients){
        this.coefficients = coefficients;
    }

    @Override
    public boolean equals(Object other){
        if(!(other instanceof Polynomial)){
            return false;
        }
        Polynomial p = (Polynomial) other;
        if(p.coefficients.length != coefficients.length){
            return false;
        }
        for (int i = 0; i < coefficients.length; i++) {
            if (coefficients[i] != p.coefficients[i]){
                return false;
            }
        }
        return true;
    }

    public String toString() {
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < coefficients.length; i++){
           if(coefficients[i] != 0){
               sb.append(coefficients[i]);
               if (i > 0){
                  sb.append(" xˆ" + i + " ");
               }
               if (i != coefficients.length - 1) {
                   sb.append(" + ");
               }
           }
       }
       return sb.toString();
    }

}

class Monomial extends Polynomial {

    public Monomial(int power, double coefficient){
       this(computeCoefficients(power, coefficient));
    }

    private static double[] computeCoefficients(int power, double coefficient){
        double[] c = new double[power + 1];
        c[power] = coefficient;
        return c;
    }

    private Monomial(double[] coefficients){
        super(coefficients);
    }

}
