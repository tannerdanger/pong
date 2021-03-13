import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    Game myGame;
    Rectangle bounds;

    public View(){
        setBackground(Color.BLACK);
        bounds = new Rectangle(0,0,705,670);


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




}
