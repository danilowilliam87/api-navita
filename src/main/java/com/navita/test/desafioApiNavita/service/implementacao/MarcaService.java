package com.navita.test.desafioApiNavita.service.implementacao;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.navita.test.desafioApiNavita.model.Marca;
import com.navita.test.desafioApiNavita.repository.MarcaRepository;
import com.navita.test.desafioApiNavita.service.MarcaRn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService implements MarcaRn {

    @Autowired
    private MarcaRepository repository;

    @Override
    public Marca save(Marca marca) {
        return repository.save(marca);
    }

    @Override
    public Optional<Marca> findById(Long id) {
       return repository.findById(id);
    }

    @Override
    public Optional<Marca> findByNome(String nome) {
        return repository.findByNomeLike(nome);
    }

    @Override
    public boolean update(Marca marca, Long id) {
        Optional<Marca>busca = repository.findById(id);
        Marca nova = new Marca();
        boolean status = false;
        if (busca.isPresent()){
            nova = busca.get();
            nova.setNome(marca.getNome());
            repository.save(nova);
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(Long id) {
        boolean status = false;
        Optional<Marca>busca = repository.findById(id);
        if (busca.isPresent()){
            repository.deleteById(id);
            status = true;
        }
        return status;
    }
}
