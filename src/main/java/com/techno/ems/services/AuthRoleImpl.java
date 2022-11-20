package com.techno.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techno.ems.dao.AuthRoleDao;
import com.techno.ems.entity.AuthRole;
@Service
public class AuthRoleImpl {

	@Autowired
	private AuthRoleDao authRoleDao;
	
	 public AuthRole getRegister(AuthRole authRole) {
		return authRoleDao.save(authRole);
		 
	 }
}
