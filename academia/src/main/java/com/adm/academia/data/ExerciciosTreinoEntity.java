package com.adm.academia.data;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "exercicios_treinos")
public class ExerciciosTreinoEntity {

    @EmbeddedId
    private ExercicioTreinoId id;
    
    @ManyToOne
    @MapsId("idExercicios")
    @JoinColumn(name = "id_exercicios")
    private ExercicioEntity exercicio;

    @ManyToOne
    @MapsId("idTreinos")
    @JoinColumn(name = "id_treinos")
    private TreinoEntity treino;

    private String divisao;
    private int series;
    private int repeticoes;

}

