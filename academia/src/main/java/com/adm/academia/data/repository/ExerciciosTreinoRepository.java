package com.adm.academia.data.repository;


import com.adm.academia.data.ExercicioTreinoId;
import com.adm.academia.data.ExerciciosTreinoEntity;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS EXERCÍCIOS PRESENTE EM TREINOS
@Repository
public interface ExerciciosTreinoRepository extends JpaRepository<ExerciciosTreinoEntity, ExercicioTreinoId> {
     List<ExerciciosTreinoEntity> findByTreinoIdOrderByDivisao(Integer idTreinos);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO exercicios_treinos (id_exercicios, id_treinos, divisao, series, repeticoes) VALUES (:idExercicios, :idTreinos, :divisao, :series, :repeticoes)", nativeQuery = true)
    void insertExercicio(
            @Param("idExercicios") Integer idExercicios,
            @Param("idTreinos") Integer idTreinos,
            @Param("divisao") String divisao, 
            @Param("series") int series,
            @Param("repeticoes") int repeticoes);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM exercicios_treinos WHERE id_exercicios =:idExercicios AND id_treinos=:idTreinos", nativeQuery = true)
    void deleteExercicio(
            @Param("idExercicios") Integer idExercicios,
            @Param("idTreinos") Integer idTreinos);
}