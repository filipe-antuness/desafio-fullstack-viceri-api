package com.desafiofullstackviceri.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Herois")
public class Heroi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Nome", nullable = false, length = 120)
    private String nome;

    @Column(name = "NomeHeroi", nullable = false, length = 120)
    private String nomeHeroi;

    @Column(name = "DataNascimento")
    private LocalDateTime dataNascimento;

    @Column(name = "Altura", nullable = false)
    private float altura;

    @Column(name = "Peso", nullable = false)
    private float peso;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "HeroisSuperpoderes", joinColumns = @JoinColumn(name = "HeroiId"), inverseJoinColumns = @JoinColumn(name = "SuperpoderId"))
    private Set<Superpoder> superpoderes = new HashSet<>();


    public Heroi(int id, String nome, String nomeHeroi, LocalDateTime dataNascimento, float altura, float peso, Set<Superpoder> superpoderes) {
        this.id = id;
        this.nome = nome;
        this.nomeHeroi = nomeHeroi;
        this.dataNascimento = dataNascimento;
        this.altura = altura;
        this.peso = peso;
        this.superpoderes = superpoderes;
    }

    public Heroi() {
        // Default constructor
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeHeroi() {
        return nomeHeroi;
    }

    public void setNomeHeroi(String nomeHeroi) {
        this.nomeHeroi = nomeHeroi;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Set<Superpoder> getSuperpoderes() {
        return superpoderes;
    }

    public void setSuperpoderes(Set<Superpoder> superpoderes) {
        this.superpoderes = superpoderes;
    }
}
