import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class View extends JPanel implements KeyListener{

    Game myGame;
    Rectangle bounds;

    public View(){
        setBackground(Color.BLACK);
        bounds = new Rectangle(0,0,705,670);

        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

    }


    public void setGame(Game game){
        this.myGame = game;
    }

    @Override
    public Rectangle getBounds(){
        return bounds;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        myGame.ball.draw(g);
        myGame.paddle1.draw(g);
        myGame.paddle2.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

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
    }

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
