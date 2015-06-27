package ch.botta.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.botta.persistence.model.security.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
