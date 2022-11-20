package com.techno.ems.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

//import com.techno.ems.config.MyEmployeeDetails;
import com.techno.ems.dao.EmployeeDao;
import com.techno.ems.dto.EmployeeDto;
import com.techno.ems.dto.JwtResponse;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.dto.LoginResponse;
import com.techno.ems.dto.ReturnData;
import com.techno.ems.entity.EmailConfig;
import com.techno.ems.entity.EmailMessage;
import com.techno.ems.entity.Employee;
import com.techno.ems.exception.EmployeeException;
//import com.techno.ems.jwt.JwtUtilToken;
//import com.techno.ems.jwt1.JwtUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public EmployeeDao employeeDao;

	@Autowired
	public EmailConfig emailConfig;
	
//	@Autowired
//	private JwtUtilToken jwtUtilToken;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

//	 @Autowired private JavaMailSender javaMailSender;

	@Override
	public EmployeeDto getRegister(EmployeeDto employeeDto) {
		try {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeDto, employee);
			employeeDao.save(employee);
			BeanUtils.copyProperties(employee, employeeDto);
			emailConfig.sendMail(employeeDto.getEmailId(),
					EmailMessage.getMess(employeeDto.getEmpName(), employeeDto.getEmpId()));
			return employeeDto;
		} catch (Exception e) {
			throw new EmployeeException("Something went wrong");
		}

	}

//			Employee map = this.modelMapper.map(employeeDto, Employee.class);
//			Employee save = employeeDao.save(map);

//			this.modelMapper.map(save, EmployeeDto.class);
//			emailConfig.sendMail(employeeDto.getEmailId(),
//					EmailMessage.getMess(employeeDto.getEmpName(), employeeDto.getEmpId()));
//			return employeeDto;

	@Override
	public EmployeeDto getDelete(Integer empId) {
		try {
			Employee findById = employeeDao.findById(empId)
					.orElseThrow(() -> new EmployeeException("Employee Not found"));
			employeeDao.delete(findById);
			EmployeeDto map = modelMapper.map(findById, EmployeeDto.class);
			return map;
		} catch (Exception e) {
			throw new EmployeeException("Not found");
		}

//			try {
//				employeeDao.deleteById(empId);
//				return null;
//			} catch (Exception e) {
//					throw new EmployeeException("Employee Not found");
//			}
	}
