import java.awt.*;

/**
 * A paddle object used by both the player and the AI
 */
public class Paddle {
    /**
     * Keeps track of this paddle's score
     */
    int myScore = 0;
    /**
     * Keeps track of the paddle. 1 for left, 2 for right
     */
    int paddleNum;//TODO: isPlayer
    /**
     * X location of paddle on screen
     */
    int myX = 0;
    /**
     * Y location of paddle on screen
     */
    int myY = 0;
    /**
     * A reference to the game object
     */
    Game myGame;
    /**
     * Default value for how wide the paddle is.
     */
    public static final int PADDLE_WIDTH = 20;
    /**
     * Default value for how tall the paddle is. Used for collision detecting
     */
    public static final int PADDLE_HEIGHT = 100;


    Point myLocation = new Point(0,0);

    /**
     * Creates a new paddle object
     * @param theNum numerical identifier for left (1) or right (2) paddle
     * @param theGame a reference to the game object
     * @param theX the x location for the paddle
     * @param theY the starting Y location for the paddle
     */
    public Paddle(int theNum, Game theGame, int theX, int theY){
        paddleNum = theNum;
        myGame = theGame;
        myX = theX;
        myY = theY;
    }

    /**
     * Returns the score of this paddle
     * @return score
     */
    public int getScore(){
        return myScore;
    }

    /**
     * Called if a player scores. Increments the score
     */
    public void scored(){
        myScore++;
    }

    /**
     * Resets paddle position and score
     */
    void reset(){
        myY = 350;
        myScore = 0;
    }

    /**
     * Get y value
     * @return y
     */
    public int getY(){
        return myY;
    }

    /**
     * Get x value
     * @return x
     */
    public int getX(){
        return myX;
    }

    /**
     * Draw this paddle
     * @param g the graphics object to draw on
     */
    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(myX, myY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

}
