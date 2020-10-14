package com.jesperapps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesperapps.api.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	User finByUserEmail(String userEmail);

	User findByUserId(int userId);

}
