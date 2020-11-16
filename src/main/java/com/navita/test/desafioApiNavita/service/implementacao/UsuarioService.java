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
        Optional<Usuario>buscaporEmail = repository.findByEmailLike(usuario.getEmail());
        return repository.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Usuario> list() {
        return repository.findAll();
    }

    @Override
    public Optional<Usuario> findByNameLike(String nome) {
         return repository.findByNomeLike(nome);
    }

    @Override
    public Optional<Usuario> findByEmailLike(String email) {
        return repository.findByEmailLike(email);
    }

    @Override
    public boolean update(Usuario usuario, Long id) {
        boolean status = false;
        Optional<Usuario>busca = repository.findById(id);
        Usuario atualizar = new Usuario();
        if (busca.isPresent()){
            atualizar = busca.get();
            atualizar.setNome(usuario.getNome());
            atualizar.setEmail(usuario.getEmail());
            atualizar.setSenha(usuario.getSenha());
            repository.save(atualizar);
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(Long id) {
        boolean status = false;
        Optional<Usuario>busca = repository.findById(id);
        if (busca.isPresent()){
            repository.deleteById(id);
            status = true;
        }
        return status;
    }
}
