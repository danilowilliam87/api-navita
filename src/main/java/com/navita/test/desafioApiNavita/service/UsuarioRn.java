package com.navita.test.desafioApiNavita.service;

import com.navita.test.desafioApiNavita.dto.UsuarioDTO;
import com.navita.test.desafioApiNavita.dto.UsuarioResponseDTO;
import com.navita.test.desafioApiNavita.model.Usuario;

import java.util.List;

public interface UsuarioRn {

    public Usuario save(Usuario usuario);
    public Usuario findById(Long id);
    public List<Usuario>list();
    public Usuario findByName(String nome);
    public Usuario findByEmail(String email);
    public void delete(Long id);
    public Usuario update(Usuario usuario,Long id);
    //public boolean login(Usuario usuario);
}
