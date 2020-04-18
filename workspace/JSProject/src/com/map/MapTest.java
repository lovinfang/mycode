package com.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "a");
		map.put("b", "b");
		map.put("c", "c");
		map.put("d", "d");
		
		String test = map.get("b");
		System.out.println(test);
		
	}
}
