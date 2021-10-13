package sequence;

import java.util.*;

import utils.*;

public class Checker {
	private static Checker instance = new Checker();
	public static Checker getInstance() {
		
		return instance;
	}
	
public boolean CheckChow(Tile a, Tile b, Tile c) {

		if(a.getId()/4 == b.getId()/4-1 && b.getId()/4== c.getId()/4-1 )//&& a.getType().equals(c.getType()))
		{
			
			return true;
		}
		
		return false;
	}

	public boolean CheckPong(Tile a, Tile b, Tile c) {
		
		if(a.getId()/4 == b.getId()/4 && b.getId()/4 == c.getId()/4)
		{
			//System.out.println(a.getId()+" "+b.getId()+" "+c.getId());
			return true;
		}
		
		return false;
	}

	public int CheckScore(ArrayList<Tile> hand, ArrayList<Meld> showed_hand ) {
		int score=0;
		int local_score=0;
		Combination comb=new Combination();
		ArrayList<ArrayList<Meld>> set=comb.getCombination(hand);
		
		for(ArrayList<Meld> winning_hand : set) {
			//winning_hand.addAll(showed_hand);   use to merge the showed_hand into winning_hand
			//sort winning all by first of each meld, put eye at last
			local_score+=CheckPH(winning_hand);
			local_score+=CheckPPH(winning_hand);
			local_score+=CheckHYS(winning_hand);
			local_score+=CheckQYS(winning_hand);
			// other check will add later 
			
			if(local_score>=score) {
				score=local_score;
			}
			
		}
		return score;
		
		
	}
	public boolean CheckSameType(Tile a, Tile b) {
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72), DRAGON(3, 108), FLOWER(5, 136), WIND(4, 120);
		if( (a.getId() >=0 &&  a.getId()  <36 &&  b.getId()  >=0 &&  b.getId()  <36)
				|| (a.getId() >=36 &&  a.getId()  <72 &&  b.getId()  >=36 &&  b.getId()  <72)
				||(a.getId() >=72 &&  a.getId()  <108 &&  b.getId()  >=72 &&  b.getId()  <108)
				||(a.getId() >108 &&  a.getId()  <136 &&  b.getId()  >=108 &&  b.getId()  <136)
				) {return true;}
		
		return false;
		
	}
	public int CheckPH(ArrayList<Meld> hand) {//平燸
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=1 ||hand.get(i).getcomb_type() !=0) {
				return 0;
			}
			
		}
		return 1;
	}
	public int CheckPPH(ArrayList<Meld> hand) {//對對糊
		for(int i=0;i<hand.size();i++){
			if(hand.get(i).getcomb_type() !=2 ||hand.get(i).getcomb_type() !=0) {
				return 0;
			}
			
		}
		return 3;
	}
	public int CheckHYS(ArrayList<Meld> hand) {//添一色
	
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		if(first_hand.getId()>108 ) {
			
			return 0; // it should be check for 字一色 , which is exception to HYS
		}
			
		for(int i=0;i<hand.size();i++) { //if all meld is same type with first tile, or if it is dragon, then return 3, else return 0
			if(!(CheckSameType(hand.get(i).getFirst(),first_hand) || hand.get(i).getFirst().getId()>=108))
				return 0;
		}
		return 3;
	}
	
	public int CheckQYS(ArrayList<Meld> hand) {//清一色
		Tile first_hand= hand.get(0).getFirst(); //initial hand, use for check type , assume meld is sort.
		
		//BAMBOO(0, 0), CHARACTER(1, 36), DOT(2, 72),
		if(first_hand.getId()>108 ) {
			
			return 0; // it should be check for 字一色 , which is exception to QYS
		}
			
		for(int i=0;i<hand.size();i++) {
			if(!CheckSameType(hand.get(i).getFirst(),first_hand))
				return 0;
		}
		return 7;
	}
	public int CheckMF(ArrayList<Meld> hand) { //門風
	
	
		return 1;
	}
	public int CheckJF(ArrayList<Meld> hand) {//正弁
		
		return 1;
	}



}
