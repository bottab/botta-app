package ch.botta.persistence.model.localization;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.customer.Contact;

@Entity
@Table(name="T_Country", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class Country extends BaseEntity {

	private String country;

	@OneToMany(mappedBy="country", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<Contact> contactList;
	
	@OneToMany(mappedBy="country", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private List<State> stateList;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Contact> getContactList() {
		return contactList;
	}

	public void setContactList(List<Contact> contactList) {
		this.contactList = contactList;
	}

	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

}
