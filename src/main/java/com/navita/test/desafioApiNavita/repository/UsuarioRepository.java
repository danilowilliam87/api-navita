package com.navita.test.desafioApiNavita.repository;

import com.navita.test.desafioApiNavita.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Optional<Usuario> findByNome(String nome);
    public Optional<Usuario> findByEmail(String email);


}
