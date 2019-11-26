package com.david.stringaccumulator;

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
		String numbers = "";
		log.info("input:[{}]", numbers);
		int sum = add(numbers);
		log.info("total:{}", sum);
	}

	public int add(String numbers)
	{
		if(Strings.isBlank(numbers))
		{
			return 0;
		}
		
		int sum = 0;
		
		return sum;
	}
}
