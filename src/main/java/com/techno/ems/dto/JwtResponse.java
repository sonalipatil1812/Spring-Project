package com.techno.ems.dto;

import com.techno.ems.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {

	private Employee employee;
	private String jwtToken;
}
