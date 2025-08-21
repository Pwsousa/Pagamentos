package br.com.saboresconectados.pagamentos.dto;

import java.math.BigDecimal;

import br.com.saboresconectados.pagamentos.model.Status;
import br.com.saboresconectados.pagamentos.model.Tipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDTO {
    
    private Long ID;
    private BigDecimal valor;
    private String nome;
    private Status status;
    private Tipo tipo;
    private Long pedidoId;
    
}
