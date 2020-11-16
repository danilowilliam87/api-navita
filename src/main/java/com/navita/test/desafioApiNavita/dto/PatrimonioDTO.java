package com.navita.test.desafioApiNavita.dto;

import com.navita.test.desafioApiNavita.model.Marca;
import com.navita.test.desafioApiNavita.model.Patrimonio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatrimonioDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private Marca marca;
    private String descricao;

    public Patrimonio converterParaPatrimonio(){
        return new Patrimonio(nome,marca,descricao);
    }
}
