package com.example.demo.repository;
import com.example.demo.models.funcionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface funcionarioRespository extends JpaRepository<funcionarioModel,Integer> {
    
}
