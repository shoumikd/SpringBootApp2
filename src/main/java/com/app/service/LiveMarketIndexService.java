package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Constants.CronStatus;
import com.app.model.IndexListModel;
import com.app.model.IndexLiveDataPriceModel;
import com.app.nseIndia.model.LiveMarketIndexModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.repository.LiveMarketIndexRepository;
import com.app.repository.LiveMarketIndexValueRepository;

@Service
public class LiveMarketIndexService {
	
	@Autowired
	private LiveMarketIndexRepository liveMarketIndexRepository;
	
	@Autowired
	LiveMarketIndexValueRepository liveMarketIndexValueRepository;
	
	private static final Map<String, Long> indexMap = new HashMap<>();
	
	/*
	 * public void addDetails(LiveMarketIndexModelList liveMarketIndexModelList) {
	 * for (LiveMarketIndexModel indexModel : liveMarketIndexModelList.getData()) {
	 * IndexLiveDataPriceModel indexLiveDataPriceModel = new
	 * IndexLiveDataPriceModel();
	 * indexLiveDataPriceModel.setIndexName(indexModel.getIndexName());
	 * indexLiveDataPriceModel.setHigh(indexModel.getHigh());
	 * indexLiveDataPriceModel.setLast(indexModel.getLast());
	 * indexLiveDataPriceModel.setLow(indexModel.getLow());
	 * indexLiveDataPriceModel.setOpen(indexModel.getOpen());
	 * indexLiveDataPriceModel.setPercChange(indexModel.getPercChange());
	 * indexLiveDataPriceModel.setPreviousClose(indexModel.getPreviousClose());
	 * indexLiveDataPriceModel.setYearHigh(indexModel.getYearHigh());
	 * indexLiveDataPriceModel.setYearLow(indexModel.getYearLow()); try {
	 * liveMarketIndexRepository.save(indexLiveDataPriceModel); } catch (Exception
	 * e) { e.printStackTrace(); } }
	 * 
	 * }
	 */
	
	public void populateIndexList(LiveMarketIndexModelList liveMarketIndexModelList) {		
		for (LiveMarketIndexModel indexModel : liveMarketIndexModelList.getData()) {
			IndexListModel indexListModel=new IndexListModel();
			indexListModel.setIndexId(indexModel.getIndexOrder().longValue());
			indexListModel.setIndexName(indexModel.getIndexName());
			try {
				liveMarketIndexRepository.save(indexListModel);
				indexMap.put(indexListModel.getIndexName(), indexListModel.getIndexId());	
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
	
	public CronStatus addIndexValue(LiveMarketIndexModelList liveMarketIndexModelList) {
		if (liveMarketIndexValueRepository.findByTimeVal(liveMarketIndexModelList.getData().get(0).getTimeVal())
				.size() == 0) {
			for (LiveMarketIndexModel indexModel : liveMarketIndexModelList.getData()) {
				IndexLiveDataPriceModel indexLiveDataPriceModel = new IndexLiveDataPriceModel();
				indexLiveDataPriceModel.setHigh(indexModel.getHigh());
				indexLiveDataPriceModel.setLast(indexModel.getLast());
				indexLiveDataPriceModel.setLow(indexModel.getLow());
				indexLiveDataPriceModel.setOpen(indexModel.getOpen());
				indexLiveDataPriceModel.setPercChange(indexModel.getPercChange());
				indexLiveDataPriceModel.setPreviousClose(indexModel.getPreviousClose());
				indexLiveDataPriceModel.setTimeVal(indexModel.getTimeVal());
				indexLiveDataPriceModel.setYearHigh(indexModel.getYearHigh());
				indexLiveDataPriceModel.setYearLow(indexModel.getYearLow());
				if (indexMap.size() == 0) {
					populateIndexMapFromExistingData();
				}
				indexLiveDataPriceModel.setNseIndexId(indexMap.get(indexModel.getIndexName()));
				try {
					liveMarketIndexValueRepository.save(indexLiveDataPriceModel);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}else {
			return CronStatus.REPEATITIVE_DATA;
		}
		return CronStatus.SUCCESS;
	}

	private void populateIndexMapFromExistingData() {
		List<IndexListModel> indexList=liveMarketIndexRepository.findAll();
		for (IndexListModel indexListModel : indexList) {
			indexMap.put(indexListModel.getIndexName(), indexListModel.getIndexId());	
		}
	}
	

}
