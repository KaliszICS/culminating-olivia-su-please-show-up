public class Main {

	public static void main(String args[]) {
		Deck d = new Deck();
		
		//System.out.println(d.toString());
		d.shuffle();
	
	Player pl = new Player("help", d);
	System.out.println(pl.size());
	System.out.println(pl.getBackHand().toString());
	pl.organizeFront();
	System.out.println(pl.toString());
	}

}
