package com.app.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.IndexListModel;
import com.app.model.IndexLiveDataPriceModel;
import com.app.nseIndia.model.LiveMarketIndexModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.repository.LiveMarketIndexRepository;

@Service
public class LiveMarketindexService {
	
	@Autowired
	private LiveMarketIndexRepository liveMarketIndexRepository;
	
	public void addDetails(LiveMarketIndexModelList liveMarketIndexModelList) {		
		for (LiveMarketIndexModel indexModel : liveMarketIndexModelList.getData()) {
			IndexLiveDataPriceModel indexLiveDataPriceModel = new IndexLiveDataPriceModel();
			indexLiveDataPriceModel.setIndexName(indexModel.getIndexName());
			indexLiveDataPriceModel.setHigh(indexModel.getHigh());
			indexLiveDataPriceModel.setLast(indexModel.getLast());
			indexLiveDataPriceModel.setLow(indexModel.getLow());
			indexLiveDataPriceModel.setOpen(indexModel.getOpen());
			indexLiveDataPriceModel.setPercChange(indexModel.getPercChange());
			indexLiveDataPriceModel.setPreviousClose(indexModel.getPreviousClose());
			indexLiveDataPriceModel.setYearHigh(indexModel.getYearHigh());
			indexLiveDataPriceModel.setYearLow(indexModel.getYearLow());
			try {
				liveMarketIndexRepository.save(indexLiveDataPriceModel);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
		
	}

}
