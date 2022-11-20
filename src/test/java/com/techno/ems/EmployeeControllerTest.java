package com.techno.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Response;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techno.ems.controller.EmployeeController;
import com.techno.ems.dto.EmployeeDto;
import com.techno.ems.dto.ResponseDto;
import com.techno.ems.dto.ReturnData;
import com.techno.ems.entity.Address;
import com.techno.ems.entity.BankDetails;
import com.techno.ems.entity.Department;
import com.techno.ems.entity.Employee;
import com.techno.ems.services.EmployeeService;

import net.minidev.json.JSONObject;

@SpringBootTest
public class EmployeeControllerTest {

	private static final ResultMatcher MockMvcRequestBuilders = null;

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;

	private MockMvc mockMvc;
	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	public void testRegister() throws Exception {
		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
		java.util.List<BankDetails> details = new ArrayList<>();
		details.add(bankDetails);

		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
		java.util.List<Address> address1 = new ArrayList<>();
		address1.add(address);

		Department department = new Department(1, "dd", "dd", "dd");

		EmployeeDto employeeDto = EmployeeDto.builder().empId(1).empName("sonali").empAge("20")
				.empDesignation("Developer").emailId("ss@gmail.com").bloodGroup("B+").dob("22/09/1996").gender("female")
				.maritalStatus("unmarried").address(address1).bankDetails(details).department(department).build();
		 ResultActions response = mockMvc.perform(post("/register")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(employeeDto)));
		 
		
		when(employeeService.getRegister(employeeDto)).thenReturn(employeeDto);
		ResponseEntity<?> emp = employeeController.register(employeeDto);
		assertNotNull(emp);
		assertEquals(HttpStatus.OK, emp.getStatusCode());
	}

	@Test
	public void getByIdTest() throws Exception {
		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
		java.util.List<BankDetails> details = new ArrayList<>();
		details.add(bankDetails);

		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
		java.util.List<Address> address1 = new ArrayList<>();
		address1.add(address);

		Department department = new Department(1, "dd", "dd", "dd");

		ReturnData employeeDto = ReturnData.builder().empId(1).empName("sonali").empAge("20")
				.empDesignation("Developer").emailId("ss@gmail.com").bloodGroup("B+").dob("22/09/1996").gender("female")
				.maritalStatus("unmarried").address(address1).bankDetails(details).department(department).build();
		when(employeeService.getOne(anyInt())).thenReturn(employeeDto);
		 ResultActions response = mockMvc.perform(get("/getById/1")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(employeeDto)));
		ResponseEntity<?> emp = employeeController.getById(employeeDto.getEmpId());
		assertNotNull(emp);
		assertEquals(HttpStatus.OK, emp.getStatusCode());

	}
	@Test
	void testDeleteEmployeeDetails_success() throws Exception {
		 String URI="/delete/1";
		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
		java.util.List<BankDetails> details = new ArrayList<>();
		details.add(bankDetails);

		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
		java.util.List<Address> address1 = new ArrayList<>();
		address1.add(address);

		Department department = new Department(1, "dd", "dd", "dd");

		EmployeeDto employeeDto = EmployeeDto.builder().empId(1).empName("sonali").empAge("20")
				.empDesignation("Developer").emailId("ss@gmail.com").bloodGroup("B+").dob("22/09/1996").gender("female")
				.maritalStatus("unmarried").address(address1).bankDetails(details).department(department).build();
		when(employeeService.getDelete(anyInt())).thenReturn(employeeDto);
		 
				 ResultActions response = mockMvc.perform(((MockMvcRequestBuilders) MockMvcRequestBuilders)
						 .delete("/delete/1")
						 .contentType(MediaType.APPLICATION_JSON))
						 .andExpect(status().isOk());
		            
//		when(employeeService.getDelete(anyInt())).thenReturn(employeeDto);
//		ResponseEntity<?> emp = employeeController.delete(anyInt());
//		assertEquals(HttpStatus.OK, emp.getStatusCode());
	}
	
	@Test
	public void getAllTest() throws Exception {
		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
		java.util.List<BankDetails> details = new ArrayList<>();
		details.add(bankDetails);

		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
		java.util.List<Address> address1 = new ArrayList<>();
		address1.add(address);

		Department department = new Department(1, "dd", "dd", "dd");

		ReturnData employeeDto = ReturnData.builder().empId(1).empName("sonali").empAge("20")
				.empDesignation("Developer").emailId("ss@gmail.com").bloodGroup("B+").dob("22/09/1996").gender("female")
				.maritalStatus("unmarried").address(address1).bankDetails(details).department(department).build();
		 ResultActions response = mockMvc.perform(get("/getAll")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(employeeDto)));
		List<ReturnData> dtos=new ArrayList<>();
		dtos.add(employeeDto);
		when(employeeService.getAll()).thenReturn(dtos);
//		mockMvc.perform(((MockMvcRequestBuilders) MockMvcRequestBuilders).get("/getAll").)
	}

	public void updateTest() throws Exception {
		BankDetails bankDetails = new BankDetails(1, "MHB0001", "ICICI", "ifsc001", "Saving");
		java.util.List<BankDetails> details = new ArrayList<>();
		details.add(bankDetails);

		Address address = new Address(1, "per", "A/111", "ss", "ss", "ss", "ss", "ss", 416101);
		java.util.List<Address> address1 = new ArrayList<>();
		address1.add(address);

		Department department = new Department(1, "dd", "dd", "dd");

		EmployeeDto employeeDto = EmployeeDto.builder().empId(1).empName("sonali").empAge("20")
				.empDesignation("Developer").emailId("ss@gmail.com").bloodGroup("B+").dob("22/09/1996").gender("female")
				.maritalStatus("unmarried").address(address1).bankDetails(details).department(department).build();
		 ResultActions response = mockMvc.perform(put("/update/{empId}",1)
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(objectMapper.writeValueAsString(employeeDto)));
		when(employeeService.update(employeeDto)).thenReturn(employeeDto);
		ResponseEntity<?> update = employeeController.update(employeeDto);
		assertNotNull(update);
		assertEquals(HttpStatus.OK,update.getStatusCode());
	}
}
