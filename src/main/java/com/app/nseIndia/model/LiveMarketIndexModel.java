package com.app.nseIndia.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LiveMarketIndexModel {
	
	private String indexName;
	private String percChange;
	private Double previousClose;
	private Double open;
	private Double high;
	private Double low;
	private Double last;	
	private Double yearHigh;
	private Double yearLow;
	private Double indexOrder;
	private LocalDateTime timeVal;
	
	public LocalDateTime getTimeVal() {
		return timeVal;
	}
	public void setTimeVal(String timeVal) {
		this.timeVal = NseDataModelUtility.formatRequestDate(timeVal);// NseDataModelUtility.removeCommaFromDate(timeVal);
	}
	public String getIndexName() {
		return indexName;
	}
	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
	public String getPercChange() {
		return percChange;
	}
	public void setPercChange(String percChange) {
		this.percChange =percChange;
	}
	public Double getPreviousClose() {
		return previousClose;
	}
	public void setPreviousClose(String previousClose) {
		this.previousClose =  NseDataModelUtility.removeCommaFromPrice(previousClose);
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = NseDataModelUtility.removeCommaFromPrice(open);
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = NseDataModelUtility.removeCommaFromPrice(high);
	}
	public Double getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = NseDataModelUtility.removeCommaFromPrice(low);
	}
	public Double getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = NseDataModelUtility.removeCommaFromPrice(last);
	}
	public Double getYearHigh() {
		return yearHigh;
	}
	public void setYearHigh(String yearHigh) {
		this.yearHigh = NseDataModelUtility.removeCommaFromPrice(yearHigh);
	}
	public Double getYearLow() {
		return yearLow;
	}
	public void setYearLow(String yearLow) {
		this.yearLow = NseDataModelUtility.removeCommaFromPrice(yearLow);
	}
	public Double getIndexOrder() {
		return indexOrder;
	}
	public void setIndexOrder(Double indexOrder) {
		this.indexOrder = indexOrder;
	}
	
}
