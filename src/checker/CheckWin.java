/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: CheckWin.java </p> 
 * @author TeamCS3343 </a>
 */

package checker;

import java.util.ArrayList;

import checker.sequence.All_Honours;
import checker.sequence.All_In_Triplet;
import checker.sequence.All_Kongs;
import checker.sequence.All_One_Suit;
import checker.sequence.All_Terminals;
import checker.sequence.Common_Hand;
import checker.sequence.Four_Concealed_Triplets;
import checker.sequence.Great_Dragons;
import checker.sequence.Great_Winds;
import checker.sequence.Green_Dragon;
import checker.sequence.Mixed_One_Suit;
import checker.sequence.Mixed_Terminals;
import checker.sequence.Nine_Gates;
import checker.sequence.Red_Dragon;
import checker.sequence.Sequence;
import checker.sequence.Small_Dragons;
import checker.sequence.Small_Winds;
import checker.sequence.Thirteen_Orphans;
import checker.sequence.White_Dragon;
import checker.sequence.Win_From_Wall;
import utils.Meld;
import utils.Tile;
import utils.Type;
import utils.Sorting;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckWin.
 */
public class CheckWin {
	
	
	/**
	 * Instantiates a new check win.
	 */
	public CheckWin() {
	}
	
	/**
	 * Check is win.
	 *
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @return true, if successful
	 */
	public boolean checkIsWin(ArrayList<Tile> hand, ArrayList<Meld> showed_hand) {//now use this added one
		GenerateWinningHand comb=new GenerateWinningHand();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		if(set.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	/**
	 * Check score.
	 * Passing hand and showed_hand, and calculate the total score by algorithm, 
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @return the array list
	 */
	public ArrayList<Sequence> CheckScore(ArrayList<Tile> hand, ArrayList<Meld> showed_hand ) {
		int score=1;
		
		GenerateWinningHand comb=new GenerateWinningHand();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		ArrayList<Sequence> sequence =new ArrayList<>();
		if(set.isEmpty()) {
			if(CheckSSY(hand)) {
				sequence.add(new Thirteen_Orphans());
			}
		}
		for(ArrayList<Meld> winning_hand : set) {
			ArrayList<Sequence> temp_sequence =new ArrayList<>();
			if(showed_hand!=null)
				winning_hand.addAll(showed_hand);  // use to merge the showed_hand into winning_hand
			Sorting.sort_Meld(winning_hand);
			//sort winning all by first of each meld, put eye at last
			int local_score=0;
			Sorting.sort_Meld(winning_hand);
			if(CheckPH(winning_hand)) {
				Sequence common_hand=new Common_Hand();
				temp_sequence.add(common_hand);
			}
			if(showed_hand!=null)
				if(CheckPPH(winning_hand,showed_hand)) {
					if(!CheckQYJ(winning_hand)) {
			
						Sequence all_in_triplet=new All_In_Triplet();
						temp_sequence.add(all_in_triplet);
					}		
						
					
				}
			if(CheckQYJ(winning_hand))
			{

				Sequence all_terminals=new All_Terminals();
				temp_sequence.add(all_terminals);
				
			}
			if(CheckHYS(winning_hand)) {
				Sequence mixed_one_suit=new Mixed_One_Suit();
				temp_sequence.add(mixed_one_suit);
			}
			if(CheckQYS(winning_hand) ) {
				if(!CheckJLBD(winning_hand)) {
				Sequence all_one_suit=new All_One_Suit();
				temp_sequence.add(all_one_suit);
				}
			}
			if(CheckHYJ(winning_hand)) {
				Sequence mixed_terminals=new Mixed_Terminals(); 
				temp_sequence.add(mixed_terminals);
			}
			if(CheckXSY(winning_hand)) {
				Sequence small_dragon=new Small_Dragons();
				temp_sequence.add(small_dragon);
				
			}
			if(CheckXSX(winning_hand)) {
				Sequence small_wind=new Small_Winds();
				temp_sequence.add(small_wind);
				
			}
			if(CheckZYS(winning_hand)) {
				Sequence all_honour=new All_Honours();
				temp_sequence.add(all_honour);
				
			}
			if(CheckDSY(winning_hand)) {
				Sequence great_dragon=new Great_Dragons();
				temp_sequence.add(great_dragon);
				
			}
			if(CheckDSX(winning_hand)) {
				Sequence great_wind=new Great_Winds();
				temp_sequence.add(great_wind);
				
			}
			if(CheckJLBD(winning_hand)) {
				Sequence nine_gate=new Nine_Gates() ;
				temp_sequence.add(nine_gate);
				
			}
			if(CheckKKH(winning_hand,showed_hand)) {
				Sequence kkh = new Four_Concealed_Triplets();
				temp_sequence.add(kkh);
				
			}
			if(CheckAKS(winning_hand)) {
				Sequence aks=new All_Kongs();
				temp_sequence.add(aks);
			}
			
			//extra score
			if(showed_hand != null) {
				if(CheckMC(showed_hand)) {
					if(!CheckJLBD(winning_hand) &&!CheckQYJ(winning_hand)&&!CheckKKH(winning_hand,showed_hand)) {
					Sequence win_from_wall=new Win_From_Wall();
					temp_sequence.add(win_from_wall);
					}
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
	
	
	/**
	 * Check same type.
	 *
	 * @param a the a
	 * @param b the b
	 * @return true, if successful
	 */
	public boolean CheckSameType(Tile a, Tile b) {

		if(a.getType().equals(b.getType())
				) {return true;}
		
		return false;
		
	}
	
	
	/**
	 * Check PH.
	 * Check if the hand is in common hand
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckPH(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=1 &&hand.get(i).getcomb_type() !=0) {
				return false;
			}
			
		}
		return true;
	}

	/**
	 * Check PPH.
	 * Check if the hand is All in Triplet 
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @return true, if successful
	 */
	

	public boolean CheckPPH(ArrayList<Meld> hand,ArrayList<Meld>showed_hand) {//
		if(showed_hand.isEmpty())
			return false; 
		boolean OnlyDragonOrWind = true;
		boolean AllKongs=true; 
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
	
	/**
	 * Check HYJ.
	 * Check if it Mix Terminals
	 * @param hand the hand
	 * @return true, if successful
	 */
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
	

	/**
	 * Check HYS.
	 * Check if it is Mixed one suit
	 * @param hand the hand
	 * @return true, if successful
	 */


	public boolean CheckHYS(ArrayList<Meld> hand) {

	
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type 
		
		if(!(first_hand.getType()== Type.BAMBOO || first_hand.getType()== Type.CHARACTER ||first_hand.getType()== Type.DOT )) {
			
			return false; // it should be check for ZYS , which is exception to HYS
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
	

	/**
	 * Check QYS.
	 * Check if it is All one suit
	 * @param hand the hand
	 * @return true, if successful
	 */

	public boolean CheckQYS(ArrayList<Meld> hand) {

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
	
	/**
	 * Check KKH.
	 * Check if it is  Four Concealed Triplet
	 * @param hand the hand
	 * @param showed_hand the showed hand
	 * @return true, if successful
	 */
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
	
	/**
	 * Check AKS.
	 * Check if it is all kongs
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckAKS(ArrayList<Meld> hand) { // all kongs
		for(Meld m:hand) {
			if(m.getcomb_type()!=0)
				if(m.getcomb_type()!=3)
					return false;
		}
		return true;
		
	}
	
	/**
	 * Check MC.
	 * Check if it is Win From Wall
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckMC(ArrayList<Meld> hand) {
		if(hand.isEmpty())
			return true;
		return false;
	}
	
	/**
	 * Check red dragon.
	 * Check if it is a pong with Red Dragon
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckRedDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==27)
				return true;
		}
		return false;
	}
	
	/**
	 * Check green dragon.
	 * Check if it is a pong with Green Dragon
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckGreenDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==28)
				return true;
		}
		return false;
		
	}
	
	/**
	 * Check white dragon.
	 * Check if it is a pong with White Dragon
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckWhiteDragon(ArrayList<Meld> hand) {
		for(int i=0;i<hand.size();i++) {
			if(hand.get(i).getFirst().getId()/4==29)
				return true;
		}
		return false;
	
	}
	

	/**
	 * Check XSY.
	 * Check if it is small dragon
	 * @param hand the hand
	 * @return true, if successful
	 */

	public boolean CheckXSY(ArrayList<Meld> hand) {

		int dragon=0;
		int dra_eye=0;
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type()==2 && hand.get(i).getFirst().getType()==Type.DRAGON) {
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
	

	/**
	 * Check XSX.
	 * Check if it is small wind
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckXSX(ArrayList<Meld> hand){

		int wind=0;
		boolean wind_eye=false;
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type()==2 && hand.get(i).getFirst().getType()==Type.WIND) {
				wind++;
			}else if(hand.get(i).getcomb_type()==0 && hand.get(i).getFirst().getType()==Type.WIND) {
				wind_eye=true;
			}
		}
		if(wind==3 && wind_eye==true) {
			return true;
		}
		return false;
	}
		

	/**
	 * Check ZYS.
	 * Check if it is all honours
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckZYS(ArrayList<Meld> hand){
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getFirst().getType()!=Type.WIND && hand.get(i).getFirst().getType()!=Type.DRAGON) {
				return false;
			}
		}
		
		return true;
	}
	

	/**
	 * Check QYJ.
	 * Check if it is all terminals
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckQYJ(ArrayList<Meld> hand){
		for(int i=0;i<hand.size();i++){
			Tile t = hand.get(i).getFirst();
			if((t.getRankIndex()!=0 && t.getRankIndex()!=8) || t.getType()==Type.DRAGON || t.getType()==Type.WIND ) {
				return false;
			}
		}
		
		return true;
	}
	

	/**
	 * Check DSY.
	 * Check if it is Great Dragon
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckDSY(ArrayList<Meld> hand){
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
  
	/**
	 * Check DSX.
	 * Check if it is Great Wind
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckDSX(ArrayList<Meld> hand){
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

	/**
	 * Check JLBD.
	 * Check if it is nine gate
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckJLBD(ArrayList<Meld> hand) {
		Tile first_hand= hand.get(0).getFirst();
		int exceedtwo=0;
		int exceedfour=0;
		int [] list = {0,0,0,0,0,0,0,0,0};
		for(int i=0;i<hand.size();i++){
			if (hand.get(i).getFirst().getType()!=first_hand.getType()){ //make sure the types are all the same
				return false;
			}
			list[hand.get(i).getFirst().getRankIndex()]++;
			if(hand.get(i).getFirst().getRankIndex()==0 || hand.get(i).getFirst().getRankIndex()==8)
			{
				if(list[hand.get(i).getFirst().getRankIndex()]>3) {
					exceedfour++;
				}
			}else {
				if(list[hand.get(i).getFirst().getRankIndex()]>1)
					exceedtwo++;
				
			}
			list[hand.get(i).getSecond().getRankIndex()]++;
			if(hand.get(i).getSecond().getRankIndex()==0 || hand.get(i).getSecond().getRankIndex()==8)
			{
				//nothing
			}else {
				if(list[hand.get(i).getSecond().getRankIndex()]>1)
					exceedtwo++;
				
			}
			
			if(hand.get(i).getThird()!=null) {
				list[hand.get(i).getThird().getRankIndex()]++;
				if(hand.get(i).getThird().getRankIndex()==0 || hand.get(i).getThird().getRankIndex()==8)
				{
					if(list[hand.get(i).getThird().getRankIndex()]>3) {
						exceedfour++;
					}
				}else {
					if(list[hand.get(i).getThird().getRankIndex()]>1) {
						exceedtwo++;
					}
					
				}
				
				
			}
			
		}
		
		if(exceedtwo==1 && exceedfour==0 || exceedfour==1 && exceedtwo==0){
			return true;
		}else
			return false;
	}
	

	/**
	 * Check SSY.
	 * Check if it is thirteen orphans
	 * @param hand the hand
	 * @return true, if successful
	 */
	public boolean CheckSSY(ArrayList<Tile> hand) {
		if(hand.size()==14 ) {
			int[] list = {0,0,0,0,0,0,0,0,0,0,0,0,0}; 
			for (Tile each:hand ) {
				if(each.getType()==Type.WIND && each.getRankIndex()==0) {
					list[0]++;
				}
				if(each.getType()==Type.WIND && each.getRankIndex()==1) {
					list[1]++;
				}if(each.getType()==Type.WIND && each.getRankIndex()==2) {
					list[2]++;
				}if(each.getType()==Type.WIND && each.getRankIndex()==3) {
					list[3]++;
				}
				
				if(each.getType()==Type.DRAGON && each.getRankIndex()==0) {
					list[4]++;
				}
				if(each.getType()==Type.DRAGON && each.getRankIndex()==1) {
					list[5]++;
				}
				if(each.getType()==Type.DRAGON && each.getRankIndex()==2) {
					list[6]++;
				}
				
				if(each.getType()==Type.BAMBOO&& each.getRankIndex()==0) {
					list[7]++;
				}
				if(each.getType()==Type.BAMBOO && each.getRankIndex()==8) {
					list[8]++;
				}
				
				if(each.getType()==Type.CHARACTER && each.getRankIndex()==0) {
					list[9]++;
				}
				if(each.getType()==Type.CHARACTER && each.getRankIndex()==8) {
					list[10]++;
				}
				
				if(each.getType()==Type.DOT && each.getRankIndex()==0) {
					list[11]++;
				}if(each.getType()==Type.DOT && each.getRankIndex()==8) {
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

