package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "list_nse_index")
public class IndexListModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="index_id")
	private int indexId;
	
	@Column(name="index_name", unique = true, nullable = false)
	private String indexName;
	
	/*
	 * @OneToMany private IndexLiveDataPriceModel indexLiveDataPriceModel;
	 */

	public int getIndexId() {
		return indexId;
	}

	public void setIndexId(int indexId) {
		this.indexId = indexId;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	/*
	 * public IndexLiveDataPriceModel getIndexLiveDataPriceModel() { return
	 * indexLiveDataPriceModel; }
	 * 
	 * public void setIndexLiveDataPriceModel(IndexLiveDataPriceModel
	 * indexLiveDataPriceModel) { this.indexLiveDataPriceModel =
	 * indexLiveDataPriceModel; }
	 */
	
	
	
	
	
}
