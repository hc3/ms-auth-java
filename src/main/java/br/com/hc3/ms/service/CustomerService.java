package br.com.hc3.ms.service;

import br.com.hc3.ms.dto.CustomerDTO;
import br.com.hc3.ms.model.Customer;
import br.com.hc3.ms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends AbstractService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Customer entity = new Customer();
    private CustomerDTO dto = new CustomerDTO();

    public ResponseEntity create(CustomerDTO dto) {
        try {
            entity = convert(dto,Customer.class);
            entity.getUser().setPassword(passwordEncoder.encode(dto.getUser().getPassword()));
            customerRepository.save(entity);
            return ResponseEntity.status(HttpStatus.OK).body(convert(entity,CustomerDTO.class));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao cadastrar usuário.");
        }
    }
}
