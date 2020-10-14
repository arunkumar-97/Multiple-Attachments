package com.jesperapps.api.service;

import com.jesperapps.api.message.OrganizationWithProfilePicture;
import com.jesperapps.api.model.Organization;


 

public interface OrganizationService {
	
	Organization findByName(String organizationName);
	
	Organization getOrganizationFromName(String organizationName);

	Organization addadmin(OrganizationWithProfilePicture organizationRequestWithProfilePicture);

	Organization getOrganizationId(Integer organizationId);

	void saveOrganization(Organization idFromDb);

	
}
