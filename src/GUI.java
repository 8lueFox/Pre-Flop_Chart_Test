import javax.swing.*;
import java.util.List;

public class GUI extends JFrame{
    private JPanel mainPanel;
    private JLabel mainLabel;
    private JComboBox typeComboBox;
    private JRadioButton UTGRadioButton;
    private JRadioButton UTG1RadioButton;
    private JRadioButton CORadioButton;
    private JRadioButton BBRadioButton;
    private JRadioButton SBRadioButton;
    private JButton foldButton;
    private JButton raiseButton;
    private JButton checkButton;
    private JPanel leftCard;
    private JPanel rightCard;

    private ButtonGroup positionRadioGroup;
    private Deck deck;

    public GUI(){
        deck = new Deck();

        setTitle("Poker Texas Holdem");
        setSize(600,500);
        add(mainPanel);

        positionRadioGroup = new ButtonGroup();
        positionRadioGroup.add(UTGRadioButton);
        positionRadioGroup.add(UTG1RadioButton);
        positionRadioGroup.add(CORadioButton);
        positionRadioGroup.add(BBRadioButton);
        positionRadioGroup.add(SBRadioButton);

        typeComboBox.addItem("RFI");
        typeComboBox.addItem("RFI, 3BET");

        setCardsOnTable(deck.getTwoCards());
    }

    private void setCardsOnTable(List<Card> cards){
        CardPanel panelLeft = new CardPanel(cards.get(0).getImage());
        CardPanel panelRight = new CardPanel(cards.get(1).getImage());

        leftCard = panelLeft;
        rightCard = panelRight;

        add(leftCard);
        add(rightCard);
    }

}
