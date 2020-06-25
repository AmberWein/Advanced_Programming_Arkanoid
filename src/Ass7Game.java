//author 208783522

import levels.Level1;
import levels.Level2;
import levels.Level3;
import levels.Level4;
import driver.GameFlow;

import management.AnimationRunner;
import management.HighScore;
import management.LevelInformation;
import management.HighScoresAnimation;
import management.MenuAnimation;

import tasks.Selection;
import tasks.TaskRunGame;
import tasks.ShowHighScoresTask;
import tasks.TaskQuit;
import tasks.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Ass 7 game.
 * Represent assignment 7.
 */
public class Ass7Game {

    /**
     * Sets levels.
     *
     * @param args the args
     * @return the levels
     */
    public static List<LevelInformation> setLevels(String[] args) {
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        // check if there is an input,
        // if no then  start a regular game with 4 levels
        if (args.length == 0) {
            return levels;
        } else {
            // there is an input, then check it
            List<LevelInformation> newLevels = new ArrayList<>();
            for (String s : args) {
                try {
                    int num = Integer.parseInt(s);
                    if ((num > 0) && (num < 5)) {
                        newLevels.add(levels.get(num - 1));
                    }
                } catch (NumberFormatException e) {
                    // do nothing
                }
            }
            // check if no argument is valid
            if (newLevels.size() == 0) {
                return levels;
            } else {
                return newLevels;
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input argument
     */
    public static void main(String[] args) {
        List<LevelInformation> levels = setLevels(args);
        AnimationRunner runner = new AnimationRunner();
        MenuAnimation<Selection> menu = new MenuAnimation<>(runner.getGui().getKeyboardSensor());
        HighScore highScore = new HighScore();
        HighScoresAnimation highScoresAnimation = new HighScoresAnimation(highScore.getHighest());
        GameFlow driver = new GameFlow(runner, highScore);
        Task<Void> start = new TaskRunGame(driver, levels);
        Task<Void> showScore = new ShowHighScoresTask(runner, highScoresAnimation);
        Task<Void> quit = new TaskQuit();
        menu.addSelection("s", "Start Game", start);
        menu.addSelection("h", "High Score", showScore);
        menu.addSelection("q", "Quit", quit);
        // run the game
        while (true) {
                runner.run(menu);
                Task<Void> selectedTask = (Task<Void>) menu.getStatus();
                selectedTask.run();
                // reset the game before starting a new one
                menu.reset();
        }
    }
}
