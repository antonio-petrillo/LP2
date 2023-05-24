public enum Status {
    ONLINE, BUSY, HIDDEN, OFFLINE;

    public boolean isVisible() {
        return ordinal() < 2;
    }

    public boolean canContact(Status s) {
        return ordinal() != 3 && s.isVisible();
    }

}
