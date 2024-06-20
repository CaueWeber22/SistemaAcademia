package com.adm.academia.service;

import com.adm.academia.data.UsuarioEntity;
import com.adm.academia.data.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO USUÁRIO
@Service
public class UsuarioService {
    //Inicialização do repositório para controle de dados 
    @Autowired
    UsuarioRepository usuarioRepository;
    
    //Método para listar todos usuários
    @Transactional
    public List<UsuarioEntity> getAllUsuarios(){
        return usuarioRepository.findAll();   //Call para repository  
    }
    
    //Método para listar todos usuários por ordem alfabética
    @Transactional
    public List<UsuarioEntity> getAllUsuariosAsc(){
        return usuarioRepository.findAllByOrderByNomeAsc(); //Call para repository  
    }
    
    //Método para buscar usuário por seu ID
    @Transactional
    public UsuarioEntity getUsuarioById(Integer id){
        return usuarioRepository.findById(id).orElse(null);   //Call para repository  
    }
   
       
    //Método para adicionar usuário ao DB
    @Transactional
    public UsuarioEntity criarUsuario(UsuarioEntity usuario){
        UsuarioEntity novoUsuario = usuarioRepository.save(usuario);

        return novoUsuario; // 
    }
    
    //Método para alterar dados de usuário
    @Transactional
    public UsuarioEntity alterarUsuario(UsuarioEntity usuarioRequest, Integer id){
        UsuarioEntity usuarioAlterar = getUsuarioById(usuarioRequest.getId_carteirinha());
        usuarioAlterar.setCpf(usuarioRequest.getCpf()); //Alterar cpf
        usuarioAlterar.setData_nascimento(usuarioRequest.getData_nascimento()); //Alterar data de nascimento
        usuarioAlterar.setNome(usuarioRequest.getNome()); //Alterar nome
        usuarioAlterar.setPlano_id(usuarioRequest.getPlano_id()); //Alterar plano
        usuarioAlterar.setTreino_id(usuarioRequest.getTreino_id()); //Alterar treino
        usuarioAlterar.setAtivo(usuarioRequest.isAtivo()); //Alterar status do usuário
        
        usuarioRepository.save(usuarioAlterar); //Call para repository 
        return usuarioAlterar;
    }
    
    //Método para deletar usuário do DB
    @Transactional 
    public void deletarUsuario(Integer id){
        UsuarioEntity usuario = getUsuarioById(id);
        usuarioRepository.deleteById(usuario.getId_carteirinha()); //Call para repository
    }
}


