/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: AiRecommenderUtil.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.aiUi;

import java.util.*;

import utils.Tile;

/**
 * The Class AiRecommenderUtil.
 */
public class AiRecommenderUtil {
	
	
	/**
	 * Find closest combinations.
	 *
	 * @param eyes the eyes
	 * @param triplets the triplets
	 * @param sequences the sequences
	 * @return the list
	 */
	public List<List<Tile>> findClosest(List<List<Tile>> eyes, List<List<Tile>> triplets, List<List<Tile>> sequences){
		// return if no eyes, no triplets, no sequences
		if(eyes.size()==0 && triplets.size()==0 && sequences.size()==0) {
			return new ArrayList<>();
		}
		
		List<List<Tile>> allTiles = new ArrayList<>();
		allTiles.addAll(eyes);
		allTiles.addAll(triplets);
		allTiles.addAll(sequences);
		List<List<Tile>> sortedListWithPossibleDuplicates = this.sortTiles(allTiles); // sort according to max ID
		
		// remove redundant combinations
		int traversed = eyes.size(); // break the while loop
		while(eyes.size()>1 && traversed>0) {
			for(int i=0; i<eyes.size(); i++) {
				List<Tile> eye = eyes.get(i);
				if(duplicated(sortedListWithPossibleDuplicates, eye.get(0).getId()))
					eyes.remove(i);
			}
			traversed--;
		}
		// remove the eyes randomly if no duplicates were found
		while(eyes.size()>1) {
			eyes.remove(eyes.size()-1);
		}
		
		List<List<Tile>> sortedListWithoutDuplicates = new ArrayList<>();
		sortedListWithoutDuplicates.addAll(eyes);
		sortedListWithoutDuplicates.addAll(triplets);
		sortedListWithoutDuplicates.addAll(sequences);
		
		// no more redundancy, apply interval scheduling
		List<List<Tile>> optimized = this.findMaxNumofCompatibleCombinations(sortedListWithoutDuplicates);
		return optimized;
	}
	
	/**
	 * Find max number of compatible combinations to form a winning hand
	 *
	 * @param sortedList the sorted list of combinations
	 * @return the list
	 */
	public List<List<Tile>> findMaxNumofCompatibleCombinations(List<List<Tile>> sortedList){
		List<List<Tile>> result = new ArrayList<>();
		result.add(sortedList.get(0));
		List<Tile> lastCombination = sortedList.get(0);
		
		// apply interval scheduling algorithm
		for(List<Tile> t : sortedList) {
			if(isCompatible(t, lastCombination)) {
				result.add(t);
				lastCombination.clear();
				lastCombination.addAll(t);
			}
		}
		
		return result;
		
	}
	
	/**
	 * Sort combinations list.
	 *
	 * @param tilesToSort the combination list to sort
	 * @return the sorted list
	 */
	public List<List<Tile>> sortTiles(List<List<Tile>> tilesToSort){
		Collections.sort(tilesToSort, new Comparator<List<Tile>>() {
			@Override
			public int compare(List<Tile> a, List<Tile> b) {
				if(a.get(a.size()-1).getId() > b.get(b.size()-1).getId())
					return 1;
				else if(a.get(a.size()-1).getId() < b.get(b.size()-1).getId())
					return -1;
				return 0;
			}
		}); 
		return tilesToSort;
	}
	
	/**
	 * Checks if two combinations are compatible.
	 *
	 * @param former the former
	 * @param latter the latter
	 * @return true, if is compatible
	 */
	public boolean isCompatible(List<Tile> former, List<Tile> latter) {
		if(former.get(former.size()-1).getId() < latter.get(0).getId())
			return true;
		return false;
	}
	
	/**
	 * Check if a list of combinations has duplicated Tile ids.
	 *
	 * @param list the list
	 * @param id the id
	 * @return true, if duplicated
	 */
	public boolean duplicated(List<List<Tile>> list, int id) {
		for(List<Tile> l: list) {
			if(containsId(l, id))
				return true;
		}
		return false;
	}
	
	/**
	 * Checker if a list of Tile contains a Tile id.
	 *
	 * @param tilesToCheck the tiles to check
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean containsId(List<Tile> tilesToCheck, int id) {
		for(Tile t : tilesToCheck) {
			if(t.getId()==id)
				return true;
		}
		return false;
	}
}