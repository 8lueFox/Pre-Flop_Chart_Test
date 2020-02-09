import java.util.ArrayList;
import java.util.List;
import java.util.Random;
class Deck {
    private List<Card> cardList;

    Deck(){
        completeDeck();
    }

    List<Card> getTwoCards(){
        List<Card> twoCards = new ArrayList<>();
        Random generator = new Random();
        Card card;
        for(int i = 0; i < 2; i++){
            card = cardList.get(generator.nextInt(cardList.size()));
            if(isDrawn(card, twoCards))
                i--;
            else
                twoCards.add(card);
        }
        return twoCards;
    }

    private boolean isDrawn(Card card, List<Card> cards){
        for (Card value : cards){
            if(value.equals(card))
                return true;
        }
        return false;
    }

    private void completeDeck(){
        cardList = new ArrayList<>();

        cardList.add(new Card("2", "C"));
        cardList.add(new Card("3", "C"));
        cardList.add(new Card("4", "C"));
        cardList.add(new Card("5", "C"));
        cardList.add(new Card("6", "C"));
        cardList.add(new Card("7", "C"));
        cardList.add(new Card("8", "C"));
        cardList.add(new Card("9", "C"));
        cardList.add(new Card("10", "C"));
        cardList.add(new Card("J", "C"));
        cardList.add(new Card("Q", "C"));
        cardList.add(new Card("K", "C"));
        cardList.add(new Card("A", "C"));

        cardList.add(new Card("2", "D"));
        cardList.add(new Card("3", "D"));
        cardList.add(new Card("4", "D"));
        cardList.add(new Card("5", "D"));
        cardList.add(new Card("6", "D"));
        cardList.add(new Card("7", "D"));
        cardList.add(new Card("8", "D"));
        cardList.add(new Card("9", "D"));
        cardList.add(new Card("10", "D"));
        cardList.add(new Card("J", "D"));
        cardList.add(new Card("Q", "D"));
        cardList.add(new Card("K", "D"));
        cardList.add(new Card("A", "D"));

        cardList.add(new Card("2", "H"));
        cardList.add(new Card("3", "H"));
        cardList.add(new Card("4", "H"));
        cardList.add(new Card("5", "H"));
        cardList.add(new Card("6", "H"));
        cardList.add(new Card("7", "H"));
        cardList.add(new Card("8", "H"));
        cardList.add(new Card("9", "H"));
        cardList.add(new Card("10", "H"));
        cardList.add(new Card("J", "H"));
        cardList.add(new Card("Q", "H"));
        cardList.add(new Card("K", "H"));
        cardList.add(new Card("A", "H"));

        cardList.add(new Card("2", "S"));
        cardList.add(new Card("3", "S"));
        cardList.add(new Card("4", "S"));
        cardList.add(new Card("5", "S"));
        cardList.add(new Card("6", "S"));
        cardList.add(new Card("7", "S"));
        cardList.add(new Card("8", "S"));
        cardList.add(new Card("9", "S"));
        cardList.add(new Card("10", "S"));
        cardList.add(new Card("J", "S"));
        cardList.add(new Card("Q", "S"));
        cardList.add(new Card("K", "S"));
        cardList.add(new Card("A", "S"));
    }
}
