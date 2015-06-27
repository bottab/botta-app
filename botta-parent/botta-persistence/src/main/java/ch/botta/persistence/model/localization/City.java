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
@Table(name="T_City", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class City extends BaseEntity{

	private String city;
	private String zip;

	@OneToMany(mappedBy="city", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Contact> contactList;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CITY_REGION",
			schema="botta",
			joinColumns = @JoinColumn(name="city_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="region_id", referencedColumnName="id", nullable=false))
	private Region region;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
