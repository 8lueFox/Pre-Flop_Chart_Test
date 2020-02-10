package Panels;

import Cards.Card;
import Cards.Deck;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GamePanel extends JPanel implements ActionListener {
    private JPanel firstCardOnTable;
    private JPanel secondCardOnTable;
    private JPanel thirdCardOnTable;
    private JPanel fourthCardOnTable;
    private JPanel fifthCardOnTable;
    private JPanel firstCardInHand;
    private JPanel secondCardInHand;
    private JPanel cardOnTablePanel;
    private JPanel cardInHandPanel;
    private JButton foldButton;
    private JButton checkButton;
    private JButton raiseButton;
    private JLabel scoreLabel;

    private int selectedType;
    private int answers, answersGood;
    private String selectedRadio;
    private Deck deck;
    private List<Card> cards;

    GamePanel(int selectedType, String selectedRadio){
        this.selectedType = selectedType;
        this.selectedRadio = selectedRadio;
        deck = new Deck();
        answers = 0;
        answersGood = 0;
        setUpCards();

        setLayout(new BorderLayout());

        cardOnTablePanel = new JPanel();
        cardOnTablePanel.setPreferredSize(new Dimension(885,264));
        cardOnTablePanel.setLayout(new FlowLayout(5));
        cardOnTablePanel.add(firstCardOnTable);
        cardOnTablePanel.add(secondCardOnTable);
        cardOnTablePanel.add(thirdCardOnTable);
        cardOnTablePanel.add(fourthCardOnTable);
        cardOnTablePanel.add(fifthCardOnTable);
        add(cardOnTablePanel, BorderLayout.NORTH);

        cardInHandPanel = new JPanel();
        cardInHandPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        cardInHandPanel.add(firstCardInHand);
        cardInHandPanel.add(secondCardInHand);
        add(cardInHandPanel, BorderLayout.CENTER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        foldButton = new JButton("Fold");
        foldButton.setPreferredSize(new Dimension(150, 30));
        foldButton.setBackground(new Color(255,55,33,255));
        checkButton = new JButton("Check");
        checkButton.setBackground(new Color(16,255,29,255));
        checkButton.setPreferredSize(new Dimension(150,30));
        raiseButton = new JButton("Raise");
        raiseButton.setBackground(new Color(255,253,32,255));
        raiseButton.setPreferredSize(new Dimension(150,30 ));
        foldButton.addActionListener(this);
        raiseButton.addActionListener(this);
        checkButton.addActionListener(this);
        scoreLabel = new JLabel(answersGood + " / " + answers);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        buttonsPanel.add(foldButton);
        buttonsPanel.add(checkButton);
        buttonsPanel.add(raiseButton);
        buttonsPanel.add(scoreLabel);
        add(buttonsPanel, BorderLayout.SOUTH);

        invalidate();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source instanceof JButton){
            if(source == raiseButton){
                answers++;

                setAgainCards();
            }else if(source == checkButton){
                answers++;

                setAgainCards();
            }else if(source == foldButton){
                answers++;

                setAgainCards();
            }
            scoreLabel.setText(answersGood + " / " + answers);
            this.revalidate();

        }
    }

    private void setUpCards(){
        cards = deck.drawCards();
        firstCardOnTable = new CardPanel(cards.get(0).getImage());
        secondCardOnTable = new CardPanel(cards.get(1).getImage());
        thirdCardOnTable = new CardPanel(cards.get(2).getImage());
        fourthCardOnTable = new CardPanel(cards.get(3).getImage());
        fifthCardOnTable = new CardPanel(cards.get(4).getImage());
        firstCardInHand = new CardPanel(cards.get(5).getImage());
        secondCardInHand = new CardPanel(cards.get(6).getImage());
    }

    private void setAgainCards(){
        cardOnTablePanel.remove(firstCardOnTable);
        cardOnTablePanel.remove(secondCardOnTable);
        cardOnTablePanel.remove(thirdCardOnTable);
        cardOnTablePanel.remove(fourthCardOnTable);
        cardOnTablePanel.remove(fifthCardOnTable);

        cardInHandPanel.remove(firstCardInHand);
        cardInHandPanel.remove(secondCardInHand);

        cards = deck.drawCards();
        firstCardOnTable = new CardPanel(cards.get(0).getImage());
        secondCardOnTable = new CardPanel(cards.get(1).getImage());
        thirdCardOnTable = new CardPanel(cards.get(2).getImage());
        fourthCardOnTable = new CardPanel(cards.get(3).getImage());
        fifthCardOnTable = new CardPanel(cards.get(4).getImage());
        firstCardInHand = new CardPanel(cards.get(5).getImage());
        secondCardInHand = new CardPanel(cards.get(6).getImage());

        cardOnTablePanel.add(firstCardOnTable);
        cardOnTablePanel.add(secondCardOnTable);
        cardOnTablePanel.add(thirdCardOnTable);
        cardOnTablePanel.add(fourthCardOnTable);
        cardOnTablePanel.add(fifthCardOnTable);

        cardInHandPanel.add(firstCardInHand);
        cardInHandPanel.add(secondCardInHand);
    }
}
