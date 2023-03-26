import java.util.Objects;

public class Exam {

}

class Student {
    private String nome;
    private long matricola;

    @Override
    public boolean equals(Object o){
       // The criteria a is not valid, the relation is not transitive.
       // The criteria b is valid.
        if (o == null){
            return false;
        }
        if (o.getClass() != getClass()){
            return false;
        }
        Student s = (Student) o;
        return s.matricola % 2 == matricola % 2;
       // The criteria c is not valid, the relation is not symmetric.
       // The criteria d is valid.
        if (o == null){
            return false;
        }
        if (o.getClass() != getClass()){
            return false;
        }
        Student s = (Student) o;
        if (s.nome == null && nome == null){
            return true;
        }
        return s.nome != null && nome != null && s.matricola == matricola;
    }

    // RMB: x == y => x.hashCode() == y.hashCode()
    @Override
    public int hashCode(){
        // b version
        // strange requirement yields to strange hash functions
        return Objects.hashCode(matricola % 2);
        // d version
        if (nome == null){
            return 1;
        } else {
            return Objects.hashCode(matricola);
        }
    }

}
