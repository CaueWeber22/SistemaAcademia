package com.adm.academia.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

//ENTIDADE PARA FUNCIONÁRIOS
@Data
@Entity
@Table(name = "funcionarios")
public class FuncionarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Preencha o nome")
    private String nome;

    @CPF
    @NotBlank(message = "Preencha o cpf")
    private String cpf;

    @NotNull(message = "Preencha a data de nascimento")
    private LocalDate data_nascimento;

    @NotNull(message = "Preencha o cargo")
    @ManyToOne
    @JoinColumn(name = "id_cargo")
    private CargoEntity cargo;

    @NotNull(message = "Preencha a data de nascimento")
    private LocalDate data_admissao;

    private LocalDate data_demissao;

    @NotNull(message = "O funcionário está ativo?")
    private boolean ativo;

}
