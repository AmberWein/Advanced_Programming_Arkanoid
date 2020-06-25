//author 208783522

package management;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * The type High score.
 */
public class HighScore {
    private Counter highest;
    /**
     * The constant FILE_NAME.
     */
    public static final String FILE_NAME = "highscores.txt";

    /**
     * Instantiates a new High score.
     */
    public HighScore() {
        this.highest = new Counter();
        File currentFile = new File(FILE_NAME);
        // check if there is a file- if not, then create a new one
        if (!currentFile.exists()) {
            this.createFile(currentFile);
        } else {
            this.highest = this.getScoreFromFile();
        }
    }

    /**
     * Gets highest.
     *
     * @return the highest score
     */
    public Counter getHighest() {
        return this.highest;
    }

    /**
     * Create file.
     * Create a new file according to the given one.
     *
     * @param currentFile the current file
     */
    public void createFile(File currentFile) {
        try {
            currentFile.createNewFile();
            this.writeHighScore(this.getHighest());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get score from file Counter.
     * Get the highest score for the file
     *
     * @return the high score
     */
    private Counter getScoreFromFile() {
        BufferedReader is = null;
        Counter result = new Counter();
        try {
            is = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_NAME)));
            String line = is.readLine();
            String[] dividedLine = line.split(": ");
            result.setValue(Integer.parseInt(dividedLine[1]));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) { // Exception might have happened at constructor
                try {
                    is.close();
                } catch (IOException e) {
                    System.out.println("Failed closing the file!");
                }
            }
        }
        return result;
    }

    /**
     * Is higher boolean.
     * Compare between the given score value to the current one.
     *
     * @param other another score counter
     * @return the boolean
     */
    public boolean isHigher(Counter other) {
        Counter current = this.getScoreFromFile();
        return (other.getValue() > current.getValue());
    }

    /**
     * Write high score boolean.
     * Write the new highest score into the file.
     *
     * @param newScore a new highest score to update the file
     */
    private void writeHighScore(Counter newScore) {
        PrintWriter os = null;
        try {
            os = new PrintWriter(// wrapper with many ways of writing strings
                    new OutputStreamWriter(// wrapper that can write strings
                            new FileOutputStream(FILE_NAME)));
            os.printf("The highest score so far is: %d", newScore.getValue());
        } catch (IOException e) {
            System.out.println("Something went wrong while writing!");
        } finally {
            if (os != null) { // Exception might have happened at constructor
                os.close(); // closes fileOutputStream too
            }
        }
    }

    /**
     * Sets high score.
     *
     * @param newScore the new score
     */
    public void setHighScore(Counter newScore) {
        if (this.isHigher(newScore)) {
            this.writeHighScore(newScore);
        }
    }
}
