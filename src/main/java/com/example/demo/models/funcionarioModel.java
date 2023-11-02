package com.example.demo.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer func_codigo;
    
    @Column(name="func_name", length = 30,nullable = false)
    private String nome;
     
    @Column(name ="func_ctps" ,nullable=false)
    private Date ctps;

    @Column(name ="func_rescisao" ,nullable=false)
    private Date rescisao;

    @OneToMany(mappedBy = "func_codigo", cascade = CascadeType.ALL)
    private Set<alocadoModel> alocadoModels = new HashSet<>();
}