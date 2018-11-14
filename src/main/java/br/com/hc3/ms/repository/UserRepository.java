package br.com.hc3.ms.repository;

import br.com.hc3.ms.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

    User findByUsername(String username);
}
