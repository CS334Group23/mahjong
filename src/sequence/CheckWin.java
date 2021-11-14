package sequence;

import java.util.ArrayList;

import utils.Meld;
import utils.Tile;
import utils.Type;
import utils.sorting;

public class CheckWin {
	private Combination comb;
	public CheckWin() {
		
	}
	public ArrayList<Sequence> CheckScore(ArrayList<Tile> hand, ArrayList<Meld> showed_hand ) {
		int score=0;
		
		Combination comb=new Combination();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		ArrayList<Sequence> sequence =new ArrayList<>();
		System.out.printf("Set:%d\n",set.size());
		for(ArrayList<Meld> winning_hand : set) {
			ArrayList<Sequence> temp_sequence =new ArrayList<>();
			if(showed_hand!=null)
				winning_hand.addAll(showed_hand);  // use to merge the showed_hand into winning_hand
			sorting.sort_Meld(winning_hand);
			//sort winning all by first of each meld, put eye at last
			int local_score=0;
			sorting.sort_Meld(winning_hand);
			if(CheckPH(winning_hand)) {
				Sequence common_hand=new Common_Hand();
				temp_sequence.add(common_hand);
			}
			if(showed_hand!=null)
				if(CheckPPH(winning_hand,showed_hand)) {
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
			if(CheckHYJ(winning_hand)) {
				Sequence mixed_terminals=new Mixed_Terminals(); 
				temp_sequence.add(mixed_terminals);
			}
			// other check will add later 
			
			//extra score eg ���e/��/��
			if(showed_hand != null) {
				if(CheckMC(showed_hand)) {
					Sequence win_from_wall=new Win_From_Wall();
					temp_sequence.add(win_from_wall);
				}
			}
			if(CheckRedDragon(winning_hand)) {
				Sequence red=new Red_Dragon();
				temp_sequence.add(red);
			}
			if(CheckGreenDragon(winning_hand)) {
				Sequence green=new Green_Dragon();
				temp_sequence.add(green);
			}
			if(CheckWhiteDragon(winning_hand)) {
				Sequence white=new White_Dragon();
				temp_sequence.add(white);
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
	public boolean CheckPPH(ArrayList<Meld> hand,ArrayList<Meld>showed_hand) {//���k
		if(showed_hand.isEmpty())
			return false; // exception for 
		boolean OnlyDragonOrWind = true;
		boolean AllKongs=true; //exception for all kong
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() ==1) {
				return false;
			}
			if(hand.get(i).getcomb_type()!=3) {
				if(!(hand.get(i).getcomb_type()==0))
					AllKongs=false;
			}
			if(hand.get(i).getFirst().getType()== Type.BAMBOO ||
					hand.get(i).getFirst().getType()== Type.DOT ||
					hand.get(i).getFirst().getType()== Type.CHARACTER 
					)
				OnlyDragonOrWind=false;
			
		}
		if(OnlyDragonOrWind)
			return false;
		if(AllKongs)
			return false;
		return true;
	}
	public boolean CheckHYJ(ArrayList<Meld> hand) {
		boolean withYJ=false;
		boolean onlyYJ=true;
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getcomb_type()==2 
					|| hand.get(i).getcomb_type() ==0) {
				if(hand.get(i).getFirst().getType() != Type.DRAGON &&
						hand.get(i).getFirst().getType() != Type.WIND)
				{
					if(hand.get(i).getFirst().getRankIndex()!=0 &&hand.get(i).getFirst().getRankIndex()!=8)
						return false;
					else
						withYJ=true;
				}
				else
					onlyYJ=false;
				
			}else return false;
			
		}
		if(withYJ&&!onlyYJ)
			return true;
		else
			return false;
		
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
	public boolean CheckKKH(ArrayList<Meld> hand, ArrayList<Meld> showed_hand) { // four concealed triplet
			if(!showed_hand.isEmpty())
				return false; // exception for pph
			for(int i=0;i<hand.size();i++){
				if(hand.get(i).getcomb_type() ==1 ||hand.get(i).getcomb_type() ==3 ) {
					return false;
				}		
			}

			return true;
	}
	public boolean CheckAKS(ArrayList<Meld> hand, ArrayList<Meld> showed_hand) { // all kongs
		if(hand.size()>2)
			return false;
		for(Meld m:showed_hand) {
			if(m.getcomb_type()!=0)
				if(m.getcomb_type()!=3)
					return false;
		}
		return true;
		
	}
	public boolean CheckMC(ArrayList<Meld> hand) {
		if(hand.isEmpty())
			return true;
		return false;
	}
	public boolean CheckRedDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==27)
				return true;
		}
		return false;
	}
	public boolean CheckGreenDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==28)
				return true;
		}
		return false;
		
	}
	public boolean CheckWhiteDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==29)
				return true;
		}
		return false;
	
	}
	
	
}
