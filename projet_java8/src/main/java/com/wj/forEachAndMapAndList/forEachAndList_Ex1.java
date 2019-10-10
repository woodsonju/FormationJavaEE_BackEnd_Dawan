package com.wj.forEachAndMapAndList;

import java.util.ArrayList;
import java.util.List;

public class forEachAndList_Ex1 {
	public static void main(String[] args) {
		List<String> items = new ArrayList<String>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		System.out.println("******Foreach************");
		for(String item: items)
			System.out.println(item);
		
		
		System.out.println("***********Lamda**************");
		items.forEach(item -> {
			System.out.println(item);
		});
		
		System.out.println("******************Stream and filter*****************");
		items.stream()
			.filter(s -> s.contains("B"))
			.forEach(System.out::println);
	}
}
