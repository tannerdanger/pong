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
       // myY = 350;
       // myScore = 0;
    }

    public void setLocation(Point p){
        myLocation = p;
    }

    public void draw(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(myX, myY, myHeight, myWidth);
    }
}



