package com.app.job;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.app.nseIndia.model.LiveMarketIndexModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.service.LiveMarketindexService;
import com.app.service.Nifty50ListService;

@Component
public class ReadLiveData {

	private Logger logger = LoggerFactory.getLogger(ReadLiveData.class);

	@Autowired
	private LiveMarketindexService liveMarketindexService;

	private String liveMarketURI = "https://nseindia.com/live_market/dynaContent/live_watch/stock_watch/liveIndexWatchData.json";

	// @Scheduled(cron="0/20 * * * * ?")//20 seconds
	@Scheduled(cron = "0 0/1 * * * ?") // 1 minute
	// @Scheduled(cron="0 0/1 9-16 * * ?")//every 1 minute between 9AM to 16PM
	public void read() {
		logger.info("ran at:" + System.currentTimeMillis());
		RestTemplate rt = new RestTemplate();

		LiveMarketIndexModelList liveMarketIndexModelList;
		try {
			liveMarketIndexModelList = rt.getForObject(liveMarketURI,
					LiveMarketIndexModelList.class);
			liveMarketindexService.addDetails(liveMarketIndexModelList);
		} catch (RestClientException e) {
			// TODO Auto-generated catch block
			liveMarketIndexModelList=new LiveMarketIndexModelList();
			LiveMarketIndexModel liveMarketIndexModel=new LiveMarketIndexModel();
			liveMarketIndexModel.setIndexOrder(1.0);
			liveMarketIndexModel.setIndexName("NIFTY");
			liveMarketIndexModel.setHigh("5.00");
			List<LiveMarketIndexModel> abc=new ArrayList<LiveMarketIndexModel>();
					abc.add(liveMarketIndexModel);
			liveMarketIndexModelList.setData(abc);
			e.printStackTrace();
		}
		
		logger.info("Response:" + liveMarketIndexModelList);
	}

}

