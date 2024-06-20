package com.adm.academia.service;

import com.adm.academia.data.CargoEntity;
import com.adm.academia.data.repository.CargoRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//SERVICE PARA REQUISIÇÃO AO BANCO DE DADOS E REPOSTA PARA ENTIDADES TIPO CARGO
@Service
public class CargoService {

    //Inicialização do repositório para controle de dados 
    @Autowired
    CargoRepository cargoRepository;

    //Método para buscar cargo por seu ID
    @Transactional
    public CargoEntity getCargoBy(Integer id) {
        return cargoRepository.findById(id).orElse(null); //Call para repository  
    }
    
    //Método para buscar todos os cargos
    @Transactional
    public List<CargoEntity> getAllCargos() {
        return cargoRepository.findAll(); //Call para repository  
    }
}
