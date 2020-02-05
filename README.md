# Hotel API Service

> Status: _em desenvolvimento._

API para lidar com gerenciamento de Hotelaria. Este aplicativo foi escrito usando o framework Spring Boot Java.

## Progresso

- [ ] Implemetação básica da API
  - [x] /clientes
  - [x] /clientes/id
  - [x] /hospedagens
  - [x] /hospedagens/id
  - [x] /quartos
  - [x] /quartos/id
  - [ ] /servicos
  - [ ] /servicos/id
- [ ] Testar endpoints da API
- [ ] Autenticação de usuários - JWT
- [ ] Imagens dos quartos

## Exigências

Para executar a API localmente, você precisará do seguinte instalado em sua máquina:

- [Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)
- [MongoDB](https://www.mongodb.com/)
- [Postman](https://www.getpostman.com/)

## Começando

- ### Opção 1: **Executando a aplicação no Spring Tool Suite**

- [Spring Tools](https://spring.io/tools)

1. git clone https://github.com/mathzMV/api-hotel-projeto-lp2.git
2. Execute o Spring Tool e importe o projeto:

> 1. File
> 2. import
> 3. Git
> 4. Projects From Git (with smath import)
> 5. Existing local repository
> 6. Add
> 7. adicione o diretório onde o projeto foi clonado
> 8. selecione o projeto
> 9. Finish

3. Inicie o MongoDB pelo terminal: **mongod**
4. Execute a aplicação:

> - src/main/java
>   - com.matheus.apiprojetolp2
>     - ApiProjetoLp2Application.java

5. Utilize os endpoints através do navegador(GET) ou Postman(GET, POST, PUT, DELETE).

- ### Opção 2: **Gerando o .jar e executando a aplicação no terminal**

> - Ao optar por este método de execução será necessário criar os documentos no banco de dados através de requisições POST ou     diretamente usando o [compass](https://www.mongodb.com/products/compass).

1. git clone https://github.com/mathzMV/api-hotel-projeto-lp2.git
2. remova a pasta: src/main/java/com/matheus/apiprojetolp2/config (temporário)
3. Em api-hotel-projeto-lp2 execute: **./mvnw clean package**
4. Incie o MongoDB pelo terminal: **mongod**
5. Execute o .jar: **java -jar target/programa.jar**
6. Utilize os endpoints através do navegador(GET) ou Postman(GET, POST, PUT, DELETE).

## Endpoints da API (em progresso...)

| **Clientes** | **Quartos** | **Hospedagens** | **Serviços** |
|--------------|-------------|-----------------|--------------|
| /clientes    | /quartos    | /hospedagens    | /servicos    |
| /clientes/id | /quartos/id | /hospedagens/id | /servicos/id |

## Equipe de desenvolvimento

[<img src="https://avatars0.githubusercontent.com/u/51245188?s=460&v=4" width="115"><br><smal>@matheusmv</smal>](https://github.com/matheusmv)
[<img src="https://avatars2.githubusercontent.com/u/32533017?s=460&v=4" width="115"><br><smal>@robsonsants</smal>](https://github.com/robsonsants)|
| :---: | :---: |
