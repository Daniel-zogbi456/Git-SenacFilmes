package com.senacfilmes.controller;

import com.senacfilmes.model.Filme;
import com.senacfilmes.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmeRepository.findAll());
        return "filmes-listar";

    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("filme", new Filme());
        return "filmes-form";
    }

    @PostMapping("/salvar")
    public String salvarFilme(@ModelAttribute Filme filme) {
        filmeRepository.save(filme);
        return "redirect:/filmes";
    }
}
