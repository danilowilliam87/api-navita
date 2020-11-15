package com.navita.test.desafioApiNavita.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioDTO {
    private String nome;
    private String marca;
    private String descricao;
}
