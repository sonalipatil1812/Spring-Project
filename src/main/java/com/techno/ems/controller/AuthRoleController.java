package com.techno.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ems.entity.AuthRole;
import com.techno.ems.services.AuthRoleImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AuthRoleController {
 
	@Autowired
	private AuthRoleImpl authRoleImpl;
	
	@PostMapping("/role")
	public AuthRole register(@RequestBody AuthRole authRole) {
		return authRoleImpl.getRegister(authRole);
		
	}
}
