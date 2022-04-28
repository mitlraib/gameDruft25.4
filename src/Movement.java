import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Movement implements KeyListener {
    private WaterGirl player;

    public Movement (WaterGirl player) {
        this.player = player;

    }

    public void keyTyped(KeyEvent e) {
    }
    boolean pressedKey= false;

   public void keyPressed(KeyEvent e) {
       if (e.getKeyCode()==KeyEvent.VK_UP){
           this.player.jump();
           pressedKey =true;
       }
       else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.player.moveRight();
            pressedKey =true;
        }
        else if (e.getKeyCode()==KeyEvent.VK_LEFT){
            this.player.moveLeft();
            pressedKey =true;
        }

        else if (e.getKeyCode()==KeyEvent.VK_DOWN){
            this.player.moveDown();
        }



    }
    public void keyReleased(KeyEvent e) {

        this.player.moveDown();

    }
}
