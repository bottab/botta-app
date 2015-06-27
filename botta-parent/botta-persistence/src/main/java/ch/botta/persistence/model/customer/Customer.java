package ch.botta.persistence.model.customer;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.code.Code;
import ch.botta.persistence.model.security.User;

@Entity
@Table(name="T_Customer", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Customer extends BaseEntity{

	private String name;
	private String firstname;
	private String gender;
	private Date birthdate;
	private String titel;
	private String nationality;
	private String type;
	
	// customer Status
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CUSTOMER_CODE",
			schema="botta",
			joinColumns = @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="code_id", referencedColumnName="id", nullable=false))
	private Code code;

	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Contact> contactList;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CUSTOMER_USER",
			schema="botta",
			joinColumns = @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="user_id", referencedColumnName="id", nullable=false))
	private User user;
	
	@OneToOne(mappedBy="customer", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	@JoinTable(
			name="T_R_CUSTOMER_CUSTOMER_INFO",
			schema="botta",
			joinColumns = @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="customer_info_id", referencedColumnName="id", nullable=false))
	private CustomerInfo customerInfo;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

}
