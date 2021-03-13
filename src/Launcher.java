import javax.swing.*;

public class Launcher {

    private static int WINDOW_HEIGHT = 750;
    private static int WINDOW_WIDTH = 750;

    public static void main(String[] args){
        JFrame frame = new JFrame();
        View view = new View();
        Game myGame = new Game(view);

        frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        frame.getContentPane().add(view);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setTitle("Tanner's Pong");

        myGame.start();
    }
}
