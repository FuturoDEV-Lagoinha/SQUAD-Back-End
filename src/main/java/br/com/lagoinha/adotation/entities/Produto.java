package br.com.lagoinha.adotation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id")
    private Long id;

    @Column(length = 40, nullable = false)
    private String produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(length = 10, nullable = false)
    private String animal;

    @Column(length = 15, nullable = false)
    private String categoria;

}