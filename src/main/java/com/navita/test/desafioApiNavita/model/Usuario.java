package com.navita.test.desafioApiNavita.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "usuario")
public class Usuario {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     @Column(nullable = false)
     private String nome;
     @Column(nullable = false, unique = true)
     private String email;
     @Column(nullable = false)
     private String senha;

     //construtor para ser usado no DTO
     public Usuario(String nome, String email, String senha){
          this.nome = nome;
          this.email = email;
          this.senha = senha;
     }


}
