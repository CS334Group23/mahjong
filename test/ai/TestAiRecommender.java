/*
 * <p>Project: mahjong-dev </p> 
 * <p>File Name: TestAiRecommender.java </p> 
 * @author TeamCS3343 </a>
 */
package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import ui.aiUi.AiRecommender;
import utils.Meld;
import utils.Tile;

// TODO: Auto-generated Javadoc
/**
 * The Class TestAiRecommender.
 */
class TestAiRecommender {

	/**
	 * Test.
	 */
	@Test
	void test1() {
		AiRecommender theAiRecommender = new AiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(1)); // eye
		cardsInHand.add(new Tile(10));// should be played
		cardsInHand.add(new Tile(14));
		cardsInHand.add(new Tile(18)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(21));
		cardsInHand.add(new Tile(22)); // triplet
		cardsInHand.add(new Tile(31)); 
		cardsInHand.add(new Tile(32));
		cardsInHand.add(new Tile(40));
		cardsInHand.add(new Tile(41));
		cardsInHand.add(new Tile(42));
		cardsInHand.add(new Tile(50)); 
		List<Tile> cardsNotPlayed = new ArrayList<>();
		cardsNotPlayed.add(new Tile(55));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(41));
		cardsNotPlayed.add(new Tile(57));
		cardsNotPlayed.add(new Tile(56));
		theAiRecommender.uponCalled(cardsInHand, 70);
		Tile card = theAiRecommender.recommend();
		assertEquals(10,card.getId());
	}
	
	@Test
	void test2() {
		AiRecommender theAiRecommender = new AiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(1)); // eye
		cardsInHand.add(new Tile(10));
		cardsInHand.add(new Tile(14));
		cardsInHand.add(new Tile(18)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(21));// should be played
		cardsInHand.add(new Tile(22)); // triplet
		cardsInHand.add(new Tile(31)); 
		cardsInHand.add(new Tile(32));
		cardsInHand.add(new Tile(40));
		cardsInHand.add(new Tile(41));
		cardsInHand.add(new Tile(42));
		cardsInHand.add(new Tile(50));
		List<Tile> cardsNotPlayed = new ArrayList<>();
		cardsNotPlayed.add(new Tile(55));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(41));
		cardsNotPlayed.add(new Tile(57));
		cardsNotPlayed.add(new Tile(56));
		theAiRecommender.uponCalled(cardsInHand, new Meld(new Tile(108),new Tile(109), new Tile(110),null));
		Tile card = theAiRecommender.recommend();
		assertEquals(10,card.getId());
	}
	
	@Test
	void test3() {
		AiRecommender theAiRecommender = new AiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(1)); // eye
		cardsInHand.add(new Tile(10));// should be played
		cardsInHand.add(new Tile(14));
		cardsInHand.add(new Tile(18)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(21));
		cardsInHand.add(new Tile(22)); // triplet
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
		theAiRecommender.uponCalled(cardsInHand, new Meld(new Tile(108),new Tile(109), new Tile(110),new Tile(111)));
		Tile card = theAiRecommender.recommend();
		assertEquals(10,card.getId());
	}

	@Test
	void test4() {
		AiRecommender theAiRecommender = new AiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(1)); // eye
		cardsInHand.add(new Tile(10));// should be played
		cardsInHand.add(new Tile(14));
		cardsInHand.add(new Tile(18)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(21));
		cardsInHand.add(new Tile(22)); // triplet
		cardsInHand.add(new Tile(70)); 
		cardsInHand.add(new Tile(71));
		cardsInHand.add(new Tile(72));
		cardsInHand.add(new Tile(117));
		cardsInHand.add(new Tile(123));
		cardsInHand.add(new Tile(128)); // should be played
		List<Tile> cardsNotPlayed = new ArrayList<>();
		cardsNotPlayed.add(new Tile(55));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(41));
		cardsNotPlayed.add(new Tile(57));
		cardsNotPlayed.add(new Tile(56));
		theAiRecommender.uponCalled(cardsInHand, new Meld(new Tile(108),new Tile(109), null,null));
		Tile card = theAiRecommender.recommend();
		assertEquals(72,card.getId());
	}
	
	@Test
	void test5() {
		AiRecommender theAiRecommender = new AiRecommender();
		List<Tile> cardsInHand = new ArrayList<>();
		// one eye, one triplet, one sequence
		cardsInHand.add(new Tile(0));
		cardsInHand.add(new Tile(1)); // eye
		cardsInHand.add(new Tile(10));
		cardsInHand.add(new Tile(14));
		cardsInHand.add(new Tile(18)); // sequence
		cardsInHand.add(new Tile(20));
		cardsInHand.add(new Tile(21));// should be played
		cardsInHand.add(new Tile(22)); // triplet
		cardsInHand.add(new Tile(36)); 
		cardsInHand.add(new Tile(48));
		cardsInHand.add(new Tile(49));
		cardsInHand.add(new Tile(117));
		cardsInHand.add(new Tile(123));
		cardsInHand.add(new Tile(128)); // should be played
		List<Tile> cardsNotPlayed = new ArrayList<>();
		cardsNotPlayed.add(new Tile(55));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(40));
		cardsNotPlayed.add(new Tile(41));
		cardsNotPlayed.add(new Tile(57));
		cardsNotPlayed.add(new Tile(56));
		ArrayList<Integer> a = new ArrayList<Integer> (Arrays.asList(21,28,36,37,38,44,61,62,68,69,72,76,84));
		theAiRecommender.uponCalled(a);
		assertEquals(123,theAiRecommender.getRemainingCards());
	}
	
}
