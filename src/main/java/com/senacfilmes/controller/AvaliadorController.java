package com.senacfilmes.controller;

import com.senacfilmes.model.Avaliador;
import com.senacfilmes.repository.AvaliadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/avaliadores")
public class AvaliadorController {

    @Autowired
    private AvaliadorRepository avaliadorRepository;

    @GetMapping
    public String listarAvaliadores(Model model) {
        model.addAttribute("avaliadores", avaliadorRepository.findAll());
        return "avaliadores/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("avaliador", new Avaliador());
        return "avaliadores/form";
    }

    @PostMapping("/salvar")
    public String salvarAvaliador(@ModelAttribute Avaliador avaliador) {
        avaliadorRepository.save(avaliador);
        return "redirect:/avaliadores";
    }
}
