package com.adm.academia.data.repository;

import com.adm.academia.data.UsuarioEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//REPOSITÓRIO PARA ABSTRAÇÃO DA LÓGICA DE DADOS DOS USUÁRIOS
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer>{       
     List<UsuarioEntity> findAllByOrderByNomeAsc();
}
