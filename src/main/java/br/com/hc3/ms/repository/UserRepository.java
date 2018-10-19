package br.com.hc3.ms.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.hc3.ms.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
