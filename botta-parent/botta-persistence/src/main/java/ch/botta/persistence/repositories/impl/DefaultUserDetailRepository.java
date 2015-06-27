package ch.botta.persistence.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ch.botta.persistence.model.security.UserDetail;
import ch.botta.persistence.repositories.UserDetailRepository;

@Repository
public class DefaultUserDetailRepository implements UserDetailRepository{
	
	protected EntityManager entityManager;
	
	@PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDetail> findUserDetailByLogin(String username, String password){
		Query query = entityManager.createNativeQuery("select u.id, u.username, u.password, c.name, c.firstname, r.role from T_User u " +
				"inner join T_R_CUSTOMER_USER cu ON u.id = cu.user_id inner join T_CUSTOMER c ON c.id = cu.customer_id " +
				"inner join T_R_USER_ROLE ur ON u.id = ur.USER_ID inner join T_ROLE r ON r.id = ur.ROLE_ID " +
				"where u.password = ? and u.username = ?", "UserDetailResult");
		query.setParameter(1, username);
		query.setParameter(2, password);
		return query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<UserDetail> findUserDetailByUsername(String username){
		Query query = entityManager.createNativeQuery("select u.id, u.username, u.password, c.name, c.firstname, r.role from T_User u " +
				"inner join T_R_CUSTOMER_USER cu ON u.id = cu.user_id inner join T_CUSTOMER c ON c.id = cu.customer_id " +
				"inner join T_R_USER_ROLE ur ON u.id = ur.USER_ID inner join T_ROLE r ON r.id = ur.ROLE_ID " +
				"where u.username = ?", "UserDetailResult");
		query.setParameter(1, username);
		return query.getResultList();
	}
}
