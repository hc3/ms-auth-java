package br.com.hc3.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hc3.ms.dto.AdminDTO;
import br.com.hc3.ms.service.AdminService;

@RestController
@RequestMapping("/v1/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AdminDTO adminDTO) {
		return adminService.create(adminDTO);
	}
}
