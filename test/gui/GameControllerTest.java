package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class GameControllerTest {
	@Test
	public void testGameController1() {
		GameController gameController = GameController.getInstance();
		while(true) {
			gameController.setVisible(true);
		}
	}
}
