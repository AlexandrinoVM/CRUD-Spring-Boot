package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.alocadoModel;

@Repository
public interface alocarRepository extends JpaRepository<alocadoModel, Integer>{
    
}
