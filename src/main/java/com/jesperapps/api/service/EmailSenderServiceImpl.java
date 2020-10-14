package com.jesperapps.api.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.jesperapps.api.model.ConfirmationToken;
import com.jesperapps.api.model.User;
import com.jesperapps.api.repository.UserRepository;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{

	
	
	

	private JavaMailSender javaMailSender;
	private final Integer OTP_LENGTH = 6;
	private final String FROM_ADDRESS = "arun.thril@gmail.com";
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	private String generateRandomOTP() {
		String oneTimePassword = "";
		Random randomGenerator = new Random();
		for(int i=0;i<OTP_LENGTH;i++) {
			oneTimePassword += randomGenerator.nextInt(10);
		}
		return oneTimePassword;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public ConfirmationToken getConfirmationTokenForUser(User user) {
		String newOtp = this.generateRandomOTP();
		ConfirmationToken newToken = user.getOtpToken() != null ? user.getOtpToken() : new ConfirmationToken(newOtp, user);
		newToken.setConfirmationToken(newOtp);
		user.setOtpToken(newToken);
		userRepository.save(user);
		return newToken;
	}

	@Override
	public boolean sendOTPMail(User otpUsers) {
		try {
			SimpleMailMessage otpMail = new SimpleMailMessage();
			otpMail.setTo(otpUsers.getOrganizationEmail());
			ConfirmationToken oneTimePassword = this.getConfirmationTokenForUser(otpUsers);
			otpMail.setFrom(FROM_ADDRESS);
			otpMail.setText("Hi "+otpUsers.getUserName()+", The One Time Password for your login request is "+oneTimePassword.getConfirmationToken());
			this.javaMailSender.send(otpMail);
		}catch(Exception e){
			return false;
		}
		return true;
	}
	}


