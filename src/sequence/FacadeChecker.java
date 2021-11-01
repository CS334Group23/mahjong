package sequence;
import java.util.*;
import utils.*;
public class FacadeChecker {
	private ChowChecker chowchecker;
	private PongChecker pongchecker;
	private KongChecker kongchecker;
	private ArrayList<Tile> hand;
	private ArrayList<Meld> showed_hand;
	private CheckWin checkwin;
	private Tile a;
	private int pos;
	public FacadeChecker(ArrayList<Tile> hand,ArrayList<Meld> showed_hand,Tile a) {
		this.hand=new ArrayList<>();
		this.hand.addAll(hand);
		this.showed_hand=showed_hand;
		this.a=a;
		this.pos=FindTilePosition.FindPosition(hand, a);
		this.hand.add(pos,a);
		chowchecker=new ChowChecker();
		pongchecker=new PongChecker();
		kongchecker=new KongChecker();
		checkwin=new CheckWin();
	}
	public Meld check_if_pong() {
		return pongchecker.checkPong(hand, a);
		
	}	
	public Meld check_if_kong() {
		return kongchecker.checkKong(hand, a);
		
	}	
	public ArrayList<Meld> check_if_chow(){
		return chowchecker.checkChow(hand, a);
		
		
	}
	public ArrayList<Sequence> check_if_win(){
		return checkwin.CheckScore(hand,showed_hand);
	}
	
}
