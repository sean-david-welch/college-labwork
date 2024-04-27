public enum Status {
    FULFILLED, SHIPPED, CANCELLED;

    @Override
    public String toString() {
        return "Status{}";
    }

    Status() {
    }
}
