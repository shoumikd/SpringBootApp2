package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.IndexListModel;
import com.app.nseIndia.model.LiveMarketIndexModel;

@Repository
public interface LiveMarketIndexRepository extends JpaRepository<IndexListModel, Long> {	
	
	public IndexListModel findByIndexName(String indexName);


}
