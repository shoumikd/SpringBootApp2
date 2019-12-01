package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Nifty50Model;
import com.app.repository.Nifty50ListRepository;

@Service
public class Nifty50ListService {

	@Autowired
	private Nifty50ListRepository allCompanyListRepository;
	
	public List<Nifty50Model> findAll() {
		return allCompanyListRepository.findAll();		
	}
	
	public void addDetails(Nifty50Model allCompanyList) {
		allCompanyListRepository.save(allCompanyList);		
	}
}
