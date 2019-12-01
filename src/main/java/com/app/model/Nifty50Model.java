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
	@Column(name = "id")
	private int id;
	
	@Column(name = "company_name",nullable = false, columnDefinition = "text default '15-JUL-1980'")
	private String companyName;

	@Column(name = "industry",nullable = false, columnDefinition = "varchar(45) default '15-JUL-1980'")
	private String industry;

	@Column(name = "symbol",nullable = false, columnDefinition = "varchar(45) default '15-JUL-1980'")
	private String symbol;

	@Column(name = "series",nullable = false, columnDefinition = "varchar(45) default '15-JUL-1980'")
	private String series;
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 */
	@Column(name = "isin_code",nullable = false,columnDefinition = "varchar(45) default '15-JUL-1980'")
	private String isinCode;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
