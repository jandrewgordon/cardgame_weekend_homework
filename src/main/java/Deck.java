import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void populateDeck() {
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                Card newCard = new Card(suit, rank);
                addCard(newCard);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.getCards());
    }
}
