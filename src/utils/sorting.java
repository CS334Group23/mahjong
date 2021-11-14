package utils;

import java.util.ArrayList;

public final class sorting {
    public static void sort_Meld(ArrayList<Meld> showed_hand){
    	Meld temp;
    	boolean sorted=false;
    	while(!sorted) {
    		 sorted = true;
    	        for (int i = 0; i < showed_hand.size()-1; i++) {
    	            if (showed_hand.get(i).compareTo(showed_hand.get(i + 1)) > 0) {
    	                temp = showed_hand.get(i);
    	                showed_hand.set(i, showed_hand.get(i + 1));
    	                showed_hand.set(i + 1, temp);
    	                sorted = false;
    	            }
    	        }
    		
    	}
    	
    }
    
    
    public static void sortTile(ArrayList<Tile> hand) { //just us bubble sort for temp testing, can change later
    	Tile temp;
    	boolean sorted=false;
    	while(!sorted) {
    		 sorted = true;
    	        for (int i = 0; i < hand.size()-1; i++) { 
    	            if (hand.get(i).compareTo(hand.get(i + 1)) > 0) {
    	                temp = hand.get(i);
    	                hand.set(i, hand.get(i + 1));
    	                hand.set(i + 1, temp);
    	                sorted = false;
    	            }
    	        }
    		
    	}
    }
}
