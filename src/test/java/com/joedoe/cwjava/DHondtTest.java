package com.joedoe.cwjava;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

public class DHondtTest {

  @Test
	void test6Parties() {
		int numSeats = 8;
		int[] votes = new int[] {168_000,104_000,72_000,64_000,40_000,32_000};
		int[] result = new int[] {4,2,1,1,0,0};
		int [] seats = DHondt.distributeSeats(numSeats, votes);
		assertArrayEquals(result, seats);
	}
	
	@Test
	void testWikipediaExample() {
		int numSeats = 8;
		int[] votes = new int[] {100_000,80_000,30_000,20_000};
		int[] result = new int[] {4,3,1,0};
		int [] seats = DHondt.distributeSeats(numSeats, votes);
		assertArrayEquals(result, seats);
	}
	
	@Test
	void test5Parties() {
		int numSeats = 7;
		int[] votes = new int[] {15_000,60_000,340_000,280_000,160_000};
		int[] result = new int[] {0,0,3,3,1};
		int [] seats = DHondt.distributeSeats(numSeats, votes);
		assertArrayEquals(result, seats);
	}

	@Test
	void testLittleVotes() {
		int numSeats = 4;
		int[] votes = new int[] {1, 2, 3};
		int[] result = new int[] {1,1,2};
		int [] seats = DHondt.distributeSeats(numSeats, votes);
		assertArrayEquals(result, seats);
	}

}