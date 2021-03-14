import java.awt.*;

public class Paddle {
    int myScore = 0;
    int paddleNum;//TODO: isPlayer
    int myX = 0;
    int myY = 0;
    View view;
    Game myGame;
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 100;

    Point myLocation = new Point(0,0);

    public Paddle(int theNum, Game theGame, int theX, int theY){
        paddleNum = theNum;
        myGame = theGame;
        myX = theX;
        myY = theY;
    }

    public void createBindings(){
        if(paddleNum == 1){
            //view.addKeyBindings("up.pressed", KeyEvent.VK_W)
        }
    }

    public Dimension getSize(){
        return new Dimension(PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public Point getLocation(){
        return new Point(myLocation);
    }

    public void setLocation(Point p){
        myLocation = p;
    }

    public int getScore(){
        return myScore;
    }

    void reset(){
        myY = 350;
        myScore = 0;
    }

    public void draw(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(myX, myY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

}
