public class TestCardinal {

    public static void main(String[] args) {
        Cardinal nord = Cardinal.N;
        Cardinal nordNordEst = Cardinal.NNE;
        Cardinal est = Cardinal.E;
        System.out.println(nord.isOpposite(Cardinal.S));
        System.out.println(nordNordEst.isOpposite(Cardinal.SSO));
        System.out.println(est.isOpposite(Cardinal.N));
        Cardinal nordest = Cardinal.mix(Cardinal.N, Cardinal.E);
        assert nordest == Cardinal.NE : "Errore inaspettato!";
        Cardinal nordnordest = Cardinal.mix(nordest, Cardinal.N);
        System.out.println(nordnordest);
    }

}
