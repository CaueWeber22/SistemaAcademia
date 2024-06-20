package com.adm.academia.data.repository;

import com.adm.academia.data.TreinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<TreinoEntity, Integer> {

}
