package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

//ENTIDADE PARA USUÁRIOS
@Data
@Entity
@Table(name="usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_carteirinha;
    
    @NotBlank(message = "Preencha o nome")
    private String nome;
    
    @CPF
    @NotBlank(message = "Preencha o cpf")
    private String cpf;
    
    @NotNull(message = "Preencha a data de nascimento")
    private LocalDate data_nascimento;
    
    private Integer treino_id;
    private Integer plano_id;
    
    @NotNull(message = "O usuário está ativo?")
    private boolean ativo;  
    
    
}