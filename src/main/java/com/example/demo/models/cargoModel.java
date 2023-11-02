package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_cargos")
public class cargoModel {
    @Id
    @Column(name="carg_codigo", nullable= false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carg_codigo;

    @Column(name="carg_nome",length = 30, nullable= false)
    private String carg_nome;

    @Column(name="carg_sal_mes", nullable= false)
    private double car_sal_mes;

    @Column(name="carg_descricao",length = 30, nullable= false)
    private String carg_descricao;

}
