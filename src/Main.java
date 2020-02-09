import java.util.List;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        List<Card> cards = deck.getTwoCards();
        System.out.println(cards.get(0));
        System.out.println(cards.get(1));
    }
}
