package com.jesperapps.api.message;

import com.jesperapps.api.model.Attachment;
import com.jesperapps.api.model.User;

public class UserResponseWithProfilePicture {
	
	private Integer userId;
	private String 	userName;
	private String userEmail;
	private String OrganizationEmail;
	private String password;
	private String confirmPassword;
	private Attachment attachment;
	private OrganizationWithProfilePicture organization;
	
	public UserResponseWithProfilePicture() {
		
	}
	public UserResponseWithProfilePicture(User createdUser) {
		this.userId=createdUser.getUserId();
		this.userName=createdUser.getUserName();
		this.userEmail=createdUser.getUserEmail();
		this.OrganizationEmail=createdUser.getOrganizationEmail();
		this.password=createdUser.getPassword();
		this.confirmPassword=createdUser.getConfirmPassword();
		this.attachment=createdUser.getAttachment();
		if(createdUser.getOrganization()!=null) {
		}
		

	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getOrganizationEmail() {
		return OrganizationEmail;
	}
	public void setOrganizationEmail(String organizationEmail) {
		OrganizationEmail = organizationEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public OrganizationWithProfilePicture getOrganization() {
		return organization;
	}
	public void setOrganization(OrganizationWithProfilePicture organization) {
		this.organization = organization;
	}
	
	

}
