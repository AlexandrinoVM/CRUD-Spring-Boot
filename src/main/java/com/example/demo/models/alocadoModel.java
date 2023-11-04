package com.example.demo.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

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


    @Column(name = "aloc_inicio")
    private Date aloc_inicio;

    @Column(name = "aloc_fim")
    private Date aloc_fim;

    @Column(name = "aloc_horas_mes")
    private int aloc_horas_mes;

    @ManyToOne
    @JoinColumn(name ="carg_codigo")
   private cargoModel cargo;

   @ManyToOne
    @JoinColumn(name ="func_codigo")
   private funcionarioModel  funcionario;
  

   

public alocadoModel(int aloc_horas_mes) {
    this.aloc_horas_mes = aloc_horas_mes;
}

public alocadoModel(Date aloc_inicio, Date aloc_fim, int aloc_horas_mes) {
    this.aloc_inicio = aloc_inicio;
    this.aloc_fim = aloc_fim;
    this.aloc_horas_mes = aloc_horas_mes;
}





@Override
public String toString() {
    return "alocadoModel [aloc_inicio=" + aloc_inicio + ", aloc_fim=" + aloc_fim + ", aloc_horas_mes=" + aloc_horas_mes
            + ", cargo=" + cargo + ", funcionario=" + funcionario + "]";
}



   

}
