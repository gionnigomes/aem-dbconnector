Para poder usar o projeto, basta baixar o connector / driver de um banco (no meu caso, o mysql), instalá-lo no felix console do AEM, e adicionar uma configuração para poder utilizar o serviço OSGi DataSourcePool:
![image](https://user-images.githubusercontent.com/61244675/162733554-7cdb53c5-8f4c-454e-9b6b-e228646e40dc.png)

Também é necessário criar um banco de dados com nome "aem_db", e adicionar uma tabela "user_table" com duas colunas: "user_name" e "age". Abaixo os comandos usados por mim:
> create database aem_db;
> use aem_db;
> create table user_table (user_name varchar(80), age int);

* Para inserir um registro no banco:
![image](https://user-images.githubusercontent.com/61244675/162734201-284da0bf-f08a-494d-8cba-76c13750d013.png)

* Para consultar os registros:
![image](https://user-images.githubusercontent.com/61244675/162734335-eaf2e856-6310-44e8-9998-4278e1bdf3c4.png)
