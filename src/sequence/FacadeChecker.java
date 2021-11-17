package sequence;
import java.util.*;
import utils.*;
public class FacadeChecker {
	private ChowChecker chowchecker;
	private PongChecker pongchecker;
	private KongChecker kongchecker;
	private GenerateWinningHand combination;
	protected ArrayList<Tile> hand;
	private ArrayList<Meld> showed_hand;
	private CheckWin checkwin;
	private Tile a;
	private int pos;
	public FacadeChecker(ArrayList<Tile> hand,ArrayList<Meld> showed_hand,Tile a) {
		UpdateHand(hand,showed_hand,a);
		chowchecker=new ChowChecker();
		pongchecker=new PongChecker();
		kongchecker=new KongChecker();
		checkwin=new CheckWin();
	}
	public Meld check_if_pong() {
		return pongchecker.checkPong(hand, a);
		
	}	
	public ArrayList<Meld> check_if_kong() {//this is not used, may be changed to this later
		Tile temp=new Tile(136);//initialize as flower , which must different to hands
		ArrayList<Meld> result=new ArrayList<Meld>();
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getRankIndex()==temp.getRankIndex() && hand.get(i).getType()==temp.getType()) { //only return kongs with distinct meld
				continue;
			}
			temp=hand.get(i);
			hand.remove(i);
			if(kongchecker.checkKong(hand, temp)!=null)
				result.add(kongchecker.checkKong(hand, temp));
			hand.add(i,temp);
		}
		return result;
	}	
	
	public ArrayList<Meld> check_if_chow(){
		return chowchecker.checkChow(hand, a);
		
		
		
	}
	public ArrayList<Sequence> check_if_win(){
		return checkwin.CheckScore(hand,showed_hand);
	}
	public void UpdateHand(ArrayList<Tile> hand, ArrayList<Meld> showed_hand, Tile a) {
		this.hand=new ArrayList<>();
		this.hand.addAll(hand);
		this.showed_hand=showed_hand;
		this.a=a;
		this.pos=FindTilePosition.FindPosition(hand, a);
		this.hand.add(pos,a);
		
//		System.out.println("ID"+this.a.getId()+"  "+hand.get(12).getId());
	}
	
}
