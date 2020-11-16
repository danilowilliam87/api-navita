package com.navita.test.desafioApiNavita.controller;

import com.navita.test.desafioApiNavita.dto.MarcaResponseDTO;
import com.navita.test.desafioApiNavita.model.Marca;
import com.navita.test.desafioApiNavita.service.implementacao.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
     private MarcaService service;

    public ResponseEntity<MarcaResponseDTO> busca(Long id){
        return null;
    }

    public ResponseEntity<MarcaResponseDTO> salvar(Marca marca){
        return null;
    }

    public ResponseEntity<Marca>atualizar(Marca marca, Long id){
        return null;
    }

    public List<Marca>listar(){
        return null;
    }

    public ResponseEntity<Marca>deletar(Long id){
        return null;
    }
}
