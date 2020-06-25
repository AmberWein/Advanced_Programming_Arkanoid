//author 208783522

package management;

/**
 * The interface Menu.
 * Represents a menu.
 * @param <T> Type.
 */
public interface Menu<T> extends Animation {

    /**
     * Add selection.
     * @param key a key.
     * @param message a message.
     * @param returnVal Return value.
     */
    void addSelection(String key, String message, T returnVal);

    /**
     * Get status T.
     * @return Status.
     */
    T getStatus();
}
