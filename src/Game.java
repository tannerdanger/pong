import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;


public class Game {
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;

    int PLAYERSPEED = 4;

    boolean playerUP = false;
    boolean playerDOWN = false;

    Timer timer;

    int ballX = 300;
    int ballY = 300;
    boolean ballDirection = false;

    int p1x = 30;
    int p1y = 350;
    int p2x = 670;
    int p2y = 350;
    double incline = -0.5;

    View view;

    public Game(View view){
        this.view = view;
        view.setGame(this);
        registerInput();
    }

    public void start(){

        paddle1 = new Paddle(1, this, p1x, p1y);
        paddle2 = new Paddle(2, this, p2x, p2y);
        ball = new Ball(ballX, ballY);



        timer = new Timer(2, new ActionListener(){
           public void actionPerformed(ActionEvent arg0){
               update();
               draw(view.getBounds());
           }
        });
        timer.start();
    }

    public void update(){
        if(paddle1.getScore() > 7){
            JOptionPane.showMessageDialog(view, "PLAYER 1 WINS");
            reset();
        }else if(paddle2.getScore() > 7){
            JOptionPane.showMessageDialog(view, "PLAYER 2 WINS");
            reset();
        }else{
            if(playerUP){
                paddle2.myY -= PLAYERSPEED;
            }else if(playerDOWN){
                paddle2.myY += PLAYERSPEED;
            }
            if(paddle2.myY <= 50){
                paddle2.myY = 50;
            }else if(paddle2.myY >= 570){
                paddle2.myY = 570;
            }
//            playerDOWN = false;
//            playerUP = false;
        }





        setDirection(ballDirection, incline);
        //bounce(); //TODO reset directoin

        // TODO add AI action (p1)

        // TODO Add functionality for changing ball location...
        // TODO Don't forget to use collision detection!!!


        paddle1.setLocation(new Point((int)p1x, (int)p1y));
        paddle2.setLocation(new Point((int)p2x, (int)p2y));
        ball.setLocation(new Point((int) ballX, (int) ballY));

    }

    public void setDirection(boolean Xdir, double inc){
        ballY += inc;

    }

    public void reset(){
        paddle1.reset();
        paddle2.reset();
        ball.reset();
    }

    public void registerInput(){

    }

    public void draw(Rectangle bounds){
        view.repaint(bounds);
    }
}
