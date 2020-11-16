package com.navita.test.desafioApiNavita.controller;

import com.navita.test.desafioApiNavita.dto.MarcaResponseDTO;
import com.navita.test.desafioApiNavita.model.Marca;
import com.navita.test.desafioApiNavita.service.implementacao.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
     private MarcaService service;

    @GetMapping("/marca/{id}")
    public ResponseEntity<MarcaResponseDTO> busca(@PathVariable("id") Long id){
        Optional<Marca>busca = service.findById(id);
        return busca.map(valor -> new ResponseEntity<MarcaResponseDTO>
                (MarcaResponseDTO.converterParaMarcaResponseDTO(valor),HttpStatus.OK)
        ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"marca não encontrada"));
    }

    @PostMapping("/salvar")
    public ResponseEntity<MarcaResponseDTO> salvar(@RequestBody Marca marca){
        Optional<Marca>busca = service.findByNome(marca.getNome());
        if (busca.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Já existe uma Marca com esse nome");
        } else {
            Marca marca1 = service.save(marca);
            return new ResponseEntity<>(MarcaResponseDTO.converterParaMarcaResponseDTO(marca1),HttpStatus.OK);
        }

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/marca/{id}")
    public ResponseEntity<MarcaResponseDTO> atualizar(@RequestBody Marca marca, @PathVariable("id") Long id){
        if(service.update(marca, id)){
           return new ResponseEntity<MarcaResponseDTO>(MarcaResponseDTO.converterParaMarcaResponseDTO(marca),HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Impossível atualizar");
        }

    }

    @GetMapping("/lista")
    @ResponseBody
    public List<MarcaResponseDTO>listar(){
        List<Marca>marcas = service.findAll();
        List<MarcaResponseDTO>dtos = new ArrayList<>();
        for (Marca marca : marcas) {
            dtos.add(MarcaResponseDTO.converterParaMarcaResponseDTO(marca));
        }
        return dtos;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<MarcaResponseDTO> deletar(Long id){
        if(service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Inpossível deletar registro");
        }
    }
}
