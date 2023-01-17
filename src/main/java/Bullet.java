import java.awt.*;

public class Bullet extends GameObject{

    //size
    int width = 10;
    int height = 10;
    //speed
    int speed = 7;
    //direction
    Direction direction;

    public Bullet(String img, int x, int y, GamePanel gamePanel, Direction direction) {
        super(img, x, y, gamePanel);
        this.direction = direction;
    }

    public void leftWard(){
        x -= speed;
    }
    public void rightWard(){
        x += speed;
    }
    public void upWard(){
        y -= speed;
    }
    public void downWard(){
        y += speed;
    }

    public void go(){
        switch (direction){
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




    @Override
    public void paintSelf(Graphics g) {
        g.drawImage(img,x,y,null);
        this.go();
    }

    @Override
    public Rectangle getRec() {
        return new Rectangle(x,y,width,height);
    }
}
