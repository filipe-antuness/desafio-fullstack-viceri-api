package com.desafiofullstackviceri.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Superpoderes")
public class Superpoder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Superpoder", nullable = false, length = 50)
    private String superpoder;

    @Column(name = "Descricao", length = 250)
    private String descricao;

    @ManyToMany(mappedBy = "superpoderes")
    @JsonIgnore
    private Set<Heroi> herois = new HashSet<>();


    public Superpoder() {
        // Default constructor
    }

    public Superpoder(Integer id, String superpoder, String descricao, Set<Heroi> herois) {
        this.id = id;
        this.superpoder = superpoder;
        this.descricao = descricao;
        this.herois = herois;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Heroi> getHerois() {
        return herois;
    }

    public void setHerois(Set<Heroi> herois) {
        this.herois = herois;
    }
}
