package com.jesperapps.api.service;

import org.springframework.stereotype.Service;

import com.jesperapps.api.model.Attachment;
import com.jesperapps.api.model.OrganizationAttachment;
import com.jesperapps.api.utils.AttachmentHelper;


@Service
public class OrganizationProfilePictureServiceImpl extends AttachmentHelper implements OrganizationProfilePictureService {

	private final String LOCATION = "C:\\Users\\Guest_user\\OrganizationProfilePicture";
	
	@Override
	public OrganizationAttachment saveFile(OrganizationAttachment organizationProfilePicture) {
		if(this.saveRequestFile(organizationProfilePicture.getAttachmentName(), organizationProfilePicture.getFileByte(), LOCATION)) {
			return organizationProfilePicture;
		}
		return null;
	}

	
}
