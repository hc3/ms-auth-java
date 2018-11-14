package br.com.hc3.ms.repository;

import br.com.hc3.ms.model.Customer;
import br.com.hc3.ms.model.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {

}
