# DEVin-Adotation
##Projeto avaliativo do curso FuturoDEV - Módulo 3

## Introdução

Uma empresa especializada em desenvolvimento de aplicações
deseja desenvolver uma aplicação para controle de estoque 
de materiais para ONGs. Com isso a **LAB CAT&DOG** está 
contratando novos desenvolvedores para o seu quadro de 
colaboradores, com o intuito de expandir os negócios, os 
gestores entendem que antes de finalizar as contratações,
é necessário executar um desafio prático onde o futuro 
colaborador deverá criar um sistema de controle de estoque. 
É hora de ficar feliz, pois você foi escolhido para criar o **DEVin-Adotation**.

## Como rodar o projeto?

```bash
# Clone este repositório
$ git clone link-do-projeto

# Acesse a pasta do projeto no seu terminal
$ cd adotation

# Abra a aplicação na IDE Intellij
```
Configure o Banco de Dados através do arquivo _aplication.properties_
Após abra um arquivo e clique em run para rodar o projeto. 
A aplicação será iniciada na porta 8080, por exemplo.

## Como utilizar o projeto?

Será necessário o uso de _EndPoints_

* Para Cadastrar Usuário

**POST** '/usuario'
```json
{
  "nome": "Fulano de Tal",
  "email": "fulano@gmail.com",
  "senha": 12345678
}
```
* Para Cadastrar Produto
**POST** '/produto'
```json
{
  
}
```

* Para Login de Usuário

**POST** '/login'
```json
{
  "email": "fulano@gmail.com",
  "senha": 12345678
}
```


## 👏Pessoas envolvidas no projeto

<a href= "https://www.linkedin.com/in/maristelapeglow/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Maristela
#
<a href= "https://www.linkedin.com/in/renato-aires-5128b7189/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Renato
#
<a href= "https://www.linkedin.com/in/vini-andrade-35ab6421/" target= "_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target= "_blank"/> Vinícius