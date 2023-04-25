public class Driver {

    public static void main(String[] args) {
        Elemento ossigeno = new Elemento("O");
        Elemento idrogeno = new Elemento("H");
        Molecola acqua = new Molecola();
        acqua.add(ossigeno);
        acqua.add(idrogeno);
        acqua.add(idrogeno);
        System.out.println(acqua);
    }

}
