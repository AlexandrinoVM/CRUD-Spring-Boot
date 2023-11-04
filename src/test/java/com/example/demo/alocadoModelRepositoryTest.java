package com.example.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.models.alocadoModel;
import com.example.demo.models.cargoModel;
import com.example.demo.models.funcionarioModel;
import com.example.demo.repository.alocarRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class alocadoModelRepositoryTest {
    



    @Autowired
    alocarRepository alocadorep;

    @Autowired 
    TestEntityManager entityManager;


    @Test
    public void test(){
        
    }

     @Test
    public void testAddItem(){
        
    }

    @Test
    public void addALocadoInformacoes(){
        alocadoModel alocado = new alocadoModel(300);
        alocadorep.save(alocado);
    }

    @Test
    public void testAdicionar(){
        funcionarioModel func = entityManager.find(funcionarioModel.class,1);
         cargoModel carg = entityManager.find(cargoModel.class,1);

       // alocadoModel aloc = new alocadoModel(150,carg,func);
       // alocadorep.save(aloc);
    }
    @Test
    public void testlist(){
       alocadoModel alocad = alocadorep.findById(2).get();
       alocad.setAloc_horas_mes(200);
       alocadorep.save(alocad);
    }
}
