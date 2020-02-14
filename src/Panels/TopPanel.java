package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPanel extends JPanel implements ActionListener {
    private Font mediumBoldFont;
    private JComboBox<String> typeComboBox;
    private int selectedIndex;
    private JPanel buttonsPanel;
    private JRadioButton UTGRadioButton;
    private JRadioButton UTG1RadioButton;
    private JRadioButton BTNRadioButton;
    private JRadioButton CORadioButton;
    private JRadioButton BBRadioButton;
    private JRadioButton SBRadioButton;
    private JRadioButton UTGRadioRaiseButton;
    private JRadioButton UTG1RadioRaiseButton;
    private JRadioButton BTNRadioRaiseButton;
    private JRadioButton CORadioRaiseButton;
    private JRadioButton BBRadioRaiseButton;
    private JRadioButton SBRadioRaiseButton;
    private JRadioButton UTGRadioCallButton;
    private JRadioButton UTG1RadioCallButton;
    private JRadioButton BTNRadioCallButton;
    private JRadioButton CORadioCallButton;
    private JRadioButton BBRadioCallButton;
    private JRadioButton SBRadioCallButton;
    private ButtonGroup positionRadioGroup;
    private ButtonGroup raiseRadioGroup;
    private ButtonGroup callRadioGroup;
    private String selectedType;
    private String selectedRadio;
    private String selectedRadioRaise;
    private String selectedRadioCall;
    private JPanel gamePanel;

    public TopPanel(){
        selectedRadioCall = "";
        selectedRadioRaise = "";
        mediumBoldFont = new Font("Serif", Font.BOLD, 16);
        JLabel pokerLabel = new JLabel("Poker Texas Holdem");
        pokerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pokerLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        typeComboBox = new JComboBox<>();
        typeComboBox.setPreferredSize(new Dimension(300,40));
        typeComboBox.addItem("-- Choose type --");
        typeComboBox.addItem("RFI");
        typeComboBox.addItem("vs RFI");
        typeComboBox.addItem("vs RFI and Call");
        typeComboBox.addItem("Blind vs Blind (After SB limp)");
        typeComboBox.addItem("Blind vs Blind (After SB raise)");
        typeComboBox.addItem("RFI vs 3-Bet");
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
            if(selectedIndex == 1)
                selectedType = "RFI";
            else if(selectedIndex == 2)
                selectedType = "vs RFI";
            else if(selectedIndex == 3)
                selectedType = "vs RFI and Call";
            else if(selectedIndex == 4)
                selectedType = "Blind vs Blind (After SB limp)";
            else if(selectedIndex == 5)
                selectedType = "Blind vs Blind (After SB raise)";
            else if(selectedIndex == 6)
                selectedType = "RFI vs 3-Bet";
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
            }else if(source == BTNRadioButton){
                selectedRadio = "BTN";
            }else if(source == CORadioButton){
                selectedRadio = "CO";
            }else if(source == SBRadioButton){
                selectedRadio = "SB";
            }else if(source == BBRadioButton){
                selectedRadio = "BB";
            }else if(source == UTGRadioRaiseButton){
                selectedRadioRaise = "UTG";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == UTG1RadioRaiseButton){
                selectedRadioRaise = "UTG1";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == BTNRadioRaiseButton){
                selectedRadioRaise = "BTN";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == CORadioRaiseButton){
                selectedRadioRaise = "CO";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == SBRadioRaiseButton){
                selectedRadioRaise = "SB";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == BBRadioRaiseButton){
                selectedRadioRaise = "BB";
                if(selectedIndex != 1 && selectedIndex != 3) setGamePanel();
            }else if(source == UTGRadioCallButton){
                selectedRadioCall = "UTG";
                setGamePanel();
            }else if(source == UTG1RadioCallButton){
                selectedRadioCall = "UTG1";
                setGamePanel();
            }else if(source == BTNRadioCallButton){
                selectedRadioCall = "BTN";
                setGamePanel();
            }else if(source == CORadioCallButton){
                selectedRadioCall = "CO";
                setGamePanel();
            }else if(source == SBRadioCallButton){
                selectedRadioCall = "SB";
                setGamePanel();
            }else if(source == BBRadioCallButton){
                selectedRadioCall = "BB";
                setGamePanel();
            }
            if(selectedIndex == 1) setGamePanel();
        }
    }

    private void setGamePanel(){
        if(gamePanel != null)
            remove(gamePanel);
        gamePanel = new GamePanel(selectedType, selectedRadio, selectedRadioRaise, selectedRadioCall);
        add(gamePanel, BorderLayout.PAGE_END);
        revalidate();
    }

    private void addButtons(){
        if(buttonsPanel != null)
            remove(buttonsPanel);
        selectedRadio = "";
        selectedRadioCall = "";
        selectedRadioRaise = "";
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        switch (selectedIndex){
            case 1:
                addPositionButtons();
                break;
            case 2:
            case 4:
            case 5:
            case 6:
                addPositionButtons();
                addRaiseButtons();
                break;
            case 3:
                addPositionButtons();
                addRaiseButtons();
                addCallButtons();
                break;

        }

        add(buttonsPanel, BorderLayout.EAST);
        revalidate();
    }

    private void addPositionButtons(){
        UTGRadioButton = new JRadioButton("UTG");
        UTGRadioButton.addActionListener(this);
        UTG1RadioButton = new JRadioButton("UTG +1");
        UTG1RadioButton.addActionListener(this);
        CORadioButton = new JRadioButton("CO");
        CORadioButton.addActionListener(this);
        BTNRadioButton = new JRadioButton("BTN");
        BTNRadioButton.addActionListener(this);
        SBRadioButton = new JRadioButton("SB");
        SBRadioButton.addActionListener(this);
        BBRadioButton = new JRadioButton("BB");
        BBRadioButton.addActionListener(this);
        positionRadioGroup = new ButtonGroup();
        positionRadioGroup.add(UTG1RadioButton);
        positionRadioGroup.add(UTGRadioButton);
        positionRadioGroup.add(CORadioButton);
        positionRadioGroup.add(BTNRadioButton);
        positionRadioGroup.add(BBRadioButton);
        positionRadioGroup.add(SBRadioButton);
        JPanel bPanel = new JPanel();
        JPanel pomPanel = new JPanel();
        bPanel.setLayout(new BorderLayout());
        pomPanel.setLayout(new FlowLayout());
        JLabel positionLabel = new JLabel("Position: ");
        positionLabel.setFont(mediumBoldFont);
        bPanel.add(positionLabel, BorderLayout.NORTH);
        pomPanel.add(UTGRadioButton);
        pomPanel.add(UTG1RadioButton);
        pomPanel.add(CORadioButton);
        pomPanel.add(SBRadioButton);
        pomPanel.add(BBRadioButton);
        bPanel.add(pomPanel, BorderLayout.CENTER);
        buttonsPanel.add(bPanel, BorderLayout.NORTH);
    }

    private void addRaiseButtons(){
        UTGRadioRaiseButton = new JRadioButton("UTG");
        UTG1RadioRaiseButton = new JRadioButton("UTG +1");
        CORadioRaiseButton = new JRadioButton("CO");
        BTNRadioRaiseButton = new JRadioButton("BTN");
        SBRadioRaiseButton = new JRadioButton("SB");
        BBRadioRaiseButton = new JRadioButton("BB");
        UTGRadioRaiseButton.addActionListener(this);
        UTG1RadioRaiseButton.addActionListener(this);
        CORadioRaiseButton.addActionListener(this);
        BTNRadioRaiseButton.addActionListener(this);
        SBRadioRaiseButton.addActionListener(this);
        BBRadioRaiseButton.addActionListener(this);
        raiseRadioGroup = new ButtonGroup();
        raiseRadioGroup.add(UTG1RadioRaiseButton);
        raiseRadioGroup.add(UTGRadioRaiseButton);
        raiseRadioGroup.add(CORadioRaiseButton);
        raiseRadioGroup.add(BTNRadioRaiseButton);
        raiseRadioGroup.add(SBRadioRaiseButton);
        raiseRadioGroup.add(BBRadioRaiseButton);
        JPanel bPanel = new JPanel();
        JPanel pomPanel = new JPanel();
        bPanel.setLayout(new BorderLayout());
        pomPanel.setLayout(new FlowLayout());
        JLabel positionLabel = new JLabel("Raise: ");
        positionLabel.setFont(mediumBoldFont);
        bPanel.add(positionLabel, BorderLayout.NORTH);
        pomPanel.add(UTGRadioRaiseButton);
        pomPanel.add(UTG1RadioRaiseButton);
        pomPanel.add(CORadioRaiseButton);
        pomPanel.add(SBRadioRaiseButton);
        pomPanel.add(BBRadioRaiseButton);
        bPanel.add(pomPanel, BorderLayout.CENTER);
        buttonsPanel.add(bPanel, BorderLayout.CENTER);
    }

    private void addCallButtons(){
        UTGRadioCallButton = new JRadioButton("UTG");
        UTG1RadioCallButton = new JRadioButton("UTG +1");
        CORadioCallButton = new JRadioButton("CO");
        BTNRadioCallButton = new JRadioButton("BTN");
        SBRadioCallButton = new JRadioButton("SB");
        BBRadioCallButton = new JRadioButton("BB");
        UTGRadioCallButton.addActionListener(this);
        UTG1RadioCallButton.addActionListener(this);
        CORadioCallButton.addActionListener(this);
        BTNRadioCallButton.addActionListener(this);
        SBRadioCallButton.addActionListener(this);
        BBRadioCallButton.addActionListener(this);
        callRadioGroup = new ButtonGroup();
        callRadioGroup.add(UTG1RadioRaiseButton);
        callRadioGroup.add(UTGRadioRaiseButton);
        callRadioGroup.add(CORadioRaiseButton);
        callRadioGroup.add(BTNRadioRaiseButton);
        callRadioGroup.add(SBRadioRaiseButton);
        callRadioGroup.add(BBRadioRaiseButton);
        JPanel bPanel = new JPanel();
        JPanel pomPanel = new JPanel();
        bPanel.setLayout(new BorderLayout());
        pomPanel.setLayout(new FlowLayout());
        JLabel positionLabel = new JLabel("Call: ");
        positionLabel.setFont(mediumBoldFont);
        bPanel.add(positionLabel, BorderLayout.NORTH);
        pomPanel.add(UTGRadioCallButton);
        pomPanel.add(UTG1RadioCallButton);
        pomPanel.add(CORadioCallButton);
        pomPanel.add(SBRadioCallButton);
        pomPanel.add(BBRadioCallButton);
        bPanel.add(pomPanel, BorderLayout.CENTER);
        buttonsPanel.add(bPanel, BorderLayout.SOUTH);
    }
}
