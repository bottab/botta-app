package ch.botta.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.persistence.model.security.UserDetail;
import ch.botta.persistence.repositories.UserDetailRepository;
import ch.botta.persistence.repositories.UserRepository;
import ch.botta.service.UserDetailService;
import ch.botta.service.dto.security.UserDetailData;

@Service("userDetailService")
public class DefaultUserDetailService implements UserDetailService, UserDetailsService {

	
	private UserDetailRepository userDetailRepository;
	
	@Inject
	public DefaultUserDetailService(UserDetailRepository userDetailRepository, UserRepository userRepository) {
		this.userDetailRepository = userDetailRepository;
	}
	
	@Override
	public UserDetailData loadUserDetailByLogin(String username, String password) throws BottaApplicationException {
		List<UserDetail> userDetailList = userDetailRepository.findUserDetailByLogin(username, password);
		if(userDetailList.size() > 0){
			return mapUserDetailData(userDetailList);
		}
		throw new BottaApplicationException("No user found!");
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<UserDetail> userDetailList = userDetailRepository.findUserDetailByUsername(username);
		if(userDetailList.size() > 0){
			List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(UserDetail userDetail: userDetailList){
				GrantedAuthority gRole = new SimpleGrantedAuthority(userDetail.getRole());
				grantedAuthorities.add(gRole);
			}
			String password = userDetailList.get(0).getPassword();
			return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorities);
		}
		return null;
	}
	
	private UserDetailData mapUserDetailData(List<UserDetail> userDetailList){
		List<String> roleList = new ArrayList<String>();
		for(UserDetail userDetail: userDetailList){
			roleList.add(userDetail.getRole());
		}
		
		UserDetailData userDetailData = new UserDetailData();
		userDetailData.setId(userDetailList.get(0).getId());
		userDetailData.setFirstname(userDetailList.get(0).getFirstname());
		userDetailData.setName(userDetailList.get(0).getName());
		userDetailData.setRoleList(roleList);
		userDetailData.setUsername(userDetailList.get(0).getUsername());
		userDetailData.setPassword(userDetailList.get(0).getPassword());

		return userDetailData;
	}

}
