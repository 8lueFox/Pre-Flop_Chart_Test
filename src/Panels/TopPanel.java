package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private JLabel pokerLabel;
    private JComboBox<String> typeComboBox;
    private int selectedIndex;
    private JRadioButton UTGRadioButton;
    private JRadioButton UTG1RadioButton;
    private JRadioButton CORadioButton;
    private JRadioButton BBRadioButton;
    private JRadioButton SBRadioButton;
    private ButtonGroup positionRadioGroup;
    private String selectedRadio;
    private JPanel gamePanel;

    public TopPanel(){
        pokerLabel = new JLabel("Poker Texas Holdem");
        pokerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pokerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        typeComboBox = new JComboBox<>();
        typeComboBox.setPreferredSize(new Dimension(300,40));
        typeComboBox.addItem("-- Choose type --");
        typeComboBox.addItem("RFI");
        typeComboBox.addItem("RFI, 3BET");
        typeComboBox.addActionListener(this);
        setLayout(new BorderLayout(20,20));
        add(pokerLabel, BorderLayout.NORTH);
        add(typeComboBox, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == typeComboBox){
            selectedIndex = typeComboBox.getSelectedIndex();
            System.out.println("Type: " + typeComboBox.getItemAt(selectedIndex));
            if(selectedIndex != 0){
                addButtons();
            }
            if(gamePanel != null)
                remove(gamePanel);
        }
        else if(source instanceof JRadioButton){
            System.out.println("Radio's choose: " + ((JRadioButton) source).getText());
            if(source == UTGRadioButton){
                selectedRadio = "UTG";
            }else if(source == UTG1RadioButton){
                selectedRadio = "UTG1";
            }else if(source == CORadioButton){
                selectedRadio = "CO";
            }else if(source == SBRadioButton){
                selectedRadio = "SB";
            }else if(source == BBRadioButton){
                selectedRadio = "BB";
            }
            if(selectedIndex != 0)
                setGamePanel();
        }
    }

    private void addButtons(){
        UTGRadioButton = new JRadioButton("UTG");
        UTGRadioButton.addActionListener(this);
        UTG1RadioButton = new JRadioButton("UTG +1");
        UTG1RadioButton.addActionListener(this);
        CORadioButton = new JRadioButton("CO");
        CORadioButton.addActionListener(this);
        SBRadioButton = new JRadioButton("SB");
        SBRadioButton.addActionListener(this);
        BBRadioButton = new JRadioButton("BB");
        BBRadioButton.addActionListener(this);
        positionRadioGroup = new ButtonGroup();
        positionRadioGroup.add(UTG1RadioButton);
        positionRadioGroup.add(UTGRadioButton);
        positionRadioGroup.add(CORadioButton);
        positionRadioGroup.add(BBRadioButton);
        positionRadioGroup.add(SBRadioButton);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        buttonsPanel.add(UTGRadioButton);
        buttonsPanel.add(UTG1RadioButton);
        buttonsPanel.add(CORadioButton);
        buttonsPanel.add(SBRadioButton);
        buttonsPanel.add(BBRadioButton);

        add(buttonsPanel, BorderLayout.EAST);
        revalidate();
    }

    private void setGamePanel(){
        if(gamePanel != null)
            remove(gamePanel);
        gamePanel = new GamePanel(selectedIndex, selectedRadio);
        add(gamePanel, BorderLayout.PAGE_END);
        revalidate();
    }
}
