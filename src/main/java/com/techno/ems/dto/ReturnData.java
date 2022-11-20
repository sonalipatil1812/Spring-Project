package com.techno.ems.dto;

import java.util.List;

import com.techno.ems.entity.Address;
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
public class ReturnData {
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
}
