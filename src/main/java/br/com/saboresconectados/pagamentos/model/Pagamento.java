package br.com.saboresconectados.pagamentos.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "Pagamentos")
@Getter
@Setter
@AllArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @NotNull
    @Positive
    private BigDecimal valor;
    
    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotNull
    @Enumerated (EnumType.STRING)
    private Status status;

    @NotNull
    private Long pedidoId;

    @NotNull
    private long formaPagamento;
}
