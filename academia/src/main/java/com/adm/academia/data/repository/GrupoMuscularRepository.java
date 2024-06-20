package com.adm.academia.data.repository;

import com.adm.academia.data.GrupoMuscularEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS GRUPOS MUSCULARES
@Repository
public interface GrupoMuscularRepository extends JpaRepository<GrupoMuscularEntity, Integer> {
    
}
