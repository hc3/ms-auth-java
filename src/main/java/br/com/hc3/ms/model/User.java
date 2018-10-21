package br.com.hc3.ms.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String nickName;
	
	private String email;
	
	private String password;

	public User() {

	}

	public User(String nickName, String email, String password) {
		super();
		this.nickName = nickName;
		this.email = email;
		this.password = password;
	}

}
