package com.desafiofullstackviceri.controllers;

import com.desafiofullstackviceri.model.Heroi;
import com.desafiofullstackviceri.services.HeroiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path ="/herois", produces = MediaType.APPLICATION_JSON_VALUE)
public class HeroiController {

    @Autowired
    private HeroiService heroiService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrarHeroi(@RequestBody Heroi heroi) {
        heroiService.cadastrarHeroi(heroi);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Heroi>> listarHerois() {
        List<Heroi> herois = heroiService.listarHerois();
        return ResponseEntity.ok(herois);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Heroi> buscarHeroiPorId(@PathVariable Integer id) {
        Heroi heroi = heroiService.buscarHeroiPorId(id);
        return ResponseEntity.ok(heroi);
    }

    @PutMapping("/atualizar/{id}")
    public int atualizarHeroi(@PathVariable Integer id, @RequestBody Heroi heroi,
                              @RequestParam(required = false) Set<Integer> idsSuperpoderes) {

        int heroiRetorno = heroiService.atualizarHeroi(id, heroi, idsSuperpoderes);
        return heroiRetorno;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarHeroi(@PathVariable Integer id) {
        heroiService.deletarHeroi(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(RuntimeException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}
