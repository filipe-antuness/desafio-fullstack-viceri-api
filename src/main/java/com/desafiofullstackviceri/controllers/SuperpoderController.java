package com.desafiofullstackviceri.controllers;

import com.desafiofullstackviceri.model.Superpoder;
import com.desafiofullstackviceri.services.SuperpoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path ="/superpoder", produces = MediaType.APPLICATION_JSON_VALUE)
public class SuperpoderController {

    @Autowired
    private SuperpoderService superpoderService;

    @GetMapping("/listar")
    public ResponseEntity<List<Superpoder>> listarSuperpoderes() {

        List<Superpoder> superpoderes = superpoderService.listarSuperpoderes();

        return ResponseEntity.ok(superpoderes);
    }
}
