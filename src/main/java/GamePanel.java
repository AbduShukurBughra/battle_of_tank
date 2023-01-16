import javax.swing.*;
import java.awt.*;

public class GamePanel extends JFrame {
    //window width and height
    int width = 800;
    int height = 610;

    public void launch(){
        setTitle("Battle Of Tank");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
    }

    //pain() Method
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }
}
