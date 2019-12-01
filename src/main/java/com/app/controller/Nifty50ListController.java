package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Nifty50Model;
import com.app.service.Nifty50ListService;

@RestController
@RequestMapping(value="/nifty50")
public class Nifty50ListController {
	
	@Autowired
	private Nifty50ListService allCompanyListService;
	
	@RequestMapping("/a")
	public String downloadExcel() {
		return "hi";
	}
	
	@RequestMapping(value="/getAll")
	public List<Nifty50Model> nifty50getAll() {
			return allCompanyListService.findAll();
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String nifty50ListUpdate(@RequestBody Nifty50Model allCompanyList) {
		try {
			allCompanyListService.addDetails(allCompanyList);
		}catch(Exception e) {
			throw e ;
		}
		return "success";
	}

}
