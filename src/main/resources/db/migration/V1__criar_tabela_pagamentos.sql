CREATE TABLE pagamentos (

    id  BIGINT(20) NOT NULL AUTO_INCREMENT,
    valor DECIMAL(19,2) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    status VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    pedido_id BIGINT(20) NOT NULL,
    
    PRIMARY KEY (id)

)