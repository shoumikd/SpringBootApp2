package com.app.job;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.app.Constants.CronStatus;
import com.app.model.CronStatusModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.service.CronStatusService;
import com.app.service.LiveMarketIndexService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReadLiveData {

	private Logger logger = LoggerFactory.getLogger(ReadLiveData.class);

	@Autowired
	private LiveMarketIndexService liveMarketindexService;
	
	@Autowired
	CronStatusService cronStatusService;

	private String liveMarketURI = "https://nseindia.com/live_market/dynaContent/live_watch/stock_watch/liveIndexWatchData.json";
	
	

	/*
	 * // @Scheduled(cron="0/20 * * * * ?")//20 seconds
	 * 
	 * @Scheduled(cron = "0 0/1 * * * ?") // 1 minute
	 * // @Scheduled(cron="0 0/1 9-16 * * ?")//every 1 minute between 9AM to 16PM
	 * public void read() { logger.info("ran at:" + System.currentTimeMillis());
	 * RestTemplate rt = new RestTemplate(); LiveMarketIndexModelList
	 * liveMarketIndexModelList; try { liveMarketIndexModelList =
	 * rt.getForObject(liveMarketURI, LiveMarketIndexModelList.class);
	 * liveMarketindexService.addDetails(liveMarketIndexModelList); } catch
	 * (RestClientException e) { // TODO Auto-generated catch block
	 * liveMarketIndexModelList = new LiveMarketIndexModelList();
	 * LiveMarketIndexModel liveMarketIndexModel = new LiveMarketIndexModel();
	 * liveMarketIndexModel.setIndexOrder(1.0);
	 * liveMarketIndexModel.setIndexName("NIFTY");
	 * liveMarketIndexModel.setHigh("5.00"); List<LiveMarketIndexModel> abc = new
	 * ArrayList<LiveMarketIndexModel>(); abc.add(liveMarketIndexModel);
	 * liveMarketIndexModelList.setData(abc); e.printStackTrace(); }
	 * 
	 * logger.info("Response:" + liveMarketIndexModelList); }
	 */

	@Scheduled(cron = "0 0 16 * * ?")
	public void readIndex() {		
		
		//cron start
		CronStatusModel cronStatusModel=new CronStatusModel();
		cronStatusModel.setStartTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setCronName(ReadLiveData.class.getEnclosingMethod().getName());
		cronStatusModel.setStatus(CronStatus.INPROGRESS.toString());
		cronStatusService.save(cronStatusModel);

		//retrieve Index List
		RestTemplate rt = new RestTemplate();
		LiveMarketIndexModelList liveMarketIndexModelList;
		try {
			liveMarketIndexModelList = rt.getForObject(liveMarketURI, LiveMarketIndexModelList.class);
			liveMarketindexService.populateIndexList(liveMarketIndexModelList);
		} catch (RestClientException e) {
			//cron Failure end
			cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
			cronStatusModel.setStatus(CronStatus.FAILURE.toString());
			cronStatusModel.setMessage(e.getMessage());
			cronStatusService.save(cronStatusModel);
			e.printStackTrace();
		}
		
		//cron end
		cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setStatus(CronStatus.SUCCESS.toString());
		cronStatusService.save(cronStatusModel);
	}

	// @Scheduled(cron="0/20 * * * * ?")//20 seconds
	@Scheduled(cron = "0 0/1 * * * ?") // 1 minute
	// @Scheduled(cron="0 0/1 9-16 * * ?")//every 1 minute between 9AM to 16PM
	public void readIndexValue() {
		//cron start
		CronStatus cronStatus=CronStatus.INPROGRESS;
		CronStatusModel cronStatusModel=new CronStatusModel();
		cronStatusModel.setStartTime(new Date(System.currentTimeMillis()));
		//cronStatusModel.setCronName(ReadLiveData.class.getEnclosingMethod().getName());
		cronStatusModel.setStatus(cronStatus.toString());
		cronStatusService.save(cronStatusModel);
		
		//retrieve Index Price List
		
		RestTemplate rt = new RestTemplate();
		LiveMarketIndexModelList liveMarketIndexModelList;
		try {
			liveMarketIndexModelList = rt.getForObject(liveMarketURI, LiveMarketIndexModelList.class);
			cronStatus=liveMarketindexService.addIndexValue(liveMarketIndexModelList);
		} catch (RestClientException e) {
			//cron Failure end
			cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
			cronStatusModel.setStatus(CronStatus.FAILURE.toString());
			cronStatusModel.setMessage(e.getMessage());
			cronStatusService.save(cronStatusModel);
			e.printStackTrace();
		}
		
		//cron end
		cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setStatus(cronStatus.toString());
		cronStatusService.save(cronStatusModel);
	}

}

