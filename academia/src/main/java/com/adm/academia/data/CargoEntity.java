package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


//ENTIDADE PARA TREINOS
@Data
@Entity
@Table(name="cargo")
public class CargoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "Preencha o cargo")
    private String cargo;
    
    @NotNull(message = "Qual o salário?")
    private double salario;
    
}
