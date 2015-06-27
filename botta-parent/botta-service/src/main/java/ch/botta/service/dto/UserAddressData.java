/**
 * 
 */
package ch.botta.service.dto;

import java.util.List;

/**
 * @author Scheiss
 *
 */
public class UserAddressData {
	
	private List<AddressData> addressDataList;
	private UserData userData;

	public UserAddressData(UserData userData, List<AddressData> adressDataList){
		this.addressDataList = adressDataList;
		this.userData = userData;
	}

	public List<AddressData> getAddressDataList() {
		return addressDataList;
	}

	public void setAddressDataList(List<AddressData> addressDataList) {
		this.addressDataList = addressDataList;
	}

	public UserData getUserData() {
		return userData;
	}

	public void setUserData(UserData userData) {
		this.userData = userData;
	}
	
}
