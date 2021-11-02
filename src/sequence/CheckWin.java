package sequence;

import java.util.ArrayList;

import utils.Meld;
import utils.Tile;
import utils.Type;
import utils.sorting;

public class CheckWin {
	public ArrayList<Sequence> CheckScore(ArrayList<Tile> hand, ArrayList<Meld> showed_hand ) {
		int score=0;
		
		Combination comb=new Combination();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		ArrayList<Sequence> sequence =new ArrayList<>();
		for(ArrayList<Meld> winning_hand : set) {
			ArrayList<Sequence> temp_sequence =new ArrayList<>();
			//winning_hand.addAll(showed_hand);   use to merge the showed_hand into winning_hand
			//sort winning all by first of each meld, put eye at last
			int local_score=0;
			sorting.sort_Meld(winning_hand);
			if(CheckPH(winning_hand)) {
				Sequence common_hand=new Common_Hand();
				temp_sequence.add(common_hand);
			}
			if(CheckPPH(winning_hand)) {
				Sequence all_in_triplet=new All_In_Triplet();
				temp_sequence.add(all_in_triplet);
			}
			if(CheckHYS(winning_hand)) {
				Sequence mixed_one_suit=new Mixed_One_Suit();
				temp_sequence.add(mixed_one_suit);
			}
			if(CheckQYS(winning_hand) ) {
				Sequence all_one_suit=new All_One_Suit();
				temp_sequence.add(all_one_suit);
			}
			
			// other check will add later 
			
			//extra score eg ���e/��/��
			if(CheckMC(showed_hand)) {
				Sequence win_from_wall=new Win_From_Wall();
				temp_sequence.add(win_from_wall);
			}
			for(Sequence s: temp_sequence) {
				local_score+=s.getScore();
			}
	
			if(local_score>=score) {
				score=local_score;
				sequence=temp_sequence;
			}
			
		}
		return sequence;
		
		
	}	
	
	
	public boolean CheckSameType(Tile a, Tile b) {
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72), DRAGON(3, 108), FLOWER(5, 136), WIND(4, 120);
		if(a.getType().equals(b.getType())
				) {return true;}
		
		return false;
		
	}
	
	
	
	public boolean CheckPH(ArrayList<Meld> hand) {//���w
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=1 &&hand.get(i).getcomb_type() !=0) {
				return false;
			}
			
		}
		return true;
	}
	public boolean CheckPPH(ArrayList<Meld> hand) {//���k
		if(hand.get(0).getFirst().getType() == Type.DRAGON) {
			return false; // exception of �r�@��
		}
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=2 &&hand.get(i).getcomb_type() !=0) {
				return false;
			}
			
		}
		return true;
	}
	public boolean CheckHYS(ArrayList<Meld> hand) {//�K�@��
	
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		if(!(first_hand.getType()== Type.BAMBOO || first_hand.getType()== Type.CHARACTER ||first_hand.getType()== Type.DOT )) {
			
			return false; // it should be check for �r�@�� , which is exception to HYS
		}
		Boolean hasDragon_or_wind=false;	
		for(int i=0;i<hand.size();i++) { //if all meld is same type with first tile, or if it is dragon, then return 3, else return 0
			if(!(CheckSameType(hand.get(i).getFirst(),first_hand))) {
				if(hand.get(i).getFirst().getType() == Type.DRAGON ||
						hand.get(i).getFirst().getType() == Type.WIND) {
					hasDragon_or_wind=true;
				}else return false;
			}

		}
		if(hasDragon_or_wind)
			return true;
		else
			return false; // exception on qys
	}
	
	public boolean CheckQYS(ArrayList<Meld> hand) {//�M�@��
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		
			
		for(int i=0;i<hand.size();i++) {
			
			if(!CheckSameType(hand.get(i).getFirst(),first_hand) || 
					hand.get(i).getFirst().getType() == Type.DRAGON ||
					hand.get(i).getFirst().getType() == Type.WIND)
				return false;
		}
		return true;
	}
	public boolean CheckMC(ArrayList<Meld> hand) {
		if(hand.isEmpty())
			return true;
		return false;
	}
	
	
	public int CheckMF(ArrayList<Meld> hand) { //����   will change later
	
	
		return 1;
	}
	public int CheckJF(ArrayList<Meld> hand) {//����
		
		return 1;
	}
}
