package Frames;

import Panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;

    public GUI(){
        init();
        setSize(1000,650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));
        topPanel = new TopPanel();
        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        add(mainPanel);
        setVisible(true);
    }

    private void init(){
        mainPanel = new JPanel();
        topPanel = new JPanel();
        setTitle("Pre-Flop Chart Test");
    }

    public static void main(String[] args) {
        new GUI();
    }
}
