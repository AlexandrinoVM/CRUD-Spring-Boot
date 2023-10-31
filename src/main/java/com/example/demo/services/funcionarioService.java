package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.funcionarioRespository;

@Service
public class funcionarioService {

    @Autowired
    funcionarioRespository funcionarioRespository;

    
    public void save(funcionarioModel funcionario){
        funcionarioRespository.save(funcionario);
    }

}

