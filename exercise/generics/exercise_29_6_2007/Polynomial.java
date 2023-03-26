class Polynomial<T> {

    private Field<T> field;
    private T[] coefficients;

    public Polynomial(T[] coefficients, Field<T> field) {
        this.coefficients = coefficients.clone();
        this.field = field;
    }

    public T eval(T x) {
        T result = field.getZero();
        T pow = field.getOne();
        for (T coefficient : coefficients) {
            result = field.plus(result, field.times(coefficient, pow));
            pow = field.times(x, pow);
        }
        return result;
    }

}
