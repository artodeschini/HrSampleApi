# Api sample RH

## requisitos

* maven
* java 17
* lombok

## Sobre

Esté sistema foi criaod utilizando [spring](https://start.spring.io/) com Java 17
A versão do spring utilizada foi 3.1.4 com maven
Para maiores detalhes e ajuda com spring com [spring](HELP.md)

## cliente react

Para utilizar a interface grafica desenvolvida em conjunto [react-project-app](https://github.com/artodeschini/HrSampleApp)

## Base de dados

Foi utilizada [h2 database](https://www.h2database.com/html/main.html), porém pode ser substituido por qualquer banco de dados relacional que tenha suporte a jdbc4
Para acessar a [console h2](http://localhost:8080/h2-console) voce pode utilizar esse link

## boilerplate

A fim de evitar a `boilerplate` codigo repetitivo foi utilizado [lombok](https://projectlombok.org/) afim de remover codigo como get e set construtores e escrita do metodo toString

[implementado](src/main/java/org/todeschini/rh/model/Empregado.java)
