# Petshop Singleton (Spring Boot)

Projeto Spring Boot que demonstra o padrão Singleton com um repositório em memória.

```bash
mvn clean package
java -jar target/petshop-singleton-0.0.1-SNAPSHOT.jar
```

## Observações
- O `PetService` usa essa instância singleton internamente, enquanto o `PetController` é um controller Spring padrão.
- Requer Java 17 e Maven.

