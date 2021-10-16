package ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Tile;

// Skim through cards in hand 
// keep the cards that add up to the highest marks

public class AiRecommender {
	private static AiRecommender theAiRecommender; // Singleton Pattern
	
	private int cardToPlay = -1;
	private List<Tile> cardsInHand;
	private List<Tile> cardsPlayed;
	
	private AiRecommender() {
		theAiRecommender = new AiRecommender();
	}
	
	public AiRecommender callAiRecommender() {
		return theAiRecommender;
	}
	
	// register current situation
	// and clear last card recommendation 
	// each time upon called
	public void uponCalled(List<Tile> cardsInHand, List<Tile> cardsPlayed) {
		this.cardsInHand = new ArrayList<>(cardsInHand);
		this.cardsPlayed = new ArrayList<>(cardsPlayed); // make two shallow copies for manipulation
		this.cardToPlay = -1; 
	}
	
	// simplified version
	// only recommend to reach winning hand
	public int recommend() {
		
		List<List<Tile>> eyes = new ArrayList<>();
		List<List<Tile>> triplets = new ArrayList<>();
		List<List<Tile>> sequences = new ArrayList<>();
		
		// find all occurrences of each Tile based on value
		// TODO: may need to add equals function in Tile for Collectors.counting to work
		Map<Tile, Long> counts =
			    cardsInHand.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		// find all eyes and triplets
		for (Map.Entry<Tile, Long> entry : counts.entrySet()) {
		    if(entry.getValue().intValue() == 2) {
		    	List<Tile> eye = findTileWithValue(cardsInHand, entry.getKey().getId());
		    	eyes.add(eye);
		    }
			if(entry.getValue().intValue() == 3) {
				List<Tile> triplet = findTileWithValue(cardsInHand, entry.getKey().getId());
				triplets.add(triplet);
			}
		}
		
		// find all sequences
		Collections.sort(cardsInHand, Comparator.comparing(t -> t.getId()));
		int i = 0;
		while(i < cardsInHand.size()) {
			if(cardsInHand.get(i).getId() < cardsInHand.get(i+1).getId() - 1) {
				continue;
			}
			if(cardsInHand.get(i+1).getId() < cardsInHand.get(i+2).getId() - 1) {
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
		// TODO: OPTIMIZATION NEEDED!
		
		
		
		// TODO: implement isWinningHand
		if(isWinningHand(cardsInHand)) {
			System.out.println("Winning Tile!"); // update according to GUI
			return -1;
		}
		
		// for each tile among those that can not pair up
		// calculate its possibility to pair up with incoming cards
		// simplified version: calculate the num of incoming cards that can pair up
		// find the max among these
		
		
		
		return this.cardToPlay;
	}
	
	public ArrayList<Tile> findTileWithValue(List<Tile> listToSearch, int idToFind) {
		ArrayList<Tile> group = new ArrayList<>();
		for(Tile t: listToSearch) {
			if(t.getId() == idToFind) {
				group.add(t);
			}
		}
		return group;
	}
}
