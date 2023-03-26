public class Exam {

    public static void main(String[] args) {
        Engine a = new Engine(1200, 69);
        Engine b = new Engine(1200, 75);
        Engine c = new Engine(1400, 75);
        System.out.println(a);
        System.out.println(a.equals(b));
        Engine aVol = a.byVolume();
        Engine bVol = b.byVolume();
        System.out.println(aVol);
        System.out.println(aVol.equals(bVol));
        System.out.println(a==aVol);
        Engine bPow = b.byPower();
        Engine cPow = c.byPower();
        System.out.println(bPow);
        System.out.println(bPow.equals(cPow));
    }

}

class Engine {
    private double cilindrata;
    private double cavalli;

    public Engine(double cilindrata, double cavalli){
        this.cilindrata = cilindrata;
        this.cavalli = cavalli;
    }

    @Override
    public String toString() {
        return "(" + cilindrata + " cm3, " + cavalli + " CV)";
    }

    @Override
    public boolean equals(Object other){
        if(other == null){
            return false;
        }
        if(getClass() != other.getClass()){
            return false;
        }
        Engine e = (Engine) other;
        return cilindrata == e.cilindrata && cavalli == e.cavalli;
    }

    public Engine byVolume(){
        return new Engine(cilindrata, cavalli){
            @Override
            public boolean equals(Object other){
                if(other == null){
                    return false;
                }
                if(getClass() != other.getClass()){
                    return false;
                }
                Engine e = (Engine) other;
                return e.cilindrata == cilindrata;
            }

        };
    }

    public Engine byPower(){
        return new Engine(cilindrata, cavalli){
            @Override
            public boolean equals(Object other){
                if(other == null){
                    return false;
                }
                if(getClass() != other.getClass()){
                    return false;
                }
                Engine e = (Engine) other;
                return e.cavalli == cavalli;
            }
        };
    }

}
