package com.assignment.services.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonStructure;



public class JSONParser {

	private String URI;
	
	public JSONParser(String URI) {
		this.URI = URI;
	}
	
	public String getURI() {
		return URI;
	}
	
	public JsonStructure loadJson() throws MalformedURLException, IOException {
		return Json.createReader(new URL(URI).openStream()).read();
		
	}
	
	
	public static InputStream getResponse(String URI) throws MalformedURLException, IOException {
		return new URL(URI).openStream();
	}
	
	
	
	
}
