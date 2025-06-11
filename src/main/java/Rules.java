/**
* The Rules class handles special rules and effects during the game.
 * It manages status flags like reversed order and flip mode, and provides methods to apply effects like skipping players, adding cards, and toggling game states.
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

public class Rules {
    public boolean isReversed;
    public boolean isFlip;
    public Player player;
    public Opponent computer;
    public Deck deck;

    /**
    * Constructs a Rules object with a player, opponent and deck
    * @param isReversed a boolean to check if we are playing in reverse
    * @param isFlip a boolean to check if we are playing on the front or the back of the deck
    * @param players the human player
    * @param opponent the computer opponent
    * @param deck the shared deck of cards
    */

    public Rules(boolean isReversed, boolean isFlip, Player player, Opponent opponent, Deck deck){
        this.isReversed = false;
        this.isFlip = false;
        this.player = player;
        this.computer = opponent;
        this.deck = deck;

    }


     /**
     * Gets whether the turn order is reversed.
     * @return true if reversed, false otherwise
     */
    public boolean getIsReversed(){
        return this.isReversed;
    }

    /**
     * Gets whether the game is in flip mode.
     * @return true if in flip mode, false otherwise
     */
    public boolean getIsFlip(){
        return this.isFlip;
    }

    /**
     * Reverses the turn order.
     */
    public void reverse(){
        this.isReversed = !this.isReversed;
        System.out.println("Turn order is reversed!");
    }
    

    /**
     * Toggles flip mode (could mean changing sides, day/night deck, etc.).
     */
    public void flip(){
        this.isFlip = !this.isFlip;
        System.out.println("Cards Flipped!");
    }

    /**
     * Skips the next player's turn.
     */
    public void skipNextPlayer(){
        System.out.println("Skipped the next player");
    }


    /**
     * Makes the opponent or player draw one card.
     */
    public void plusOne(){
      System.out.println("The next player have to draw one card");

    }

     /**
     * Handles a wild card play (lets user choose new colour).
     */
    public void wildCard(){
        System.out.println("Colour changed, pick a colour:");
        if(isFlip){
            System.out.println("Pink, Teal, Orange, Purple");
        }
        else{
            System.out.println("Red, Blue, Yellow, Green");
        }
    }


    /**
     * Handles a wild card that also makes opponent draw 2 cards.
     */
    public void wildPlusTwo(){
        System.out.println("Wild +2 card played!");
        
    }

    /**
     * Makes the opponent or player draw five cards.
     */
    public void plusFive(){
         System.out.println("Opponent draws five cards!");
        for (int i = 0; i < 5; i++) {
            
        }
    }

    /**
     * Skips all players (special condition, often custom rule).
     */
    public void skipEveryone(){
    System.out.println("All players are skipped this round!");
    }

    /**
     * Handles a wild card that changes colour and adds extra effect
     */
    public void wildPlusColourCard(){
        System.out.println("Wild + Colour Change card played!");
    }
}
