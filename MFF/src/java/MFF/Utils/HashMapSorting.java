package MFF.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class HashMapSorting {
	
	static public HashMap<Integer, Float> sortHashMap(HashMap<Integer, Float> input){
		Map<Integer, Float> tempMap = new HashMap<Integer, Float>();
		for (Integer wsState : input.keySet()){
			tempMap.put(wsState,input.get(wsState));
		}
		List<Integer> mapKeys = new ArrayList<Integer>(tempMap.keySet());
		List<Float> mapValues = new ArrayList<Float>(tempMap.values());
		HashMap<Integer, Float> sortedMap = new LinkedHashMap<Integer, Float>();
		TreeSet<Float> sortedSet = new TreeSet<Float>(mapValues);
		Object[] sortedArray = sortedSet.toArray();
		int size = sortedArray.length;
		for (int i=size-1; i>=0; --i){
			sortedMap.put(mapKeys.get(mapValues.indexOf(sortedArray[i])), (Float)sortedArray[i]);
		}
		return sortedMap;
	}
	
}
