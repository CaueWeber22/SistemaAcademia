package com.adm.academia.service;

import com.adm.academia.data.GrupoMuscularEntity;
import com.adm.academia.data.repository.GrupoMuscularRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO GRUPO MUSCULAR
@Service
public class GrupoMuscularService {

    //Inicialização do repositório para controle de dados 
    @Autowired
    GrupoMuscularRepository GMRepository;

    //Método para listar todos grupos musculares
    @Transactional
    public List<GrupoMuscularEntity> getAllGruposMusculares() {
        return GMRepository.findAll();  //Call para repository  
    }

    //Método para buscar grupo muscular por seu ID
    @Transactional
    public GrupoMuscularEntity getGrupoMuscularById(Integer id) {
        return GMRepository.findById(id).orElse(null);   //Call para repository  
    }

    //Método para adicionar grupo muscular ao DB
    @Transactional
    public GrupoMuscularEntity criarGrupoMuscular(GrupoMuscularEntity grupoMuscular) {
        GrupoMuscularEntity novoGrupoMuscular = GMRepository.save(grupoMuscular); //Call para repository

        return novoGrupoMuscular;
    }

    //Método para deletar grupo muscular do DB
    @Transactional
    public void deletarGrupoMuscular(Integer id) {
        if (GMRepository.existsById(id)) {
            GMRepository.deleteById(id); //Call para repository
        } else {
            throw new EntityNotFoundException("Grupo muscular não encontrado.");
        }
    }
}
