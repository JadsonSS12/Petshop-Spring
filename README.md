# Petshop Singleton Example (Spring Boot)

Projeto Spring Boot mínimo que demonstra o padrão Singleton com um repositório em memória.

## Endpoints
- `GET /api/pets` - lista todos os pets
- `GET /api/pets/{id}` - obtém pet por id
- `POST /api/pets` - cria pet (JSON)
- `PUT /api/pets/{id}` - atualiza pet
- `DELETE /api/pets/{id}` - deleta pet

## Como rodar
Requer Java 17 e Maven.

```bash
mvn clean package
java -jar target/petshop-singleton-0.0.1-SNAPSHOT.jar
```

## Observações
- `PetRepositorySingleton` é uma implementação clássica do padrão Singleton (double-checked locking).
- O `PetService` usa essa instância singleton internamente, enquanto o `PetController` é um controller Spring padrão.
- Todos os dados são mantidos em memória (HashMap), ideal apenas para fins didáticos e testes.
