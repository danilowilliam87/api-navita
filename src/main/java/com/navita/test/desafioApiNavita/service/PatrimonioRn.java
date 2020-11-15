package com.navita.test.desafioApiNavita.service;

import com.navita.test.desafioApiNavita.dto.PatrimonioDTO;
import com.navita.test.desafioApiNavita.model.Patrimonio;

import java.util.List;

public interface PatrimonioRn {

    public Patrimonio save(Patrimonio patrimonio);
    public Patrimonio findById(Long numero_tombo);
    public List<Patrimonio>list();
    public Patrimonio findByMarca(String marca);
    public Patrimonio update(Patrimonio patrimonio, Long numero_tombo);
    public void delete(Long numero_tombo);
}
