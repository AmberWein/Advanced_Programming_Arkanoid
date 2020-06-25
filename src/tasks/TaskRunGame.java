//author 208783522

package tasks;

import driver.GameFlow;
import management.LevelInformation;

import java.util.List;

/**
 * The type Task run game.
 */
public class TaskRunGame implements Task<Void> {
    private GameFlow flow;
    private List<LevelInformation> levels;

    /**
     * Task run game.
     * Create a new TaskRunGame object.
     *
     * @param flow   the game flow.
     * @param levels the levels.
     */
    public TaskRunGame(GameFlow flow, List<LevelInformation> levels) {
        this.flow = flow;
        this.levels = levels;
    }

    @Override
    public Void run() {
        this.flow.runLevels(this.levels);
        return null;
    }
}
