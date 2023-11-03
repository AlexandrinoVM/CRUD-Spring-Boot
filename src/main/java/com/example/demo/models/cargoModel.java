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
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TB_cargos")
public class cargoModel {
   public cargoModel(){

   }
   
    @Id
    @Column(name="carg_codigo", nullable= false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer carg_codigo;

    @Column(name="carg_nome",length = 30)
    private String carg_nome;

    @Column(name="carg_sal_mes")
    private double car_sal_mes;

    @Column(name="carg_descricao",length = 30)
    private String carg_descricao;

   
    public cargoModel(Integer carg_codigo) {
        this.carg_codigo = carg_codigo;
    }


    public cargoModel(String carg_nome, double car_sal_mes, String carg_descricao) {
        this.carg_nome = carg_nome;
        this.car_sal_mes = car_sal_mes;
        this.carg_descricao = carg_descricao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((carg_codigo == null) ? 0 : carg_codigo.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        cargoModel other = (cargoModel) obj;
        if (carg_codigo == null) {
            if (other.carg_codigo != null)
                return false;
        } else if (!carg_codigo.equals(other.carg_codigo))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return this.carg_nome;
    }
    
}
