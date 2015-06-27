package ch.botta.persistence.model.code;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.customer.Contact;
import ch.botta.persistence.model.customer.Customer;
import ch.botta.persistence.model.customer.CustomerInfo;
import ch.botta.persistence.model.security.User;

@Entity
@Table(name="T_Code", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Code extends BaseEntity{

	private String type;
	private String value;

	@OneToMany(mappedBy="code", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	List<CustomerInfo> customerInfoList;
	
	@OneToMany(mappedBy="code", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	List<Customer> customerList;
	
	@OneToMany(mappedBy="code", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	List<Contact> contactList;
	
	@OneToMany(mappedBy="code", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	List<User> userList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<CustomerInfo> getCustomerInfoList() {
		return customerInfoList;
	}

	public void setCustomerInfoList(List<CustomerInfo> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
}
