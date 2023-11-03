package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.alocadoModel;
import com.example.demo.models.cargoModel;
import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.alocarRepository;
import com.example.demo.repository.cargoRepository;
import com.example.demo.repository.funcionarioRespository;
import com.example.demo.services.funcionarioService;

@Controller
public class funcionarioController {

    @Autowired
    funcionarioRespository funcionarioRespository;

    @Autowired
    alocarRepository aloc;

    @Autowired
    cargoRepository cargorepo;

    @Autowired
    funcionarioService funcionarioService;

    @GetMapping(value = "/funcionario/listar")
    public String listar(Model model) {
        List<alocadoModel> alocado = aloc.findAll();
        List<funcionarioModel> funcionarios = funcionarioRespository.findAll();
        model.addAttribute("funcionarios",funcionarios);
        model.addAttribute("alocados",alocado);
        return "/funcionarios/listar";
    }

    @GetMapping(value = "/funcionario/inserir")
    public String inserir(Model model){
        List<cargoModel> todoscargos = cargorepo.findAll();
        model.addAttribute("cargos",todoscargos );
        model.addAttribute("funcionarios",new funcionarioModel());

        return "/funcionarios/inserir";

    }

    @GetMapping("/funcionario/editar/{func_codigo}")
	public String editarUsuario(@PathVariable("func_codigo") Integer id, Model model) {
		Optional<funcionarioModel> usuarioVelho = funcionarioService.findById(id);
        System.out.println(id);
		funcionarioModel usuario = usuarioVelho.get();
	    model.addAttribute("funcionario", usuario);

        List<cargoModel> todoscargos = cargorepo.findAll();
        model.addAttribute("cargos",todoscargos );
        
	    return "/funcionarios/editar";
	}

    @GetMapping(value = "/funcionario/alocar")
    public String alocar(Model model){
        
        return "/funcionarios/alocar";
    }
	
	@PostMapping("/funcionario/editar/{func_codigo}")
	public String editarUsuario(@PathVariable("func_codigo") Integer id, 
			 @Validated funcionarioModel usuario,BindingResult result) {
                if(result.hasErrors()){
                    usuario.setFunc_codigo(id);
                    return "/funcionario/editar";
                }

            
             System.out.println(id);
             funcionarioRespository.save(usuario);
            
	   
	    return "redirect:/funcionario/listar";
	}


    @PostMapping(value = "/funcionario/novo")
    public String novo(@ModelAttribute funcionarioModel novoFuncionario) {
        funcionarioService.save(novoFuncionario);
        return "redirect:/funcionario/listar";
    }

}
