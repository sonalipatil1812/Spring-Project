package com.techno.ems.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Employee implements UserDetails{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer empId;
	private String empName;
	private String empAge;
	private String empDesignation;
	private String emailId;
	private String bloodGroup;
	private String dob;
	private String gender;
	private String maritalStatus;

	@OneToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinColumn(name = "emp_id",nullable = false)
	private List<Address> address;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id",nullable = false)
	@JsonIgnore
	private List<BankDetails> bankDetails;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id",nullable = false)
	@JsonIgnore
	private Department department;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="employee_role",
	joinColumns = {
			@JoinColumn (name="empId")
	},inverseJoinColumns = {
			@JoinColumn(name="authId")
	}
	)
	private Set<AuthRole> authRoles;

	public void thenReturn(Employee returnData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
//		for(Role role:roles) {
//			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//		}
//		return authorities;
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.getDob();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

//	public void addRole(Role role) {
//		this.roles.add(role);
//	}

	
}
