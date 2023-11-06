package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.cargoModel;
import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.cargoRepository;

@Service
public class cargoService {
    @Autowired
    cargoRepository cargoRepository;

    public Optional<cargoModel> findById(Integer id){
        return cargoRepository.findById(id);
       
    }
    public void save(cargoModel cargo){
        cargoRepository.save(cargo);
    }
}
