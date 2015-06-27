package ch.botta.service;

import java.util.List;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.service.dto.UserData;

public interface UserService {
	
	public UserData updateUser(UserData userData) throws BottaApplicationException;;
	
	public void deleteUser(Integer id) throws BottaApplicationException;
	
	public UserData findUserById(Integer id);
	
	public List<UserData> findAllUsers();
	
	public UserData createUser(UserData userData);
	
}
