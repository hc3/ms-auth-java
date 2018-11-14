package br.com.hc3.ms.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="fk_customer")
    private Customer customer;

}
