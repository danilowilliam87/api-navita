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
    public Optional<Patrimonio> findById(Long numeroTombo) {
           return repository.findById(numeroTombo);
    }

    @Override
    public List<Patrimonio> list() {
        return repository.findAll();
    }

    @Override
    public List<Patrimonio> findByMarca(String marca) {
        return repository.findAllByMarcaLike(marca);
    }

    @Override
    public boolean update(Patrimonio patrimonio, Long numeroTombo) {
        Optional<Patrimonio>busca = repository.findById(numeroTombo);
        Patrimonio patrimonio1 = new Patrimonio();
        boolean status = false;
        if (busca.isPresent()){
            patrimonio1.setNome(patrimonio.getNome());
            patrimonio1.setMarca(patrimonio.getMarca());
            patrimonio1.setDescricao(patrimonio.getDescricao());
            repository.save(patrimonio1);
            status = true;
        }
        return status;
    }

    @Override
    public boolean delete(Long numeroTombo) {
        Optional<Patrimonio>busca = repository.findById(numeroTombo);
        boolean status = false;
        if (busca.isPresent()){
            repository.deleteById(numeroTombo);
            status = true;
        }
        return status;
    }


    @Override
    public List<Patrimonio> findByNomeLike(String nome) {
        return repository.findByNomeLike(nome);
    }
}
