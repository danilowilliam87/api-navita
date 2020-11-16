package com.navita.test.desafioApiNavita.service.implementacao;

import com.navita.test.desafioApiNavita.errors.SenhaInvalidaException;
import com.navita.test.desafioApiNavita.model.Usuario;
import com.navita.test.desafioApiNavita.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserImplService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService service;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Usuario usuario = new Usuario();
        Optional<Usuario>busca = usuarioRepository.findByNomeLike(userName);
        if (busca.isPresent()){
            usuario = busca.get();
        }
      String roles = "USER";
        return User.builder()
                .username(usuario.getNome())
                .password(passwordEncoder.encode(usuario.getSenha()))
                .roles(roles)
                .build();
    }

    public UserDetails autenticar(Usuario usuario){
        UserDetails user = loadUserByUsername(usuario.getNome());
        boolean verficarSenha = passwordEncoder.matches(usuario.getSenha(), user.getPassword());

        if (verficarSenha){
            return user;
        } else {
            throw new SenhaInvalidaException("senha não está correta");
        }
    }
}
