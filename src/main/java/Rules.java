/**
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
        
    }
    
    public void flip(){
        this.isFlip = !this.isFlip;
    }

    public void skipNextPlayer(){
<<<<<<< HEAD
      

=======
        
>>>>>>> 333caac (Javadocs)
    }

    public void plusOne(){
      

    }

    public void wildCard(){

    }

    public void wildPlusTwo(){

    }

    public void plusFive(){

    }

    public void skipEveryone(){

    }

    public void wildPlusColourCard(){

    }
}
