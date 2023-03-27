public class Safe {
    // V1
    // private String secret;
    // private int key;

    // public Safe(String secret, int key) {
    // this.secret = secret;
    // this.key = key;
    // }

    // public String open(int combination) {
    // if (key == combination) {
    // return secret;
    // }
    // return null;
    // }

    private String secret;
    protected int key;

    public Safe(String secret, int key) {
        this.secret = secret;
        this.key = key;
    }

    public String open(int combination) {
        if (key == combination) {
            return secret;
        }
        return null;
    }
}
