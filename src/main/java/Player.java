import java.util.ArrayList;

/**
 * 
 * The player class is the player in the game with a name, age, and hands
 * 
 * @author Kelly Fu, Olivia Su, Cindy Pan, Katherine Zhou
 * @version 17.0.1
 */

public class Player{
    private String name;
    private ArrayList<Card> frontHand;
    private ArrayList<Card> backHand;


/**
* Takes a name and array of cards which should be assigned to the hand
* @param name is the name of player
* @param hand the cards in the player's hand
*/
   public Player(String name, ArrayList<Card> hand, ArrayList<Card> backHand){

        this.name = name;
        this.frontHand = hand;
        this.backHand = backHand;

    }

/**
* returns the name of the player
* @return returns the name of the player
*/
    public String getName(){
        return this.name;
    }

/**
* returns the cards in the player's hand
* @return returns the player's hand at the front
*/
    public ArrayList<Card> getFrontHand(){
        return this.frontHand;
    }

/**
 * returns the backside of the cards in the player's hands
 * @return returns the player's hand at the back
 */

    public ArrayList<Card> getBackHand(){
        return this.backHand;
    }

/**
* returns the number of cards in the player's hand
*@return returns the size of the player's hand
*/
    public int size(){
        return this.frontHand.size();
    }

/**
* Adds a card from the deck to the hand of the player
* @param deck the deck that the card is taken from
*/
    public void draw(Deck deck){
        Card drawnCard = deck.draw();
        if (drawnCard == null){
            return;
        }
        this.hand.add(drawnCard);
    }

/**
* Removes a card from the hand to the given deck's discard pile
* Returns true if the card exists in hand, false otherwise
* @param card is the card that will be discarded
* @param discardPile is the pile the card will be discarded into
* @return returns the card taken out of the hand
*/
    public Card RemoveCard(Card card, Deck discardPile){
        if (card == null || this.hand.length == 0){
            return null;
        }
            this.hand.remove(card);
            return card;
    }


    
    public void organize(){

    }


/**
* Will print out their name and hand of cards
* @return returns the player's name, and hand of cards
*/
    public String toString(){
        String person = this.name;
        if (this.hand.size == 0){
            return person;
        }
        for (int i = 0; i < this.hand.size; i++){
            person += ", " + this.hand.get(i).toString();
        }
        return person;
    }
}
