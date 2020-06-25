//author 208783522

package tasks;

/**
 * The type Selection.
 */
public class Selection {
    private String key;
    private String name;
    private Object object;

    /**
     * Instantiates a new Selection.
     *
     * @param newKey  the new key
     * @param newName the new name
     * @param newTask the new task
     */
    public Selection(String newKey, String newName, Object newTask) {
        this.key = newKey;
        this.name = newName;
        this.object = newTask;
    }

    /**
     * The Get key.
     *
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * The Get name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets task.
     *
     * @return the task
     */
    public Object getObject() {
        return this.object;
    }

//    /**
//     * Is selected boolean.
//     *
//     * @param pressedKey the pressed key
//     * @return true if the given pressed key is the key for this
//     */
//    public boolean isSelected(String pressedKey) {
//        return (this.getKey().equals(pressedKey));
//    }
}
