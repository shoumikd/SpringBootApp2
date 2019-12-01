package com.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.NseCompaniesModel;

@Repository
public interface NseCompaniesListRepository extends JpaRepository<NseCompaniesModel, String> {
	
	@Transactional
	@Modifying
	@Query(value = "update list_allequity set company_name=?2 where symbol=?1", nativeQuery = true)
	public void update(String symbol, String compName);
	
	@Transactional
	@Modifying
	@Query(value = "update list_allequity set NseCompaniesModel=?2 where symbol=?1", nativeQuery = true)
	public void update2(String symbol, NseCompaniesModel nseCompaniesModel);
}
