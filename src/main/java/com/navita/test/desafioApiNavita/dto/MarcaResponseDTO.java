package com.navita.test.desafioApiNavita.dto;

import com.navita.test.desafioApiNavita.model.Marca;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarcaResponseDTO {
    private Long id;
    private String nome;

    public static MarcaResponseDTO converterParaMarcaResponseDTO(Marca marca){
        return new MarcaResponseDTO(marca.getId(), marca.getNome());
    }
}
