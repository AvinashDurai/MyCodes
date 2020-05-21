package javaDay6;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		map.put("D", 4);
		map.put("E", 5);
		
		map.entrySet().forEach((eachEntry)->{
			if(eachEntry.getKey().equals("A")||eachEntry.getKey().equals("C")) {
				eachEntry.setValue(10);
			}
		});
		System.out.println(map);
	}

}
