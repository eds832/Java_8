package com.epam.cdp;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main2 {

	public static void main(String[] args) {
		Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream().filter(i -> i > 4).map(i -> 1);
		System.out.println(stream.count());

	}

}
