package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.cargoModel;
import com.example.demo.repository.cargoRepository;
import com.example.demo.services.cargoService;

@Controller
public class cargoController {
    @Autowired
    cargoRepository cargoRepository;

    @Autowired
    cargoService cargoService;

    @GetMapping(value = "/cargo/inserir")
    public ModelAndView inseri(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargos/inserir");
        return mv;
    }

    @GetMapping(value = "/cargo/listar")
    public String listar(Model model) {
        model.addAttribute("cargo",cargoRepository.findAll());
        return "/cargos/listar";
    }

    @GetMapping(value = "/cargo/editar")
    public ModelAndView editar(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/cargos/editar");
        return mv;
    }

    @PostMapping(value = "/cargo/novo")
    public String novo(cargoModel cargo){
        cargoService.save(cargo);
        return "redirect:/cargo/listar";
    }
}
