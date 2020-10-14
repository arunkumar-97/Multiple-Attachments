package com.jesperapps.api.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class UserType {
	
	@Id
	private Integer userTypeId;
	private String userTypeRole;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userType")
	private List<User> user;
	
	

	public Integer getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
	}

	

	

	public String getUserTypeRole() {
		return userTypeRole;
	}

	public void setUserTypeRole(String userTypeRole) {
		this.userTypeRole = userTypeRole;
	}

	public UserType() {
		
	}

	public UserType(int id, String admin) {
		this.userTypeId=id;
		this.userTypeRole=admin;
	}

	public UserType(UserType userType) {
		// TODO Auto-generated constructor stub
		this.userTypeId=userType.getUserTypeId();
		this.userTypeRole=userType.getUserTypeRole();
	}

	

}
