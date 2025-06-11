/**
<<<<<<< HEAD
 * The Rule class handles special rules and effects during the game.
 */

public class Rules {
    public boolean isReversed;
    public boolean isFlip;
    public Player player;
    public Opponent computer;
    public Deck deck;

    public Rules(Player player, Opponent opponent, Deck deck){
        this.computer = opponent;
        this.deck = deck;
        this.player = player;
=======
 * 
 * The rules class is 
 * 
 * @author Kelly Fu, Olivia Su, Cindy Pan, Katherine Zhou
 * @version 17.0.1
 */

public class Rules {

    private boolean isReversed;
    private boolean isFlip;
    private Player[] players;

/**
* Takes 
* @param isReversed a boolean to check if we are playing in reverse
* @param isFlip a boolean to check if we are playing on the front or the back of the deck
* @param players 
*/

    public Rules(Player[] players){
        this.players = players;
>>>>>>> 92c1fac (update)
        this.isReversed = false;
        this.isFlip = false;
    }

    public boolean getIsReversed(){
        return this.isReversed;
    }

    public boolean getIsFlip(){
        return this.isFlip;
    }

    public void reverse(){
        this.isReversed = !this.isReversed;
        System.out.println("Turn order is reversed!");
    }
    
    public void flip(){
        this.isFlip = !this.isFlip;
        System.out.println("Cards Flipped!");
    }

    public void skipNextPlayer(){
        System.out.println("Skipped the next player");
    }

    public void plusOne(){
      System.out.println("The next player have to draw one card");

    }

    public void wildCard(){
        System.out.println("Colour changed, pick a colour:");
        if(isFlip){
            System.out.println("Pink, Teal, Orange, Purple");
        }
        else{
            System.out.println("Red, Blue, Yellow, Green");
        }
    }

    public void wildPlusTwo(){
        System.out.println("Wild +2 card played!");
        
    }

    public void plusFive(){
         System.out.println("Opponent draws five cards!");
        for (int i = 0; i < 5; i++) {
            
        }
    }

    public void skipEveryone(){
    System.out.println("All players are skipped this round!");
    }

    public void wildPlusColourCard(){
        System.out.println("Wild + Colour Change card played!");
    }
}
