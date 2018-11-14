package br.com.hc3.ms.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private String latitude;
    private String longitude;
}
