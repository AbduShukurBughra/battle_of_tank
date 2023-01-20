import java.awt.*;

public class Bot extends Tank{
    public Bot(String img, int x, int y, GamePanel gamePanel, String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel, upImg, downImg, leftImg, rightImg);
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, with, height);
    }
}
