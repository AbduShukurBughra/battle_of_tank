import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_1;

public class GamePanel extends JFrame {
    Image offscreenImage = null;
    //window width and height
    int width = 800;
    int height = 610;
    //select picture
    Image select = Toolkit.getDefaultToolkit().getImage("images/tank.gif");
    int y = 150;
    //Game Types 0 none start game, 1 single player 2 two players
    int state = 0;
    int a = 1;


    public void launch() {
        setTitle("Battle Of Tank");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
        this.addKeyListener(new GamePanel.KeyMonitor());

        //重绘
        while (true) {
            repaint();
            try {
                Thread.sleep(25);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //pain() Method
    @Override
    public void paint(Graphics g) {
        if (offscreenImage==null){
            offscreenImage=this.createImage(width, height);
        }
        Graphics gImage=offscreenImage.getGraphics();
        gImage.setColor(Color.gray);
        gImage.fillRect(0, 0, getWidth(), getHeight());
        gImage.setColor(Color.white);
        gImage.setFont(new Font("Times Roman", Font.BOLD, 50));
        // state = 0, game none started
        if (state == 0) {
            gImage.drawString("ئويۇن تۈرىنى تاللاڭ", 220, 100);
            gImage.drawString("يالغۇز كىشىلىك ئويناش", 220, 200);
            gImage.drawString("ئىككى كىشىلىك ئويناش", 220, 300);
            gImage.drawImage(select, 140, y, null);
        } else if (state == 1 || state == 2) {
            gImage.drawString("ئويۇن باشلاندى", 220, 100);
            if (state == 1) {
                gImage.drawString("يالغۇز كىشىلىك ئويناش", 220, 200);
            } else {
                gImage.drawString("ئىككى كىشىلىك ئويناش", 220, 300);
            }
        }
        g.drawImage(offscreenImage,0,0,null);
    }

    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        gamePanel.launch();
    }

    //keyboard monitor
    class KeyMonitor extends KeyAdapter {
        //press the keyboard
        @Override
        public void keyPressed(KeyEvent e) {
            //return key
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_1:
                    a = 1;
                    y = 150;
                    break;
                case KeyEvent.VK_2:
                    a = 2;
                    y = 250;
                    break;
                case KeyEvent.VK_ENTER:
                    state =a;
                    break;
            }
            System.out.println(e.getKeyChar());
        }
    }
}
