package com.techno.ems.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.techno.ems.dao.EmployeeDao;
import com.techno.ems.dto.JwtResponse;
import com.techno.ems.dto.LoginDto;
import com.techno.ems.entity.Employee;
import com.techno.ems.util.jwtUtil;

@Service
@Component
public class JwtService implements UserDetailsService{
    @Autowired
	private EmployeeDao employeeDao;
    
    @Autowired
    private jwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    public JwtResponse createJwtToken(LoginDto loginDto) throws Exception {
    	String userName = loginDto.getEmailId();
    	String userPassword = loginDto.getDob();
        authenticate(userName, userPassword);
		
		
		 final UserDetails userDetails = loadUserByUsername(userName);
		 String newgenerateToken = jwtUtil.generateToken(userDetails);
		 
		 Employee employee = employeeDao.findByEmailId(userName);
		 
		 return new JwtResponse(employee,newgenerateToken);
    }
    
    
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeDao.findByEmailId(username);
		if(employee!=null) {
			return new User(
					employee.getEmailId(),
					employee.getDob(), 
					(Collection<? extends GrantedAuthority>) getAuthorities(employee)
					);
		}else {
			throw new UsernameNotFoundException("Username is not valid");
		}
	}
	
	private Set<?> getAuthorities(Employee employee){
		Set authorities=new HashSet();
		employee.getAuthRoles().forEach(authrole ->{
			authorities.add(new SimpleGrantedAuthority("ROLE_"+authrole.getAuthName()));
		});
		return authorities;
	}
	
	private void authenticate(String userName,String password) throws Exception{
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
	}catch (DisabledException e) {
		throw new Exception("Disables");
	}catch (BadCredentialsException e) {
		throw new Exception("Bad Credentials");
	}
	}
}
