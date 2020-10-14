package com.jesperapps.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrganizationAttachment {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer attachmentId;
	private String attachmentName;
	private String attachmentType;
	@Column(columnDefinition="LONGTEXT")
	private String fileByte;
	
	@OneToOne(mappedBy="imageAttachment")
	private Organization organization;

	public Integer getId() {
		return attachmentId;
	}

	public void setId(Integer id) {
		this.attachmentId = id;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public String getFileByte() {
		return fileByte;
	}

	public void setFileByte(String fileByte) {
		this.fileByte = fileByte;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	
	

}
