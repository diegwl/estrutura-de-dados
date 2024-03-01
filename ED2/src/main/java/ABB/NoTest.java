package ABB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NoTest {

	@Test
	void testEhFolha() {
		
		No no1 = new No(10);
		assertTrue(no1.ehFolha());
		
		No no2 = new No(30);
		No no3 = new No(40,no1,no2);
		assertFalse(no3.ehFolha());
	}

}
