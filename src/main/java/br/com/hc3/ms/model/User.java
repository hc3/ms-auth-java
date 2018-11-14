package br.com.hc3.ms.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private boolean active;

	@ManyToMany
	@JoinTable(
			name="users_roles",
			joinColumns = @JoinColumn(name="user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="role_id", referencedColumnName = "id")
	)
	private List<Role> roles;

}
