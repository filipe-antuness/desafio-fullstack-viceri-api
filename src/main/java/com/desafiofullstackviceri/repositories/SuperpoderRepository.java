package com.desafiofullstackviceri.repositories;

import com.desafiofullstackviceri.model.Superpoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperpoderRepository extends JpaRepository<Superpoder, Integer> {

    @Query(value = "SELECT * FROM Superpoderes", nativeQuery = true)
    List<Superpoder> buscarSuperpoderes();
}
