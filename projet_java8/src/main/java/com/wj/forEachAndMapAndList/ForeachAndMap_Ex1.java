package com.wj.forEachAndMapAndList;

import java.util.HashMap;
import java.util.Map;

public class ForeachAndMap_Ex1 {

	public static void main(String[] args) {
		
		Map<String, Integer> items = new HashMap<String, Integer>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("E", 40);
		items.put("F", 50);
		
		for(Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("*********************Lambda Expression**********************");
		items.forEach((k,v) -> {
			System.out.println(k + " : " + v);
		});
		
		
		
	}

}
