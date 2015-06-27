package ch.botta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.persistence.model.security.User;
import ch.botta.persistence.repositories.UserRepository;
import ch.botta.service.UserService;
import ch.botta.service.dto.UserData;

@Service("userService")
@Transactional
public class DefaultUserService implements UserService{

	
	private final UserRepository userRepository;
	
	@Inject
	public DefaultUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserData updateUser(UserData userData) throws BottaApplicationException {
			User user = userRepository.findOne(userData.getId());
			if(user == null){
				throw new BottaApplicationException("No User found to update with id: " + userData.getId());
			}
			user = mapUserDataToUpdateUserEntity(userData, user);
			user = userRepository.saveAndFlush(user);
			UserData newUserData = new UserData();
			newUserData.mapUser(user);
			return newUserData;
	}

	@Override
	public void deleteUser(Integer id) throws BottaApplicationException {
		try{
			userRepository.delete(id);
		}catch(EmptyResultDataAccessException e){
			throw new BottaApplicationException(e.getMessage(), e.getCause());
		}
		
	}

	@Override
	public UserData findUserById(Integer id) {
		User user = userRepository.findOne(id);
		if(user == null){
			return null;
		}
		UserData userData = new UserData();
		userData.mapUser(user);
    	return userData;
	}

	@Override
	public List<UserData> findAllUsers() {
		List<User> userList = userRepository.findAll();
		return mapUserListToUserDataList(userList);
	}
	
	private List<UserData> mapUserListToUserDataList(List<User> userList){
		List<UserData> userDataList = new ArrayList<UserData>();
		for(User user: userList){
			UserData userData = new UserData();
			userData.mapUser(user);
			userDataList.add(userData);
		}
		return userDataList;
	}
	
	private User mapUserDataToNewUserEntity(UserData userData){
		User user = new User();
		return user;
	}
	
	private User mapUserDataToUpdateUserEntity(UserData userData, User user){
		return user;
	}
	
	

	@Override
	public UserData createUser(UserData userData) {
		User user = mapUserDataToNewUserEntity(userData);
		user = userRepository.saveAndFlush(user);
		UserData newUserData = new UserData();
		newUserData.mapUser(user);
		return newUserData;
	}

}
