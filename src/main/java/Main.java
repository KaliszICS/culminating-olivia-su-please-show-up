/**
 * The Main class is the UNO game
 * It makes a deck, lets the players organize their cards, and play the game with UNO flip rules 
 * @author Kelly Fu, Olivia Su, Katherine Zhou, Cindy Pan
 * @version 17.0.1
 */

public class Main {

	public static void main(String args[]) {
		Deck d = new Deck();
		
		//System.out.println(d.toString());
		d.shuffle();
	//prints the size of the deck
	//prints the back cards of your hand
	Player pl = new Player("help", d);
	System.out.println(pl.size());
	System.out.println(pl.getBackHand().toString());
	pl.organizeFront();
	System.out.println(pl.toString());
	}

}
