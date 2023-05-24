public enum LengthUnit {
    CM(0.01), M(1.), KM(1000.), INCH(0.25), YARD(0.914), MILE(1609.);

    private double factor;

    private LengthUnit(double factor) {
        this.factor = factor;
    }

    public double convertTo(LengthUnit unit, double value) {
        return value * factor / unit.factor;
    }
}
