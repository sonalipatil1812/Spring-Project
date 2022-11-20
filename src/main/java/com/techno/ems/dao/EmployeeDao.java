package com.techno.ems.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techno.ems.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	Employee findByEmpId(Integer empId);

	Employee findByEmailId(String emailId);
  
	


}
