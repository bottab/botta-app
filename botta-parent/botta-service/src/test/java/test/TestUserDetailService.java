package test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.service.UserDetailService;
import ch.botta.service.dto.security.UserDetailData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:ch/botta/service/internal/service-test-config.xml"})
public class TestUserDetailService {

	@Inject
	UserDetailService userDetailService;
	
	@Test
	public void testGetUserDetailByLogin() {
		
		UserDetailData userDetailData = null;
		try {
			userDetailData = userDetailService.loadUserDetailByLogin("admin", "admin");
		} catch (BottaApplicationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.notNull(userDetailData);
	}
	
	@Test
	public void testLoadUserByUsername(){
		UserDetails user = userDetailService.loadUserByUsername("admin");
		Assert.notNull(user);
	}

}
