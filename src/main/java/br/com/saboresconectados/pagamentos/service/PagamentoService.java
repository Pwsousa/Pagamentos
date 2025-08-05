package br.com.saboresconectados.pagamentos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import br.com.saboresconectados.pagamentos.repository.PagamentoRepository;

@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository repository;

    // Transferir dados entre a Entidade e o DTO 
    @Autowired
    private ModelMapper modelmapp;

    


}
