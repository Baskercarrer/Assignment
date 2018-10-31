package com.barclays.runner;

import java.io.IOException;
import java.net.MalformedURLException;

import com.barclays.services.utilities.JSONParser;
import com.barclays.services.vat.RatesInfo;

public class APPRunner {
	
	public static String vatEndPoint = "http://jsonvat.com/";

	public static void main(String[] args) throws MalformedURLException, IOException {

		JSONParser jp = new JSONParser(vatEndPoint);
		RatesInfo ri = new RatesInfo(jp.loadJson());
		System.out.println("---------------------------Top Highest EU Standards--------------------------");
		ri.PrintEUStandards(ri.orderByAsc());// Printing the Top 3 highest Standards
		System.out.println("---------------------------Top Lowest EU Standards--------------------------");
		ri.PrintEUStandards(ri.OrderByDesc());// Printing the Top 3 lowest Standards
	}

}
