package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_alocado")
public class alocadoModel {
    public alocadoModel(){

    }
   
    @Id
    @Column(name = "aloc_id" ,nullable =false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aloc_id;


    @Column(name = "aloc_inicio", nullable = false)
    private Date aloc_inicio;

    @Column(name = "aloc_fim", nullable = false)
    private Date aloc_fim;

    @Column(name = "aloc_horas_mes", nullable = false)
    private int aloc_horas_mes;

    @ManyToOne
    @JoinColumn(name = "func_codigo")
    private funcionarioModel func_codigo;

    @ManyToOne
    @JoinColumn(name = "carg_codigo")
    private cargoModel carg_codigo;

}
