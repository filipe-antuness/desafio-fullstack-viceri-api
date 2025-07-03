package com.desafiofullstackviceri.services;

import com.desafiofullstackviceri.model.Heroi;
import com.desafiofullstackviceri.model.Superpoder;
import com.desafiofullstackviceri.repositories.HeroiRepository;
import com.desafiofullstackviceri.repositories.SuperpoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HeroiService {

    @Autowired
    private HeroiRepository repository;

    @Autowired
    private SuperpoderRepository superpoderRepository;

    public String cadastrarHeroi(Heroi heroi) {
        if (heroi.getSuperpoderes() != null) {
            List<Superpoder> superpoderesGerenciados = new ArrayList<>();
            for (Superpoder sp : heroi.getSuperpoderes()) {
                Superpoder gerenciado = superpoderRepository.findById(sp.getId())
                        .orElseThrow(() -> new RuntimeException("Superpoder não encontrado: " + sp.getId()));
                superpoderesGerenciados.add(gerenciado);
            }
            heroi.setSuperpoderes(new HashSet<>(superpoderesGerenciados));
        }
        repository.save(heroi);
        return "Herói cadastrado com sucesso!";
    }

    public List<Heroi> listarHerois() {
        List<Heroi> herois = repository.findAll();
        if (herois == null || herois.isEmpty()) {
            throw new RuntimeException("Nenhum herói encontrado!");
        }
        return herois;
    }

    public Heroi buscarHeroiPorId(Integer id) {
        validarId(id);
        Heroi heroi = repository.buscarHeroiPorId(id);
        if (heroi == null) {
            throw new RuntimeException("Herói não encontrado!");
        }
        return heroi;
    }

    public int atualizarHeroi(Integer id, Heroi heroi, Set<Integer> idsSuperpoderes) {

        validarId(id);

        int heroiExistente = repository.atualizarHeroi(id, heroi.getNome(), heroi.getNomeHeroi(),
                heroi.getAltura(), heroi.getPeso(), heroi.getDataNascimento());

        Heroi heroiGerenciado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herói não encontrado!"));

        Set<Superpoder> superpoderes = idsSuperpoderes.stream()
                .map(spId -> superpoderRepository.findById(spId)
                        .orElseThrow(() -> new RuntimeException("Superpoder não encontrado: " + spId)))
                .collect(Collectors.toSet());

        heroiGerenciado.setSuperpoderes(superpoderes);
        repository.save(heroiGerenciado);

        return heroiExistente;
    }

    public String deletarHeroi(Integer id) {
        validarId(id);

        Heroi heroi = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Herói não encontrado!"));
        repository.delete(heroi);
        return "Herói deletado com sucesso!";
    }

    private void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido!");
        }
    }
}
