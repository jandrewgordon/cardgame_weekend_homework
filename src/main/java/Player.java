import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        this.hand.add(card);
    }

    public int getHandTotal() {
        int total = 0;
        Boolean ace  = false;
        for(Card card : getHand()){
            total += card.getRank().getValue();
            if(card.getRank().getValue() == 11){
                ace = true;
            }
        }
        if(total == 21){
            if(ace == true){
                total += 1;
            }
        }
        return total;
    }


}
