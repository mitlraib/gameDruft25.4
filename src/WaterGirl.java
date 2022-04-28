import javax.swing.*;
import java.awt.*;

public class WaterGirl extends Component {

    public static final int NONE = 0;


    private int direction;
    private int x;
    private int y;
    private int height;
    private int width;
    private Image image;
    private ImageIcon imageIcon;

    public WaterGirl(ImageIcon image) {
        imageIcon = new ImageIcon("watergirl.png");
        width = image.getIconWidth();
        height = image.getIconHeight();
        this.direction = NONE;
    }

    public void paint(Graphics graphics) {
        this.imageIcon.paintIcon(this, graphics, getX(), getY());
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public void moveRight() {
        this.x++;
    }

    public void moveLeft() {
        this.x--;
    }

    public void jump() {

        this.y--;
    }

    public void moveDown() {

        if (this.y <= 480) {
            this.y = this.y + 10;
        }


    }


    public boolean checkCollision(Obstacle obstacle) {
        boolean collision = false;

        Rectangle obstacleRect = new Rectangle(
                obstacle.getCustomRectangle().getX(),
                obstacle.getCustomRectangle().getY(),
                obstacle.getCustomRectangle().getWidth(),
                obstacle.getCustomRectangle().getHeight());
        {

            Rectangle waterBodyRect = new Rectangle(
                    this.getX(),
                    this.getY(),
                    this.getHeight(),
                    this.getWidth());

            if (obstacleRect.intersects(waterBodyRect)) {
                collision = true;
            }
            return collision;
        }
    }



}
