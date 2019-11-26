package com.david.stringaccumulator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

	@Test
	void testSimpleStrings() {
		String numbers = "1";
		int sum = app.add(numbers);
		assertEquals(1, sum);
		numbers = "1,2";
		sum = app.add(numbers);
		assertEquals(3, sum);
		numbers = "1,2,3";
		sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testNewlineNComma() {
		String numbers = "1\n2,3";
		int sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testCustomDelimiter() {
		String numbers = "//;\n1;2";
		int sum = app.add(numbers);
		assertEquals(3, sum);
		numbers = "//***\n1***2***3";
		sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testMultiLengthDelimiter() {
		String numbers = "//***\n1***2***3";
		int sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testSpecialCharacterDelimiter() {
		String numbers = "//<([{\\^-=$!]})?*+.>\n1<([{\\^-=$!]})?*+.>2<([{\\^-=$!]})?*+.>3";
		int sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testMultipleDelimiter() {
		String numbers = "//*$|%%#\n1*$2%%#3";
		int sum = app.add(numbers);
		assertEquals(6, sum);
	}
	
	@Test
	void testNegative() {
		String numbers = "2,-1\n5,-3";
		assertThrows(IllegalArgumentException.class, ()->{app.add(numbers);});
	}
	
	@Test
	void testFilter1000Plus() {
		String numbers = "2,1001,3,1000";
		int sum = app.add(numbers);
		assertEquals(1005, sum);
	}
}
