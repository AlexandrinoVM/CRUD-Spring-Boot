package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.cargoModel;
import com.example.demo.repository.cargoRepository;

@Service
public class cargoService {
    @Autowired
    cargoRepository cargoRepository;


    public void save(cargoModel cargo){
        cargoRepository.save(cargo);
    }
}
