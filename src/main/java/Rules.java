public class Rules {
    private boolean isReversed;
    private boolean isFlip;
    private Player[] players;

    public Rules(Player[] players){
        this.players = players;
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
