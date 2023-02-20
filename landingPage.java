package typing.game;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class landingPage extends JPanel {

    JLabel name;
    JButton start;
    JButton leaderboards;
    JButton settings;
    JButton exit;
    JOptionPane selection;

    public landingPage() {
        setLayout(new GridBagLayout());
        GridBagConstraints gb = new GridBagConstraints();
        Font arcade = new Font("ArcadeClassic", Font.PLAIN, 50);

        gb.insets = new Insets(1, 1, 1, 1);

        name = new JLabel("Typing Master");
        name.setHorizontalAlignment(JLabel.CENTER);
        name.setSize(500, 500);
        name.setFont(arcade);
        gb.weighty = 20;
        gb.fill = GridBagConstraints.BOTH;
        gb.gridx = 0;
        gb.gridy = 0;
        add(name, gb);

        gb.weighty = 1;

        arcade = new Font("ArcadeClassic", Font.PLAIN, 20);

        gb.fill = GridBagConstraints.BOTH;
        start = new JButton("Start");
        start.setFont(arcade);
        gb.gridx = 0;
        gb.gridy = 1;
        add(start, gb);

        leaderboards = new JButton("Leaderboards");
        leaderboards.setFont(arcade);
        gb.gridx = 0;
        gb.gridy = 2;
        add(leaderboards, gb);

        settings = new JButton("Settings");
        settings.setFont(arcade);
        gb.gridx = 0;
        gb.gridy = 3;
        add(settings, gb);

        gb.insets = new Insets(0, 0, 75, 0);

        exit = new JButton("Exit");
        exit.setFont(arcade);
        gb.gridx = 0;
        gb.gridy = 4;
        add(exit, gb);
    }
    
    public JButton getStart() {
        return start;
    }

    public JButton getLeaderboards() {
        return leaderboards;
    }

    public JButton getSettings() {
        return settings;
    }

    public JButton getExit() {
        return exit;
    }
}
