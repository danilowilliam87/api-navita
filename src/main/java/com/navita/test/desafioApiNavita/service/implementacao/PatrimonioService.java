package com.navita.test.desafioApiNavita.service.implementacao;

import com.navita.test.desafioApiNavita.model.Patrimonio;
import com.navita.test.desafioApiNavita.repository.PatrimonioRepository;
import com.navita.test.desafioApiNavita.service.PatrimonioRn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrimonioService implements PatrimonioRn {

    @Autowired
    PatrimonioRepository repository;

    @Override
    public Patrimonio save(Patrimonio patrimonio) {
        return repository.save(patrimonio);
    }

    @Override
    public Patrimonio findById(Long numero_tombo) {
        Optional<Patrimonio>busca = repository.findById(numero_tombo);
        Patrimonio patrimonio = new Patrimonio();
        if (busca.isPresent()){
            patrimonio = busca.get();
        }
        return patrimonio;
    }

    @Override
    public List<Patrimonio> list() {
        return repository.findAll();
    }

    @Override
    public Patrimonio findByMarca(String marca) {
        Optional<Patrimonio>busca = repository.findByMarca(marca);
        Patrimonio patrimonio = new Patrimonio();
        if (busca.isPresent()){
            patrimonio = busca.get();
        }
        return patrimonio;
    }

    @Override
    public Patrimonio update(Patrimonio patrimonio, Long numeroTombo) {
        Optional<Patrimonio>busca = repository.findById(numeroTombo);
        Patrimonio patrimonio1 = new Patrimonio();
        if (busca.isPresent()){
            patrimonio1.setNome(patrimonio.getNome());
            patrimonio1.setMarca(patrimonio.getMarca());
            patrimonio1.setDescricao(patrimonio.getDescricao());
            repository.save(patrimonio1);
        }
        return patrimonio1;
    }

    @Override
    public void delete(Long numeroTombo) {
        repository.deleteById(numeroTombo);
    }
}
