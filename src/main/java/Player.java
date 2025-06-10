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

    public Player(String name){
        this.name = name;
        this.hand = new Card[0];
    }

    public String getName(){
        return this.name;
    }

    public Card[] getHand(){
        return this.hand;
    }

    public int size(){
        return this.hand.length;
    }

    public void draw(Deck deck){
        Card card = deck.draw();
        if (card == null){
            return;
        }
        Card[] newHand = new Card[this.hand.length + 1];
        for (int i = 0; i < this.hand.length; i++){
            newHand[i] = this.hand[i];
        }
        newHand[this.hand.length] = card;
        this.hand = newHand;
    }