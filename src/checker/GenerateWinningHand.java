/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: GenerateWinningHand.java </p> 
 * @author TeamCS3343 </a>
 */
package  checker;

import java.util.ArrayList;
import java.util.*;

import utils.*;

// TODO: Auto-generated Javadoc
//The logic is to find out all the combination set to check the score, count the highest.

//To find the combination, I will use backtracking
//To initialize, there must be a sorted hand
//then check if there is pong or chow ( no need check kong as kong must be in show hand to win.)
//if so, remove three tile and put it in temp
//call checkcombination again, check the remain card,
// if the hand size only two, just check if it is pair ( only do this step when hand size is two, as for any winning hand, it must be pair, except 13, that will be check in another function)
// after remove a pair, the hand size is 0, then put the temp into the combination set arraylist
// then return, return , and put back the hand into list, then we can find the remain tile if can form meld again.




/**
 * The Class GenerateWinningHand.
 */
// the function may still buggy, and but at least it can check a winning hand, I will do it later.(or maybe do it on testing, have something write)
public class GenerateWinningHand {
	
	/** The combination set. */

	private ArrayList<ArrayList<Meld>> combination_set = new ArrayList<>();
	
	/** The Combi temp. */
	private ArrayList<Meld> Combi_temp = new ArrayList<>();
	
	/**
	 * Instantiates a new generate winning hand.
	 */
	public GenerateWinningHand() {

	};
	
	/** The count. */
	public int count=0;
	
	/**
	 * Gets the combination.
	 *
	 * @param hand the hand
	 * @return the combination
	 */
	public ArrayList<ArrayList<Meld>> getCombination(ArrayList<Tile> hand) {
		if(!combination_set.isEmpty()) {
			combination_set.clear();
			
		}
		if(!Combi_temp.isEmpty()) {
			Combi_temp.clear();
			
		}
		Collections.sort(hand);
		checkcombination(hand);
		return combination_set;
		
	}
	
	/**
	 * Checkcombination.
	 *
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean checkcombination(ArrayList<Tile> hand) {
		if (hand.size() ==0) {
			return true;
			
		}

		int initial_size=hand.size();
		for(int i=0;i<hand.size();i++) {
			if(hand.size()==2) { //if only 2, check if it is pair
				if(hand.get(i).getId()/4==hand.get(i+1).getId()/4){
					{
						Meld Mtemp = new Meld(hand.get(i),hand.get(i+1),null,null);
				
						Combi_temp.add(Mtemp);
						hand.remove(i);
						hand.remove(i);
						if(checkcombination(hand)) {
							ArrayList<Meld> meld=new ArrayList<Meld>(Combi_temp);
							combination_set.add(meld);
							Combi_temp.remove(Combi_temp.size()-1);
							hand.add(Mtemp.getFirst());
							hand.add(Mtemp.getSecond());
							return true;
						};
							
					}
					
					
				}else {return false;	}
				
				
			}else if(hand.size()-i>2) {
				
				if(CheckPong(hand.get(i),hand.get(i+1),hand.get(i+2))) {
					Meld Mtemp= new Meld(hand.get(i),hand.get(i+1),hand.get(i+2),null);

						Combi_temp.add(Mtemp);
						hand.remove(i);
						hand.remove(i);
						hand.remove(i);
					
						if(checkcombination(hand)) {
			
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						
						Combi_temp.remove(Combi_temp.size()-1);
						Collections.sort(hand);
				
						
						}else {

						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						Combi_temp.remove(Combi_temp.size()-1);
						Collections.sort(hand);
						}
					}


				int b_pos=  FindTilePosition.NextDifferentTile(hand,hand.get(i));
				int c_pos=-1;
				if(b_pos!=-1)
				 c_pos=  FindTilePosition.NextDifferentTile(hand,hand.get(b_pos));
				if(b_pos!=-1 && c_pos!=-1) {
				if(CheckChow(hand.get(i),hand.get(b_pos),hand.get(c_pos))) {
				
					Meld Mtemp= new Meld(hand.get(i),hand.get(b_pos),hand.get(c_pos),null);
					Combi_temp.add(Mtemp);
					hand.remove(i);
					hand.remove(b_pos-1);
					hand.remove(c_pos-2);
					
					if(checkcombination(hand)) {
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						Collections.sort(hand);
						Combi_temp.remove(Combi_temp.size()-1);	
						
					}else {
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						Combi_temp.remove(Combi_temp.size()-1);
						Collections.sort(hand);
					}
				
					
				}
				}
		
				
			  }
				
			}
		
			if(hand.size()!=initial_size)
				return true;
			return false;
		}
	
	/**
	 * Check chow.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean CheckChow(Tile a, Tile b, Tile c) {

		if(a.getRankIndex() == b.getRankIndex()-1 && b.getRankIndex()== c.getRankIndex()-1 && a.getType().equals(c.getType()))
		{
			
			return true;
		}
		
		return false;
	}

	/**
	 * Check pong.
	 *
	 * @param a the a
	 * @param b the b
	 * @param c the c
	 * @return true, if successful
	 */
	public boolean CheckPong(Tile a, Tile b, Tile c) {
		if(a.getRankIndex() == b.getRankIndex() && b.getRankIndex() == c.getRankIndex() && a.getType()==c.getType() &&b.getType()==c.getType())
		{
			
			return true;
		}
		
		return false;
	}

		
		
		
}