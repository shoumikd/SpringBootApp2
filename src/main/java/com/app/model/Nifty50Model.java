package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "list_nifty50")
public class Nifty50Model {

	@Id
	@GeneratedValue
	@Column(name = "symbol")
	private String symbol;
	
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "industry")
	private String industry;

	@Column(name = "series")
	private String series;
	
	@Column(name = "isin_code",nullable = false,columnDefinition = "varchar(45) default '15-JUL-1980'")
	private String isinCode;
	
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getIsinCode() {
		return isinCode;
	}

	public void setIsinCode(String isinCode) {
		this.isinCode = isinCode;
	}
	
	

}
