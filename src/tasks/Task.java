//author 208783522

package tasks;

/**
 * The interface Task.
 * Task is something that needs to happen, or something that we can run() and return a value.
 *
 * @param <T> the type parameter
 */
public interface Task<T> {

    /**
     * Run t.
     * Run a task.
     *
     * @return the task
     */
    T run();
}
