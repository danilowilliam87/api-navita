package com.navita.test.desafioApiNavita.dto;

import com.navita.test.desafioApiNavita.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @NotBlank(message = "{nome.not.blank}")
    private String nome;
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;
    @NotBlank(message = "{senha.not.blank}")
    private String senha;

    public Usuario converterParaUsuario(){
        return new Usuario(nome,email,senha);
    }
}
