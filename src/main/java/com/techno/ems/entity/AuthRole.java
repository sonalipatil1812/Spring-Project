package com.techno.ems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;



@Entity
@Data
public class AuthRole {
	 
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
      private Integer authId;
	  private String authName;
}
