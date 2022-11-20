package com.techno.ems.controller;

import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techno.ems.dto.EmployeeDto;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.ResponseDto;
import com.techno.ems.dto.ReturnData;
import com.techno.ems.services.EmployeeService;
//import javax.ws.rs.core.MediaType;

@RestController
//@RequestMapping("/ems/")
public class EmployeeController {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public EmployeeService employeeService;
	
	
	
	


	@PostMapping(value = "/register")
	public ResponseEntity<?> register(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(
				new ResponseDto(false, "Register successfull..", employeeService.getRegister(employeeDto)),
				HttpStatus.CREATED);

	}

//	@DeleteMapping("/delete/{empId}")
//public ResponseEntity<?> deleteEmployee(@PathVariable Integer empId) {
//		if (employeeService.getDelete(empId) == null) {
//		return new ResponseEntity<>(new ResponseDto(false, "id deleted", empId), HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>(new ResponseDto(true, "id not found ", empId), HttpStatus.BAD_REQUEST);
//		}
//
//	}
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> delete(@PathVariable Integer empId){
		EmployeeDto delete = employeeService.getDelete(empId);
		if(delete!=null) {
			return new ResponseEntity<>(new ResponseDto(false, "Employee Deleted", delete),HttpStatus.OK);
		}
 		return new ResponseEntity<>(new ResponseDto(true, "Not Deleted", delete),HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<ReturnData> list = employeeService.getAll();
		if (list != null) {
			return new ResponseEntity<List<ReturnData>>(list, HttpStatus.ACCEPTED);
		}
       return null;
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody EmployeeDto employeeDto) {
		 return new ResponseEntity<>(
					new ResponseDto(false, "Updated successfull..", employeeService.update(employeeDto)),
					HttpStatus.OK);
	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<?> getById(@PathVariable Integer empId) {
			return new ResponseEntity<>(new ResponseDto(false, "Data Found", employeeService.getOne(empId)),
					HttpStatus.OK);
		} 
	
	@PostMapping("/login")
	public ResponseEntity<?> getLogin(@RequestBody LoginDto loginDto) throws Exception {
		return new ResponseEntity<>(new ResponseDto(false, "successfully logged in",employeeService.getLogin1(loginDto)),
				HttpStatus.OK);

	}
	
	
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

