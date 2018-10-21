package br.com.hc3.ms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping
    public void save() {

    }

	@GetMapping
	public String home() {
	    return "{id:1,name:teste,idade:10}";
	}
}
