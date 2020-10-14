package com.jesperapps.api.service;

import org.springframework.stereotype.Service;

import com.jesperapps.api.model.Attachment;
import com.jesperapps.api.utils.AttachmentHelper;


@Service
public class UserProfilePictureServiceImpl extends AttachmentHelper implements UserProfilePictureService {

	private final String LOCATION = "C:\\Users\\Guest_user\\UserProfilePicture";
	
	@Override
	public Attachment saveFile(Attachment userProfilePicture) {
		if(this.saveRequestFile(userProfilePicture.getAttachmentName(), userProfilePicture.getFileByte(), LOCATION)) {
			return userProfilePicture;
		}
		return null;
	}


	
}
