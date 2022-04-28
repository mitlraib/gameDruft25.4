import java.awt.*;

public class Obstacle {
    private CustomRectangle rectangle;
    private int direction;

    public Obstacle(CustomRectangle rectangle, int direction) {
        this.rectangle = rectangle;
        this.direction = direction;
    }

    public void paint (Graphics graphics){
        this.rectangle.paint(graphics);
    }

    public CustomRectangle getCustomRectangle(){

        return this.rectangle;
    }
}
