package com.jesperapps.api.service;

import com.jesperapps.api.model.ConfirmationToken;
import com.jesperapps.api.model.User;

public interface EmailSenderService {
	
	public ConfirmationToken getConfirmationTokenForUser(User user);
	
	public boolean sendOTPMail(User otpUsers);

}
