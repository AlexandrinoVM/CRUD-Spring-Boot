package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.models.cargoModel;
import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.cargoRepository;
import com.example.demo.repository.funcionarioRespository;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CargoRepositoyTest {
    
    @Autowired
    private funcionarioRespository funcr;

    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    public void testCreatecargos(){
       cargoModel cargoAdnin = new cargoModel("lava prato",1050.0,"lavar pratos"); 
       cargoModel cargoadmim = new cargoModel("administrador",1050.0,"adiministrar");
       cargoModel cargopedreiro = new cargoModel("pedreiro",1050.0,"contruir");
       entityManager.persist(cargoAdnin);
       entityManager.persist(cargoadmim);
       entityManager.persist(cargopedreiro);
    }
    @Test
    public void testCreateFuncionariosComCargo(){
        cargoModel cargoadimin = entityManager.find(cargoModel.class, 2);
        cargoModel cargopdreito = entityManager.find(cargoModel.class, 3);
        funcionarioModel func = new funcionarioModel("roberto");
        func.addcargo(cargoadimin);
        func.addcargo(cargopdreito);
        
        funcr.save(func);
    }

    @Test
    public void testeCargoParaUsuariosExistente(){
        
        funcionarioModel func = funcr.findById(1).get();
        cargoModel cargoAdmin = entityManager.find(cargoModel.class, 2);
        cargoModel cargopedreito = entityManager.find(cargoModel.class, 3);
        func.addcargo(cargoAdmin);
        func.addcargo(cargopedreito);
    
    }

    @Test
    public void testRemoveCargo(){
        funcionarioModel func = funcr.findById(1).get();
        cargoModel cargo = new cargoModel(2);
        func.removeCargo(cargo);

    }

    @Test 
    public void getFuncionarios(){
        funcionarioModel func = funcr.findById(1).get();
        System.out.println(func.getNome());
        System.out.println(func.getCargo());
    }

    @Test
    public void removeUser(){
        funcr.deleteById(2);
    }
}
