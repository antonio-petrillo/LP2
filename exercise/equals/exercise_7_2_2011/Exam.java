public class Exam {

}

class Op {

    private String nome;
    private short salario;

    public Op (String nome, short salario){
        this.nome = nome;
        this.salario = salario;
    }

    @Override
    public boolean equals(Object other){
        if (other == null){
            return false;
        }
        if (getClass() != other.getClass()){
            return false;
        }

        // criteria a is valid
        Op op = (Op) other;
        return nome.equals(op.nome);

        // criteria b is valid
        if (other == null){
            return false;
        }
        Op op = (Op) other;
        if (getClass() == Op.class){
            op.compatibleWithOp();
        }
        if (op.getClass() == Op.class){
            compatibleWithOp();
        }
        return true;

        // criteria c is valid
        if (!(other instanceof Op)){
            return false;
        }
        Op op = (Op) other;
        return op.salario == salario;

        // criteria d is not valid
        // the specification implies that equals in OpSp is not symmetric and not transitive
    }

    private boolean compatibleWithOp(){
        return true;
    }


}

class OpSP extends Op {

    private Speciality speciality;

    public OpSp(String nome, short salario, Speciality spec){
        super(nome, salario);
        speciality = spec;
    }

    @Override
    public boolean equals(Object other){
        if(!super.equals(other)){
            return false;
        }
        OpSp os = (OpSP) other;
        // criteria a is valid
        return speciality == os.speciality;

        // criteria b is valid
        if(!super.equals(other)){
            return false;
        }
        OpSp os = (OpSP) other;
        return os.speciality == speciality;

        // criteria c is valid
        return super.equals(other);

        // criteria d is not valid
        // the specification implies that equals in OpSp is not symmetric and not transitive
    }

    private boolean compatibleWithOp(){
        return speciality == null;
    }

}

enum Speciality {
    PUJAZZER,
    SUCUZZUNER,
    ETCETARER
}
