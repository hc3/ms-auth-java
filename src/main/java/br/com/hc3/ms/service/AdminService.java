package br.com.hc3.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.hc3.ms.dto.AdminDTO;
import br.com.hc3.ms.model.Admin;
import br.com.hc3.ms.repository.AdminRepository;

public class AdminService extends AbstractService {

	@Autowired
	private AdminRepository adminRepository;
	
	public ResponseEntity<?> create(AdminDTO dto) {
		try {
			Admin entity = new Admin();
			entity = convert(dto, Admin.class);
			adminRepository.save(entity);
			return ResponseEntity.status(HttpStatus.OK).body(convert(entity, AdminDTO.class));
		} catch(Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar usuário.");
		}
	}
}
