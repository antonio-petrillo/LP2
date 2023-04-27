// public enum SuitEnum {
//     HEARTS, SPADES, CLUBS, DIAMONDS;
// }

public enum SuitEnum {

    // V1
    // HEARTS(true), SPADES(false), CLUBS(false), DIAMONDS(true);

    // private final boolean red;

    // private SuitEnum(boolean red) {
    // this.red = red;
    // }

    // public boolean isRed() {
    // return red;
    // }

    // V2
    HEARTS {

        public boolean isRed() {
            return true;
        }

    },
    DIAMONDS {

        public boolean isRed() {
            return true;
        }

    },
    SPADES, CLUBS;

    public boolean isRed() {
        return false;
    }
}
