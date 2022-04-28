import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameScene extends JPanel {

    public static final int GAME_SPEED_FAST = 1;

    private ImageIcon background;
    private WaterGirl player;
    private ArrayList<Obstacle> obstacleList;
    private ArrayList<Obstacle> obstacle2List;
    private ImageIcon waterGirlPic;

    public GameScene (int x, int y, int width, int height) {
        this.setBounds(0, 0, 2000, 1000);


        this.waterGirlPic = new ImageIcon("watergirl.png");
        this.background = new ImageIcon("background.png");
        this.player = new WaterGirl(waterGirlPic);
        this.player.setX(60);
        this.player.setY(480);
        this.mainGameLoop();


        this.obstacleList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CustomRectangle pool = new CustomRectangle(495, 510, 100, 15, Color.red);
            CustomRectangle ceiling = new CustomRectangle(500, 300, 500, 15, Color.red);
            CustomRectangle lowerCeiling = new CustomRectangle(480, 410, 410, 17, Color.red);
            CustomRectangle upperCeiling = new CustomRectangle(150, 280, 350, 17, Color.red);
            CustomRectangle BeginningLowerCeiling = new CustomRectangle(50, 370, 410, 17, Color.red);
            CustomRectangle BeginningHighCeiling = new CustomRectangle(50, 210, 850, 17, Color.red);
            CustomRectangle HighCeiling = new CustomRectangle(300, 120, 700, 17, Color.red);



            Obstacle obstacle = new Obstacle(pool, WaterGirl.NONE);
            Obstacle obstacle2 = new Obstacle(ceiling, WaterGirl.NONE);
            Obstacle obstacle3 = new Obstacle(lowerCeiling, WaterGirl.NONE);
            Obstacle obstacle4 = new Obstacle(upperCeiling, WaterGirl.NONE);
            Obstacle obstacle5 = new Obstacle(BeginningLowerCeiling, WaterGirl.NONE);
            Obstacle obstacle6 = new Obstacle(BeginningHighCeiling, WaterGirl.NONE);
            Obstacle obstacle7 = new Obstacle(HighCeiling, WaterGirl.NONE);



            this.obstacleList.add(obstacle);
            this.obstacleList.add(obstacle2);
            this.obstacleList.add(obstacle3);
            this.obstacleList.add(obstacle4);
            this.obstacleList.add(obstacle5);
            this.obstacleList.add(obstacle6);
            this.obstacleList.add(obstacle7);



        }




        this.obstacle2List = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CustomRectangle diamondUpperRight = new CustomRectangle(590, 80, 20, 20, Color.cyan);
            CustomRectangle diamondUpperLeft = new CustomRectangle(70, 105, 20, 20, Color.cyan);
            CustomRectangle diamondLowerRight = new CustomRectangle(740, 480, 20, 20, Color.CYAN);
            CustomRectangle diamondMid = new CustomRectangle(610, 260, 20, 20, Color.CYAN);


            Obstacle diamond = new Obstacle(diamondUpperRight, WaterGirl.NONE);
            Obstacle diamond2 = new Obstacle(diamondUpperLeft, WaterGirl.NONE);
            Obstacle diamond3 = new Obstacle(diamondLowerRight, WaterGirl.NONE);
            Obstacle diamond4 = new Obstacle(diamondMid, WaterGirl.NONE);


            this.obstacle2List.add(diamond);
            this.obstacle2List.add(diamond2);
            this.obstacle2List.add(diamond3);
            this.obstacle2List.add(diamond4);


        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (Obstacle obstacle : obstacleList){
            obstacle.paint(g);
        }
        for (Obstacle obstacle : obstacle2List){
            obstacle.paint(g);
        }
        this.background.paintIcon(this,g,0,0);
        this.player.paint(g);


    }

    private void mainGameLoop () {
        new Thread(() -> {
            Movement movement = new Movement(this.player);
            repaint();
            this.setFocusable(true);
            this.requestFocus();
            this.addKeyListener(movement);
            for (int i = 0; i < obstacleList.size(); i++) {


            boolean collision = this.player.checkCollision(obstacleList.get(i));

            while (!collision) {
                for (Obstacle obstacle : this.obstacleList) {
                    if (this.player.checkCollision(obstacle)){
                        this.player.setX(20);
                        this.player.setY(470);
                    }
                }
                repaint();
                try {
                    Thread.sleep(GAME_SPEED_FAST);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            }
            for (int i = 0; i < obstacle2List.size(); i++) {


                boolean collision2 = this.player.checkCollision(obstacle2List.get(i));

                while (!collision2) {
                    for (Obstacle obstacle : this.obstacle2List) {
                        if (this.player.checkCollision(obstacle)){
                            System.out.println("yes");
                        }
                    }

                    /*  כאן ההתנגשות הייתה אמורה לעבוד אבל היא לא עובדת ואין לי מושג למה
                    בניסיון ה 324 התייאשתי (ניסתי אפילו לעשות מחלקה שונה עם מתודה נוספת ולא עבד)
                   כעיקרון היה אמור להיות התנגשות עם היהלומים ואז counter ליהלומים שאספתי
                   ואז בדיקת התנגשות גם עם הדלת ואם הגעתי לדלת ואספתי את כל היהלומים אז המשחק מסתיים.

                   המשחק הוא מבוך כעיקרון סתם מעוצב כמו בן האש ובת המים... בהצלחה ותודה :)
                     */

                    repaint();
                    try {
                        Thread.sleep(GAME_SPEED_FAST);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();
    }
}
