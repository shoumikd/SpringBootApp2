package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.IndexLiveDataPriceModel;

@Repository
public interface LiveMarketIndexValueRepository extends JpaRepository<IndexLiveDataPriceModel, Long> {
	
	@Query(value="select distinct(ildpm.timeVal) from IndexLiveDataPriceModel ildpm where ildpm.timeVal= ?1")
	public List<LocalDateTime> findByTimeVal(LocalDateTime updatetime);
}
