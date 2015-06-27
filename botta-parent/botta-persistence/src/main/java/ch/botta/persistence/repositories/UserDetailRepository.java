package ch.botta.persistence.repositories;

import java.util.List;

import ch.botta.persistence.model.security.UserDetail;

public interface UserDetailRepository {

	public List<UserDetail> findUserDetailByLogin(String username, String password);
	
	public List<UserDetail> findUserDetailByUsername(String username);
	
}
