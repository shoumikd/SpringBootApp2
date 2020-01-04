package com.app.Utilities;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsCallUtility {

	private final static String ACCOUNT_SID = "ACd91680ce4b424646a5f45c477944a88b";
	private final static String AUTH_ID = "034512b803cc50acec25ed1e39bce134";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}

	// send sms
	public void sendMessage() {
		try {
			Message.creator(new PhoneNumber("9804194702"), new PhoneNumber("+16027865781"),
					"Message from Spring Boot Application").create();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// send Call
	public void sendCall(){
		try {
			Call.creator(new PhoneNumber("+919804194702"), new PhoneNumber("+16027865781"),
					new URI("http://demo.twilio.com/docs/voice.xml")).create();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
