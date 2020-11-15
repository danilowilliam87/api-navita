package com.navita.test.desafioApiNavita.controller;

import com.navita.test.desafioApiNavita.dto.UsuarioDTO;
import com.navita.test.desafioApiNavita.dto.UsuarioResponseDTO;
import com.navita.test.desafioApiNavita.model.Usuario;
import com.navita.test.desafioApiNavita.service.implementacao.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/save")
    public ResponseEntity<UsuarioResponseDTO>save(@RequestBody @Valid UsuarioDTO usuarioDTO){
        Usuario usuario1 = service.save(usuarioDTO.converterParaUsuario());
        return new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(usuario1), HttpStatus.CREATED);
    }
}
