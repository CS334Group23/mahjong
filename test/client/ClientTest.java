package client;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class ClientTest {
	@Test
	public void testConstructor() {
		Client client = new Client(0, null);
		assertEquals(client.getId(), 0);
		assertEquals(client.getServer(), null);
	}
}
