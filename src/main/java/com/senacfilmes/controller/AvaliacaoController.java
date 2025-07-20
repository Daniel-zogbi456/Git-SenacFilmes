package com.senacfilmes.controller;

import com.senacfilmes.model.Avaliacao;
import com.senacfilmes.model.Filme;
import com.senacfilmes.model.Avaliador;
import com.senacfilmes.repository.AvaliacaoRepository;
import com.senacfilmes.repository.FilmeRepository;
import com.senacfilmes.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @GetMapping
    public String listarAvaliacoes(Model model) {
        model.addAttribute("avaliacoes", avaliacaoRepository.findAll());
        return "avaliacoes-listar";
    }

    @GetMapping("/nova")
    public String mostrarFormulario(Model model) {
        model.addAttribute("avaliacao", new Avaliacao());
        model.addAttribute("filmes", filmeRepository.findAll());
        model.addAttribute("avaliadores", avaliadorRepository.findAll());
        return "avaliacoes-form";
    }

    @PostMapping("/salvar")
public String salvar(@RequestParam Long filme, @RequestParam Long avaliador, @ModelAttribute Avaliacao avaliacao) {
    Filme f = filmeRepository.findById(filme).orElseThrow();
    Avaliador a = avaliadorRepository.findById(avaliador).orElseThrow();
    avaliacao.setFilme(f);
    avaliacao.setAvaliador(a);
    avaliacaoRepository.save(avaliacao);
    return "redirect:/avaliacoes";
}

}
