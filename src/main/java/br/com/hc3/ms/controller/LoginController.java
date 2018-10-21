package br.com.hc3.ms.controller;

import br.com.hc3.ms.dto.UserLoginFormDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/v1/login")
    public UserLoginFormDTO login(@RequestBody UserLoginFormDTO user) {
        return user;
    }

    @GetMapping("/v1/check-token")
    public Boolean checkToken() {
        return false;
    }

}
