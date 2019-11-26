package com.david.stringaccumulator;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class StringAccumulatorApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StringAccumulatorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Good Luck Have Fun~");
	}

	public int add(String numbers)
	{
		if(Strings.isBlank(numbers))
		{
			return 0;
		}
		
		String delimiters = ",|\\n";
		if(numbers.startsWith("//"))
		{
			int lineBreak = numbers.indexOf("\n");
			delimiters = numbers.substring(2, lineBreak);
			numbers = numbers.substring(lineBreak + 1);
			//escape delimiters
			delimiters = Stream.of(delimiters.split("\\|")).map(s -> Pattern.quote(s)).collect(Collectors.joining("|"));
		}
		
		String[] arr = numbers.split(delimiters);
		IntStream ints = Arrays.stream(arr).mapToInt(Integer::parseInt);
//		if(ints.allMatch(i -> i < 0))
//		{
//			throw new IllegalArgumentException("");
//		}
		return ints.sum();
	}
}
