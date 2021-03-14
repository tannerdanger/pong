import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Creates the game object
 */
public class Game {
    /**
     * The left AI paddle
     */
    Paddle paddle1;
    /**
     * The right player paddle
     */
    Paddle paddle2;
    /**
     * The ball object
     */
    Ball ball;

    /**
     * Speed the paddles move at
     */
    int PLAYERSPEED = 4;

    /**
     * Is player moving up input received?
     */
    boolean playerUP = false;
    /**
     * Is player moving down input received?
     */
    boolean playerDOWN = false;

    /**
     * The game timer
     */
    Timer timer;


    /**
     * Y incline the ball is moving at
     */
    double incline = 1;
    /**
     * Reference to the game view
     */
    View view;

    /**
     * Creates the game object
     * @param view reference to the game view
     */
    public Game(View view){
        this.view = view;
        view.setGame(this);
    }

    /**
     * Initializes the game components and starts the game timer
     */
    public void start(){
        //Create the paddles and ball at their initial location
        paddle1 = new Paddle(1, this, 30, 350);
        paddle2 = new Paddle(2, this, 670, 350);
        ball = new Ball(300, 300);



        timer = new Timer(2, arg0 -> {
            update();
            draw();
        });
        timer.start();
    }

    /**
     * Updates game logic for every timer cycle
     */
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

            }
        }





        //bounce(); //TODO reset direction

        // TODO add AI action (p1)
        //processAI();


    }

    /**
     * Resets the paddles and ball
     */
    public void reset(){
        paddle1.reset();
        paddle2.reset();
        ball.reset();
    }

    /**
     * Draws the game space
     */
    public void draw(){
        view.repaint(view.getBounds());
    }
}
