package ch.botta.persistence.model.security;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.code.Code;
import ch.botta.persistence.model.customer.Customer;

/**
 * @author Scheiss
 *
 */
@Entity
@Table(name="T_User", schema="botta")
@SqlResultSetMapping(name="UserDetailResult", classes = {
	    @ConstructorResult(targetClass = UserDetail.class, 
	    columns = {
	    	@ColumnResult(name="id", type=Integer.class), 
	    	@ColumnResult(name="username", type=String.class),
	    	@ColumnResult(name="password", type=String.class), 
	    	@ColumnResult(name="name", type=String.class), 
	    	@ColumnResult(name="firstname", type=String.class), 
	    	@ColumnResult(name="role", type=List.class)})
	})
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class User extends BaseEntity {

	private String username;
	private String password;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_USER_CODE",
			schema="botta",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="code_id", referencedColumnName="id", nullable=false))
	private Code code;

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(
			name="T_R_USER_ROLE",
			schema="botta",
		    joinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")},
			inverseJoinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")})
	private List<Role> roleList;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Customer> customerList;

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

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
