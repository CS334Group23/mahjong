package sequence;

import java.util.ArrayList;
import utils.Tile;
import utils.Meld;
import utils.Tile;

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
	private ArrayList<ArrayList<Meld>> combination_set = new ArrayList<>();
	private ArrayList<Meld> Combi_temp = new ArrayList<>();
	Checker checker=new Checker();
	public Combination() {};
	public int count=0;
	public void getCombination(ArrayList<Tile> hand) {
		checkcombination(hand);
		if(Combi_temp.size()==0) {
			System.out.println("null");
		}
			
		else list(); 
		
	}
	public boolean checkcombination(ArrayList<Tile> hand) {
		if (hand.size() ==0) {
			return true;
			
		}
		for(int i=0;i<hand.size();i++) {
			//System.out.println(count+"  "+i+"  "+hand.size());
			if(hand.size()==2) { //if only 2, check if it is pair
				if(hand.get(i).getId()/4==hand.get(i+1).getId()/4){
					{
						Meld Mtemp = new Meld(hand.get(i),hand.get(i+1),null,null);
						Combi_temp.add(Mtemp);
						hand.remove(i);
						hand.remove(i);
						if(checkcombination(hand)) {
							combination_set.add(Combi_temp);
							return true;
						};
							
					}
					
					
				}else {return false;	}
				
				
			}else if(hand.size()-i>2) {
				//System.out.println("jump "+hand.get(i).getId());
				if(checker.CheckChow(hand.get(i),hand.get(i+1),hand.get(i+2))||
						checker.CheckPong(hand.get(i),hand.get(i+1),hand.get(i+2))) {
					//System.out.println(hand.get(i).getId()+" "+hand.get(i+1).getId()+" "+hand.get(i+2).getId());
					Meld Mtemp = new Meld(hand.get(i),hand.get(i+1),hand.get(i+2),null);
					Combi_temp.add(Mtemp);
					hand.remove(i);
					hand.remove(i);
					hand.remove(i);
					if(checkcombination(hand)) {
						count++;
						// which mean, there is aleady a combination created
						// for example, just checked eyes is true, then return
						// put back the remain hand and also try again
						hand.add(Mtemp.getFirst());
						hand.add(Mtemp.getSecond());
						hand.add(Mtemp.getThird());
						
					}
					
					
				} 
				
				
			  }
				
				
				
			}
			
			return false;
		}
		public void list() {
			
			for(ArrayList<Meld> m: combination_set) {
				for(Meld m2: m) {
					if(m2.getThird()!=null)
						System.out.print(m2.getFirst().getId()+" "+m2.getSecond().getId()+" "+m2.getThird().getId()+" ");
					else
						System.out.print(m2.getFirst().getId()+" "+m2.getSecond().getId()+" ");
				}
				System.out.println();
			}
		}
		
}


