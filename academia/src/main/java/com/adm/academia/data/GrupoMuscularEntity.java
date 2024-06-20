package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//ENTIDADE PARA GRUPOS MUSCULARES
@Data
@Entity
@Table(name="grupos_musculares")
public class GrupoMuscularEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotNull(message = "Qual o grupo muscular?")
    private String grupo_muscular;
    
}
