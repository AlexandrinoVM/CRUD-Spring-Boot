package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.funcionarioRespository;
import com.example.demo.services.funcionarioService;

@Controller
public class funcionarioController {

    @Autowired
    funcionarioRespository funcionarioRespository;

    @Autowired
    funcionarioService funcionarioService;

    @GetMapping(value = "/funcionario/listar")
    public String listar(Model model) {
        model.addAttribute("funcionarios",funcionarioRespository.findAll());
        return "/funcionarios/listar";
    }

    @GetMapping(value = "/funcionario/inserir")
    public ModelAndView inserir() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarios/inserir");
        return mv;
    }

    @GetMapping(value = "/funcionario/editar")
    public ModelAndView editar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("funcionarios/editar");
        return mv;
    }

    @PostMapping(value = "/funcionario/novo")
    public String novo(@ModelAttribute funcionarioModel novoFuncionario) {
        funcionarioService.save(novoFuncionario);
        return "redirect:/funcionario/listar";
    }

}
