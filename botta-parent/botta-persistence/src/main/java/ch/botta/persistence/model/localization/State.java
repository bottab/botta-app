package ch.botta.persistence.model.localization;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.customer.Contact;

@Entity
@Table(name="T_State", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class State  extends BaseEntity{

	private String state;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_STATE_COUNTRY",
			schema="botta",
			joinColumns = @JoinColumn(name="state_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="country_id", referencedColumnName="id", nullable=false))
	private Country country;
	
	@OneToMany(mappedBy="state", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Contact> contactList;
	
	@OneToMany(mappedBy="state", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Region> regionList;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<Region> getRegionList() {
		return regionList;
	}

	public void setRegionList(List<Region> regionList) {
		this.regionList = regionList;
	}

}
