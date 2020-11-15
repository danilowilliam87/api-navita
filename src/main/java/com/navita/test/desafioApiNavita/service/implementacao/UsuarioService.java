package com.navita.test.desafioApiNavita.service.implementacao;

import com.navita.test.desafioApiNavita.model.Usuario;
import com.navita.test.desafioApiNavita.repository.UsuarioRepository;
import com.navita.test.desafioApiNavita.service.UsuarioRn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class UsuarioService implements UsuarioRn {

    @Autowired
    private UsuarioRepository repository;


    @Override
    public Usuario save(Usuario usuario) {
        Optional<Usuario>buscaporEmail = repository.findByEmail(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        Optional<Usuario>busca =  repository.findById(id);
        Usuario usuario = new Usuario();
        if(busca.isPresent()) {
            usuario = busca.get();
        }
        return usuario;
    }

    @Override
    public List<Usuario> list() {
        return repository.findAll();
    }

    @Override
    public Usuario findByName(String nome) {
         Optional<Usuario>busca = repository.findByNome(nome);
         Usuario usuario = new Usuario();
         if (busca.isPresent()){
             usuario = busca.get();
         }
         return usuario;
    }

    @Override
    public Usuario findByEmail(String email) {
        Usuario usuario = new Usuario();
        Optional<Usuario>busca = repository.findByEmail(email);
        if (busca.isPresent()){
            usuario = busca.get();
        }
        return usuario;
    }

    @Override
    public Usuario update(Usuario usuario, Long id) {
        Optional<Usuario>busca = repository.findById(id);
        Usuario atualizar = new Usuario();
        if (busca.isPresent()){
            atualizar = busca.get();
            atualizar.setNome(usuario.getNome());
            atualizar.setEmail(usuario.getEmail());
            atualizar.setSenha(usuario.getSenha());

        }
        return repository.save(atualizar);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
