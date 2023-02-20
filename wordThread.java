package typing.game;

import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class wordThread extends Thread {

    int x;
    int y;
    int width;
    int height;
    int distance;
    int finishedLine;
    int score;
    JLabel text;

    gamePage frame;
    Random rand = new Random();
    String name;
    JPanel txtArea;

    public wordThread(gamePage frame, JPanel textArea, String labelWord) {
        this.frame = frame;
        this.txtArea = textArea;
        this.x = rand.nextInt(900) - 200;
        this.y = -120;
        this.width = 100;
        this.height = 100;
        this.distance = 0;
        this.score = 0;
        this.finishedLine = 450;
        this.name = labelWord;

        text = new JLabel(name);
        text.setBounds(x, y, width, height);
        txtArea.add(text);
    }

    public void run() {
        try {
            sleep(rand.nextInt(5000));
            while (y < finishedLine) {
                distance = y;
                y++;
                text.setBounds(x, y, width, height);
                txtArea.revalidate();
                sleep(20);
                if (frame.textField.getText().equalsIgnoreCase(name)) {
                    System.out.println("Reading");
                    String x = frame.getTextField().getText();
                    frame.setScore(x.length());
                    text.setVisible(false);
                    frame.setTextField();
                    frame.revalidate();
                    stop();
                    if (frame.counter == 0) {

                    }
                }
            }
            System.out.println("Done");
            stop();
            frame.revalidate();
        } catch (InterruptedException ex) {
            Logger.getLogger(wordThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
