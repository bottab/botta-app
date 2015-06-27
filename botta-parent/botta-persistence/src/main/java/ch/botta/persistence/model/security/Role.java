package ch.botta.persistence.model.security;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;

@Entity
@Table(name="T_Role", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Role  extends BaseEntity{

	private String role;

	@ManyToMany(mappedBy="roleList")
	private List<User> userList;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
