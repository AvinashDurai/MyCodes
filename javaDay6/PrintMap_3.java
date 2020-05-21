package javaDay6;

import java.util.LinkedHashMap;
import java.util.Map;

public class PrintMap_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		map.forEach((eachKey,eachValue)->System.out.println((eachKey+"->"+eachValue)));

	}

}
