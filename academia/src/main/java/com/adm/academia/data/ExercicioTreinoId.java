package com.adm.academia.data;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ExercicioTreinoId {
    @Column(name = "id_exercicios")
    private Integer idExercicios;
    @Column(name = "id_treinos")
    private Integer idTreinos;
}
