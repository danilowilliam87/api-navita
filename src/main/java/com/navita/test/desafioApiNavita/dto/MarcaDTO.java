package com.navita.test.desafioApiNavita.dto;

import com.navita.test.desafioApiNavita.model.Marca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaDTO {
    @NotBlank
    private String nome;

}
