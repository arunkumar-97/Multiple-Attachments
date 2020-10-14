package com.jesperapps.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Attachment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer attachmentId;
	private String attachmentName;
	private String attachmentType;
	@Column(columnDefinition="LONGTEXT")
	private String fileByte;
	
	
	@OneToOne( cascade = CascadeType.ALL,mappedBy = "attachment")
	private User user;
	
	
	public Attachment() {
		
	}
	
	public Attachment(Attachment attachment) {
		this.attachmentName=attachment.getAttachmentName();
		this.attachmentType=attachment.getAttachmentType();
		this.fileByte=attachment.getFileByte();
	}
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

	public Integer getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
