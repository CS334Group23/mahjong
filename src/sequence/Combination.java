package  sequence;

import java.util.ArrayList;
import java.util.*;

import utils.*;

//The logic is to find out all the combination set to check the score, count the highest.

//To find the combination, I will use backtracking
//To initialize, there must be a sorted hand
//then check if there is pong or chow ( no need check kong as kong must be in show hand to win.)
//if so, remove three tile and put it in temp
//call checkcombination again, check the remain card,
// if the hand size only two, just check if it is pair ( only do this step when hand size is two, as for any winning hand, it must be pair, except 13, that will be check in another function)
// after remove a pair, the hand size is 0, then put the temp into the combination set arraylist
// then return, return , and put back the hand into list, then we can find the remain tile if can form meld again.




// the function may still buggy, and but at least it can check a winning hand, I will do it later.(or maybe do it on testing, have something write)
public class Combination {
	/*public int getmeldid(Meld t) {
		if(t.getFirst().getType()==Type.BAMBOO)
			if(t.getcomb_type()==2)
				return t.getFirst().getRankIndex();
			else
				return t.getFirst().getRankIndex()+10;
		else if(t.getFirst().getType()==Type.CHARACTER)
			if(t.getcomb_type()==2)
				return t.getFirst().getRankIndex()+20;
			else
				return t.getFirst().getRankIndex()+30;
			
		else if(t.getFirst().getType()==Type.DOT)
			if(t.getcomb_type()==2)
				return t.getFirst().getRankIndex()+40;
			else
				return t.getFirst().getRankIndex()+50;
		else if(t.getFirst().getType()==Type.DRAGON)
				return t.getFirst().getRankIndex()+60;
			
		else if(t.getFirst().getType()==Type.WIND)
				return t.getFirst().getRankIndex()+63;
		else
			return -1;
	}*/
	private ArrayList<ArrayList<Meld>> combination_set = new ArrayList<>();
	private ArrayList<Meld> Combi_temp = new ArrayList<>();
	//private ArrayList<Meld> all_temp=new ArrayList<>();
	//Integer[] ponged = Collections.nCopies(144, 0).toArray(new Integer[0]);
	private Integer[] formmeld=new Integer[70]; // 0-8 bamboo pong, 10-16 bambo chow || 20-28 character pong, 30-16 chow || 40-48 dot pong,50-56 chow || 60-62 dragon 63-67 wind
	public Combination() {
		/*
		for(int i=0;i<70;i++) {
			
			formmeld[i]=0;
		}
		*/
	};
	public int count=0;
	public ArrayList<ArrayList<Meld>> getCombination(ArrayList<Tile> hand) {
		if(!combination_set.isEmpty()) {
			combination_set.clear();
			
		}
		if(!Combi_temp.isEmpty()) {
			Combi_temp.clear();
			
		}
		sorting.sortTile(hand);
		checkcombination(hand);
		return combination_set;
		
	}
	
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
					//if( formmeld[getmeldid(Mtemp)]>5){
						
					//}else 
					//{
					//	formmeld[getmeldid(Mtemp)]++;
					//all_temp.add(Mtemp);	
						Combi_temp.add(Mtemp);
						hand.remove(i);
						hand.remove(i);
						hand.remove(i);
					
						if(checkcombination(hand)) {
			
						// which mean, there is aleady a combination created
						// for example, just checked eyes is true, then return
						// put back the remain hand and also try again
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						
						Combi_temp.remove(Combi_temp.size()-1);
						sorting.sortTile(hand);
				
						
						}else {

						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						Combi_temp.remove(Combi_temp.size()-1);
						sorting.sortTile(hand);
						}
					}

				//} 
			//	/*
				int b_pos=  FindTilePosition.NextDifferentTile(hand,hand.get(i));
				int c_pos=-1;
				if(b_pos!=-1)
				 c_pos=  FindTilePosition.NextDifferentTile(hand,hand.get(b_pos));
				if(b_pos!=-1 && c_pos!=-1) {
				if(CheckChow(hand.get(i),hand.get(b_pos),hand.get(c_pos))) {
				
					Meld Mtemp= new Meld(hand.get(i),hand.get(b_pos),hand.get(c_pos),null);
					//if( formmeld[getmeldid(Mtemp)]>10){
					//	continue;
					//}else 
					//	formmeld[getmeldid(Mtemp)]++;
					Combi_temp.add(Mtemp);
					hand.remove(i);
					hand.remove(b_pos-1);
					hand.remove(c_pos-2);
					
					if(checkcombination(hand)) {
			
						// which mean, there is aleady a combination created
						// for example, just checked eyes is true, then return
						// put back the remain hand and also try again
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						sorting.sortTile(hand);
						Combi_temp.remove(Combi_temp.size()-1);

				
						
					}else {
						hand.add(0,Mtemp.getThird());
						hand.add(0,Mtemp.getSecond());
						hand.add(0,Mtemp.getFirst());
						Combi_temp.remove(Combi_temp.size()-1);
						sorting.sortTile(hand);
						//r=true;
					}
				
					
				}
				}
	
					
				
				


				
				
			  }
				
			}
		
			if(hand.size()!=initial_size)
				return true;
			return false;
		}
	public boolean CheckChow(Tile a, Tile b, Tile c) {

		if(a.getRankIndex() == b.getRankIndex()-1 && b.getRankIndex()== c.getRankIndex()-1 && a.getType().equals(c.getType()))
		{
			
			return true;
		}
		
		return false;
	}

	public boolean CheckPong(Tile a, Tile b, Tile c) {
		if(a.getRankIndex() == b.getRankIndex() && b.getRankIndex() == c.getRankIndex() && a.getType()==c.getType() &&b.getType()==c.getType())
		{
			
			return true;
		}
		
		return false;
	}

		public void list() {//debug and also use for result
			
			for(ArrayList<Meld> m: combination_set) {
				for(Meld m2: m) {
					if(m2.getThird()!=null)
						System.out.print(m2.getFirst().getRankIndex()+" "+m2.getSecond().getRankIndex()+" "+m2.getThird().getRankIndex()+" ");
					else
						System.out.print(m2.getFirst().getId()/4+" "+m2.getSecond().getId()/4+" ");
				}
				System.out.println("Hello");
			}
		}
		public void list(ArrayList<Tile> h) {//debug and also use for result
			
			for(Tile m: h) {
				
					
						System.out.print(m.getId()+" ");
					
			
			}
		}
		
}