//		return isDeleted;
//		return null;

	@Override
	public EmployeeDto update(EmployeeDto employeeDto) {
		try {
			Employee employee = employeeDao.findById(employeeDto.getEmpId())
					.orElseThrow(() -> new EmployeeException("not found"));
			BeanUtils.copyProperties(employeeDto, employee);
			employeeDao.save(employee);
			BeanUtils.copyProperties(employee, employeeDto);
			return employeeDto;
		} catch (BeansException e) {
			throw new EmployeeException("Something went wrong");
		}

////		Employee employee = employeeDao.findById(employeeDto.getEmpId()).orElseThrow(()->new EmployeeException("User Not Found"));
////            System.out.println("Done");
////			BeanUtils.copyProperties(employeeDto, employee);
////			employeeDao.save(employee);
////			BeanUtils.copyProperties(employee, employeeDto);
////			return employeeDto;
//		try {
//			if(employeeDao.findById(employeeDto.getEmpId()).isPresent()) {
//		Employee map = this.modelMapper.map(employeeDto, Employee.class);
//        Employee save = employeeDao.save(map);
//		return this.modelMapper.map(save, EmployeeDto.class);
//			}else {
//				throw new EmployeeException("User not found");
//			}
//		}catch (BeansException e) {
//			// TODO: handle exception
//			throw new EmployeeException("Something went wrong");
//		}
	}

	@Override
	public List<ReturnData> getAll() {
		try {
			System.out.println("get all");
			List<Employee> findAll = (List<Employee>) employeeDao.findAll();
			List<ReturnData> arrayList = new ArrayList<>();
			for (Employee employee : findAll) {
//				ReturnData data=new ReturnData();
//				data.setEmpId(employee.getEmpId());
//				data.setEmpName(employee.getEmpName());
//				data.setEmpAge(employee.getEmpAge());
//				data.setEmpDesignation(employee.getEmpDesignation());
//				data.setEmailId(employee.getEmailId());
//				data.setBloodGroup(employee.getBloodGroup());
//				data.setDob(employee.getDob());
//				data.setGender(employee.getGender());
//				data.setMaritalStatus(employee.getMaritalStatus());
//				data.setAddress(employee.getAddress());
//				data.setDepartment(employee.getDepartment());
//				data.setBankDetails(employee.getBankDetails());
//				arrayList.add(data);
				ReturnData emp = new ReturnData(employee.getEmpId(), employee.getEmpName(), employee.getEmpAge(),
						employee.getEmpDesignation(), employee.getEmailId(), employee.getBloodGroup(),
						employee.getDob(), employee.getGender(), employee.getMaritalStatus(), employee.getAddress(),
						employee.getBankDetails(), employee.getDepartment());
				arrayList.add(emp);

			}
			return arrayList;
		} catch (Exception e) {
			throw new EmployeeException("Not found");
		}
//        return null;
	}

	@Override
	public ReturnData getOne(Integer empId) {
		try {
			Employee findByEmpId = employeeDao.findByEmpId(empId);
			return new ReturnData(findByEmpId.getEmpId(), findByEmpId.getEmpName(), findByEmpId.getEmpAge(),
					findByEmpId.getEmpDesignation(), findByEmpId.getEmailId(), findByEmpId.getBloodGroup(),
					findByEmpId.getDob(), findByEmpId.getGender(), findByEmpId.getMaritalStatus(),
					findByEmpId.getAddress(), findByEmpId.getBankDetails(), findByEmpId.getDepartment());
		} catch (Exception e) {
			throw new EmployeeException("Not found1");

		}

//		Employee employee= employeeDao.findByEmpId(empId);
//////		List<Employee> findAll =(List<Employee>) employeeDao.findAll();
////		List<ReturnData> arrayList = new ArrayList<>();
//		if(employeeDao.findByEmpId(empId)!=null) {
//			
//				List<ReturnData> emp=(List<ReturnData>) new ReturnData(employee.getEmpId(),employee.getEmpName(),employee.getEmpAge(),employee.getEmpDesignation(),employee.getEmailId(),employee.getBloodGroup(),employee.getDob(),employee.getGender(),employee.getMaritalStatus(),employee.getAddress(),employee.getBankDetails(),employee.getDepartment());
//			   
//			return emp;
//		}
//		
////		List<Employee> findAll =(List<Employee>) employeeDao.findByEmpId(empId);
////		List<ReturnData> arrayList = new ArrayList<>();
////		for(Employee employee:findAll) {
////			ReturnData emp=new ReturnData(employee.getEmpId(),employee.getEmpName(),employee.getEmpAge(),employee.getEmpDesignation(),employee.getEmailId(),employee.getBloodGroup(),employee.getDob(),employee.getGender(),employee.getMaritalStatus(),employee.getAddress(),employee.getBankDetails(),employee.getDepartment());
////		    arrayList.add(emp);
////		}
//		return null;
	}

	@Override
//	public LoginResponse getLogin(LoginDto loginDto) {
//		try {
//			 Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmailId(), loginDto.getDob()));
//			 Employee employee= (Employee) authentication.getPrincipal();
//			 String accessToken = jwtUtilToken.generateAccessToken(employee);
//			 return new LoginResponse(employee.getEmailId(),accessToken);
//		}catch (AuthenticationException e) {
//		  throw new EmployeeException("Unauthorized");
//		}
//	}

	public JwtResponse getLogin1(LoginDto loginDto) throws Exception {
		return jwtService.createJwtToken(loginDto);
	}

	
	
}
		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
//		Employee findByEmailId = employeeDao.findByEmailId(loginDto.getEmailId());
//		if (findByEmailId != null) {
//			if (findByEmailId.getDob().equals(loginDto.getDob())) {
//				return modelMapper.map(findByEmailId, LoginDto.class);
//			} else {
//				throw new EmployeeException("Wrong Password");
//			}
//		}
//		throw new EmployeeException("Invalid Email Id");
//	}


