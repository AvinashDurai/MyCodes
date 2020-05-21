package javaDay6;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class PrintMap_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		iterator.forEachRemaining((eachEntry)->System.out.println(eachEntry.getKey()+"->"+eachEntry.getValue()));

	}

}
