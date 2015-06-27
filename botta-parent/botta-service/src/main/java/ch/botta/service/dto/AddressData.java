package ch.botta.service.dto;

public class AddressData {
	
	private String  street;
	private String  zip;
	private String  country;
	private String  email;
	private String  phoneNr;
	private String  mobileNr;

	
	public AddressData(String street, String zip, String country, String email, String phoneNr, String mobileNr){
		this.street = street;
		this.zip = zip;
		this.country = country;
		this.email = email;
		this.phoneNr = phoneNr;
		this.mobileNr = mobileNr;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNr() {
		return phoneNr;
	}


	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}


	public String getMobileNr() {
		return mobileNr;
	}


	public void setMobileNr(String mobileNr) {
		this.mobileNr = mobileNr;
	}
	
}
