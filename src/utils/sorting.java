/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: sorting.java </p> 
 * @author TeamCS3343 </a>
 */
package utils;

import java.util.ArrayList;

/**
 * The Class sorting.
 * The Class which does some common sorting work.
 */
public final class sorting {
    
    /**
     * Sort a list of Meld.
     *
     * @param showed_hand A list of showed Meld
     */
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
}
