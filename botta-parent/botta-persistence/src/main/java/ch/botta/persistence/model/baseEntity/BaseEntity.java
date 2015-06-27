package ch.botta.persistence.model.baseEntity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity implements Serializable{

	/**
	 * This is the base Entity for all Entities
	 */
	private static final long serialVersionUID = 855753365921935410L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "botta_gen")
	private Integer id;
	
	@Version
    private Timestamp optlock;

	public Integer getId() {
		return id;
	}

	public Timestamp getOptlock() {
		return optlock;
	}
	
}
