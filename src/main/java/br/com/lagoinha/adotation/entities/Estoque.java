package br.com.lagoinha.adotation.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estoque_id")
    private Long id;

    @Column(length = 15, nullable = false)
    private String nome_estoque;

    @Column(length = 10, nullable = false)
    private String animal;

}
