package br.com.hc3.ms.controller;

import br.com.hc3.ms.dto.CustomerDTO;
import br.com.hc3.ms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CustomerDTO dto) {
        return customerService.create(dto);
    }

    @PutMapping("/{id}")
    public CustomerDTO edit(@RequestBody CustomerDTO customerDTO, @RequestParam Long id) { return null; }

    @GetMapping("/{id}")
    public CustomerDTO getOne(@RequestParam Long id) { return null; }

    @PutMapping("/desactive/{id}")
    public ResponseEntity<?> desactive(@RequestParam Long id) { return null; }

    @PutMapping("/active/{id}")
    public ResponseEntity<?> active(@RequestParam Long id) { return null; }
}
