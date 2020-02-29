package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.io.File;

public class TopPanel extends JPanel implements ActionListener {
    private JComboBox<String> typeComboBox;
    private ButtonGroup[] radioGroups;
    private JPanel buttonsPanel;
    private JPanel gamePanel;
    private JPanel panelPom;
    private JPanel topPanel;
    private String selectedType;
    private String path;
    private int iPosition;
    private int selectedIndex;
    private int radioGroupsIndex;
    private String pos0 = "";
    private String pos1 = "";
    private String pos2 = "";

    public TopPanel(){
        radioGroups = new ButtonGroup[3];
        radioGroupsIndex = 0;
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
        topPanel = new JPanel(new BorderLayout());
        topPanel.setSize(1000,200);
        JPanel tempPanel = new JPanel(new FlowLayout());
        tempPanel.add(typeComboBox);
        buttonsPanel = new JPanel();
        buttonsPanel.setSize(500,200);
        tempPanel.setSize(500,200);
        topPanel.add(tempPanel, BorderLayout.NORTH);
        topPanel.add(buttonsPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == typeComboBox){
            selectedIndex = typeComboBox.getSelectedIndex();
            switch (selectedIndex){
                case 1: selectedType = "RFI"; break;
                case 2: selectedType = "vs RFI"; break;
                case 3: selectedType = "vs RFI and Call"; break;
                case 4: selectedType = "Blind vs Blind (After SB limp)"; break;
                case 5: selectedType = "Blind vs Blind (After SB raise)"; break;
                case 6: selectedType = "RFI vs 3-Bet";
            }
            if(selectedIndex == 3)
                iPosition = 2;
            else if(selectedIndex == 1)
                iPosition = 0;
            else
                iPosition = 1;

            path = "./charts/" + selectedType;
            addButtons();
            if(gamePanel != null)
                remove(gamePanel);
        }
        else {
            AbstractButton btn;
            for(Enumeration<AbstractButton> btns = radioGroups[0].getElements(); btns.hasMoreElements();){
                btn = btns.nextElement();
                String btnTempText = "/" + btn.getText();
                if(btn.isSelected() && !pos0.equals("") && !btnTempText.equals(pos0)) {
                    if(radioGroups[2] != null) {
                        buttonsPanel.remove(2);
                        radioGroupsIndex = 2;
                        radioGroups[2] = null;
                        pos2 = "";
                    }
                    if(radioGroups[1] != null){
                        buttonsPanel.remove(1);
                        radioGroups[1] = null;
                        pos1 = "";
                    }
                    if(selectedIndex == 3){
                        iPosition = 1;
                    }else {
                        iPosition = 0;
                    }
                    radioGroupsIndex = 1;
                    if(gamePanel != null)
                        remove(gamePanel);
                    pos0 = "/" + btn.getText();
                }else if(btn.isSelected()){
                    if(gamePanel != null)
                        remove(gamePanel);
                    pos0 = "/" + btn.getText();
                }
            }
            if(radioGroups[1] != null){
                for(Enumeration<AbstractButton> btns = radioGroups[1].getElements(); btns.hasMoreElements();){
                    btn = btns.nextElement();
                    String btnTempText = "/" + btn.getText();
                    if(btn.isSelected() && !pos1.equals("") && !btnTempText.equals(pos1)) {
                        if(radioGroups[2] != null) {
                            buttonsPanel.remove(2);
                            radioGroups[2] = null;
                            pos2 = "";
                        }
                        radioGroupsIndex = 2;
                        iPosition = 0;
                        if(gamePanel != null)
                            remove(gamePanel);
                        pos1 = "/" + btn.getText();
                    }else if(btn.isSelected()){
                        if(gamePanel != null)
                            remove(gamePanel);
                        pos1 = "/" + btn.getText();
                    }
                }
            }
            if(radioGroups[2] != null){
                for(Enumeration<AbstractButton> btns = radioGroups[2].getElements(); btns.hasMoreElements();){
                    btn = btns.nextElement();
                    if(btn.isSelected()) {
                        if(gamePanel != null)
                            remove(gamePanel);
                        pos2 = "/" + btn.getText();
                    }
                }
            }
            String tempPath = path + pos0 + pos1 + pos2 + ".txt";
            File file = new File(tempPath);
            if(file.isFile())
                setGamePanel(tempPath);
            else{
                addRadioButtons2();
            }
        }
    }


    private void setGamePanel(String path){
        if(gamePanel != null)
            remove(gamePanel);
        gamePanel = new GamePanel(path);
        add(gamePanel, BorderLayout.SOUTH);
        revalidate();
    }

    private void addButtons(){
        if(buttonsPanel != null)
            topPanel.remove(buttonsPanel);
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BorderLayout());
        radioGroups = new ButtonGroup[3];
        pos0 = "";
        pos1 = "";
        pos2 = "";
        radioGroupsIndex = 0;
        addRadioButtons2();
        topPanel.add(buttonsPanel, BorderLayout.CENTER);
        revalidate();
    }


    private void addRadioButtons2() {
        File directory = new File(path + pos0 + pos1 + pos2);
        File[] files = directory.listFiles();

        panelPom = new JPanel(new FlowLayout());
        panelPom.setSize(200,50);
        JRadioButton radioButton;
        radioGroups[radioGroupsIndex] = new ButtonGroup();
        if(selectedIndex == 3) {
            if(iPosition == 2) {
                panelPom.add(new JLabel("Raise: "));
                iPosition--;
            }else if(iPosition == 1){
                panelPom.add(new JLabel("Call: "));
                iPosition--;
            }
            else{
                panelPom.add(new JLabel("Your's position: "));
            }
        }
        else {
            if (iPosition == 1) {
                panelPom.add(new JLabel("Raise: "));
                iPosition--;
            } else {
                panelPom.add(new JLabel("Your's position: "));
            }
        }
        if(files != null){
            for(File file : files){
                String[] pom = file.getName().split("\\.");
                radioButton = new JRadioButton(pom[0]);
                radioButton.addActionListener(this);
                radioGroups[radioGroupsIndex].add(radioButton);
                panelPom.add(radioButton);
            }
            if(radioGroupsIndex == 0)
                buttonsPanel.add(panelPom, BorderLayout.NORTH);
            else if(radioGroupsIndex == 1)
                buttonsPanel.add(panelPom, BorderLayout.CENTER);
            else if(radioGroupsIndex == 2)
                buttonsPanel.add(panelPom, BorderLayout.SOUTH);
            radioGroupsIndex++;
            revalidate();
        }
    }
}
