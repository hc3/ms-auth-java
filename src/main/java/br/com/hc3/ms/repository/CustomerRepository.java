package br.com.hc3.ms.repository;

import br.com.hc3.ms.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<Customer, Long> {
}
