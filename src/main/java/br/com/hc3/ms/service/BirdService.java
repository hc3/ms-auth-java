package br.com.hc3.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hc3.ms.dto.BirdDTO;
import br.com.hc3.ms.model.Bird;
import br.com.hc3.ms.repository.BirdRepository;

@Service
public class BirdService extends AbstractService {

	@Autowired
	private BirdRepository birdRepository;
	
	public ResponseEntity<?> create(BirdDTO dto) {
		try {
			Bird entity = new Bird();
			entity = convert(dto, Bird.class);
			birdRepository.save(entity);
			return ResponseEntity.status(HttpStatus.OK).body(convert(entity,BirdDTO.class));
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar pássaro.");
		}
	}
}
