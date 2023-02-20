package typing.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;
import static typing.game.TypingGame.getWords;

public class gamePage extends JPanel implements ActionListener {

    ArrayList<String> wordList = new ArrayList<>();
    ArrayList<String> wordstoSend = new ArrayList<>();
    public static List<wordThread> wt = new ArrayList<>();
    Random rand = new Random();
    JTextField textField;
    JPanel textArea;
    JButton start;
    JLabel word;
    JLabel score;
    JLabel level;
    mainframe mf;
    int scoreC;
    int counter;

    public gamePage() {
        Border border = BorderFactory.createLineBorder(Color.black);
        wordList = TypingGame.getWords();
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        Font arcade = new Font("ArcadeClassic", Font.PLAIN, 20);

        gb.insets = new Insets(5, 5, 5, 5);

        start = new JButton("Start");
        start.setFont(arcade);
        gb.ipadx = 40;
        gb.gridx = 0;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.VERTICAL;
        gb.anchor = GridBagConstraints.NORTH;
        gb.gridwidth = 2;
        gb.weightx = 0.02;
        gb.weighty = 0.02;
        add(start, gb);

        gb.ipadx = 0;
        gb.ipady = 0;

        textArea = new JPanel();
        textArea.setBorder(border);
        textArea.setLayout(null);
        gb.gridwidth = 2;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.gridx = 0;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.BOTH;
        gb.anchor = GridBagConstraints.CENTER;
        add(textArea, gb);

        gb.gridwidth = 1;

        textField = new JTextField(20);
        textField.setBorder(border);
        gb.gridx = 0;
        gb.gridy = 2;
        gb.weightx = 0.02;
        gb.weighty = 0.02;
        gb.fill = GridBagConstraints.VERTICAL;
        gb.anchor = GridBagConstraints.LINE_END;
        add(textField, gb);

        score = new JLabel("Score: ");
        score.setFont(arcade);
        gb.gridx = 1;
        gb.gridy = 2;
        gb.weightx = 0.02;
        gb.weighty = 0.02;
        gb.fill = GridBagConstraints.VERTICAL;
        gb.anchor = GridBagConstraints.SOUTH;
        add(score, gb);

        for (int i = 0; i < 5; i++) {
            boolean reroll = true;
            String x = "";
            do { //avoid spawn duplicate words 
                x = wordList.get(rand.nextInt(wordList.size()));
                if (wordstoSend.contains(x) == false) {
                    reroll = false;
                    wordstoSend.add(x);
                }
            } while (reroll);
            wordThread t = new wordThread(this, textArea, x);
            wt.add(t);
        }

        counter = wordstoSend.size();
        getStart().addActionListener(this);
    }

    public static void startRun() {
        for (wordThread t : wt) {
            t.start();
        }
    }

    public void setScore(int x) {
        scoreC = scoreC + x;
        score.setText("Score > " + scoreC);
        // Picking a random name from a Array
        String[] getNames = new String[]{"Bob", "Candy", "xHunterx", "Jackas", "Naruto", "Saitama"};
        Random rand = new Random();
        int randX = rand.nextInt(6);
        String name = getNames[randX]; //randomed Names 
        
        // Getting the date 
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        // Writer the score to a file 
        File f = new File("Testing.txt");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.append("\n" + String.valueOf(scoreC) + "\t" + name + "\t" + String.valueOf(df.format(date)));
            bw.close();
        }catch(IOException e){e.printStackTrace();} 
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField() {
        textField.setText("");
    }

    public JButton getStart() {
        return start;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getStart()) {
            getStart().disable();
            startRun();
        }
    }
}
