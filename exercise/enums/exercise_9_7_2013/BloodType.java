public enum BloodType {
    ZERO, A, B, AB {
        public boolean canReceiveFrom(BloodType b) {
            return true;
        }
    };

    public boolean canReceiveFrom(BloodType b) {
        return this == b || b == ZERO;
    }
}
