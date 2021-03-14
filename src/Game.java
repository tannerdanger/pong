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
        }else{ //game isn't over, process game
            if(playerUP){
                paddle2.myY -= PLAYERSPEED;

                //TODO Remove below line. Used for testing
                paddle1.myY -= PLAYERSPEED;

            }else if(playerDOWN){
                paddle2.myY += PLAYERSPEED;

                //TODO Remove below line. Used for testing
                paddle1.myY += PLAYERSPEED;
            }
            if(paddle2.myY <= 50){
                paddle2.myY = 50;
            }else if(paddle2.myY >= 570){
                paddle2.myY = 570;
            }
            if(!ball.isServable){
                ball.myX += ball.SPEED;

                //bounce ball off edge of screen
                if(ball.getY() == 50){
                    incline = -incline;
                    ball.myY += incline;
                }else if(ball.getY() == 700){
                    incline = -incline;
                    ball.myY += incline;
                }else{
                    ball.myY += incline;
                }

                if(ball.collidesWith(paddle2)){
                    ball.SPEED =- ball.SPEED;
                }

                if(ball.collidesWith(paddle1)){
                    ball.SPEED =- ball.SPEED;
                }

                if(ball.getX() < paddle1.getX()){
                    paddle2.scored();
                    ball.reset();
                }
                if(ball.getX() > paddle2.getX()){
                    paddle1.scored();
                    ball.reset();
                }

                //TODO: Collision with paddle

            }
        }





        //bounce(); //TODO reset directoin

        // TODO add AI action (p1)
        //processAI();

        // TODO Add functionality for changing ball location...


        paddle1.setLocation(new Point((int)p1x, (int)p1y));
        paddle2.setLocation(new Point((int)p2x, (int)p2y));
        ball.setLocation(new Point((int) ballX, (int) ballY));

    }

    public void reset(){
        paddle1.reset();
        paddle2.reset();
        ball.reset();
    }

    public void draw(Rectangle bounds){
        view.repaint(bounds);
    }
}
