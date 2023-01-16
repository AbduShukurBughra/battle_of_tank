import java.awt.*;

public class Tank extends GameObject{
    public int with = 40;
    public int height = 50;
    //speed
    private int speed = 3;
    //direction
    private Direction direction = Direction.UP;
    //Tank position
    private String upImg;
    private String downImg;
    private String leftImg;
    private String rightImg;

    public Tank(String img, int x, int y, GamePanel gamePanel,
                String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel);
        this.upImg = upImg;
        this.downImg =downImg;
        this.leftImg=leftImg;
        this.rightImg = rightImg;
    }


    @Override
    public void paintSelf(Graphics g) {
    }



    @Override
    public Rectangle getRec() {
        return null;
    }
}
