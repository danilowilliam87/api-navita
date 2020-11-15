package com.navita.test.desafioApiNavita.repository;

import com.navita.test.desafioApiNavita.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

    public Optional<Patrimonio>findByMarca(String marca);
}
