package com.app.nseIndia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class NseDataModelUtility {
	
	static Double removeCommaFromPrice(String inputPrice) {
		return Double.valueOf(inputPrice.replaceAll(",", ""));
	}
	
	static LocalDateTime formatRequestDate(String inputDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss", Locale.ENGLISH);
		LocalDateTime dateTime = LocalDateTime.parse(inputDate, formatter);
		return dateTime;
	}

}
