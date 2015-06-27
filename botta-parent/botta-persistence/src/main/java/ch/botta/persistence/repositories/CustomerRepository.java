package ch.botta.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.botta.persistence.model.customer.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
}
