package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;


//ENTIDADE PARA TREINOS
@Data
@Entity
@Table(name="treino")
public class TreinoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Preencha o nome")
    private String nome;
    
    @NotNull(message = "Qual o numero de divisões?")
    private int numero_divisoes;
    
    @NotBlank(message = "Preencha a descrição do treino")
    private String descricao;  
    
    @NotBlank(message = "Preencha a descrição do treino")
    private String descricao_dias;  
    
}