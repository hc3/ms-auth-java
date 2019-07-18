package br.com.hc3.ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.hc3.ms.model.Bird;

@Repository
public interface BirdRepository extends CrudRepository<Bird, Long>{

}
