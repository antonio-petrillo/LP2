public class ResettableSafe extends Safe {

    // private int key;
    // private int defaultKey;
    // private int failedAttempt;
    // private boolean locked;

    // public ResettableSafe(int key, String secret) {
    // super(secret, key);
    // this.key = key;
    // this.defaultKey = key;
    // }

    // public String open(int combination) {
    // if (locked) {
    // throw new RuntimeException();
    // }
    // if (combination == key) {
    // failedAttempt = 0;
    // return super.open(defaultKey);
    // } else {
    // failedAttempt++;
    // if (failedAttempt == 3) {
    // locked = true;
    // }
    // return null;
    // }
    // }

    // public boolean changeKey(int newKey, int oldKey) {
    // if (locked) {
    // throw new RuntimeException();
    // }
    // if (key == oldKey) {
    // key = newKey;
    // failedAttempt = 0;
    // return true;
    // } else {
    // failedAttempt++;
    // if (failedAttempt == 3) {
    // locked = true;
    // }
    // return false;
    // }
    // }

    private int failedAttempt = 0;
    private boolean locked = false;

    public ResettableSafe(int key, String secret) {
        super(secret, key);
    }

    @Override
    public String open(int key) {
        if (locked) {
            throw new RuntimeException();
        }
        String s = super.open(key);
        if (s == null) {
            failedAttempt++;
            if (failedAttempt == 3) {
                locked = true;
            }
        } else {
            failedAttempt = 0;
        }
        return s;
    }

    public boolean changeKey(int oldKey, int newKey) {
        if (locked) {
            throw new RuntimeException();
        }
        if (oldKey == key) {
            failedAttempt = 0;
            key = newKey;
            return true;
        } else {
            failedAttempt++;
            if (failedAttempt == 3) {
                locked = true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ResettableSafe s = new ResettableSafe(2381313, "L’assassino e' il maggiordomo.");
        System.out.println(s.open(887313));
        System.out.println(s.open(13012));
        System.out.println(s.changeKey(12, 34));
        System.out.println(s.open(2381313));
    }

}
