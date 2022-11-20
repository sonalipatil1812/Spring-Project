//package com.techno.ems.jwt;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.ObjectUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.techno.ems.entity.Employee;
//
//import io.jsonwebtoken.Claims;
//
//@Component
//public class JunitTokenFilter extends OncePerRequestFilter {
//  
//	@Autowired 
//	private JwtUtilToken jwtUtilToken;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		if (!hasAuthorizationBearer(request)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//		String token = getAccessToken(request);
//        System.out.println(token);
// 
//        if (!jwtUtilToken.validateAccessToken(token)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
// 
//        setAuthenticationContext(token, request);
//        filterChain.doFilter(request, response);
//    }
//		
//	private void setAuthenticationContext(String token, HttpServletRequest request) {
//		// TODO Auto-generated method stub
//		 UserDetails userDetails = getUserDetails(token);
//	        
//		 
//	        UsernamePasswordAuthenticationToken
//	            authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);
//	 
//	        authentication.setDetails(
//	                new WebAuthenticationDetailsSource().buildDetails(request));
//	 
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//	}
//
//	private UserDetails getUserDetails(String token) {
//		 Employee userDetails = new Employee();
//		 Claims claims=jwtUtilToken.parseClaims(token);
//		 
//		
//		  
//		 
//		String subject= (String)claims.get(Claims.SUBJECT);
//		
//	        String[] jwtSubject = jwtUtilToken.getSubject(token).split(",");
//	        System.out.println("jwtsubject "+jwtSubject);
//	 
//	        userDetails.setEmailId(jwtSubject[0]);
//	        userDetails.setDob(jwtSubject[1]);
//	 
//	        return userDetails;
//	}
//
//	private String getAccessToken(HttpServletRequest request) {
//		String header = request.getHeader("Authorization");
//        String token = header.split(" ")[1].trim();
//        System.out.println("header split "+token);
//        String[] jwtSubject = jwtUtilToken.getSubject(token).split(",");
//        System.out.println("Subject"+jwtSubject);
//        return token;
//	}
//
//	
//
//	private boolean hasAuthorizationBearer(HttpServletRequest request) {
//		String header = request.getHeader("Authorization");
//        System.out.println("header "+header);
//        
//        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
//            return false;
//        }
// 
//        return true;
//	}
//	
//}
