package com.app.job;

import java.time.Duration;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.app.Constants.CronStatus;
import com.app.model.CronStatusModel;
import com.app.nseIndia.model.LiveMarketIndexModelList;
import com.app.service.CronStatusService;
import com.app.service.LiveMarketIndexService;

@Component
@EnableAsync
public class ReadLiveData {

	private Logger logger = LoggerFactory.getLogger(ReadLiveData.class);

	@Autowired
	private LiveMarketIndexService liveMarketindexService;
	
	@Autowired
	CronStatusService cronStatusService;

	private String liveMarketURI = "https://nseindia.com/live_market/dynaContent/live_watch/stock_watch/liveIndexWatchData.json";
	
	@Scheduled(cron = "0 0 16 * * ?")
	public void readIndex() {				
		//cron start
		CronStatus cronStatus=CronStatus.INPROGRESS;
		CronStatusModel cronStatusModel=new CronStatusModel();
		cronStatusModel.setStartTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setCronName(ReadLiveData.class.getEnclosingMethod().getName());
		cronStatusModel.setStatus(cronStatus.toString());
		cronStatusService.save(cronStatusModel);

		//retrieve Index List
		RestTemplate rt = new RestTemplate();
		LiveMarketIndexModelList liveMarketIndexModelList;
		try {
			liveMarketIndexModelList = rt.getForObject(liveMarketURI, LiveMarketIndexModelList.class);
			liveMarketindexService.populateIndexList(liveMarketIndexModelList);
			cronStatus=CronStatus.SUCCESS;
		} catch (RestClientException e) {
			//cron Failure end
			cronStatus=CronStatus.FAILURE;
			cronStatusModel.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		//cron end
		cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setStatus(CronStatus.SUCCESS.toString());
		cronStatusService.save(cronStatusModel);
	}

	@Async
	//@Scheduled(cron="0/20 * * * * ?")//20 seconds
	@Scheduled(cron = "0 0/2 * * * ?") // 1 minute
	//@Scheduled(cron="0 0/5 9-16 * * ?")//every 1 minute between 9AM to 16PM
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
			cronStatus=CronStatus.FAILURE;
			cronStatusModel.setMessage(e.getMessage());
			e.printStackTrace();
		}
		
		//cron end
		cronStatusModel.setEndTime(new Date(System.currentTimeMillis()));
		cronStatusModel.setStatus(cronStatus.toString());
		cronStatusService.save(cronStatusModel);
	}
	
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) 
    {
        return restTemplateBuilder
           .setConnectTimeout(Duration.ofMillis(60000))
           .setReadTimeout(Duration.ofMillis(60000))
           .build();
    }

}

