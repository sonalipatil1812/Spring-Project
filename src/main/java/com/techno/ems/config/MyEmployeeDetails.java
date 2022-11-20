//package com.techno.ems.config;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.techno.ems.entity.Employee;
//import com.techno.ems.entity.Role;
//
//
//public class MyEmployeeDetails implements UserDetails {
//
//	@Autowired
//	private Employee employee;
//	
//	public MyEmployeeDetails(Employee employee) {
//		this.employee = employee;
//	}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<Role> role=employee.getRoles();
//		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
//		for(Role roles:role) {
//			authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
//		}
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return employee.getDob();
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return employee.getEmpName();
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//}
