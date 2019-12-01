package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.NseCompaniesModel;
import com.app.service.NseCompaniesListService;

@RestController
@RequestMapping(value="/nseIndia")
public class NseCompaniesListController {
	
	@Autowired
	private NseCompaniesListService nseCompaniesListService;
	

	@RequestMapping(value="/getAll")
	public List<NseCompaniesModel> nseListGetAll() {
			return nseCompaniesListService.findAll();
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String nseIndiaListAdd(@RequestBody NseCompaniesModel nseCompanyModel) {
		try {
			nseCompaniesListService.addDetails(nseCompanyModel);
		}catch(Exception e) {
			throw e ;
		}
		return "success";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String nseIndiaListUpdate(@RequestBody NseCompaniesModel nseCompanyModel) {
		try {
			nseCompaniesListService.updateDetails(nseCompanyModel);
		}catch(Exception e) {
			throw e ;
		}
		return "success";
	}

}
