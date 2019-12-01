package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_allequity")
public class NseCompaniesModel {
	
	@Id
	@GeneratedValue
	@Column(name = "symbol")
	private String symbol;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "series")
	private String series;
	
	@Column(name = "date_of_listing")
	private String dateOfListing;
	
	@Column(name = "paid_up_value")
	private Integer paidUpValue;
	
	@Column(name = "market_lot")
	private Integer marketLot;
	
	@Column(name = "isin_number")
	private String isinCode;
	
	@Column(name = "face_value")
	private Integer faceValue;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getDateOfListing() {
		return dateOfListing;
	}

	public void setDateOfListing(String dateOfListing) {
		this.dateOfListing = dateOfListing;
	}

	public Integer getPaidUpValue() {
		return paidUpValue;
	}

	public void setPaidUpValue(Integer paidUpValue) {
		this.paidUpValue = paidUpValue;
	}

	public Integer getMarketLot() {
		return marketLot;
	}

	public void setMarketLot(Integer marketLot) {
		this.marketLot = marketLot;
	}

	public String getIsinCode() {
		return isinCode;
	}

	public void setIsinCode(String isinCode) {
		this.isinCode = isinCode;
	}

	public Integer getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(Integer faceValue) {
		this.faceValue = faceValue;
	}
	
	
	

}
