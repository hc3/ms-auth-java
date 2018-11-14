package br.com.hc3.ms.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private boolean active;

}
