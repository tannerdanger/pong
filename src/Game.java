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

    static Map<Direction, KeyEvent> keys = new HashMap<>();//TODO: Hashmap
    Timer timer;

    double ballX = 0;
    double ballY = 0;
    boolean ballDirection = false;

    double p1x = 0;
    double p1y = 0;
    double p2x = 0;
    double p2y = 0;
    double incline = -0.5;

    View view;

    public Game(View view){
        this.view = view;
        view.setGame(this);
    }

    public void start(){

        paddle1 = new Paddle(1, this);
        paddle2 = new Paddle(2, this);
        ball = new Ball();
        ballX = 300;
        ballY = 300;
        p1x = 30;
        p1y = 350;
        p2x = 650;
        p1y = 350;





        timer = new Timer(2, new ActionListener(){
           public void actionPerformed(ActionEvent arg0){
               update(view.getBounds());
               draw(view);
           }
        });
        timer.start();
    }

    public void update(Rectangle bpimds){
        if(paddle1.getScore() > 7){
            JOptionPane.showMessageDialog(view, "PLAYER 1 WINS");
            reset();
        }else if(paddle2.getScore() > 7){
            JOptionPane.showMessageDialog(view, "PLAYER 2 WINS");
            reset();
        }

        setDirection(ballDirection, incline);
        //bounce(); //TODO reset directoin

        // TODO add AI action (p1)

        // TODO Add functionality for changing ball location...
        // TODO Don't forget to use collision detection!!!

        if(keys.containsKey(Direction.UP)){
            p2y -=2;
        }else if(keys.containsKey(Direction.DOWN)){
            p2y +=2;
        }

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

    public void draw(){
        view.repaint();
    }
}
