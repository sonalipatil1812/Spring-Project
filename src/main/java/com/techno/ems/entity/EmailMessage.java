package com.techno.ems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class EmailMessage {
	public static String getMess(String empName,Integer empId) {
		
		String mss="\r\n"
				+ "Hello "+empName+",\r\n"
				+ "\r\n"
				+ "Thank you for Register your Employee ID is "+empId+".\r\n"
				+ "\r\n";
				
		
		return mss;
		
	}
	public static void main(String[] args) {
		
	}

}
