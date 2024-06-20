package com.adm.academia.data.repository;

import com.adm.academia.data.ExercicioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS EXERCÍCIOS
@Repository
public interface ExercicioRepository extends JpaRepository<ExercicioEntity, Integer> {
    List<ExercicioEntity> findByNomeContaining(String nome);
    
    @Query(value = "SELECT * FROM exercicios WHERE grupo_musculares_id = :idGrupoMuscular", nativeQuery = true)
    List<ExercicioEntity> findByIdGrupoMuscular(@Param("idGrupoMuscular") Integer idGrupoMuscular);
    
    @Query(value = "SELECT * FROM exercicios WHERE grupo_musculares_id = :idGrupoMuscular AND nome LIKE %:nome%", nativeQuery = true)
    List<ExercicioEntity> findByIdGmAndNome(
            @Param("idGrupoMuscular") Integer idGrupoMuscular, @Param("nome") String nome);
}