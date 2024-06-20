package com.adm.academia.service;

import com.adm.academia.data.ExercicioEntity;
import com.adm.academia.data.ExerciciosTreinoEntity;
import com.adm.academia.data.TreinoEntity;
import com.adm.academia.data.repository.ExerciciosTreinoRepository;
import com.adm.academia.data.repository.TreinoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO TREINO
@Service
public class TreinoService {
    //Inicialização dos repositórios para controle de dados 
    @Autowired
    TreinoRepository treinoRepository;
    
    @Autowired
    ExerciciosTreinoRepository etRepository;
    
    //Método para buscar todos os treinos
    @Transactional
    public List<TreinoEntity> getAllTreinos(){
        return treinoRepository.findAll();
    }
    
    //Método para buscar treino por seu ID
    @Transactional
    public TreinoEntity getTreinoById(Integer id){
        return treinoRepository.findById(id).orElse(null); //Call para repository  
    }
    
    //Método para adicionar treino ao DB
    @Transactional
    public TreinoEntity criarTreino(TreinoEntity treino){
        treino.setId(null);
        treinoRepository.save(treino); //Call para repository
                
        return treino;
    }
    
    //Método para alterar dados de treino
    @Transactional
    public TreinoEntity alterarTreino(TreinoEntity treinoRequest, Integer id){
        //Buscar dados do DB
        TreinoEntity treinoAlterar = getTreinoById(treinoRequest.getId());
        //Alterar por dados novos
        treinoAlterar.setNome(treinoRequest.getNome()); //Alterar nome
        treinoAlterar.setNumero_divisoes(treinoRequest.getNumero_divisoes());
        treinoAlterar.setDescricao_dias(treinoRequest.getDescricao_dias());
        treinoAlterar.setDescricao(treinoRequest.getDescricao());
        
        treinoRepository.save(treinoAlterar); //Call para repository 
        return treinoAlterar;
    }
    
    //Método para deletar treino do DB
    @Transactional 
    public void deletarTreino(Integer id){
        if(treinoRepository.existsById(id)){ //Verificar se o treino existe
        treinoRepository.deleteById(id); //Call para delete
    } else {
        throw new EntityNotFoundException("Treino não encontrado.");
        }      
    }
    
    //Método para pesquisar todos exercícios ligado ao treino
    @Transactional
    public List<ExerciciosTreinoEntity> getExerciciosByTreinoId(Integer idTreino) { 
        return etRepository.findByTreinoIdOrderByDivisao(idTreino);
        
    }
    
    //Método para adicionar exercício ao treino
    @Transactional
    public ExerciciosTreinoEntity adicionarExercicioTreino(ExerciciosTreinoEntity et) {    
        //Variáveis para requisição ao repository
        Integer idTreino = et.getTreino().getId();
        Integer idExercicio = et.getExercicio().getId();
        String divisao = et.getDivisao();
        int repeticoes = et.getRepeticoes();
        int series = et.getSeries();
        
        etRepository.insertExercicio(idExercicio, idTreino, divisao, series, repeticoes);
                
        return et;
    }
    
    //Método para remover exercício de um treino
    @Transactional
    public void removerExercicioTreino(Integer idExercicio, Integer idTreino) {     
        etRepository.deleteExercicio(idExercicio, idTreino);

    }
    
    
}



