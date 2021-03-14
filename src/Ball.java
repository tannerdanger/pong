import java.awt.*;

public class Ball {

    Point myLocation = new Point(0,0);
    int myX = 0, myY = 0;
    int myHeight = 20, myWidth = 20;
    boolean isServable = true;
    int SPEED = 5;

    public Ball(int theX, int theY){
        myX = theX;
        myY = theY;
    }


    void reset(){
        myY = 300;
        myX = 300;
        isServable = true;
        SPEED = -SPEED; //change direction
       // myScore = 0;
    }

    public void setLocation(Point p){
        myLocation = p;
    }

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

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(myX, myY, myHeight, myWidth);
    }
}



