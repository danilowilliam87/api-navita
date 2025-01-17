package com.navita.test.desafioApiNavita.controller;

import com.navita.test.desafioApiNavita.dto.LogarDTO;
import com.navita.test.desafioApiNavita.dto.TokenDTO;
import com.navita.test.desafioApiNavita.dto.UsuarioDTO;
import com.navita.test.desafioApiNavita.dto.UsuarioResponseDTO;
import com.navita.test.desafioApiNavita.model.Usuario;
import com.navita.test.desafioApiNavita.service.implementacao.JwtService;
import com.navita.test.desafioApiNavita.service.implementacao.UserImplService;
import com.navita.test.desafioApiNavita.service.implementacao.UsuarioService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class UsuarioController {

    @Autowired
    private UsuarioService service;

    private  UserImplService userImplService;
    private  PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    @PostMapping("/usuario/salvar")
    public ResponseEntity<UsuarioResponseDTO>save(@RequestBody @Valid UsuarioDTO usuarioDTO){
        Optional<Usuario>verficarEmail = service.findByEmailLike(usuarioDTO.getEmail());
        if (verficarEmail.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"E-mail já cadastrado");
        } else {
            Usuario usuario1 = service.save(usuarioDTO.converterParaUsuario());
            return new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(usuario1), HttpStatus.CREATED);
        }
    }

    @GetMapping("/usuario/buscar/{id}")
    public ResponseEntity<UsuarioResponseDTO>getUsuarioById(@PathVariable("id") Long id){
        Optional<Usuario> usuario = service.findById(id);
        return usuario.map(value -> new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(value), HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Usuario não encontrado"));

    }

    @GetMapping("/usuario/nome/{nome}")
    public ResponseEntity<UsuarioResponseDTO>getUsuarioByNome(@PathVariable("nome") String nome){
        Optional<Usuario> usuario = service.findByNameLike(nome);
        return usuario.map(value -> new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(value), HttpStatus.OK))
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND,"usuario não encontrado"));

    }

    @GetMapping("/usuario/email/{email}")
    public ResponseEntity<UsuarioResponseDTO>getUsuarioByEmail(@PathVariable("email") String email){
        Optional<Usuario> usuario = service.findByEmailLike(email);
        return usuario.map(value -> new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(value), HttpStatus.OK))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Email não encontrado"));
    }



    @PutMapping("/usuario/atualizar/{id}")
    public ResponseEntity<UsuarioResponseDTO>updateUsuario(@RequestBody Usuario usuario, @PathVariable("id") Long id){
        boolean atualizar = service.update(usuario,id);
        Optional<Usuario>atualizado = service.findById(id);
        if (atualizar && atualizado.isPresent()){
            return new ResponseEntity<>(UsuarioResponseDTO.converterParaResponseDTO(atualizado.get()), HttpStatus.OK);
        } else {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND,"Impossível atualizar");
        }
    }

    @ResponseBody
    @GetMapping("/usuario/lista")
    public List<UsuarioResponseDTO>lista(){
        List<Usuario>usuarios = service.list();
        List<UsuarioResponseDTO>listaDto = new ArrayList<>();
        for (int i = 0; i < usuarios.size(); i++) {
            listaDto.add(UsuarioResponseDTO.converterParaResponseDTO(usuarios.get(i)));
        }
        return listaDto;
    }

    @DeleteMapping("/usuario/delete/{id}")
    public ResponseEntity<UsuarioDTO>delete(@PathVariable("id") Long id){
        if (service.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Não existe registro com esse Id");
        }
    }


    @PostMapping("/auth")
    public TokenDTO atenticacao(@RequestBody LogarDTO logarDTO){
        try {
         Usuario usuario = Usuario.builder()
                 .nome(logarDTO.getLogin())
                 .senha(logarDTO.getSenha()).build();
         UserDetails user = userImplService.autenticar(usuario);
         String token = jwtService.gerarToken(usuario);
         return new TokenDTO(usuario.getNome(), token);
        }catch (UsernameNotFoundException e){
            throw  new ResponseStatusException(HttpStatus.UNAUTHORIZED,e.getLocalizedMessage());
        }
    }


}
