package typing.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class TypingGame {

    public static ArrayList<String> getWords() {
        String filepath = "C:\\Users\\Brenson\\Documents\\NetBeansProjects\\PracticeMode\\Testing.txt";
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String app;
            String[] split;
            try {
                while ((app = br.readLine()) != null) {
                    split = app.split(" ");
                    for (String x : split) {
                        wordList.add(x);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(TypingGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(wordThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wordList;
    }

    public static void main(String[] args) {

        landingPage lp = new landingPage();
        mainframe mf = new mainframe();

        mf.getContentPane().removeAll();
        mf.getContentPane().add(lp);
        mf.setVisible(true);

        

        ActionListener btnListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == lp.getStart()) {
                    gamePage gp = new gamePage();
                    mf.getContentPane().removeAll();
                    mf.getContentPane().add(gp);
                    mf.setVisible(true);
                }
                if (e.getSource() == lp.getLeaderboards()) {
                    System.out.println("leaderboards pressed");
                }
                if (e.getSource() == lp.getSettings()) {
                    System.out.println("settings pressed");
                }
                if (e.getSource() == lp.getExit()) {
                    JOptionPane.showMessageDialog(mf, "Thanks for Playing!", "Exit Game", 0);
                    System.exit(0);
                }
            }
        };

        lp.getStart().addActionListener(btnListener);
        lp.getLeaderboards().addActionListener(btnListener);
        lp.getSettings().addActionListener(btnListener);
        lp.getExit().addActionListener(btnListener);
        
        
    }
}
