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
			if(CheckXSY(winning_hand)) {
				Sequence small_dragons=new Small_Dragons();
				temp_sequence.add(small_dragons); 
			}
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
				AllKongs=false;
			}
			if(hand.get(i).getFirst().getType()!= Type.WIND &&
					hand.get(i).getFirst().getType()!= Type.DRAGON	)
				OnlyDragonOrWind=false;
			
		}
		if(OnlyDragonOrWind)
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
	
	public int CheckMF(ArrayList<Meld> hand) { //����   will change later
	
	
		return 1;
	}
	public int CheckJF(ArrayList<Meld> hand) {//����
		
		return 1;
	}
	
	public boolean CheckXSY(ArrayList<Meld> hand) {//小三元
		int dragon=0;
		int dra_eye=0;
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type()==1 && hand.get(i).getFirst().getType()==Type.DRAGON) {
				dragon+=1;
			}
			else if(hand.get(i).getcomb_type()==0 && hand.get(i).getFirst().getType()==Type.DRAGON) {
				dra_eye+=1;
			}
		}
		if(dragon==2 && dra_eye==1) {
			return true;
		}
		return false;
	}
	
	public boolean CheckXSX(ArrayList<Meld> hand){//小四喜
		int wind=0;
		boolean wind_eye=false;
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getFirst().getType()==Type.WIND) {
				wind++;
			}else if(hand.get(i).getcomb_type()==0 && hand.get(i).getFirst().getType()==Type.DRAGON) {
				wind_eye=true;
			}
		}
		if(wind==3 && wind_eye==true) {
			return true;
		}
		return false;
	}
		
	public boolean CheckZYS(ArrayList<Meld> hand){//字一色
		
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getFirst().getType()!=Type.WIND && hand.get(i).getFirst().getType()!=Type.DRAGON) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean CheckQYJ(ArrayList<Meld> hand){//清幺九
		
		for(int i=0;i<hand.size();i++){
			Tile t = hand.get(i).getFirst();
			if((t.getRankIndex()!=1 || t.getRankIndex()!=9) && t.getType()==Type.DRAGON && t.getType()==Type.WIND && t.getType()==Type.FLOWER) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean CheckDSY(ArrayList<Meld> hand){//大三元
		
		int dragon=0;

		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type()!=0 && hand.get(i).getFirst().getType()==Type.DRAGON) {
				dragon+=1;
			}
			
		}
		if(dragon==3) {
			return true;
		}
		return false;
	}
	public boolean CheckDSX(ArrayList<Meld> hand){//大四喜	
		
		int wind=0;

		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type()!=0 && hand.get(i).getFirst().getType()==Type.WIND) {
				wind+=1;
			}
		}
		if(wind==4) {
			return true;
		}
		return false;
	}
	
	public boolean CheckJLBD(ArrayList<Meld> hand) {//九莲宝灯
		int sum=0;
		Tile first_hand= hand.get(0).getFirst();
		
		for(int i=0;i<hand.size();i++){
			if (hand.get(i).getFirst().getType()!=first_hand.getType()){ //make sure the types are all the same
				return false;
			}
			sum+=hand.get(i).getFirst().getRankIndex();
			sum+=hand.get(i).getSecond().getRankIndex();
			if(hand.get(i).getThird()!=null) {
				sum+=hand.get(i).getThird().getRankIndex();
			}
			if(hand.get(i).getForth()!=null) {
				sum+=hand.get(i).getForth().getRankIndex();
			}
		}
		
		if( sum >95 && sum<105) {  //when the hand is 111 2345678 999 with any extra one of them
			return true;
		}
		return false;
	}
	
	public boolean CheckSSY(ArrayList<Tile> hand, ArrayList<ArrayList<Meld>> set) {//十三幺
		if(hand.size()==14 && set.isEmpty()) {
			int[] list = {0,0,0,0,0,0,0,0,0,0,0,0,0}; 
			for (Tile each:hand ) {
				if(each.getClass().isInstance(Type.WIND) && each.getRankIndex()==0) {
					list[0]++;
				}
				if(each.getClass().isInstance(Type.WIND) && each.getRankIndex()==1) {
					list[1]++;
				}if(each.getClass().isInstance(Type.WIND) && each.getRankIndex()==2) {
					list[2]++;
				}if(each.getClass().isInstance(Type.WIND) && each.getRankIndex()==3) {
					list[3]++;
				}
				
				if(each.getClass().isInstance(Type.DRAGON) && each.getRankIndex()==0) {
					list[4]++;
				}
				if(each.getClass().isInstance(Type.DRAGON) && each.getRankIndex()==1) {
					list[5]++;
				}
				if(each.getClass().isInstance(Type.DRAGON) && each.getRankIndex()==2) {
					list[6]++;
				}
				
				if(each.getClass().isInstance(Type.BAMBOO) && each.getRankIndex()==0) {
					list[7]++;
				}
				if(each.getClass().isInstance(Type.BAMBOO) && each.getRankIndex()==8) {
					list[8]++;
				}
				
				if(each.getClass().isInstance(Type.CHARACTER) && each.getRankIndex()==0) {
					list[9]++;
				}
				if(each.getClass().isInstance(Type.CHARACTER) && each.getRankIndex()==8) {
					list[10]++;
				}
				
				if(each.getClass().isInstance(Type.DOT) && each.getRankIndex()==0) {
					list[11]++;
				}if(each.getClass().isInstance(Type.DOT) && each.getRankIndex()==8) {
					list[12]++;
				}
			}
			boolean probable=false;
			for (int ele : list) {
				if(ele<1) {
					return false;
				}
				if(ele==2) { //judge the 14th tile
					probable =true;
				}
			}
			if(probable) {
				return true;
			}
			
		}
		return false;
	}
}
