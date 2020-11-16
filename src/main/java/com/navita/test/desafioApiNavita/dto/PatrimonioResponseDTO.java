package com.navita.test.desafioApiNavita.dto;

import com.navita.test.desafioApiNavita.model.Patrimonio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioResponseDTO {
    private Long numeroTombo;
    private String nome;
    private String descricao;
    private String marca;

    public static PatrimonioResponseDTO converterParapatrimonioResponseDTO(Patrimonio patrimonio){
        return new PatrimonioResponseDTO(patrimonio.getNumeroTombo(),
                patrimonio.getNome(),
                patrimonio.getDescricao(),
                patrimonio.getMarca().getNome());
    }
}
