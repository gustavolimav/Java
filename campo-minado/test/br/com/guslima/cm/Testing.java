package br.com.guslima.cm;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testing {

	@Test
	void testIfIsEqualToTwo() {
		int a = 1 + 1;
		
		assertEquals(2, a);
	}
	
	@Test
	void testIfEqualsToTree() {
		int x = 10 - 7;
		
		assertEquals(x, 3);
	}

}
