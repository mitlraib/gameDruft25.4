import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;




public class Main extends JFrame {

    public static final int WINDOW_WIDTH = 2000;
    public static final int WINDOW_HEIGHT = 1000;

    public static void main(String[] args) {
        new Main();
    }

    public Main () {
        initUI();
    }



        private void initUI() {
            this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

            JTextArea description = new JTextArea(
                    "   Mission: collect all the diamonds without touching the floor or the ceiling :) \n"+"\n"+
                            "   (the first floor was given to adjust, but avoid the hot lava :O)\n"+"\n"+"\n"+
                    "    Press Left arrow to move left <- \n" +
                            "    Press Right arrow to move right ->\n" +
                            "    Press Up arrow to move up  ^ \n" +
                            "    Press Down arrow to move down V \n" +"\n" +"\n"+
                            "   Hint: every time you realise a key, WaterGirl will get down, so be careful :D \n"+"\n"+"\n"
            );

            Font myPont = new Font("myPont",Font.ITALIC,25);
            description.setFont(myPont);
            description.setForeground(Color.black);
            description.setBackground(Color.PINK);



            description.setBounds(100,50,900,700);
            description.setVisible(true);

            JButton btnStart = new JButton(" Start Game ");
            btnStart.setBounds(400,500,200,100);
            setLayout(null);
            btnStart.setVisible(true);
            add(btnStart);
            add(description);
            btnStart.addActionListener((e -> {
                GameScene gameScene = new GameScene(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                this.add(gameScene);

                btnStart.setVisible(false);
                description.setVisible(false);


            }));


            this.setLocationRelativeTo(null);
            this.setLayout(null);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
            this.setLayout(new BorderLayout());


        }
    }


