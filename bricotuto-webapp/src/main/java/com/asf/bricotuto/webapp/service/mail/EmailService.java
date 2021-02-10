package com.asf.bricotuto.webapp.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	 @Autowired
	    public JavaMailSender emailSender;

    @Async
    public void sendEmail(SimpleMailMessage email) {
    	emailSender.send(email);
    }
    
    public void sendConfirmationTokenMail(String userMail, String token) {

    	final SimpleMailMessage mailMessage = new SimpleMailMessage();
    	mailMessage.setTo(userMail);
    	mailMessage.setSubject("Mail Confirmation Link!");
    	mailMessage.setFrom("<MAIL>");
    	mailMessage.setText(
    			"Thank you for registering. Please click on the below link to activate your account." + "http://localhost:9001/regitrationConfirm?token="
    					+ token);

    	sendEmail(mailMessage);
    }
    
    public void sendResetPasswordMail(String userMail, String token) {

    	final SimpleMailMessage mailMessage = new SimpleMailMessage();
    	mailMessage.setTo(userMail);
    	mailMessage.setSubject("Mail resetPassword Link!");
    	mailMessage.setFrom("<MAIL>");
    	mailMessage.setText(
    			"Thank you for registering. Please click on the below link to activate your account." + "http://localhost:9001/changePassword?token="
    					+ token);

    	sendEmail(mailMessage);
    }
}
