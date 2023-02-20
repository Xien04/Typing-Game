package typing.game;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;

public class mainframe extends JFrame{
    
    JTextField textField;
    
    public mainframe(){
        super("Typing Master");
        
        setSize(800, 600);        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}