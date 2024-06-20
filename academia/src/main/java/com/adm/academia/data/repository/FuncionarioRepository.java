package com.adm.academia.data.repository;

import com.adm.academia.data.FuncionarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS FUNCIONÁRIOS
@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Integer> {
    List<FuncionarioEntity> findByNomeContainingIgnoreCase(String nome);
}