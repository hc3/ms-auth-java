package br.com.hc3.ms.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private List<Dog> dogs;
}
