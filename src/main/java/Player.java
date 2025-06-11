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
* @param front the front of the deck we're pulling cards from
* @param back the back of the deck we're drawing cards from
*/
   public Player(String name, Deck deck){

        this.name = name;
         this.frontHand = new ArrayList<Card>();
        this.backHand = new ArrayList<Card>();
        for(int i = 0; i<7; i++){
           
            this.frontHand.add(deck.draw(false));
            this.backHand.add(deck.draw(true));
        }

        // get the shuffled deck and draw cards to get the hand


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
        Card drawnCard = deck.draw(false);
        Card drawnBack = deck.draw(true);
        this.frontHand.add(drawnCard);
        this.backHand.add(drawnBack);
    }

/**
* Removes a card from the hand to the given deck's discard pile
* Returns true if the card exists in hand, false otherwise
* @param card is the card that will be discarded
* @param discardPile is the pile the card will be discarded into
* @return returns the card taken out of the hand
*/
    public String RemoveCard(int index, Deck discardPile){
        if (this.frontHand.size() == 0){
            return null;
        }   
        Card tempFront = frontHand.get(index);
        Card tempBack = backHand.get(index);
        this.frontHand.remove(index);
        this.backHand.remove(index);
        return tempFront.toString()+" "+tempBack.toString()+" removed.";
    }

    public void organizeFront(){
       
       for(int i = 0; i < this.frontHand.size() - 1; i++){
            for(int j = 0; j < this.frontHand.size() - i - 1;j++){
                if((this.frontHand.get(j)).getColour().compareTo((this.frontHand.get(j+1)).getColour()) > 0 ){
                    Card temp = this.frontHand.get(j);
                    Card tempBack = this.backHand.get(j);
                    this.frontHand.set(j, this.frontHand.get(j + 1));
                    this.frontHand.set(j + 1, temp);
                    this.backHand.set(j, this.backHand.get(j+1));
                    this.backHand.set(j+1, tempBack);
                }
            }
       }
    }

    public void organizeBack(){
       
       for(int i = 0; i < this.backHand.size() - 1; i++){
            for(int j = 0; j < this.backHand.size() - i - 1;j++){
                if((this.backHand.get(j)).getColour().compareTo((this.backHand.get(j+1)).getColour()) > 0 ){
                    Card temp = this.backHand.get(j);
                    Card tempFront = this.frontHand.get(j);

                    this.backHand.set(j, this.backHand.get(j + 1));
                    this.backHand.set(j + 1, temp);

                    this.frontHand.set(j, this.frontHand.get(j + 1));
                    this.frontHand.set(j + 1, tempFront);
                }
            }
       }
    }


/**
* Will print out their name and hand of cards
* @return returns the player's name, and hand of cards
*/
    public String toString(){
        String person = this.name;
        if (this.frontHand.size() == 0){
            return person;
        }
        
        return person +"'s front Cards are " + this.frontHand.toString()+" and their back Cards are "+ this.backHand.toString();
    }
}