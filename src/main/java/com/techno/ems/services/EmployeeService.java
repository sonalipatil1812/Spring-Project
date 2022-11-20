package com.techno.ems.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techno.ems.dto.EmployeeDto;
import com.techno.ems.dto.JwtResponse;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.LoginResponse;
import com.techno.ems.dto.ReturnData;
import com.techno.ems.entity.Employee;

@Component
public interface EmployeeService {
   EmployeeDto getRegister(EmployeeDto employeeDto);
   
   public EmployeeDto getDelete(Integer empId);
   
   EmployeeDto update(EmployeeDto employeeDto);
   
   List<ReturnData> getAll();
   
   ReturnData getOne(Integer empId);
   
//    LoginResponse getLogin(LoginDto loginDto);
   
    JwtResponse getLogin1(LoginDto loginDto) throws Exception;
}
