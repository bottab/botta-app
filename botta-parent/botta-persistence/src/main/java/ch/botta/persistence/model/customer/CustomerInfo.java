package ch.botta.persistence.model.customer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import ch.botta.persistence.model.baseEntity.BaseEntity;
import ch.botta.persistence.model.code.Code;

@Entity
@Table(name="T_Customer_Info", schema="botta")
@SequenceGenerator(name = "botta_gen", sequenceName = "botta_sequence", allocationSize = 1)
public class CustomerInfo extends BaseEntity{

	private String infoPrivate;
	private String infoPublic;
	private String sponsor;

	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name="T_R_CUSTOMER_INFO_CODE",
			schema="botta",
			joinColumns = @JoinColumn(name="customer_info_id", referencedColumnName="id", nullable=false),
			inverseJoinColumns = @JoinColumn(name="code_id", referencedColumnName="id", nullable=false))
	private Code code;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Customer customer;

	public String getInfoPrivate() {
		return infoPrivate;
	}

	public void setInfoPrivate(String infoPrivate) {
		this.infoPrivate = infoPrivate;
	}

	public String getInfoPublic() {
		return infoPublic;
	}

	public void setInfoPublic(String infoPublic) {
		this.infoPublic = infoPublic;
	}

	public String getSponsor() {
		return sponsor;
	}

	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
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
