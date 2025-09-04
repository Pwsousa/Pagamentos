# Microserviço de Pagamentos

## Visão Geral
Microserviço responsável pelo processamento de pagamentos do restaurante Sabores Conectados.

## Funcionalidades
- ✅ CRUD completo de pagamentos
- ✅ Controle de status de pagamento
- ✅ Tipos de pagamento (A_VISTA, PARCELADO)
- ✅ Integração com pedidos
- ✅ Histórico de transações
- ✅ Integração com Eureka Server
- ✅ API REST completa

## Tecnologias
- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Cloud 2023.0.3**
- **Spring Data JPA**
- **MySQL 8.0**
- **Flyway** (migrações)
- **ModelMapper**
- **Lombok**

## Estrutura do Projeto
```
pagamentos/
├── Pagamentos/                  # Projeto Spring Boot
│   ├── src/main/java/
│   │   └── br/com/saboresconectados/pagamentos/
│   │       ├── model/           # Entidades JPA
│   │       ├── dto/             # Data Transfer Objects
│   │       ├── repository/      # Repositórios JPA
│   │       ├── service/         # Lógica de negócio
│   │       └── controller/      # Controllers REST
│   ├── src/main/resources/
│   │   ├── application.properties
│   │   └── db/migration/        # Scripts Flyway
│   └── src/test/                # Testes unitários
├── Dockerfile                   # Container Docker
└── README.md                    # Este arquivo
```

## Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Configuração do Banco
```sql
CREATE DATABASE pagamentos;
```

### Execução Local
```bash
cd pagamentos/Pagamentos
mvn spring-boot:run
```

### Execução com Docker
```bash
docker build -t pagamentos-service .
docker run -p 8081:8081 pagamentos-service
```

## Endpoints da API

### Base URL
- **Local**: http://localhost:8081/pagamentos
- **Gateway**: http://localhost:8084/pagamentos

### Principais Endpoints
- `GET /pagamentos` - Listar com paginação
- `GET /pagamentos/{id}` - Obter por ID
- `POST /pagamentos` - Criar novo pagamento
- `PUT /pagamentos/{id}` - Atualizar pagamento
- `DELETE /pagamentos/{id}` - Excluir pagamento

### Exemplo de Uso
```bash
# Listar pagamentos
curl http://localhost:8084/pagamentos

# Criar novo pagamento
curl -X POST http://localhost:8084/pagamentos \
  -H "Content-Type: application/json" \
  -d '{
    "valor": 25.90,
    "nome": "João Silva",
    "pedidoId": 1
  }'
```

## Modelo de Dados

### Pagamento
```json
{
  "id": 1,
  "valor": 25.90,
  "nome": "João Silva",
  "status": "PENDENTE",
  "tipo": "A_VISTA",
  "pedidoId": 1
}
```

### Status de Pagamento
- **PENDENTE**: Aguardando processamento
- **APROVADO**: Pagamento aprovado
- **REJEITADO**: Pagamento rejeitado
- **CANCELADO**: Pagamento cancelado

### Tipos de Pagamento
- **A_VISTA**: Pagamento à vista
- **PARCELADO**: Pagamento parcelado

## Configuração
O microserviço está configurado para:
- **Porta**: 8081
- **Banco**: MySQL (pagamentos)
- **Eureka**: Registrado automaticamente
- **Gateway**: Acessível via http://localhost:8084/pagamentos

## Integração com Pedidos
O microserviço de pagamentos está integrado com o microserviço de pedidos através do campo `pedidoId`, permitindo rastrear qual pedido está associado a cada pagamento.

## Desenvolvimento
Para contribuir com o desenvolvimento:
1. Clone o repositório
2. Configure o ambiente de desenvolvimento
3. Execute os testes: `mvn test`
4. Faça suas alterações
5. Execute os testes novamente
6. Faça commit das alterações
