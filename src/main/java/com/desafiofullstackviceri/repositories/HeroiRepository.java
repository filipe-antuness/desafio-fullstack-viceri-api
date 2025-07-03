package com.desafiofullstackviceri.repositories;

import com.desafiofullstackviceri.model.Heroi;
import com.desafiofullstackviceri.model.Superpoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Integer> {

    @Query(value = "SELECT * FROM Herois WHERE id = :id", nativeQuery = true)
    Heroi buscarHeroiPorId(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Herois SET " +
            "Nome = :nome, " +
            "NomeHeroi = :nomeHeroi," +
            "Altura = :altura," +
            "Peso = :peso," +
            "DataNascimento = :dataNascimento WHERE Id = :id", nativeQuery = true)
    int atualizarHeroi(@Param("id") Integer  id,
                       @Param("nome") String nome,
                       @Param("nomeHeroi") String nomeHeroi,
                       @Param("altura") float altura,
                       @Param("peso") float peso,
                       @Param("dataNascimento") LocalDateTime dataNascimento);
}
