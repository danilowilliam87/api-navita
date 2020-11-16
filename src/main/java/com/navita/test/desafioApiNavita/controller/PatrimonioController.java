package com.navita.test.desafioApiNavita.controller;

import com.navita.test.desafioApiNavita.dto.PatrimonioDTO;
import com.navita.test.desafioApiNavita.dto.PatrimonioResponseDTO;
import com.navita.test.desafioApiNavita.model.Patrimonio;
import com.navita.test.desafioApiNavita.repository.PatrimonioRepository;
import com.navita.test.desafioApiNavita.service.implementacao.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patrimonio")
public class PatrimonioController {

    @Autowired
    private PatrimonioService service;

    @PostMapping("/salvar")
    public ResponseEntity<PatrimonioResponseDTO> salvar(@RequestBody  PatrimonioDTO patrimonioDTO){
        Patrimonio patrimonio = service.save(patrimonioDTO.converterParaPatrimonio());
        return new ResponseEntity<>(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonio), HttpStatus.OK);
    }

    @GetMapping("/busca/{id}")
    public ResponseEntity<PatrimonioResponseDTO> buscar(@PathVariable("id") Long numeroTombo){
        Optional<Patrimonio>busca = service.findById(numeroTombo);
        return busca.map(patrimonio -> new ResponseEntity<>(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonio), HttpStatus.FOUND))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Patrimômio Não localizado"));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PatrimonioResponseDTO> atualizar(@RequestBody PatrimonioDTO patrimonioDTO,
                                                          @PathVariable("id") Long id){
        if (service.update(patrimonioDTO.converterParaPatrimonio(),id)){
            return new ResponseEntity<>(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonioDTO.
                    converterParaPatrimonio()),HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Impossível atualizar registro");
        }
    }

    @DeleteMapping("/delete/{numero}")
    public ResponseEntity<PatrimonioResponseDTO>deletar(@PathVariable("numero") Long numeroTombo){
        Optional<Patrimonio>busca = service.findById(numeroTombo);
        if (busca.isPresent()){
            service.delete(numeroTombo);
            return new ResponseEntity<>(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(busca.get()), HttpStatus.OK);
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND, "Patriõnio não encontrado");
        }
    }

    @ResponseBody
    @GetMapping("/lista")
    public List<PatrimonioResponseDTO>listarTodos(){
        List<PatrimonioResponseDTO>responseDTOS = new ArrayList<>();
        List<Patrimonio>patrimonios = new ArrayList<>();

        patrimonios = service.list();

        for(int i = 0; i < patrimonios.size(); i++){
            responseDTOS.add(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonios.get(i)));
        }
        return responseDTOS;
    }

    @ResponseBody
    @GetMapping("/lista-nome/{nome}")
    public List<PatrimonioResponseDTO>listarPorNome(@PathVariable("nome") String nome){
        List<PatrimonioResponseDTO>responseDTOS = new ArrayList<>();
        List<Patrimonio>patrimonios = new ArrayList<>();

        patrimonios = service.findAllByNomeLike(nome);
        for(int i = 0; i < patrimonios.size(); i++){
            responseDTOS.add(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonios.get(i)));
        }
        return responseDTOS;
    }

    @GetMapping("/lista-marca/{id}")
    public List<PatrimonioResponseDTO>listarPorMarca(@PathVariable("id") Long marcaId){
        List<PatrimonioResponseDTO>responseDTOS = new ArrayList<>();
        List<Patrimonio>patrimonios = new ArrayList<>();

        patrimonios = service.findAllByMarca(marcaId);

        for(int i = 0; i < patrimonios.size(); i++){
            responseDTOS.add(PatrimonioResponseDTO.converterParapatrimonioResponseDTO(patrimonios.get(i)));
        }
        return responseDTOS;
    }

}
