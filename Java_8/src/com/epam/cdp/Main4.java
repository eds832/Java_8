package com.epam.cdp;

import java.util.Arrays;

public class Main4 {
	public static void main(String[] args) {
		Arrays.asList(2, 1, 4.423, -2, 8e2).stream().map(n -> Double.valueOf(String.valueOf(n))).sorted()
		.forEach(System.out::println);
	}
}
