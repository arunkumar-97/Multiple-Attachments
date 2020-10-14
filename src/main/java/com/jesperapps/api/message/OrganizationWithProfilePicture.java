package com.jesperapps.api.message;

import com.jesperapps.api.model.OrganizationAttachment;

public class OrganizationWithProfilePicture {
	
	private Integer organizationId;
	private String organizationName;
	private String status;
	private OrganizationAttachment attachment;
	
	
	public Integer getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrganizationAttachment getAttachment() {
		return attachment;
	}
	public void setAttachment(OrganizationAttachment attachment) {
		this.attachment = attachment;
	}
	
	

}
