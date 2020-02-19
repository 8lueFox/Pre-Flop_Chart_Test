package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.io.File;

public class TopPanel extends JPanel implements ActionListener {
    private JComboBox<String> typeComboBox;
    private ButtonGroup positionRadioGroup;
    private JPanel buttonsPanel;
    private JPanel gamePanel;
    private JPanel panelPom;
    private String selectedType;
    private String path;

    public TopPanel(){
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
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(typeComboBox);
        add(topPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == typeComboBox){
            int selectedIndex = typeComboBox.getSelectedIndex();
            switch (selectedIndex){
                case 1: selectedType = "RFI"; break;
                case 2: selectedType = "vs RFI"; break;
                case 3: selectedType = "vs RFI and Call"; break;
                case 4: selectedType = "Blind vs Blind (After SB limp)"; break;
                case 5: selectedType = "Blind vs Blind (After SB raise)"; break;
                case 6: selectedType = "RFI vs 3-Bet";
            }

            path = "./charts/" + selectedType;
            addButtons();
            if(gamePanel != null)
                remove(gamePanel);
        }
        else {
            for(Enumeration<AbstractButton> buttons = positionRadioGroup.getElements(); buttons.hasMoreElements();){
                AbstractButton button = buttons.nextElement();
                if(button.isSelected()){
                    String tempPath = path + "/" +button.getText();
                    File file = new File(tempPath);
                    if(file.isFile()){
                        setGamePanel(tempPath);
                    }
                    else{
                        path = path + "/" +button.getText();
                        addRadioButtons();
                    }
                }
            }
        }
    }

    private void setGamePanel(String path){
        if(gamePanel != null)
            remove(gamePanel);
        gamePanel = new GamePanel(path);
        add(gamePanel, BorderLayout.PAGE_END);
        revalidate();
    }

    private void addButtons(){
        if(buttonsPanel != null)
            remove(buttonsPanel);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        addRadioButtons();
        add(buttonsPanel, BorderLayout.EAST);
        revalidate();
    }

    private void addRadioButtons(){
        File directory = new File(path);
        File[] files = directory.listFiles();
        if(panelPom != null)
            buttonsPanel.remove(panelPom);
        panelPom = new JPanel(new FlowLayout());
        panelPom.setSize(200,50);
        positionRadioGroup = new ButtonGroup();
        JRadioButton radioButton;
        if(files != null){
            for(File file : files){
                radioButton = new JRadioButton(file.getName());
                radioButton.addActionListener(this);
                positionRadioGroup.add(radioButton);
                panelPom.add(radioButton);
            }
        }
        buttonsPanel.add(panelPom);
        revalidate();
    }
}
