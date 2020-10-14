package com.jesperapps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.api.message.OrganizationWithProfilePicture;
import com.jesperapps.api.model.Organization;


public interface OrganizationRepository extends JpaRepository<Organization, Integer> {

	Organization findByOrganizationName(String organizationName);

	Organization findByOrganizationId(Integer organizationId);

	void save(OrganizationWithProfilePicture organization);

}
