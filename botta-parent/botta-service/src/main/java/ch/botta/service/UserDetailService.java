package ch.botta.service;

import org.springframework.security.core.userdetails.UserDetails;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.service.dto.security.UserDetailData;

public interface UserDetailService {

	public UserDetailData loadUserDetailByLogin(String username, String password) throws BottaApplicationException;
	
	public UserDetails loadUserByUsername(String username);
	
}
