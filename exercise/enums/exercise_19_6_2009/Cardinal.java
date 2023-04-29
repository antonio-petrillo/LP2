public enum Cardinal {
    N, NNE, NE, NEE, E, SEE, SE, SSE, S, SSO, SO, SOO, O, NOO, NO, NNO;

    public boolean isOpposite(Cardinal c) {
        return values()[ordinal() + 8 % 16] == c;
    }

    public static Cardinal mix(Cardinal c1, Cardinal c2) {
        if (c1.isOpposite(c2)) {
            throw new IllegalArgumentException();
        }
        int pos = c1.ordinal() + c2.ordinal() >> 1;
        return values()[pos];
    }

}
