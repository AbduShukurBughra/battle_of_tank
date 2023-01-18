import java.awt.*;

public class Tank extends GameObject {
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

    //4 direction boolean
    boolean left = false;
    boolean right = false;
    boolean up = false;
    boolean down = false;

    //Attack mode
    private boolean attackCoolDown = true;
    private int attackCoolDownTime =1000;

    public Tank(String img, int x, int y, GamePanel gamePanel,
                String upImg, String downImg, String leftImg, String rightImg) {
        super(img, x, y, gamePanel);
        this.upImg = upImg;
        this.downImg = downImg;
        this.leftImg = leftImg;
        this.rightImg = rightImg;
    }

    public void leftWard() {
        x -= speed;
        setImg(leftImg);
        direction = Direction.LEFT;
    }

    public void upWard() {
        y -= speed;
        setImg(upImg);
        direction = Direction.UP;
    }

    public void rightWard() {
        x += speed;
        setImg(rightImg);
        direction = Direction.RIGHT;
    }

    public void downWard() {
        y += speed;
        setImg(downImg);
        direction = Direction.DOWN;
    }

    public void attack() {
        if (attackCoolDown){
        Point point = this.getHeadPoint();
        Bullet bullet = new Bullet("images/bullet00.png", point.x, point.y, this.gamePanel,direction);
        this.gamePanel.bulletList.add(bullet);
        new AttackCD().start();
    }
    }

    //new line
    class AttackCD extends Thread{
        public void run() {
            attackCoolDown = false;
            try{
                Thread.sleep(attackCoolDownTime);
            }catch (Exception e){
                e.printStackTrace();
            }
            attackCoolDown = true;
            this.stop();
        }
    }
    public Point getHeadPoint() {
       switch (direction) {
           case LEFT:
               return new Point(x, y+height/2);
           case RIGHT:
               return new Point(x+with, y+height/2);
           case UP:
               return new Point(x+with/2,y);
           case DOWN:
               return new Point(x+with,y+height);
           default:
               return null;
       }
    }

    public void setImg(String img) {
        this.img = Toolkit.getDefaultToolkit().getImage(img);
    }


    @Override
    public void paintSelf(Graphics g) {
    }

    @Override
    public Rectangle getRec() {
        return null;
    }


}
