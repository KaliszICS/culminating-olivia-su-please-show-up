public class DiscardPile{
    private Card[] pile;

   public DiscardPile(Card[] cards){
        this.pile = pile;
        if (cards != null){
            this.pile = new Card[cards.length];
            for (int i = 0; i < cards.length; i++){
                this.pile[i] = cards[i];
            }
        } 
        else{
            this.pile = new Card[0];
        }
    }
    public DiscardPile(){
        this.pile = new Card[0];
        }

    public void addCard(Card card){
        if (card == null) {
            return;
        }

        Card[] newPile = new Card[this.pile.length + 1];
        for (int i = 0; i < this.pile.length; i++) {
            newPile[i] = this.pile[i];
        }
        newPile[this.pile.length] = card;
        this.pile = newPile;
    }
}