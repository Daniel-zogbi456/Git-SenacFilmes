package com.senacfilmes.model;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.*;
@Entity
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    
     @NotBlank(message = "O gênero é obrigatório")
    private String genero;
    
    @NotNull(message = "O ano é obrigatório")
    private int ano;

    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL)
    private List<Avaliacao> avaliacoes;
    
    @Override
public String toString() {
    return this.titulo; // ou nome para avaliador
}

    
    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
    
}
