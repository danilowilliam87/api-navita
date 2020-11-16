Api para Gerenciamento de Patrimônios 

Tecnologias Utilizadas : 
1-Java 11.
2-Spring boot
3-Jwt para Geração de token
4-Banco de Dados MySQL
Projeto Criado no Site Spring initalzr

#Resumo
A api contém 3 endpoints que são : Usuários, Marca e patrimônio.

Os métodos do endpoint Usuários são : 
POST usuários -> Url : http://localhost:8080/usuario/salvar
PUT usuários  -> Url : http://localhost:8080/usuario/atualizar
GET usuário ->  Url : http://localhost:8080/usuario/id
GET listar usuário ->  Url : http://localhost:8080/usuario/lista
GET  usuário ->  Url : http://localhost:8080/usuario/nome (retorna o usuário com base no nome)
GET  usuário ->  Url : http://localhost:8080/usuario/email(retorna o usuário com base no email)
GET usuário -> > Url : http://localhost:8080/usuario/id

Os métodos do endpoint patrimônio são : 
POST patrimônio -> Url : http://localhost:8080/patrimonio/salvar
PUT patrimônio  -> Url : http://localhost:8080/patrimonioo/atualizar/id
GET patrimônio -> > Url : http://localhost:8080/patrimonio/buscar/id
GET listar patrimônio ->  Url : http://localhost:8080/patrimonio/lista
DELETE  patrimonio ->  Url : http://localhost:8080/patrimonio/delete/id 



Os métodos do endpoint Marca são : 
POST usuários -> Url : http://localhost:8080/marca/salvar
PUT usuários  -> Url : http://localhost:8080/marca/atualizar
GET usuário -> > Url : http://localhost:8080/marca/id
GET listar usuário ->  Url : http://localhost:8080/marca/lista
GET  usuário ->  Url : http://localhost:8080/marca/nome (retorna o usuário com base no nome)
GET  usuário ->  Url : http://localhost:8080/marca/email(retorna o usuário com base no email)

Todas as Requisiçoes e Resposta são estão no formato json.
json do usuario para p post e put 
{
    "nome":"nome",
    "email":"email",
    "senha":"senha"
}
no método put além de enviar o objeto json , é preciso enviar o id na url.
o mesmo serve para as outras entidades.

Json do patrimônio : 
{
    ""
}

Json Marca :
