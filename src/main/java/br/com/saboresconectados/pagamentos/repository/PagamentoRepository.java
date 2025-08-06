package br.com.saboresconectados.pagamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.saboresconectados.pagamentos.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
