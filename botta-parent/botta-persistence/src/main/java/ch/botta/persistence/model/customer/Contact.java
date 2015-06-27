package ch.botta.persistence.model.customer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.code.Code;
import ch.botta.persistence.model.localization.City;
import ch.botta.persistence.model.localization.Country;
import ch.botta.persistence.model.localization.Region;
import ch.botta.persistence.model.localization.State;

@Entity
@Table(name="T_Contact", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Contact extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3693105792281670695L;
	private String street;
	private String co;
	private String phone;
	private String mobile;
	private String email;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_CUSTOMER",
			schema="botta",
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="customer_id", referencedColumnName="id", nullable=false))
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_COUNTRY",
			schema="botta",
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="country_id", referencedColumnName="id", nullable=false))
	private Country country;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_STATE", 
			schema="botta", 
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="state_id", referencedColumnName="id", nullable=false))
	private State state;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_REGION",
			schema="botta",
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="region_id", referencedColumnName="id", nullable=false))
	private Region region;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_CITY",
			schema="botta",
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="city_id", referencedColumnName="id", nullable=false))
	private City city;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CONTACT_CODE",
			schema="botta",
			joinColumns = @JoinColumn(name="contact_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="code_id", referencedColumnName="id", nullable=false))
	private Code code;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
