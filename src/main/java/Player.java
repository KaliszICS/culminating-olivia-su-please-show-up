public class Player{
    private String name;
    private Card[] hand;


   public Player(String name, Card[] hand){
        this.name = name;
        if (hand != null){
            this.hand = new Card[hand.length];
            for (int i = 0; i < hand.length; i++){
                this.hand[i] = hand[i];
            }
        }
        else{
            this.hand = new Card[0];
        }
    }
}