# Sistema de chat com usuários posts e comentários
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/joaohnt/ws-springboot-mongodb/blob/main/LICENSE)  

# Sobre o projeto

Este projeto implementa um sistema de chat com usuários, posts e comentários e com a utilização das operações CRUD, também foi usado Query para filtragem mais precisa. 

## Modelo conceitual
![image](https://github.com/user-attachments/assets/f310a448-414b-422b-bba8-8fd214c27cc2)


# Tecnologias utilizadas
- Java
- SpringBoot
- MongoDB
- Postman

## Endpoints

- Usuários

GET /users: Retorna todos os usuários.

GET /users/{id}: Retorna um usuário específico pelo ID.

POST /users: Cria um novo usuário (em JSON).

PUT /users/{id}: Atualiza um usuário existente.

DELETE /users/{id}: Deleta um usuário pelo ID.


- Posts

GET /posts: retorna todos os posts.

GET /posts/{id}: retorna um post específico pelo ID.

GET /posts/titlesearch: Pesquisa posts por título.

GET /posts/fullsearch: Pesquisa posts com texto, data mínima e data máxima.


# João Pedro Carvalho Garcia

https://www.linkedin.com/in/joaohnt
