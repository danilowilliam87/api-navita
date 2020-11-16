package com.navita.test.desafioApiNavita.service;

import com.navita.test.desafioApiNavita.dto.UsuarioDTO;
import com.navita.test.desafioApiNavita.dto.UsuarioResponseDTO;
import com.navita.test.desafioApiNavita.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRn {

    public Usuario save(Usuario usuario);
    public Optional<Usuario> findById(Long id);
    public List<Usuario>list();
    public Optional<Usuario> findByNameLike(String nome);
    public Optional<Usuario> findByEmailLike(String email);
    public boolean delete(Long id);
    public boolean update(Usuario usuario,Long id);
    //public boolean login(Usuario usuario);
}
