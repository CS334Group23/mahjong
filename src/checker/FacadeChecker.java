/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: FacadeChecker.java </p> 
 * @author TeamCS3343 </a>
 */
package checker;
import java.util.*;

import checker.sequence.Sequence;
import utils.*;
// TODO: Auto-generated Javadoc

/**
 * The Class FacadeChecker.
 */
public class FacadeChecker {
	
	/** The chowchecker. */
	private ChowChecker chowchecker;
	
	/** The pongchecker. */
	private PongChecker pongchecker;
	
	/** The kongchecker. */
	private KongChecker kongchecker;
	
	/** The combination. */
	private GenerateWinningHand combination;
	
	/** The hand. */
	protected ArrayList<Tile> hand;
	
	/** The updated hand. */
	private ArrayList<Tile> updatedHand;
	
	/** The showed hand. */
	private ArrayList<Meld> showed_hand;
	
	/** The checkwin. */
	private CheckWin checkwin;
	
	/** The a. */
	private Tile a;
	
	/** The pos. */
	private int pos;
	
	/**
	 * Instantiates a new facade checker.
	 *
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @param a the a
	 */
	public FacadeChecker(ArrayList<Tile> hand,ArrayList<Meld> showed_hand,Tile a) {
		this.hand = new ArrayList<>(hand);
		UpdateHand(hand,showed_hand,a);
		chowchecker=new ChowChecker();
		pongchecker=new PongChecker();
		kongchecker=new KongChecker();
		checkwin=new CheckWin();
	}
	
	/**
	 * Check if pong.
	 *
	 * @return the meld
	 */
	public Meld check_if_pong() {
		return pongchecker.checkPong(hand, a);
		
	}	
	
//	public ArrayList<Meld> check_if_kong() {//this is not used, may be changed to this later
//		Tile temp=new Tile(136);//initialize as flower , which must different to hands
//		ArrayList<Meld> result=new ArrayList<Meld>();
//		for(int i=0;i<hand.size();i++) {
//			if(hand.get(i).getRankIndex()==temp.getRankIndex() && hand.get(i).getType()==temp.getType()) { //only return kongs with distinct meld
//				continue;
//			}
//			temp=hand.get(i);
//			hand.remove(i);
//			if(kongchecker.checkKong(hand, temp)!=null)
//				result.add(kongchecker.checkKong(hand, temp));
//			hand.add(i,temp);
//		}
//		return result;
//	}	
	
	/**
	 * Check if kong.
	 *
	 * @return the meld
	 */
	public Meld check_if_kong() {
			return kongchecker.checkKong(hand, a);
		}
	
	
	/**
	 * Check if chow.
	 *
	 * @return the array list
	 */
	public ArrayList<Meld> check_if_chow(){
		return chowchecker.checkChow(hand, a);
		
		
		
	}
	
	/**
	 * Check if win.
	 *
	 * @return the array list
	 */
	public ArrayList<Sequence> check_if_win(){
		
		return checkwin.CheckScore(updatedHand,showed_hand);
	}
	
	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		ArrayList<Sequence> temp=checkwin.CheckScore(updatedHand,showed_hand);
		int sum=0;
		for(Sequence s:temp)
			sum+=s.getScore();
		return sum;
	}
	
	/**
	 * Check whether win.
	 *
	 * @return true, if successful
	 */
	public boolean checkWhetherWin() {
		return checkwin.checkIsWin(updatedHand, showed_hand);
	}
	
	/**
	 * Update hand.
	 *
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @param a the a
	 */
	public void UpdateHand(ArrayList<Tile> hand, ArrayList<Meld> showed_hand, Tile a) {
		this.updatedHand=new ArrayList<>();
		this.updatedHand.addAll(hand);
		this.showed_hand=new ArrayList<>(showed_hand);
		this.a=a;
		this.pos=FindTilePosition.FindPosition(hand, a);
		this.updatedHand.add(pos,a);
		
//		System.out.println("ID"+this.a.getId()+"  "+hand.get(12).getId());
	}
	
}
