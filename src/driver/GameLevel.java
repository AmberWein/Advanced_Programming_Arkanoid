//author 208783522

package driver;

import biuoop.DrawSurface;
import biuoop.GUI;
import geometryprimitives.Point;
import geometryprimitives.Rectangle;

import management.AnimationRunner;
import management.Counter;
import management.Animation;
import management.LevelInformation;
import management.SpriteCollection;
import management.GameEnvironment;
import management.BallRemover;
import management.BlockRemover;
import management.ScoreIndicator;
import management.ScoreTrackingListener;
import management.CountdownAnimation;
import management.PauseScreen;

import sprites.Block;
import sprites.Ball;
import sprites.Paddle;
import sprites.Sprite;
import sprites.Collidable;

import java.awt.Color;
import java.util.List;

/**
 * The type Game.
 * Will hold the sprites and the collidables, and will be in charge of the animation
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private GUI gui;
    private Counter remainBlocks;
    private Counter remainBalls;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInfo;
    // adjusts the name level printing to be in it's right position
//    public static final int OFFSET = 20;
//    private static final int WIDTH_OF_BLOCK = 800;
//    private static final int HEIGHT_OF_BLOCK = 30;

    /**
     * Instantiates a new Game.
     *
     * @param levelInfo the level information
     * @param newRunner an animation runner
     * @param newScore  the score counter
     */
    public GameLevel(LevelInformation levelInfo, AnimationRunner newRunner, Counter newScore) {
        this.levelInfo = levelInfo;
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.remainBlocks = new Counter();
        this.remainBalls = new Counter();
        this.score = newScore;
        this.runner = newRunner;
        this.gui = runner.getGui();
    }

    /**
     * Get remain balls int.
     * @return the number of the remain balls in the current GameLevel
     */
    public int getRemainBalls() {
        return this.remainBalls.getValue();
    }
    /**
     * Add collidable.
     * Adds a collidable object to the game
     *
     * @param c a collidable object that would be added to the game
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }


    /**
     * Add sprite.
     * Add a sprite object to the game
     *
     * @param s a sprite object that would be added to the game
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Add boundaries.
     * Add 4 blocks on the boundaries of the window of the game
     */
    private void addBoundaries() {
        // create 4 blocks for boundaries:
        // left border
        Rectangle leftSide = new Rectangle(new Point(0, 30), 10, 580);
        Block leftBoundBlock = new Block(leftSide, Color.GRAY);
        // right border
        Rectangle rightSide = new Rectangle(new Point(790, 30), 10, 580);
        Block rightBoundBlock = new Block(rightSide, Color.GRAY);
        // upper border
        Rectangle upSide = new Rectangle(new Point(0, 20), 800, 20);
        Block upBoundBlock = new Block(upSide, Color.GRAY);
        // lower border
        Rectangle downSide = new Rectangle(new Point(0, 600), 800, 20);
        Block downBoundBlock = new Block(downSide, Color.BLACK);
        // add listeners to
        BallRemover br = new BallRemover(this, this.remainBalls);
        downBoundBlock.addHitListener(br);
        // add them to the game
        leftBoundBlock.addToGame(this);
        rightBoundBlock.addToGame(this);
        upBoundBlock.addToGame(this);
        downBoundBlock.addToGame(this);
    }

    /**
     * Add paddle.
     * Add a paddle to the game.
     */
    private void addPaddle() {
        // creating a new paddle
        Rectangle rect = new Rectangle(new Point((double) (this.gui.getDrawSurface().getWidth())
                / 2 - (double) (this.levelInfo.paddleWidth()) / 2, 580), this.levelInfo.paddleWidth(), 10);
        Color newColor = Color.ORANGE;
        Paddle pad = new Paddle(this.gui.getKeyboardSensor(), rect, newColor);
        // add the new paddle to the game
        pad.addToGame(this);
    }

    /**
     * Add balls.
     * Initialize the game level balls.
     */
    public void addBalls() {
        for (int i = 0; i < this.levelInfo.numberOfBalls(); i++) {
            Ball b = new Ball(new Point((double) (this.gui.getDrawSurface().getWidth())
                    / 2, 480), 5, Color.WHITE, this.environment);
            b.setVelocity(this.levelInfo.initialBallVelocities().get(i));
            b.addToGame(this);
            this.remainBalls.increase(1);
        }
    }


    /**
     * Add score block.
     * Add an upper block for the score.
     */
    private void addScoreBlock() {
        ScoreIndicator si = new ScoreIndicator(this.score);
        si.addToGame(this);
    }

    /**
     * Add block pattern.
     * Add blocks in a pattern similar to the example given in the assignment.
     */
    public void addBlockPattern() {
        ScoreTrackingListener scoreTrack = new ScoreTrackingListener(this.score);
        BlockRemover blockRemover = new BlockRemover(this, this.remainBlocks);
        List<Block> blocksPattern = this.levelInfo.blocks();
        // a loop to go over all of the blocks in the current game level
        for (Block b : blocksPattern) {
            b.addToGame(this);
            b.addHitListener(scoreTrack);
            b.addHitListener(blockRemover);
            this.remainBlocks.increase(1);
        }
    }

    /**
     * Initialize.
     * Initialize a new game: create the Blocks, 2 Balls, and a Paddle
     * and add them to the game
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInfo.getBackground());
        this.addBoundaries();
        this.addBlockPattern();
        this.addPaddle();
        this.addBalls();
        this.addScoreBlock();
    }

    /**
     * Run.
     * Run the game - start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(3, 3, this.sprites)); // countdown before turn starts.
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * Remove collidable.
     * Remove collidable from the current game.
     *
     * @param c a collidable object to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * Remove sprite.
     * Remove sprite from the current game.
     *
     * @param s a sprite object to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * Is turn end boolean.
     *
     * @return true if there is a stop condition,
     * or else false.
     */
    private boolean isTurnEnd() {
        // check if there are no more balls or blocks left in the game
        if (this.remainBlocks.getValue() == 0) {
            this.score.increase(100);
            return true;
        }
        return (this.remainBalls.getValue() == 0);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.gui.getKeyboardSensor().isPressed("p")) {
            this.runner.run(new PauseScreen(this.gui.getKeyboardSensor()));
        }
        this.sprites.drawAllOn(d);
        // draw level's name
        d.setColor(Color.BLACK);
        d.drawText(d.getWidth() - 250, 15, "Level Name: " + this.levelInfo.levelName(), 14);
        this.sprites.notifyAllTimePassed();
        // check if needed to be stopped
        if (this.isTurnEnd()) {
            this.running = false;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}