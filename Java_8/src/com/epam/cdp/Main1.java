package com.epam.cdp;

import java.util.Arrays;
import java.util.List;

public class Main1 {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("usa", " RUSSIA ", "gerMANY", "JaPaN!");

//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//		for(String item:list) {
//			System.out.println(item);
//		}
//		list.forEach(System.out::println);		
//		list.stream().forEach(System.out::println);
		for(String item:list) {
			String newItem = item.toLowerCase().trim();
			if(newItem.contains("p")) {
				continue;
			}
			System.out.println(newItem);
		}
		list
		.stream()
		.map(item -> item.toLowerCase().trim())
		.filter(item -> !item.contains("p"))
		.forEach(System.out::println);
	}

}
