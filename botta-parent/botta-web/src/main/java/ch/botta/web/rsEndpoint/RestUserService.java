package ch.botta.web.rsEndpoint;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ch.botta.persistence.exception.BottaApplicationException;
import ch.botta.service.UserDetailService;
import ch.botta.service.UserService;
import ch.botta.service.dto.UserData;
import ch.botta.service.dto.security.UserDetailData;

@RestController("restUserServiceController")
@RequestMapping("/rest")
public class RestUserService {

	private final UserService userService;
	private final UserDetailService userDetailService;
	
	@Inject
	public RestUserService(UserService userService, UserDetailService userDetailService) {
		this.userService = userService;
		this.userDetailService = userDetailService;
	}

    /**
     * GET ALL
     * @return {@link List<UserData>}
     */
    @RequestMapping(value="/users", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public ResponseEntity<List<UserData>> getAllUsers() {
        List<UserData> userDataList = userService.findAllUsers();
        if(userDataList.size() > 0){
        	return new ResponseEntity<List<UserData>>(userDataList, HttpStatus.OK);
        }
        	return new ResponseEntity<List<UserData>>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value="/user/{username}/{password}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public ResponseEntity<UserDetailData> authenticatedUser(@PathVariable("username") String username, @PathVariable("password") String password){
		try {
			UserDetailData userDetailData = userDetailService.loadUserDetailByLogin(username, password);
			return new ResponseEntity<UserDetailData>(userDetailData, HttpStatus.OK);
		} catch (BottaApplicationException e) {
			return new ResponseEntity<UserDetailData>(HttpStatus.NOT_FOUND);
		}
    }

    /**
     * GET by ID
     * @param id
     * @return {@link UserData}
     */
    @RequestMapping(value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
    public ResponseEntity<UserData> getUserById(@PathVariable("id") int id) {
    	UserData userData = userService.findUserById(id);
    	if(userData != null){
    		return new ResponseEntity<UserData>(userData, HttpStatus.OK);
    	}
    	return new ResponseEntity<UserData>(HttpStatus.NOT_FOUND);
    }

    /**
     * PUT
     * @param id
     * @param userData
     * @return {@link UserData}
     */
    @RequestMapping(value="/users/{id}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.PUT)
    public ResponseEntity<UserData> updateUser(@PathVariable ("id") int id, @RequestBody UserData userData) {
        try{
        	UserData newUserData = userService.updateUser(userData);
        	return new ResponseEntity<UserData>(newUserData, HttpStatus.OK);
        }catch(BottaApplicationException e){
        	return new ResponseEntity<UserData>(HttpStatus.NOT_MODIFIED);
        }
    }

    /**
     * DELETE
     * @param id
     * @return {@link String}
     */
    @RequestMapping(value="/users/{id}", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.DELETE)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        try{
        	userService.deleteUser(id);
        	return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }catch(BottaApplicationException e){
        	return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
        }
    }
    
    /**
     * POST
     * @param userData
     * @return {@link UserData}
     */
    @RequestMapping(value="/users", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public UserData createUser(@RequestBody UserData userData){
    	UserData newUserData = userService.createUser(userData);
    	return newUserData;
    }
    
}
