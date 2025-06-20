/**
 * The Opponent class tells the computor what cards to place depending on the situation.
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

public class Opponent extends Player {
    private Card shouldPlay;

    public Opponent(String name, Deck deck){
        super(name, deck);
        this.shouldPlay = deck.topCard(false); 
    }
    
public Card getShouldPlay(){
    return this.shouldPlay;
}

/**
 * Checks if most recently played card is a draw card
 * Tells computor to place a Draw1, draw2, Draw5, or drawColour to stack
 * @param topCard most recently played card
 * @param humanPlayer you, the player
 * @return play card from your hand
 */
    public String chooseCardToPlay(Card topCard, Player humanPlayer){
        boolean lowOnCards = humanPlayer.getFrontHand().size() <= 3;
        String topColour = topCard.getColour();
        String topType = topCard.getType();

        if(topType.equals("Draw1") || topType.equals("draw2") || topType.equals("Draw5") || topType.equals("drawColour")){
            for(int i = 0; i< getFrontHand().size(); i++){
                if(getFrontHand().get(i).getType().equals(topType)){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }
            }

            /**
            *Checks if oppponent is low on cards
            *Tells computor to place a Draw1, draw2, Draw5, or drawColour available in hand
             */
        }else if(lowOnCards){
            for(int i = 0; i < getFrontHand().size(); i++){
                String type = getFrontHand().get(i).getType();
                if (topType.equals("Draw1") || topType.equals("draw2") || topType.equals("Draw5") || topType.equals("drawColour")){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";

                    /**
                     * If no types of draw cards, place reverse, skip, or SkipEveryone
                     */
                    }else if(topType.equals("Reverse") || topType.equals("skip") || topType.equals("SkipEveryone")){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";

                }
            }

            /**
             * checks if hand is greater than 0
             * Places card that matches colour of top card
             */
        }else if(getFrontHand().size()>0){
            for(int i = 0; i< getFrontHand().size(); i++){
                if (getFrontHand().get(i).getType().equals(topColour)){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                    /**
                     * Places card that matches number
                     */
                }else if(getFrontHand().get(i).getType().equals(topType)){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }
            }
        }
        
            //.draw();
            return "No card to play";
        

    }
}
