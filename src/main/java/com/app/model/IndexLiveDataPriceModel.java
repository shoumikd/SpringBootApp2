package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity

@Table(name="present_index_price")
public class IndexLiveDataPriceModel extends IndexListModel {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO)
	 * 
	 * @Column(name = "price_id") private int priceId;
	 */
	@Column(name = "perc_change")
	private String percChange;

	@Column(name = "previous_close")
	private Double previousClose;

	@Column(name = "price_high")
	private Double high;

	@Column(name = "price_low")
	private Double low;

	@Column(name = "price_open")
	private Double open;

	@Column(name = "price_last")
	private Double last;

	@Column(name = "price_year_high")
	private Double yearHigh;

	@Column(name = "price_year_low")
	private Double yearLow;

	@Column(name = "update_Time")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeVal;

	/*
	 * public int getPriceId() { return priceId; }
	 * 
	 * public void setPriceId(int priceId) { this.priceId = priceId; }
	 */

	public String getPercChange() {
		return percChange;
	}

	public void setPercChange(String percChange) {
		this.percChange = percChange;
	}

	public Double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(Double previousClose) {
		this.previousClose = previousClose;
	}

	public Double getHigh() {
		return high;
	}

	public void setHigh(Double high) {
		this.high = high;
	}

	public Double getLow() {
		return low;
	}

	public void setLow(Double low) {
		this.low = low;
	}

	public Double getOpen() {
		return open;
	}

	public void setOpen(Double open) {
		this.open = open;
	}

	public Double getLast() {
		return last;
	}

	public void setLast(Double last) {
		this.last = last;
	}

	public Double getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(Double yearHigh) {
		this.yearHigh = yearHigh;
	}

	public Double getYearLow() {
		return yearLow;
	}

	public void setYearLow(Double yearLow) {
		this.yearLow = yearLow;
	}

	public Date getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(Date timeVal) {
		this.timeVal = timeVal;
	}

}
