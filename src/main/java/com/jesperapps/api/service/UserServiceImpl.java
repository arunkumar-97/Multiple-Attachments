package com.jesperapps.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.api.message.OrganizationWithProfilePicture;
import com.jesperapps.api.message.UserRequestWithProfilePicture;
import com.jesperapps.api.model.Attachment;
import com.jesperapps.api.model.Organization;
import com.jesperapps.api.model.OrganizationAttachment;
import com.jesperapps.api.model.User;
import com.jesperapps.api.model.UserType;
import com.jesperapps.api.repository.UserRepository;
import com.jesperapps.api.repository.UserTypeRepository;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private OrganizationProfilePictureService organizationProfilePictureService;
	
	@Autowired
	private UserProfilePictureService userProfilePictureService;
	
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	

	@Override
	public User findById(int userId) {
		return userRepository.findByUserId(userId);
	}

	@Override
	public User addUser(UserRequestWithProfilePicture userRequestWithProfilePicture) {
		User user=new User();
		user.setUserId(userRequestWithProfilePicture.getUserId());
		user.setUserName(userRequestWithProfilePicture.getUserName());
		user.setUserEmail(userRequestWithProfilePicture.getUserEmail());
		user.setOrganizationEmail(userRequestWithProfilePicture.getOrganizationEmail());
		user.setPassword(userRequestWithProfilePicture.getPassword());
		user.setConfirmPassword(userRequestWithProfilePicture.getConfirmPassword());
		
		if(userRequestWithProfilePicture.getUserType()!= null) {
			UserType requestUserType=userRequestWithProfilePicture.getUserType();
			if(requestUserType.getUserTypeId() != null) {
				user.setUserType(userTypeRepository.findByUserTypeId(requestUserType.getUserTypeId()));
			
			}else {
				user.setUserType(userTypeRepository.findByUserTypeId(1));
			}
			 emailSenderService.sendOTPMail(user);
		}
		OrganizationWithProfilePicture newOrganization=userRequestWithProfilePicture.getOrganization();
		if(newOrganization!=null) {
			OrganizationAttachment attachment= this.organizationProfilePictureService.saveFile(newOrganization.getAttachment());
			if(attachment != null) {
				newOrganization.setAttachment(attachment);
				Organization organizationForDB = new Organization(newOrganization);
				user.setOrganization(organizationForDB);
			}else {
				
			}

		}
			
		Attachment userProfileAttachment=userRequestWithProfilePicture.getAttachment();
		if(userProfileAttachment != null) {
			Attachment newAttachment=this.userProfilePictureService.saveFile(userProfileAttachment);
			if(newAttachment != null) {
				user.setAttachment(newAttachment);
				newAttachment.setUser(user);
				userRepository.save(user);	
			}
			else {
				user.setAttachment(null);
			}
		}
		return user;
	}

}
