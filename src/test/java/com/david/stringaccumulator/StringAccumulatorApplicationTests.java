package com.david.stringaccumulator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringAccumulatorApplicationTests {

	StringAccumulatorApplication app = new StringAccumulatorApplication();
	
	@Test
	void testEmptyString() {
		String numbers = "";
		int sum = app.add(numbers);
		assertEquals(0, sum);
	}

}
