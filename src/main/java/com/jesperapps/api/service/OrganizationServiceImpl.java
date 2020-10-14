package com.jesperapps.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesperapps.api.message.OrganizationWithProfilePicture;
import com.jesperapps.api.model.Organization;
import com.jesperapps.api.model.OrganizationAttachment;
import com.jesperapps.api.repository.OrganizationRepository;



@Service
public class OrganizationServiceImpl implements OrganizationService{

	
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public Organization findByName(String organizationName) {
		return this.organizationRepository.findByOrganizationName(organizationName);
	}

	@Override
	public Organization getOrganizationFromName(String organizationName) {
		Organization organizationFromDb = this.findByName(organizationName);
		if(organizationFromDb==null) {
			organizationFromDb = new Organization();
			organizationFromDb.setOrganizationName(organizationName);
			organizationFromDb.setStatus("Active");
		}
		return organizationFromDb;
	}

	@Override
	public Organization addadmin(OrganizationWithProfilePicture organizationRequestWithProfilePicture) {
		Organization organizationWithSameName = organizationRepository.findByOrganizationName(organizationRequestWithProfilePicture.getOrganizationName());
		if(organizationWithSameName == null) {
			Organization newOrganizationList=new Organization();
//			newOrganizationList.setOrganizationId(organizationRequestWithProfilePicture.getOrganizationId());
			newOrganizationList.setOrganizationName(organizationRequestWithProfilePicture.getOrganizationName());
			newOrganizationList.setStatus(organizationRequestWithProfilePicture.getStatus());
			try {
				OrganizationAttachment profileAttachment = organizationRequestWithProfilePicture.getAttachment();
				profileAttachment.setOrganization(newOrganizationList);
				newOrganizationList.setImageAttachment(profileAttachment);
				organizationRepository.save(newOrganizationList);
			}
			catch(Exception e) {
		System.out.println(e);
			return new Organization();
			}
			return newOrganizationList;	
		}else {
			return null;
		}

	}

	@Override
	public Organization getOrganizationId(Integer organizationId) {
		// TODO Auto-generated method stub
		return organizationRepository.findByOrganizationId(organizationId);
	}

	@Override
	public void saveOrganization(Organization idFromDb) {
		// TODO Auto-generated method stub
		organizationRepository.save(idFromDb);
	}

}
