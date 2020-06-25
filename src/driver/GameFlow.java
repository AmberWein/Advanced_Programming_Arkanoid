//author 208783522

package driver;

import biuoop.GUI;
import biuoop.KeyboardSensor;

import management.Counter;
import management.AnimationRunner;
import management.HighScore;
import management.LevelInformation;
import management.EndScreen;
import management.HighScoresAnimation;
import management.KeyPressStoppableAnimation;

import java.util.List;

/**
 * The type Game flow.
 * In charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private Counter score;
    private AnimationRunner runner;
    private HighScore highScoreManager;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar                     Animation runner.
     * @param newHighScore the new high score.
     */
    public GameFlow(AnimationRunner ar, HighScore newHighScore) {
        this.runner = ar;
        this.score = new Counter();
        this.highScoreManager = newHighScore;
    }

    /**
     * Get score Counter.
     *
     * @return the current score counter
     */
    public Counter getScore() {
        return this.score;
    }

    /**
     * Get runner AnimationRunner.
     *
     * @return the current runner
     */
    public AnimationRunner getRunner() {
        return this.runner;
    }

    /**
     * Run levels.
     * Runs the argument levels.
     *
     * @param levels The argument levels.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean hasWon = true;
        GUI gui = this.getRunner().getGui();
        KeyboardSensor keyBoard = gui.getKeyboardSensor();
        EndScreen endScreen = new EndScreen(hasWon, this.getScore().getValue(), keyBoard);
        //HighScore highScore = new HighScore();
        // a loop to run threw the levels
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.getRunner(), this.getScore());
            level.initialize();
            level.run();
            // run the level while it should
            while (!level.shouldStop()) {
                level.run();
            }
            // check if there are still any ball in the game
            if (level.getRemainBalls() == 0) {
                hasWon = false;
                endScreen.setHasWon(hasWon);
                break;
            }
        }
        endScreen.setScore(this.getScore());
        // check if the current score is higher then the highest that reached so far
        if (this.highScoreManager.isHigher(this.getScore())) {
            this.highScoreManager.setHighScore(this.getScore());
        }
        HighScoresAnimation hsAnimation = new HighScoresAnimation(this.getScore());
        KeyPressStoppableAnimation keyPressStoppableAnimation =
                new KeyPressStoppableAnimation(keyBoard,
                        KeyboardSensor.SPACE_KEY, endScreen);
        this.getRunner().run(keyPressStoppableAnimation);
        KeyPressStoppableAnimation kpsAnimation = new KeyPressStoppableAnimation(
                keyBoard, KeyboardSensor.SPACE_KEY, hsAnimation);
       this.getRunner().run(kpsAnimation);
    }
}
