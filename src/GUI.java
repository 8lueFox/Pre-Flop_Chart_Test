import panels.TopPanel;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel leftCardPanel;
    private JPanel rightCardPanel;
    private JPanel buttonsPanel;
    private JButton foldButton;
    private JButton raiseButton;
    private JButton checkButton;

    private Deck deck;

    public GUI(){
        deck = new Deck();
        init();
        setSize(600,500);
        setLayout(new BorderLayout(5, 5));
        topPanel = new TopPanel();
        mainPanel.add(topPanel, BorderLayout.PAGE_START);

        add(mainPanel);
        setVisible(true);
    }

    private void init(){
        mainPanel = new JPanel();
        topPanel = new JPanel();
        leftCardPanel = new JPanel();
        rightCardPanel = new JPanel();
        buttonsPanel = new JPanel();
        foldButton = new JButton("Fold");
        raiseButton = new JButton("Raise");
        checkButton = new JButton("Check");
        setTitle("Poker Texas Holdem");
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
