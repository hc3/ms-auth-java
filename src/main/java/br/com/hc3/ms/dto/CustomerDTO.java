package br.com.hc3.ms.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {

    private Long id;
    private UserDTO user;
    private List<DogDTO> dogs;
}
