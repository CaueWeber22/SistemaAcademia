package com.adm.academia.data.repository;

import com.adm.academia.data.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS CARGOS
@Repository
public interface CargoRepository extends JpaRepository<CargoEntity, Integer> {
    
}
