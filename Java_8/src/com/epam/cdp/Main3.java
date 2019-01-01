package com.epam.cdp;

import java.util.stream.IntStream;

public class Main3 {

	public static void main(String[] args) {
		IntStream.iterate(0, i -> i + 2).skip(5).limit(10).forEach(i -> {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}); 
	}
}
