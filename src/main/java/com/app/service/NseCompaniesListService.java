package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.NseCompaniesModel;
import com.app.repository.NseCompaniesListRepository;

@Service
public class NseCompaniesListService {

	@Autowired
	private NseCompaniesListRepository nseCompaniesListRepository;
	
	public List<NseCompaniesModel> findAll() {
		return nseCompaniesListRepository.findAll();		
	}
	
	public void addDetails(NseCompaniesModel nseCompaniesModel) {
		nseCompaniesListRepository.save(nseCompaniesModel);		
	}
	
	public void updateDetails(NseCompaniesModel nseCompaniesModel) {
		nseCompaniesListRepository.update(nseCompaniesModel.getSymbol(),nseCompaniesModel.getCompanyName());	
		
	}
}
