public enum NumberType {
    BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64);

    public final int width;

    private NumberType(int width) {
        this.width = width;
    }

    public boolean isAssignableTo(NumberType n) {
        return ordinal() <= n.ordinal();
    }

}
