package com.desafiofullstackviceri.services;

import com.desafiofullstackviceri.model.Superpoder;
import com.desafiofullstackviceri.repositories.SuperpoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperpoderService {

    @Autowired
    private SuperpoderRepository superpoderRepository;

    public List<Superpoder> listarSuperpoderes() {

        List<Superpoder> superpoderes = superpoderRepository.buscarSuperpoderes();

        return superpoderes;
    }
}
