public class Opponent extends Player {
    private Card shouldPlay;
    public Opponent(String name, Deck deck){
        super(name, deck);
        this.shouldPlay = deck.topCard(false); 
    }
    
    public String chooseCardToPlay(Card topCard, Player humanPlayer){
        boolean lowOnCards = humanPlayer.getFrontHand().size() <= 3;
        String topColour = topCard.getColour();
        String topType = topCard.getType();

        if(topType.equals("Draw1") || topType.equals("draw2") || topType.equals("Draw5") || topType.equals("drawColour")){
            for(int i = 0; i< getFrontHand().size(); i++){
                if(getFrontHand().get(i).getType().equals(topType)){
                    shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }
            }
        }

        if(lowOnCards){
            for(int i = 0; i < getFrontHand().size(); i++){
                String type = getFrontHand().get(i).getType();
                if (topType.equals("Draw1") || topType.equals("draw2") || topType.equals("Draw5") || topType.equals("drawColour")){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }
            }
        }
        return "play any card";

    }
}
