import java.awt.*;
import java.util.Random;

public class Bot extends Tank {

    int moveTime = 0;

    public Bot(String img, int x, int y, GamePanel gamePanel, String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel, upImg, downImg, leftImg, rightImg);
    }

    public Direction getRandomDirection() {
        Random random = new Random();
        int randomNum = random.nextInt(4);
        switch (randomNum) {
            case 0:
                return Direction.LEFT;
            case 1:
                return Direction.RIGHT;
            case 2:
                return Direction.UP;
            case 3:
                return Direction.DOWN;
            default:
                return null;
        }

    }

    public void go() {
        attack();
        if (moveTime >= 20) {
            direction = getRandomDirection();
            moveTime = 0;
        } else {
            moveTime++;
        }
        switch(direction) {
            case LEFT:
                leftWard();
                break;
            case RIGHT:
                rightWard();
                break;
            case UP:
                upWard();
                break;
            case DOWN:
                downWard();
                break;
        }
    }

    public void attack() {
        Point point = new Point();
        Random rand = new Random();
        int randomNum = rand.nextInt(100);
        if(randomNum < 4){
            this.gamePanel.bulletList.add(new EnemyBullet("images/enemy/enemyBullet.png", point.x, point.y, this.gamePanel,direction));
        }
    }

    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img, x, y, null);
        go();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x, y, with, height);
    }
}
