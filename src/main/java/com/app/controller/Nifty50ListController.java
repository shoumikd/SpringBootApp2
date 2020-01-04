package com.app.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.Utilities.EmailSendingUtility;
import com.app.Utilities.SmsCallUtility;
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
	
	@RequestMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
	   (new EmailSendingUtility()).sendmail();
	   return "Email sent successfully";   
	}
	
	@RequestMapping(value = "/sendCall")
	public String sendCall() throws AddressException, MessagingException, IOException {
	   try {
		(new SmsCallUtility()).sendCall();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return "Email sent successfully";   
	}
	
	@RequestMapping(value = "/sendSms")
	public String sendSms() throws AddressException, MessagingException, IOException {
	   (new SmsCallUtility()).sendMessage();
	   return "Email sent successfully";   
	}
	
	

}
