//package com.techno.ems.config;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.techno.ems.dao.EmployeeDao;
//import com.techno.ems.exception.EmployeeException;
//import com.techno.ems.jwt.JunitTokenFilter;
//import com.techno.ems.services.EmployeeServiceImpl;
//
//@Configuration
//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	private EmployeeDao employeeDao;
//	
//	@Autowired
//	private JunitTokenFilter junitTokenFilter;
//	
////	@Autowired
////	private UserDetailsService userDetailsService;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		
//		http.exceptionHandling().authenticationEntryPoint((request,response,ex)->{
//		          response.sendError(HttpServletResponse.SC_UNAUTHORIZED,ex.getMessage());	
//		}
//				);
//			
//		
//		http.authorizeRequests().antMatchers("/login","/register").permitAll().anyRequest().authenticated();
//		
//		
//		
//	    http.addFilterBefore(junitTokenFilter, UsernamePasswordAuthenticationFilter.class);
////			
//		
//				
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		try {
//			auth.userDetailsService(username -> employeeDao.findByEmailId(username));
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new EmployeeException("user not found");
//		}
////		auth.userDetailsService(userDetailsService);
//		
//	}
//
//	@Override
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//		return super.authenticationManagerBean();
//
//	}
//	
//	
//	
//
//	
//	
//}
