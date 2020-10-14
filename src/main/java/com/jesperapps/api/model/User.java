package com.jesperapps.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;






@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String 	userName;
	private String userEmail;
	private String OrganizationEmail;
	private String password;
	private String confirmPassword;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="attachment_id", referencedColumnName="attachmentId")
	private Attachment attachment;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="organization_Id", referencedColumnName="organizationId")
	private Organization organization;
	
	
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private ConfirmationToken otpToken;


	@ManyToOne
	@JoinColumn(name="userTypeId", referencedColumnName ="userTypeId")
	private UserType userType;
	
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
	public String getOrganizationEmail() {
		return OrganizationEmail;
	}
	public void setOrganizationEmail(String organizationEmail) {
		OrganizationEmail = organizationEmail;
	}
	public Attachment getAttachment() {
		return attachment;
	}
	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}
	public Organization getOrganization() {
		return organization;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public ConfirmationToken getOtpToken() {
		return otpToken;
	}
	public void setOtpToken(ConfirmationToken otpToken) {
		this.otpToken = otpToken;
	}
	
	
	

}
