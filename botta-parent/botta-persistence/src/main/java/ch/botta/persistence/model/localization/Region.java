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
@Table(name="T_Region", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Region extends BaseEntity {

	private String region;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_REGION_STATE",
			schema="botta",
			joinColumns = @JoinColumn(name="region_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="state_id", referencedColumnName="id", nullable=false))
	private State state;
	
	@OneToMany(mappedBy="region", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Contact> contactList;
	
	@OneToMany(mappedBy="region", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<City> cityList;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

}
