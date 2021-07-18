import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DeckTest {

    private Deck deck;
    private ArrayList<Card> cards;
    private Card card;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void canAddCardToDeck(){
        card = new Card(Suit.DIAMONDS, Rank.EIGHT);
        deck.addCard(card);
        assertEquals(1, deck.getCards().size());
    }

    @Test
    public void canPopulateDeck() {
        deck.populateDeck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void deckContainsAceSpades(){
        deck.populateDeck();
        card = new Card(Suit.SPADES,Rank.ACE);
        assertEquals(Suit.SPADES, deck.getCards().get(39).getSuit());
        assertEquals(Rank.ACE, deck.getCards().get(39).getRank());
    }

    @Test public void checkDeckIsShuffled(){
        deck.populateDeck();
        deck.shuffle();
        card = new Card(Suit.CLUBS,Rank.ACE);
        assertNotEquals(card.getSuit() , deck.getCards().get(0).getSuit());
        assertNotEquals(card.getRank(), deck.getCards().get(0).getRank());
    }
}
