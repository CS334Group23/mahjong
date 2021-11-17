package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import utils.Tile;

class TestAiRecommender {

	@Test
	void test() {
		AiRecommender theAiRecommender = AiRecommender.callAiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(0)); // eye
		cardsInHand.add(new Tile(10));
		cardsInHand.add(new Tile(11));
		cardsInHand.add(new Tile(12)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(20)); // triplet
		cardsInHand.add(new Tile(31)); 
		cardsInHand.add(new Tile(32));
		cardsInHand.add(new Tile(40));
		cardsInHand.add(new Tile(41));
		cardsInHand.add(new Tile(42));
		cardsInHand.add(new Tile(50)); // should be played
		List<Tile> cardsNotPlayed = new ArrayList<>();
		cardsNotPlayed.add(new Tile(55));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(41));
		cardsNotPlayed.add(new Tile(57));
		cardsNotPlayed.add(new Tile(56));
		theAiRecommender.uponCalled(cardsInHand, cardsNotPlayed);
		Tile card = theAiRecommender.recommend();
		assertEquals(card.getId(),50);
	}

}
