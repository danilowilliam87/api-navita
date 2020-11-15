package com.navita.test.desafioApiNavita.repository;

import com.navita.test.desafioApiNavita.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
    public Optional<Marca>findByNome(String nome);
}
