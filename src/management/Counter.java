//author 208783522

package management;

/**
 * The type Counter.
 * Used for counting things
 */
public class Counter {
    private int value;

    /**
     * Creates a new counter.
     */
    public Counter() {
        this.value = 0;
    }

    /**
     * Creates a new counter.
     * Create a new counter with the given value.
     *
     * @param newValue a new value for the current counter to set it's counting from.
     */
    public Counter(int newValue) {
        this.value = newValue;
    }

    /**
     * Increase.
     * Add number to current count.
     *
     * @param number the number to add.
     */
    public void increase(int number) {
        // check if the value is valid
        if (value >= 0) {
            this.value += number;
        }
    }

    /**
     * Decrease.
     * Subtract number from current count.
     *
     * @param number the number to subtract.
     */
    public void decrease(int number) {
        // check if the value is valid
        if (value >= 0) {
            this.value -= number;
        }
    }

    /**
     * Gets value.
     *
     * @return the current count value.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Sets value.
     * sets the value of the current counter.
     *
     * @param newValue the new value to change to.
     */
    public void setValue(int newValue) {
        this.value = newValue;
    }
}
