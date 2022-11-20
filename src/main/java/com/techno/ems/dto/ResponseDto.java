package com.techno.ems.dto;

import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class ResponseDto {
	
	
		private boolean status;
		private String message;
		private Object data;
		
		public ResponseDto msg() {
			return new ResponseDto(false,"Unauthorized User",null);
			
		}
		
}
