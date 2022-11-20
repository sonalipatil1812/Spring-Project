package com.techno.ems.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.techno.ems.entity.Address;
import com.techno.ems.entity.AuthRole;
import com.techno.ems.entity.BankDetails;
import com.techno.ems.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Setter
public class EmployeeDto {
	 private Integer empId;
	 private String empName;
	 private String empAge;
	 private String empDesignation;
	 private String emailId;
	 private String bloodGroup;
	 private String dob;
	 private String gender;
	 private String maritalStatus;
	 
	 
	 private List<Address>  address;
	 private List<BankDetails>  bankDetails;
	 private Department department;
	 private Set<AuthRole> authRoles;
	
	

	public void setAddress(int i, String string, String string2, String string3, String string4, String string5,
			String string6, String string7, int j) {
		// TODO Auto-generated method stub
		
	}

	public void setDepartment(int i, String string, String string2, String string3) {
		// TODO Auto-generated method stub
		
	}

	
	
}
