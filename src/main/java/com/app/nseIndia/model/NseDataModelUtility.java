package com.app.nseIndia.model;

public class NseDataModelUtility {
	
	static Double removeCommaFromPrice(String inputPrice) {
		return Double.valueOf(inputPrice.replaceAll(",", ""));
	}
	
	static String removeCommaFromDate(String inputDate) {
		return (inputDate.replaceAll(",", ""));
	}

}
