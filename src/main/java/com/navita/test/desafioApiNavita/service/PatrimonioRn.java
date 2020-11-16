package com.navita.test.desafioApiNavita.service;

import com.navita.test.desafioApiNavita.dto.PatrimonioDTO;
import com.navita.test.desafioApiNavita.model.Patrimonio;

import java.util.List;
import java.util.Optional;

public interface PatrimonioRn {

    public Patrimonio save(Patrimonio patrimonio);
    public Optional<Patrimonio> findById(Long numeroTombo);
    public List<Patrimonio>list();
    public List<Patrimonio> findByMarca(String marca);
    public boolean update(Patrimonio patrimonio, Long numeroTombo);
    public boolean delete(Long numeroTombo);
    public List<Patrimonio>findByNomeLike(String nome);
}
