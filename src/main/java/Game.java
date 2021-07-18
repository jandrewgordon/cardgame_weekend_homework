import java.util.ArrayList;

public class Game {

    private Player player1;
    private Dealer dealer;
    private Deck deck;
    private ArrayList<Card> table;

    public Game(Player player1, Dealer dealer, Deck deck) {
        this.player1 = player1;
        this.dealer = dealer;
        this.deck = deck;
        this.table = new ArrayList<>();
    }

    public void addCard(Card card){
        table.add(card);
    }

    public String playRound(String string){
        String roundResult = null;
        while(!playerBust(player1) && !dealerBust(dealer)){
            while(roundResult == null) {
                String playerChoice = string;
                dealer.dealRound(player1, this);
                Boolean endTurn = handleStick(player1, dealer, playerChoice);
                if (endTurn) {
                    roundResult = dealer.findHighestHand(player1, dealer);
                }
            }
        }
        return roundResult;
    }

    public Boolean handleStick(Player player1, Dealer dealer, String playerChoice){
        Boolean bothStuck = false;
        Boolean dealerStuck = false;
        if(playerChoice == "twist"){
            dealer.dealPlayerCard(player1);
        }
        if(dealer.getHandTotal() < 16){
            dealer.dealDealerCard();
            dealerStuck = false;
        } else if(dealer.getHandTotal() > 16) {
            dealerStuck = true;
        }

        if(playerChoice == "stick" && dealerStuck == true){
            bothStuck = true;
        }

        return bothStuck;
    }

    public Boolean playerBust(Player player){
        if(player.getHandTotal() > 21){
            return true;
        } else {
            return false;
        }
    }

    public Boolean dealerBust(Dealer dealer){
        if(dealer.getHandTotal() > 21){
            return true;
        } else {
            return false;
        }
    }
}
