package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.alocadoModel;
import com.example.demo.models.cargoModel;
import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.alocarRepository;
@Service
public class alocadomodelservice {
    
    @Autowired
    alocarRepository alocado;
    

    public void saveidfunc(funcionarioModel funcionario){
      alocadoModel aolca = new alocadoModel();
      
    }

}
