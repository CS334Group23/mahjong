/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: AiRecommender.java </p> 
 * @author TeamCS3343 </a>
 */
package ui.aiUi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Meld;
import utils.Tile;

/**
 * The Class AiRecommender.
 * Skim through cards in hand  
 * keep the cards that add up to the highest marks
 */
public class AiRecommender {
	
	/** The card to play. */
	private Tile cardToPlay;
	
	/** The cards cards in my hand. */
	private List<Tile> cardsInHand;
	
	/** The cards not played including my hands. */
	private List<Tile> cardsNotPlayed;
	
	/** The ai recommender util. */
	private AiRecommenderUtil aiRecommenderUtil;
	
	/**
	 * Instantiates a new ai recommender.
	 */
	public AiRecommender() {
		this.aiRecommenderUtil = new AiRecommenderUtil();
		cardsNotPlayed  = new ArrayList<>();
		for(int i=0; i<Tile.TOTAL_TILES_WITHOUT_FLOWERS; i++) {
			cardsNotPlayed.add(new Tile(i));
		}
	}
	
	/**
	 * Upon called when there are status change on the board
	 * register current situation and clear last card recommendation 
	 *
	 * @param cardsInHand the cards in hand of the user
	 * @param tileId the tile id be discarded or drawn
	 */
	public void uponCalled(List<Tile> cardsInHand, int tileId) {
		this.cardsInHand = new ArrayList<>(cardsInHand);
		this.cardsNotPlayed.removeIf(m -> m.getId()==tileId);
		this.cardToPlay = null; 
	}
	
	/**
	 * Upon called when there are status change on the board
	 * register current situation and clear last card recommendation 
	 *
	 * @param cardsInHand the cards in hand of the user
	 * @param meld the meld bided on the board
	 */
	public void uponCalled(List<Tile> cardsInHand, Meld meld) {
		if(meld.getFirst() != null) {
			this.cardsNotPlayed.removeIf(m -> m.getId()==meld.getFirst().getId());
		}
		if(meld.getSecond() != null) {
			this.cardsNotPlayed.removeIf(m -> m.getId()==meld.getSecond().getId());
		}
		if(meld.getThird() != null) {
			this.cardsNotPlayed.removeIf(m -> m.getId()==meld.getThird().getId());
		}
		if(meld.getForth() != null) {
			this.cardsNotPlayed.removeIf(m -> m.getId()==meld.getForth().getId());
		}
		this.cardsInHand = new ArrayList<>(cardsInHand);
	}
	
