package com.adm.academia.service;

import com.adm.academia.data.FuncionarioEntity;
import com.adm.academia.data.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO FUNCIONÁRIO
@Service
public class FuncionarioService {

    //Inicialização do repositório para controle de dados 
    @Autowired
    FuncionarioRepository funcionarioRepository;

    //Método para listar todos funcionário
    @Transactional
    public List<FuncionarioEntity> getAllFuncionarios() {
        return funcionarioRepository.findAll();  //Call para repository  
    }

    //Método para buscar funcionário por seu ID
    @Transactional
    public FuncionarioEntity getFuncionarioById(Integer id) {
        return funcionarioRepository.findById(id).orElse(null);   //Call para repository  
    }

    //Método para buscar funcionário por seu nome
    @Transactional
    public List<FuncionarioEntity> getFuncionarioByNome(String nome) {
    List<FuncionarioEntity> funcionarios = funcionarioRepository.findByNomeContainingIgnoreCase(nome);   
 
    return funcionarios;
    }

    //Método para adicionar funcionário ao DB
    @Transactional
    public FuncionarioEntity criarFuncionario(FuncionarioEntity funcionario) {    
        FuncionarioEntity novoFuncionario = funcionarioRepository.save(funcionario); //Call para repository

        return novoFuncionario;
    }

    //Método para alterar dados de funcionário
    @Transactional
    public FuncionarioEntity alterarFuncionario(FuncionarioEntity funcionarioRequest, Integer id) {
        FuncionarioEntity funcionarioAlterar = getFuncionarioById(funcionarioRequest.getId());

        funcionarioAlterar.setCpf(funcionarioRequest.getCpf()); //Alterar cpf
        funcionarioAlterar.setData_nascimento(funcionarioRequest.getData_nascimento()); //Alterar data de nascimento
        funcionarioAlterar.setNome(funcionarioRequest.getNome()); //Alterar nome
        funcionarioAlterar.setCargo(funcionarioRequest.getCargo()); //Alterar cargo
        funcionarioAlterar.setData_demissao(funcionarioRequest.getData_demissao()); //Alterar data de demissão
        funcionarioAlterar.setData_admissao(funcionarioRequest.getData_admissao()); //Alterar data de admissão
        funcionarioAlterar.setAtivo(funcionarioRequest.isAtivo()); //Alterar status 
       
        funcionarioRepository.save(funcionarioAlterar); //Call para repository 
        return funcionarioAlterar;
    }

    //Método para deletar funcionario do DB
    @Transactional
    public void deletarFuncionario(Integer id) {
        FuncionarioEntity funcionario = getFuncionarioById(id);
        funcionarioRepository.deleteById(funcionario.getId()); //Call para repository
    }
}
