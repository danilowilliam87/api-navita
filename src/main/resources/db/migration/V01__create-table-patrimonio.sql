

create table patrimonio(
   numero_tombo int not null auto_increment,
   nome varchar(100) not null,
   descricao varchar(100),
   marca_id int not null,
   primary key(numero_tombo)
);