import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Creates the JPanel that the game plays on. Implements key listener to listen for input from player
 */
public class View extends JPanel implements KeyListener{
    /**
     * Reference to game object
     */
    Game myGame;

    /**
     * Creates the game view object
     */
    public View(){
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * Sets the game reference
     * @param game the game object
     */
    public void setGame(Game game){
        this.myGame = game;
    }

    /**
     * Draws the components fo the game
     * @param g
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        myGame.ball.draw(g);
        myGame.paddle1.draw(g);
        myGame.paddle2.draw(g);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", 1, 50));
        g.drawString(myGame.paddle1.getScore() + " : " + myGame.paddle2.getScore(), 300, 50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Checks for user input and handles proper keypresses
     * @param e the key event to check
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_W
                || e.getKeyCode() == KeyEvent.VK_UP){
            myGame.playerUP = true;
            myGame.playerDOWN = false;
        }else if(e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_DOWN){
            myGame.playerDOWN = true;
            myGame.playerUP = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE && myGame.ball.isServable){
            myGame.ball.isServable = false;
        }
    }

    /**
     * When key released, paddle stops moving
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_W
                || e.getKeyCode() == KeyEvent.VK_UP){
            myGame.playerUP = false;
            myGame.playerDOWN = false;
        }else if(e.getKeyCode() == KeyEvent.VK_S
                || e.getKeyCode() == KeyEvent.VK_DOWN){
            myGame.playerDOWN = false;
            myGame.playerUP = false;
        }
    }
}