	/**
	 * Upon called when there are status change on the board
	 * register current situation and clear last card recommendation 
	 *
	 * @param dealList the deal list when user get initial deal
	 */
	public void uponCalled(List<Integer> dealList) {
		for (int i : dealList) {
			this.cardsNotPlayed.removeIf(m -> m.getId()==i);
		}
	}
	
	
	/**
	 * Recommend the tile to play according to the current hand and Tile not played.
	 * only recommend to reach winning hand
	 *
	 * @return the tile
	 */
	public Tile recommend() {
		
		List<List<Tile>> eyes = new ArrayList<>();
		List<List<Tile>> triplets = new ArrayList<>();
		List<List<Tile>> sequences = new ArrayList<>();
		
		// find all occurrences of each Tile based on Chinese name
		// TODO: may need to add equals function in Tile for Collectors.counting to work
		Map<String, Long> counts =
			    cardsInHand.stream().collect(Collectors.groupingBy(e -> e.getName(), Collectors.counting()));
		
		// find all eyes and triplets
		for (Map.Entry<String, Long> entry : counts.entrySet()) {
		    if(entry.getValue().intValue() == 2) {
		    	List<Tile> eye = findTileWithValue(cardsInHand, entry.getKey());
		    	eyes.add(eye);
		    }
			if(entry.getValue().intValue() == 3) {
				List<Tile> triplet = findTileWithValue(cardsInHand, entry.getKey());
				triplets.add(triplet);
			}
		}
		
		// find all sequences
		Collections.sort(cardsInHand, Comparator.comparing(t -> t.getId()));
		int i = 0;
		while(i < cardsInHand.size()-2) {
			if(cardsInHand.get(i+2).getType().getTypeIndex()>=3) {
				break;
			}
			if(cardsInHand.get(i).getId() < cardsInHand.get(i+1).getId() - 1) {
				i++;
				continue;
			}
			if(cardsInHand.get(i+1).getId() < cardsInHand.get(i+2).getId() - 1) {
				i++;
				continue;
			}
			if(!cardsInHand.get(i).getType().isSameType(cardsInHand.get(i+2).getType())) {
				i++;
				continue;
			}
			List<Tile> sequence = new ArrayList<>();
			sequence.add(cardsInHand.get(i));
			sequence.add(cardsInHand.get(i+1));
			sequence.add(cardsInHand.get(i+2));
			sequences.add(sequence);
			i += 2;
		}
		
		// find the combination closest to a winning hand
		// pick out the combinations that shouldn't be touched
		List<List<Tile>> closest = this.aiRecommenderUtil.findClosest(eyes, triplets, sequences);
		for(List<Tile> l: closest) {
			cardsInHand.removeAll(l);
		}
		
		// for each tile among those that can not pair up
		// calculate its possibility to pair up with incoming cards
		// simplified version: calculate the num of incoming cards that can pair up
		// find the min among these => this is the card to discard
		int[] markingBoard = new int[cardsInHand.size()];
		for(int j=0; j<cardsInHand.size(); j++) {
			Tile t = cardsInHand.get(j);
			markingBoard[j] = formSequence(cardsInHand, t) + formEyesOrTriplets(cardsInHand, t) 
			+ formSequence(cardsNotPlayed, t) + formEyesOrTriplets(cardsNotPlayed, t);
		}
		
		int minAt = 0;
		for (int j = 0; j < markingBoard.length; j++) {
		    minAt = markingBoard[j] < markingBoard[minAt] ? j : minAt;
		}
		this.cardToPlay=cardsInHand.get(minAt);
		
		return this.cardToPlay;
	}
	
	/**
	 * Find tile with value.
	 *
	 * @param listToSearch the list to search
	 * @param strToFind the str to find
	 * @return the array list of Tile
	 */
	public ArrayList<Tile> findTileWithValue(List<Tile> listToSearch, String strToFind) {
		ArrayList<Tile> group = new ArrayList<>();
		for(Tile t: listToSearch) {
			if(t.getName().equals(strToFind)) {
				group.add(t);
			}
		}
		return group;
	}
	
	/**
	 * Form a sequence with input Tile and Tile list.
	 *
	 * @param list the Tile list
	 * @param tile the tile
	 * @return the position of the sequence
	 */
	public int formSequence(final List<Tile> list,  Tile tile){
		int value = 0;
	    for(Tile t:list) {
	    	if(t.getId()==tile.getId()-1 && t.getType().equals(tile.getType()))
	    		value++;
	    	if(t.getId()==tile.getId()+1 && t.getType().equals(tile.getType()))
	    		value++;
	    }
	    return value;
	}
	
	/**
	 * Form eyes or triplets with input Tile and Tile list.
	 *
	 * @param list the Tile list
	 * @param tile the tile
	 * @return the the position of the sequence
	 */
	public int formEyesOrTriplets(final List<Tile> list, Tile tile) {
		int value = 0;
		for(Tile t: list) {
			if(t.getName().equals(tile.getName()) && (t.getId()!=tile.getId()))
				value++;
		}
		return value;
	}
	/**
	 * Gets numbers of the cards that has not been drawn.
	 *
	 * @return numbers of the cards that has not been drawn
	 */
	public int getRemainingCards() {
		return cardsNotPlayed.size();
	}

}


