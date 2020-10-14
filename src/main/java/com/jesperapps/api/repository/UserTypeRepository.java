package com.jesperapps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.api.model.UserType;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

	UserType findByUserTypeId(Integer userTypeId);

}
