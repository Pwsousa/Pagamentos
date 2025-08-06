package br.com.saboresconectados.pagamentos.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import br.com.saboresconectados.pagamentos.dto.PagamentoDTO;
import br.com.saboresconectados.pagamentos.model.Pagamento;
import br.com.saboresconectados.pagamentos.model.Status;
import br.com.saboresconectados.pagamentos.model.Tipo;
import br.com.saboresconectados.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PagamentoService {
    
    @Autowired
    private PagamentoRepository repository;

    // Transferir dados entre a Entidade e o DTO 
    @Autowired
    private ModelMapper modelmapp;

    public Page<PagamentoDTO> obterTodos(Pageable paginacao){
        return repository
                .findAll(paginacao).map(p -> modelmapp.map(p, PagamentoDTO.class));
    }

    public PagamentoDTO obterPorId(Long id){
        Pagamento pagamento = repository.findById(id)
                                        .orElseThrow(() -> new EntityNotFoundException());
        return modelmapp.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO criarPagamento(PagamentoDTO dto){
        Pagamento pagamento = modelmapp.map(dto, Pagamento.class);
        pagamento.setStatus(Status.PENDENTE);
        pagamento.setTipo(Tipo.A_VISTA);
        repository.save(pagamento);

        return modelmapp.map(pagamento, PagamentoDTO.class);
    }

    public PagamentoDTO atualizarPagamento(Long id, PagamentoDTO dto){
        Pagamento pagamento = modelmapp.map(dto,Pagamento.class);
        pagamento.setId(id);
        pagamento = repository.save(pagamento);
        return modelmapp.map(pagamento, PagamentoDTO.class);
    }


    public void excluirPagamento(Long id){
        repository.deleteById(id);
    }
}
