package br.com.hc3.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hc3.ms.model.Admin;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long>{

}
