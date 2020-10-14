package com.jesperapps.api.service;

import com.jesperapps.api.model.Attachment;
import com.jesperapps.api.model.OrganizationAttachment;

public interface OrganizationProfilePictureService {
	OrganizationAttachment saveFile(OrganizationAttachment organizationProfilePicture);

}
