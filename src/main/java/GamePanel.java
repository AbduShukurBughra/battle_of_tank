import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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
    int count = 0;
    //game element list
    ArrayList<Bullet> bulletList = new ArrayList<Bullet>();
    ArrayList<Bot> botList = new ArrayList<Bot>();
    //Player one
    PlayerOne playerOne = new PlayerOne("images/playerOne/up_tank.png",125,510,this,
            "images/playerOne/up_tank.png",
            "images/playerOne/down_tank.png",
            "images/playerOne/left_tank.png",
            "images/playerOne/right_tank.png");

    //bot
    Bot bot = new Bot("images/enemy/bot_up.png",125,510, this,
            "images/enemy/bot_up.png",
            "images/enemy/bot_down.png",
            "images/enemy/bot_left.png",
            "images/enemy/bot_right.png" );


    public void launch() {
        setTitle("تانكا ئويۇنى");
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);
        this.addKeyListener(new GamePanel.KeyMonitor());

        //重绘
        while (true) {
            //adding enemy tank
            botList.add(new Bot("images/enemy/bot_up.png",125,510, this,
                    "images/enemy/bot_up.png",
                    "images/enemy/bot_down.png",
                    "images/enemy/bot_left.png",
                    "images/enemy/bot_right.png" ));
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

            //adding game elements
            playerOne.paintSelf(gImage);
            for (Bullet bullet: bulletList){
                bullet.paintSelf(gImage);
            }
            bot.paintSelf(gImage);
            //redraw once
            count++;

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
        //pressed keyboard
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
                default:
                    playerOne.keyPressed(e);
            }
            System.out.println(e.getKeyChar());
        }
        //released keyboard
        @Override
        public void keyReleased(KeyEvent e) {
            playerOne.keyReleased(e);
        }
    }
}
