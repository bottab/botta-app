package ch.botta.service.dto;

import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import ch.botta.persistence.model.security.User;

@XmlRootElement
public class UserData {

	private Integer id;
	private String firstname;
	private String name;
	private Date birthdate;
	private Timestamp optlock;
	
	public UserData(){};
	
	public UserData(String firstname, String lastname, Date birthdate){
		firstname = this.firstname;
		lastname = this.name;
		birthdate = this.birthdate;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Timestamp getOptlock() {
		return optlock;
	}

	public void setOptlock(Timestamp optlock) {
		this.optlock = optlock;
	}

	public void mapUser(User user){

	}
	
}
