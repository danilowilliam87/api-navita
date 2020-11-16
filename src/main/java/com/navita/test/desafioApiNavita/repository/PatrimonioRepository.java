package com.navita.test.desafioApiNavita.repository;

import com.navita.test.desafioApiNavita.model.Patrimonio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatrimonioRepository extends JpaRepository<Patrimonio, Long> {

    public List<Patrimonio>findByNomeLike(String nome);;
    @Query(value = "from Patrimonio p where p.marca.id =:marcaId")
    public List<Patrimonio>findAllByMarca(@Param("marcaId") Long marcaId);

    @Query(value = "select * from Patrimonio p where p.marca.nome like ':nome%'",nativeQuery = true)
    public List<Patrimonio>findAllByNomeLike(@Param("nome") String nome);


}
