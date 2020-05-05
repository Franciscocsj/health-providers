# health-providers

#### Definição
Aplicação Java que recebe a geolocalização do segurado e o tipo do atendimento, e retorna a lista de prestadores de saúde ordenados por proximidade. 


#### Start Project
 - Build: mvn clean install
 - Start: mvn spring-boot:run
 
 #### Tecnologias Utilizadas
 - Spring Boot
 - Java
 - H2 Data Base
 - Maven
 - Postman

#### Bancos de Dados
Foi criado o esquema do banco de dados para armazenar dados ficticios das prestadoras de serviço e poder realizar o calculo de proximidade de acordo com a latitude, longitude e especialidade.

- Link de acesso: http://localhost:8080/h2-console/

- Não necessita de senha para acesso

 #### Esquema do H2
 ```
CREATE TABLE TB_HEALTH_PROVIDERS (
	id bigserial not null constraint tb_health_providers_pkprimary key,
	name varchar (255),
	address varchar (255),
	latitude double precision,
	longitude double precision
);
 ```

  #### API
  * (GET) /health-providers/find/specialty
  
  #### Payload para Teste
  ```
  {
    "geographicCoordinates": {
      "latitude": 2,
      "longitude": 3
    },
    "specialty": "Cardiologia"
  }
```