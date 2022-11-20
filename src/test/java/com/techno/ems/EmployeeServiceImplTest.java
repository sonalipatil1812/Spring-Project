//package com.techno.ems;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyInt;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.techno.ems.dao.EmployeeDao;
//import com.techno.ems.dto.EmployeeDto;
//import com.techno.ems.dto.ReturnData;
//import com.techno.ems.entity.Address;
//import com.techno.ems.entity.BankDetails;
//import com.techno.ems.entity.Department;
//import com.techno.ems.entity.Employee;
//import com.techno.ems.services.EmployeeService;
//import com.techno.ems.services.EmployeeServiceImpl;
//
//@SpringBootTest
//public class EmployeeServiceImplTest {
//
//	@Autowired
//	private EmployeeService employeeService;
//
//	@MockBean
//	private EmployeeDao employeeDao;
//
//	@InjectMocks
//	private Employee employee;
//
//	@Autowired
//	private EmployeeServiceImpl serviceImpl;
//
//	@InjectMocks
//	private EmployeeDto employeeDto;
//
//	private ModelMapper modelMapper;
//
//	@Test
//	public void testGetEmployeeById_Success() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		Employee returnData = new Employee(1, "sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022", "Female",
//				"Unmarried", address1, details, department);
//		Mockito.when(employeeDao.findByEmpId(1)).thenReturn(returnData);
//		String empployee_name = "sonali";
//		ReturnData returnData1 = employeeService.getOne(1);
//		assertEquals(empployee_name, returnData1.getEmpName());
//
//	}
//
//	@Test
//	public void testRegister() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		EmployeeDto returnData = new EmployeeDto(1, "sonali", "25", "Developer", "sss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address1, details, department);
//
//		BankDetails bankDetails1 = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details1 = new ArrayList<>();
//		details1.add(bankDetails);
//
//		Address addresses = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address2 = new ArrayList<>();
//		address2.add(address);
//
//		Department department1 = new Department(1, "dd", "dd", "dd");
//		EmployeeDto returnData1 = new EmployeeDto(1, "sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address2, details1, department1);
//
//		when(employeeService.getRegister(returnData)).thenReturn(returnData1);
//		assertEquals(returnData1.getEmpId(), returnData1.getEmpId());
//	}
//
//	@Test
//	public void deleteTest() {
//
//		Integer empId = 1;
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		Optional<Employee> returnData = Optional
//				.of(new Employee(1, "sonali", "25", "Developer", "priyankabelote1996@gmail.com", "B+", "22/09/2022",
//						"Female", "Unmarried", address1, details, department));
//		when(employeeDao.findById(empId)).thenReturn(returnData);
//		EmployeeDto delete = serviceImpl.getDelete(1);
////        assertEquals(empId, delete);
//	}
//
//	
//	public void updateTest() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		
//		Employee employee2 =Employee.builder().empId(1).empName("sonali").empAge("28").empDesignation("Dd").emailId("ss@gmail.com")
//		.bloodGroup("B+").dob("22/09/22").gender("Female").address(address1).bankDetails(details).department(department).build();
//
// 
//		Employee employee3 = Employee.builder().empId(1).empName("sonali").empAge("28").empDesignation("Dd").emailId("ss@gmail.com")
//		.bloodGroup("B+").dob("22/09/22").gender("Female").address(address1).bankDetails(details).department(department).build();
//		
////		when(employeeDao.findById(1).thenReturn(employee2);
////		when(serviceImpl.update(employeeDto)).thenReturn(employeeDto);
////		assertEquals("sonali", employeeDto.getEmpName());
//		
////		when(employeeDao.findById(anyInt()).thenReturn(employee2); 
//		when(employeeService.update(employeeDto)).thenReturn(employeeDto);
//		assertEquals("sonali", employeeDto.getEmpName());
//		
//
//	}
//
//	@Test
//	void getAllTest() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//
//		ReturnData returnData = new ReturnData(1, "sonali", "25", "Developer", "priyankabelote1996@gmail.com", "B+",
//				"22/09/2022", "Female", "Unmarried", address1, details, department);
//		List<ReturnData> list = new ArrayList<>();
//		list.add(returnData);
//
//		Mockito.when(employeeService.getAll()).thenReturn(list);
////		assertThat(employeeService.getAll()).isEqualTo(list);
//	}
//}
