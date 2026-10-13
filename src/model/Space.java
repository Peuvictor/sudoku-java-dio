package model;

public class Space {

    private final int expected;
    private final boolean fixed;
    private Integer actual;

    public Space(int expected, boolean fixed) {
        this.expected = expected;
        this.fixed = fixed;
        this.actual = fixed ? expected : null;
    }

    public int getExpected() {
        return expected;
    }

    public boolean isFixed() {
        return fixed;
    }

    public Integer getActual() {
        return actual;
    }

    public void setActual(int actual) {
        if (!fixed && actual >= 1 && actual <= 9) {
            this.actual = actual;
        }
    }

    public void clearSpace() {
        if (!fixed) {
            this.actual = null;
        }
    }
}
