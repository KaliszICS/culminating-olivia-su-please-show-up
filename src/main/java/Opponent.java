/**
 * The Opponent class tells the computor what cards to place depending on the situation.
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

<<<<<<< HEAD
=======
/* 
 * Represents a computer-controlled opponent.
 */
>>>>>>> 60a7f94 (Update)
public class Opponent extends Player {
    private Card shouldPlay;
    public Opponent(String name, Deck deck){
        super(name, deck);
        this.shouldPlay = deck.topCard(false); 
    }
    
/**
 * Takes the colour and type for the top card in play.
 * @param topCard
 * @param humanPlayer
 * @return
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
        }else if(lowOnCards){
            for(int i = 0; i < getFrontHand().size(); i++){
                String type = getFrontHand().get(i).getType();
                if (topType.equals("Draw1") || topType.equals("draw2") || topType.equals("Draw5") || topType.equals("drawColour")){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";

                    }else if(topType.equals("Reverse") || topType.equals("skip") || topType.equals("SkipEveryone")){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";

                }
            }
        }else if(getFrontHand().size()>0){
            for(int i = 0; i< getFrontHand().size(); i++){
                if (getFrontHand().get(i).getType().equals(topColour)){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }else if(getFrontHand().get(i).getType().equals(topType)){
                    this.shouldPlay = this.frontHand.get(i);
                    return "play this card";
                }
            }
        }else{
            draw();
        }

    }
}
