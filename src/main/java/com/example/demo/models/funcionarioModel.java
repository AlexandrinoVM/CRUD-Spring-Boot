package com.example.demo.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.mapping.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "TB_funcionario")
public class funcionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer func_codigo;
    
    @Column(name="func_name", length = 30,nullable = false)
    private String nome;
     
    @Column(name ="func_ctps" )
    private Date ctps;

    @Column(name ="func_rescisao")
    private Date rescisao;

    public funcionarioModel(String nome) {
        this.nome = nome;
    }
    public funcionarioModel(String nome, Date ctps, Date rescisao) {
        this.nome = nome;
        this.ctps = ctps;
        this.rescisao = rescisao;
    }
    public funcionarioModel(){

    }
    

    @ManyToMany
    @JoinTable(
        name = "table_funcionarios",
        joinColumns = @JoinColumn(name ="func_codigo"),
        inverseJoinColumns = @JoinColumn(name = "carg_codigo")
    )
    public Set<cargoModel> cargo = new HashSet<>();

   public void addcargo(cargoModel cargo){
    this.cargo.add(cargo);
   }
   public void removeCargo(cargoModel cargo){
    this.cargo.remove(cargo);
   }
}