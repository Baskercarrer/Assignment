package com.barclays.services.utilities;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
	Map<String,Double> map;
	
	
	public ValueComparator(Map<String,Double> map) {
	this.map = map;
	}
	
	@Override
	public int compare(String o1, String o2) {
		return map.get(o1)>=map.get(o2) ?1:-1;
	}
	
	
	

}
