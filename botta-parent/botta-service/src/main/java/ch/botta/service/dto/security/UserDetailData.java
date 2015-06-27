/**
 * 
 */
package ch.botta.service.dto.security;

import java.util.List;

public class UserDetailData {
	
	private String name;
	private String firstname;
	private String username;
	private String password;
	private List<String> roleList;
	private Integer id;
	
	public UserDetailData(){}
	
	public UserDetailData(String name, String firstname, String username, String password, List<String> roleList, Integer id){
		this.name = name;
		this.firstname = firstname;
		this.username = username;
		this.password = password;
		this.roleList = roleList;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
