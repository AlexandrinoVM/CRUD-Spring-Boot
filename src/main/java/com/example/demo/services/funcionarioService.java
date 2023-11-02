package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.funcionarioRespository;

import jakarta.transaction.Transactional;

@Service
public class funcionarioService {

    @Autowired
    funcionarioRespository funcionarioRespository;

    
    public void save(funcionarioModel funcionario){
        funcionarioRespository.save(funcionario);
    }
    public Optional<funcionarioModel> findById(Integer id){
        return funcionarioRespository.findById(id);
       
    }


}

