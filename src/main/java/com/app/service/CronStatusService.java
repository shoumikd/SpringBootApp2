package com.app.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.CronStatusModel;
import com.app.model.IndexListModel;
import com.app.model.IndexLiveDataPriceModel;
import com.app.nseIndia.model.LiveMarketIndexModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.repository.CronStatusRepository;
import com.app.repository.LiveMarketIndexRepository;
import com.app.repository.LiveMarketIndexValueRepository;

@Service
public class CronStatusService {
	
	@Autowired
	private CronStatusRepository cronStatusRepo;
	
	public void save(CronStatusModel cronStatusModel) {
		cronStatusRepo.save(cronStatusModel);
	}

}
