//author 208783522

package management;

/**
 * The interface Hit notifier.
 * Indicate that objects that implement it send notifications when they are being hit.
 */
public interface HitNotifier {

    /**
     * Add hit listener.
     * Add hl as a listener to hit events.
     *
     * @param hl a hit listener
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hit listener.
     * Remove hl from the list of listeners to hit events.
     *
     * @param hl the hl
     */
    void removeHitListener(HitListener hl);
}
