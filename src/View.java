import javax.swing.*;
import java.awt.*;

public class View extends JPanel {

    Game myGame;
    Rectangle bounds;

    public View(){
        setBackground(Color.BLACK);
        bounds = new Rectangle(0,0,705,670);


    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        //if(myModel.getEntities()!)
    }

    public void setGame(Game game){
        this.myGame = game;
    }

    public void paintComponent(Graphics g){

    }
}
