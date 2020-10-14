package com.jesperapps.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.jesperapps.api.message.OrganizationWithProfilePicture;






@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer organizationId;
	private String organizationName;
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="organizationProfilePicture")	
	private OrganizationAttachment imageAttachment;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "organization")
	private List<User> user;
	
	public Organization() {
		super();
	}
	
	public Organization(OrganizationWithProfilePicture requestOrganization) {
		this.setOrganizationId(requestOrganization.getOrganizationId());
		this.setOrganizationName(requestOrganization.getOrganizationName());
		this.setStatus(requestOrganization.getStatus());
		OrganizationAttachment requestAttachment = requestOrganization.getAttachment();
		if(requestAttachment != null) {
			this.setImageAttachment(requestAttachment);
		}
	}

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

	public OrganizationAttachment getImageAttachment() {
		return imageAttachment;
	}

	public void setImageAttachment(OrganizationAttachment imageAttachment) {
		this.imageAttachment = imageAttachment;
	}
	
	
	

}
