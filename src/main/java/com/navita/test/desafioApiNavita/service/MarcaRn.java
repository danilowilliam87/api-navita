package com.navita.test.desafioApiNavita.service;

import com.navita.test.desafioApiNavita.dto.MarcaDTO;
import com.navita.test.desafioApiNavita.dto.PatrimonioDTO;
import com.navita.test.desafioApiNavita.model.Marca;
import com.navita.test.desafioApiNavita.model.Patrimonio;

import java.util.List;
import java.util.Optional;

public interface MarcaRn {

    public Marca save(Marca marca);
    public Optional<Marca>findById(Long id);
    public Optional<Marca>findByNome(String nome);
    public boolean update(Marca marca, Long id);
    public boolean delete(Long id);

}
