//package com.techno.ems;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.techno.ems.dao.EmployeeDao;
//import com.techno.ems.dto.EmployeeDto;
//import com.techno.ems.entity.Address;
//import com.techno.ems.entity.BankDetails;
//import com.techno.ems.entity.Department;
//import com.techno.ems.entity.Employee;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//public class EmployeeDaoTest {
//	@Mock
//	private EmployeeDao employeeDao;
//
//	@Autowired
//	private ModelMapper modelMapper;
//
//	@Test
//	void testGetOne() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		EmployeeDto employeeDto = new EmployeeDto(1, "Sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address1, details, department);
//		
//		Employee employee = modelMapper.map(employeeDto,Employee.class);
//		when(employeeDao.findByEmpId(employee.getEmpId())).thenReturn(employee);
//		assertEquals(1, employee.getEmpId());
//
//	}
//	 
//	@Test
//	public void deleteTest() {
//              Integer id=1;
//              Employee findByEmpId = employeeDao.findByEmpId(id);
//              employeeDao.delete(findByEmpId);
//              employeeDao.findByEmpId(id);
//              assertEquals(null, employeeDao.findByEmpId(id));
//	}
//	
//	@Test
//	void registerTest() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		EmployeeDto employeeDto = new EmployeeDto(1, "Sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address1, details, department);
//		
//		Employee employee = modelMapper.map(employeeDto, Employee.class);
//		when(employeeDao.save(employee)).thenReturn(employee);
//		assertEquals(employee, employeeDao.save(employee));
//		
//	}
//	@Test
//	void getAll() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		EmployeeDto employeeDto = new EmployeeDto(1, "Sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address1, details, department);
//		
//		Employee employee = modelMapper.map(employeeDto,Employee.class);
//		
//		when(employeeDao.save(null)).thenReturn(employee);
//		assertEquals(1,employee.getEmpId());
//	}
//	
//	@Test
//	void updateTest() {
//		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
//		java.util.List<BankDetails> details = new ArrayList<>();
//		details.add(bankDetails);
//
//		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
//		java.util.List<Address> address1 = new ArrayList<>();
//		address1.add(address);
//
//		Department department = new Department(1, "dd", "dd", "dd");
//		EmployeeDto employeeDto = new EmployeeDto(1, "Sonali", "25", "Developer", "ss@gmail.com", "B+", "22/09/2022",
//				"Female", "Unmarried", address1, details, department);
//		
//		Employee employee = modelMapper.map(employeeDto, Employee.class);
//		when(employeeDao.save(employee)).thenReturn(employee);
//		assertEquals(employee, employeeDao.save(employee));
//		
//	}
//}	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//
