package com.example.demo.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_alocado")
public class alocadoModel {
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
}
