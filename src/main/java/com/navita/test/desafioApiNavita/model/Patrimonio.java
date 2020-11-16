package com.navita.test.desafioApiNavita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "patrimonio")
public class Patrimonio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_tombo")
    private Long numeroTombo;
    @Column(nullable = false)
    private String nome;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Patrimonio(String nome, Marca marca, String descricao){
        this.nome = nome;
        this.marca = marca;
        this.descricao = descricao;
    }

}
