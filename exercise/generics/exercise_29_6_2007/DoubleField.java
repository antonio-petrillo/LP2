
public class DoubleField implements Field<Double> {

    @Override
    public Double getOne() {
        return Double.valueOf(1);
    }

    @Override
    public Double getZero() {
        return Double.valueOf(0);
    }

    @Override
    public Double plus(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double times(Double x, Double y) {
        return x * y;
    }

}
