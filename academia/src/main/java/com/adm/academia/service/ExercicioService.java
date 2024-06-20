package com.adm.academia.service;

import com.adm.academia.data.ExercicioEntity;
import com.adm.academia.data.repository.ExercicioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO EXERCÍCIO
@Service
public class ExercicioService {

    //Inicialização do repositório para controle de dados 
    @Autowired
    ExercicioRepository exercicioRepository;

    //Método para buscar todos os exercicio
    @Transactional
    public List<ExercicioEntity> getAllExercicios() {
        return exercicioRepository.findAll();
    }

    //Método para buscar exercicio por seu ID
    @Transactional
    public ExercicioEntity getExercicioById(Integer id) {
        return exercicioRepository.findById(id).orElse(null); //Call para repository  
    }

    //Método para buscar exercicio por seu Nome
    @Transactional
    public List<ExercicioEntity> getExercicioByNome(String nome) {
        return exercicioRepository.findByNomeContaining(nome); //Call para repository  
    }

    //Método para buscar exercicio por seu id de grupo muscular
    @Transactional
    public List<ExercicioEntity> getExercicioByIdGrupoMuscular(Integer id) {
        return exercicioRepository.findByIdGrupoMuscular(id); //Call para repository  
    }

    //Método para buscar exercicio por seu id de grupo muscular  e nome
    @Transactional
    public List<ExercicioEntity> getExercicioByIdGmAndNome(Integer id, String nome) {
        return exercicioRepository.findByIdGmAndNome(id, nome); //Call para repository  
    }

    //Método para adicionar exercicio ao DB
    @Transactional
    public ExercicioEntity criarExercicio(ExercicioEntity exercicio) {
        exercicioRepository.save(exercicio); //Call para repository

        return exercicio;
    }

    //Método para deletar exercicio do DB
    @Transactional
    public void deletarExercicio(Integer id) {
        if (exercicioRepository.existsById(id)) { //Verificar se o exercicio existe
            exercicioRepository.deleteById(id); //Call para delete
        } else {
            throw new EntityNotFoundException("Exercício não encontrado.");
        }
    }

}
