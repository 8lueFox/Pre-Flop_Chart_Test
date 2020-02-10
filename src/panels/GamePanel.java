package panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel implements ActionListener {
    private int selectedType;
    private String selectedRadio;

    public GamePanel(int selectedType, String selectedRadio){
        this.selectedType = selectedType;
        this.selectedRadio = selectedRadio;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
