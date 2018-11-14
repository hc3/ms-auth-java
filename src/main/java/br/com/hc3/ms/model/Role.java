package br.com.hc3.ms.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String access;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
