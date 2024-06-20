package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


//ENTIDADE PARA EXERCÍCIOS
@Data
@Entity
@Table(name="exercicios")
public class ExercicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull(message = "Qual o nome do exercício?")
    private String nome;
    
    @NotNull(message = "Preencha o grupo muscular")
    @ManyToOne
    @JoinColumn(name = "grupo_musculares_id")
    private GrupoMuscularEntity grupo_muscular;
    
}
