import java.awt.*;

public class Ball {
    /**
     * Ball x and y locations
     */
    int myX = 0, myY = 0;
    /**
     * Default h and w of ball
     */
    int myHeight = 20, myWidth = 20;
    /**
     * Is ball waiting to be served?
     */
    boolean isServable = true;
    /**
     * Default speed of the ball
     */
    int SPEED = 5;

    /**
     * Creates the ball object
     * @param theX x location of ball to start
     * @param theY y location of ball to start
     */
    public Ball(int theX, int theY){
        myX = theX;
        myY = theY;
    }

    /**
     * Resets ball location
     */
    void reset(){
        myY = 300;
        myX = 300;
        isServable = true;
        SPEED = -SPEED; //change direction
    }


    /**
     * Checks if the ball collides with a paddle
     * @param paddle the paddle to check collision against
     * @return boolean if collides or not
     */
    public boolean collidesWith(Paddle paddle){

        if(myX == paddle.getX()
        && myY >= paddle.getY()
        && myY <= paddle.getY() + paddle.PADDLE_HEIGHT){
            return true;
        }
        return false;
    }

    public int getX(){
        return myX;
    }

    public int getY(){
        return myY;
    }

    /**
     * Draws the ball blue
     * @param g the graphics object
     */
    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(myX, myY, myHeight, myWidth);
    }
}



