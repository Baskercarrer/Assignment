package com.assignment.services.vat;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import javax.json.JsonStructure;
import javax.json.JsonValue;


public class RatesInfo {

	private JsonStructure jsonStructure;


	public RatesInfo(JsonStructure jsonInput) {
		this.jsonStructure = jsonInput ;
	}
	
	public JsonStructure getJsonInput() {
		return jsonStructure;
	}

	public JsonValue getRates() {
		return getJsonInput().getValue("/rates");
	}

	// Getting all Country names and corresponding standards
	public Map<String,Double> getFieldValues(String fieldName,String Jsonpointer) {
		Map<String,Double> countryName = new LinkedHashMap<String,Double>();
		getRates().asJsonArray().forEach(value -> {
			if (value.asJsonObject().get(fieldName) == null) {
				throw new NullPointerException("The given \"" +fieldName + "\" is not available in input");
			}else {
				countryName.put(value.asJsonObject().getString(fieldName),Double.valueOf(value.asJsonObject().getValue(Jsonpointer).toString()));
			}
		});
		return countryName;
	}



	// Getting all lastest EU Country Standards
	public Stream<Entry<String, Double>> euCountryStandards() {
		return getFieldValues("name", "/periods/0/rates/standard").entrySet().stream();
	}


	// sort by lowest values
	public Stream<Entry<String, Double>> orderByAsc() {
		return euCountryStandards().sorted(Map.Entry.comparingByValue());
	}


	// sort by highest values
	public Stream<Entry<String, Double>> OrderByDesc() {
		return euCountryStandards().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
	}



// Printing the lowest Standards in EU
	public void PrintEUStandards(Stream<Entry<String, Double>> para) {
		Iterator<Entry<String, Double>> iter = para.iterator();
		int counter = 0;
		while(iter.hasNext() && counter<3) {
			Entry<String, Double> Country = iter.next();
			System.out.println(" Country ==> " + Country.getKey() + "---Standard => "+ Country.getValue());
			counter++;
		}
	}

}


