package Frames;

import Cards.Card;
import Core.BadAnswer;
import Panels.CardPanel;
import Panels.GamePanel;

import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WrongAnswersFrame extends JFrame {
    private List<BadAnswer> badAnswerList;
    private String filePath;

    public WrongAnswersFrame(){
        setSize(450,1000);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocation();
        setTitle("Wrong Answers");
        setLayout(new BorderLayout());
        setVisible(true);
        loadAnswers();
        displayAnswers();
    }

    private void setLocation(){
        GraphicsConfiguration config = this.getGraphicsConfiguration();
        Rectangle bounds = config.getBounds();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(config);

        int x = bounds.x + bounds.width - insets.right - this.getWidth();
        int y = bounds.y + insets.top;
        this.setLocation(x, y);
    }

    private void loadAnswers(){
        badAnswerList = new ArrayList<>();
        filePath = "./badAnswers.txt";
        BufferedReader fileReader;

        try{
            fileReader = new BufferedReader(new FileReader(filePath));
            String s = fileReader.readLine();
            do{
                if(s != null)
                    badAnswerList.add(new BadAnswer(s));
                s = fileReader.readLine();
            }while (s != null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAnswers(){
        // Header
        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel label1 = new JLabel("First Card | ");
        JLabel label2 = new JLabel("Second Card | ");
        JLabel label3 = new JLabel("Your Answer | ");
        JLabel label4 = new JLabel("Correct Answer");
        topPanel.add(label1);
        topPanel.add(label2);
        topPanel.add(label3);
        topPanel.add(label4);
        add(topPanel, BorderLayout.NORTH);
        // Body
        JPanel answersPanel = new JPanel(new GridLayout(badAnswerList.size(), 4));
        for(int i = 0; i < badAnswerList.size(); i++){
            Card cardPom1 = badAnswerList.get(i).getCard1();
            Card cardPom2 = badAnswerList.get(i).getCard2();
            cardPom1.resize(69,106);
            cardPom2.resize(69,106);
            CardPanel cardPanel1 = new CardPanel(cardPom1.getImage());
            CardPanel cardPanel2 = new CardPanel(cardPom2.getImage());
            cardPanel1.setNewSize(69,106);
            cardPanel2.setNewSize(69,106);
            answersPanel.add(cardPanel1);
            answersPanel.add(cardPanel2);
            answersPanel.add(new JLabel(badAnswerList.get(i).getGoodAnswer()));
            answersPanel.add(new JLabel(badAnswerList.get(i).getAnswer()));
        }
        JScrollPane answersScrollPanel = new JScrollPane(answersPanel);
        add(answersScrollPanel, BorderLayout.CENTER);
    }
}
