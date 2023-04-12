package ai;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import ui.aiUi.AiRecommenderUtil;
import utils.Tile;

class TestAiRecommenderUtil {

	@Test
	void testFindClosest1() {
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(0));
		eye.add(new Tile(1));
		eyes.add(eye);
		List<List<Tile>> triplets= new ArrayList<>();
		List<Tile> tr = new ArrayList<>();
		tr.add(new Tile(4));
		tr.add(new Tile(5));
		tr.add(new Tile(6));
		triplets.add(tr);
		List<List<Tile>> sequences= new ArrayList<>();
		List<Tile> se = new ArrayList<>();
		se.add(new Tile(8));
		se.add(new Tile(12));
		se.add(new Tile(16));
		sequences.add(se);
		AiRecommenderUtil ai = new AiRecommenderUtil();
		int result = ai.findClosest(eyes, triplets, sequences).get(0).size();
		assertEquals(2,result);
	}
	
	@Test
	void testFindClosest2() {
		// one eye, one triplet, one sequence
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		List<Tile> eye1 = new ArrayList<>();
		eye1.add(new Tile(24));
		eye1.add(new Tile(25));
		List<Tile> eye2 = new ArrayList<>();
		eye2.add(new Tile(30));
		eye2.add(new Tile(31));
		eyes.add(eye);
		eyes.add(eye2);
		eyes.add(eye1);
		List<List<Tile>> triplets= new ArrayList<>();
		List<Tile> tr = new ArrayList<>();
		tr.add(new Tile(5));
		tr.add(new Tile(6));
		tr.add(new Tile(7));
		triplets.add(tr);
		List<List<Tile>> sequences= new ArrayList<>();
		AiRecommenderUtil ai = new AiRecommenderUtil();
		ai.findClosest(eyes, triplets, sequences);
		int result = ai.findClosest(eyes, triplets, sequences).get(0).size();
		assertEquals(3,result);
	}
	
	@Test
	void testFindClosest3() {
		List<List<Tile>> eyes= new ArrayList<>();
		List<List<Tile>> triplets= new ArrayList<>();
		List<List<Tile>> sequences= new ArrayList<>();
		AiRecommenderUtil ai = new AiRecommenderUtil();
		int result = ai.findClosest(eyes, triplets, sequences).size();
		assertEquals(0,result);
	}
	
	@Test
	void testDuplicated() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		// one eye, one triplet, one sequence
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		List<Tile> eye1 = new ArrayList<>();
		eye1.add(new Tile(24));
		eye1.add(new Tile(25));
		List<Tile> eye2 = new ArrayList<>();
		eye2.add(new Tile(30));
		eye2.add(new Tile(31));
		eyes.add(eye);
		eyes.add(eye2);
		eyes.add(eye1);
		List<List<Tile>> triplets= new ArrayList<>();
		List<Tile> tr = new ArrayList<>();
		tr.add(new Tile(5));
		tr.add(new Tile(6));
		tr.add(new Tile(7));
		triplets.add(tr);
		List<List<Tile>> sequences= new ArrayList<>();
		List<List<Tile>> allTiles = new ArrayList<>();
		allTiles.addAll(eyes);
		allTiles.addAll(triplets);
		allTiles.addAll(sequences);
		boolean result = ai.duplicated(allTiles, 6);
		assertEquals(true,result);
	}
	
	@Test
	void testDuplicated2() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		// one eye, one triplet, one sequence
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		List<Tile> eye1 = new ArrayList<>();
		eye1.add(new Tile(24));
		eye1.add(new Tile(25));
		List<Tile> eye2 = new ArrayList<>();
		eye2.add(new Tile(30));
		eye2.add(new Tile(31));
		eyes.add(eye);
		eyes.add(eye2);
		eyes.add(eye1);
		List<List<Tile>> triplets= new ArrayList<>();
		List<Tile> tr = new ArrayList<>();
		tr.add(new Tile(5));
		tr.add(new Tile(6));
		tr.add(new Tile(7));
		triplets.add(tr);
		List<List<Tile>> sequences= new ArrayList<>();
		List<List<Tile>> allTiles = new ArrayList<>();
		allTiles.addAll(eyes);
		allTiles.addAll(triplets);
		allTiles.addAll(sequences);
		boolean result = ai.duplicated(allTiles, 0);
		assertEquals(false,result);
	}
	
	@Test
	void testSortTiles() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		// one eye, one triplet, one sequence
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		List<Tile> eye1 = new ArrayList<>();
		eye1.add(new Tile(24));
		eye1.add(new Tile(25));
		List<Tile> eye2 = new ArrayList<>();
		eye2.add(new Tile(30));
		eye2.add(new Tile(31));
		eyes.add(eye);
		eyes.add(eye2);
		eyes.add(eye1);
		List<List<Tile>> triplets= new ArrayList<>();
		List<Tile> tr = new ArrayList<>();
		tr.add(new Tile(5));
		tr.add(new Tile(6));
		tr.add(new Tile(7));
		triplets.add(tr);
		List<List<Tile>> sequences= new ArrayList<>();
		List<List<Tile>> allTiles = new ArrayList<>();
		allTiles.addAll(eyes);
		allTiles.addAll(triplets);
		allTiles.addAll(sequences);
		ai.sortTiles(allTiles);
	}
	
	@Test
	void testCompatible1() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		// one eye, one triplet, one sequence
		List<List<Tile>> eyes= new ArrayList<>();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		eyes.add(eye);
		List<List<Tile>> sequences= new ArrayList<>();
		List<Tile> se = new ArrayList<>();
		se.add(new Tile(6));
		se.add(new Tile(10));
		se.add(new Tile(14));
		sequences.add(se);
		boolean result = ai.isCompatible(eye, se);
		assertEquals(false,result);
	}
	
	@Test
	void testCompatible2() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		List<Tile> se = new ArrayList<>();
		se.add(new Tile(10));
		se.add(new Tile(14));
		se.add(new Tile(18));
		boolean result = ai.isCompatible(eye, se);
		assertEquals(true,result);
	}
	
	@Test
	void testContainsId1() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		boolean result = ai.containsId(eye, 0);
		assertEquals(false,result);
	}
	
	@Test
	void testContainsId2() {
		AiRecommenderUtil ai = new AiRecommenderUtil();
		List<Tile> eye = new ArrayList<>();
		eye.add(new Tile(6));
		eye.add(new Tile(7));
		boolean result = ai.containsId(eye, 6);
		assertEquals(true,result);
	}
	

}
