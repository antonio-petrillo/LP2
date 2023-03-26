public class Exam {

}

class Cane {
    private Person padrone;
    private String nome;

    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }
        Cane c = (Cane) other;

        // criteria a, is not valid
        // the relation is not reflexive
        // a dog with an owner is not equal to itself

        // criteria b, is not valid
        // the relation is not transitive

        // criteria c, is valid
        if (nome != null && c.nome != null){
           return nome.length() == c.nome.length();
        }
        return nome == null && c.nome == null;

       // criteria d, is valid
        if (padrone != null && c.padrone != null){
            if (nome == null && c.nome == null){
                return true;
            } else if (nome.length() == 0 && c.nome.length() == 0) {
                return true;
            } else {
                return nome.charAt(0) == c.nome.charAt(0);
            }
        }
        return padrone == null && c.padrone == null;
    }

}
