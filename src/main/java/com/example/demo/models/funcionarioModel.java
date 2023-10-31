package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@Entity
@Table(name = "TBL_funcionario")
public class funcionarioModel {
    @Id
    @Column(name="func_codigo", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer func_codigo;
    
    @Column(name="func_name", length = 30,nullable = false)
    private String nome;
     
    @Column(name ="func_ctps" ,nullable=false)
    private Date ctps;

    @Column(name ="func_rescisao" ,nullable=false)
    private Date rescisao;
}