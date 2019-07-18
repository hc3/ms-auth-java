package br.com.hc3.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hc3.ms.dto.BirdDTO;
import br.com.hc3.ms.service.BirdService;

@RestController
@RequestMapping("/v1/bird")
public class BirdController {

	@Autowired
	private BirdService birdService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BirdDTO dto) {
		return birdService.create(dto);
	}
	
	@GetMapping
	public ResponseEntity<?> list() {
		return null;
	}
}
