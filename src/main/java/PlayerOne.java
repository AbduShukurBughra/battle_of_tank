import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayerOne extends Tank {
    public PlayerOne(String img, int x, int y, GamePanel gamePanel, String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel, upImg, downImg, leftImg, rightImg);
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_SPACE:
                attack();
            default:
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            case KeyEvent.VK_W:
                up = false;
                break;
            default:
                break;
        }
    }

    public void move() {
        if (left) {
            leftWard();
        } else if (right) {
            rightWard();
        } else if (down) {
            downWard();
        } else if (up) {
            upWard();
        }
    }



    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        move();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, with, height);
    }
}
