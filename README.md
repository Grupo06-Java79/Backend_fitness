# Aplicativo Fitness
Projeto 03 do Grupo 06 da Turma 79 Java do Bootcamp Generation

INTEGRANTES
<br>Guilherme Kaludin
<br>João Oliveira
<br>Juliana Monteiro
<br>Lucas Daniel
<br>Tainá Lara


PROJETO INTEGRADOR
ESCOPO DO PROJETO

Tema: Aplicativo Fitness

Título do Projeto e Modelo de Negócio escolhido:  
Aplicativo Fitness
<br>Uma plataforma fitness para cálculo do IMC, onde usuários podem inserir seus dados e receber uma classificação baseada no índice de massa corporal.


Descrição Geral do Projeto: 
<br>O projeto aplicativo fitness é uma aplicação desenvolvida em Spring Boot que gerencia as operações relacionadas ao cálculo do IMC, permitindo que usuários cadastrem seus exercícios e acompanhem sua evolução. O Sistema conta com um mecanismo de autenticação, onde cada usuário precisa se identificar por meio de um nome de usuário e senha para acessar a plataforma.

Descrição da Entidade/Model foi criada e seus atributos: 
<br>Criamos as Model’s Usuário, Exercicio e Categoria.
<br>(tb_usuario) com os atributos id, nome, usuario, senha, foto, peso, altura, e idade.
<br>(tb_exercicio) com os atributos id,  nome, descricao, aparelho, serie, repeticao, FK id usuario e FK id categoria.
<br>(tb_categoria) com os atributos id, tipo e grupo.


### Funcionalidades Principais (CRUD) implementadas
Criamos as seguintes funcionalidades:
<br>Getters and Setters
<br>findAll()
<br>findById()
<br>findAllByNome()
<br>get(),
<br>post()
<br>put()
<br>delete()
<br>Método utilitário para calcular o IMC com base no peso e altura do usuário:
<br>calcularIMC()
<br>Método utilitário para classificar o IMC do usuário:
<br>classificarIMC()
<br>Métodos de segurança:
<br>userDetailsService()
<br>passwordEncoder()
<br>authenticationManager
<br>filterChain(HttpSecurity http)
<br>extractAllClaims(String token)
<br>extractUsername(String token)
<br>extractExpiration(String token)
<br>isTokenExpired(String token)
<br>generateToken(String username)
<br>validateToken(String token, UserDetails details)
<br>getAuthorities()
<br>isAccountNonExpired()
<br>isAccountNonLocked()
<br>isCredentialsNonExpired()


### Tecnologias Utilizadas (banco de dados e backend):
Java 17+ 
<br>Maven Plugin
<br>MySql Driver
<br>JPA/Hibernate
<br>Spring Boot Dev Tools
<br>Spring Web
<br>Spring Validation
<br>Spring Security
<br>JSON Web Token
<br>Swagger
<br>PostgreSQL
<br>Docker
<br>Render

