# produtos-api

## Configurando o Projeto
Dependencias necessárias: H2, JPA e Spring Web.  
Java 17+.

## Executando o Projeto
Entrar na classe  
`src/main/java/com/bn/prova/ProvaApplication.java`  
e compilar o projeto.

## Testando os EndPoints

### Criar Produto (POST)
URI  
`localhost:8080/api/produtos`
  
BODY  
```json
{
    "nome": "nomeTeste",
    "descricao": "descricaoTeste",
    "preco": 100.00,
    "status": "DISPONIVEL"
}
```

---

### Listar Todos os Produtos (GET)
URI  
`localhost:8080/api/produtos` 

---

### Buscar Produto por ID (GET)
URI  
`localhost:8080/api/produtos/{id}`  

---

### Atualizar Produto (PUT)
URI  
`localhost:8080/api/produtos/{id}` 

BODY  
```json
{
    "nome": "novoNome",
    "descricao": "novaDescricao",
    "preco": 100.00,
    "status": "DISPONIVEL"
}
```

---

### Deletar Produto por ID (DELETE)
URI  
`localhost:8080/api/produtos/{id}`  
