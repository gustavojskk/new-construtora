-- comentario
-- a linha a baixo cria um banco de dados
create database newconstrutora;
-- a linha abaixo escolhe o banco de dados que vai usar
use newconstrutora;
-- a "linha" abaixo cria uma tabela
/*create table tabelausuarios(
idusuario int primary key auto_increment,
nome varchar(45) not null,
login varchar(15) not null unique,
senha varchar(15) not null
);

-- o comando abaixo descreve a tabela
describe tabelausuarios;*/
-- a linha abaixo insere dados na tabela(crud)
-- create -> insert
/*insert into tabelausuarios (idusuario, nome, login, senha)
values (1, 'Zé aldo', 'zezinho', '123456');
-- a linha abaixo exibe os dados da tabela(crud)
-- read -> select
select * from tabelausuarios;
insert into tabelausuarios (idusuario, nome, login, senha)
values (2, 'ronaldo', 'ronaldinho', '123456');
insert into tabelausuarios (idusuario, nome, login, senha)
values (3, 'administrador','admin' , 'admin');

-- a linha abaixo modifica os dados da tabela (crud)
-- update -> update
-- update tabelausuarios set telefone='222222' where iduser=2;
-- /\ atualizar a tabela /\ set=colocar telefone= numero desejado, where= onde? iduser desejado no caso foi o 2
-- a linha abaixo apaga um registro da tabela (crud)
-- delete -> delete
-- para deletar o codigo é -> delete from tabelausuarios where iduser=x;
*/
create table tabelaclientes(
idclientes int primary key auto_increment,
nome varchar(50) not null,
cpf varchar(50) not null,
CNPJ varchar(50) not null,
RG varchar(50) not null,
Cel varchar(50) not null,
Fixo varchar(50) not null,
email varchar(100) not null,
Rua varchar(100) not null,
Numerocasa varchar(100) not null,
CEP varchar (50) not null,
Bairro varchar (50) not null,
cidade varchar (50) not null,
Complemento varchar (50) not null
);
describe tabelaclientes;
-- drop table tabelaclientes;

insert into tabelaclientes(nome, cpf, CNPJ, RG, Cel, Fixo, email, Rua, Numerocasa, CEP, Bairro, cidade, Complemento)
values ('jose', '19803836773', '13345678','12345678', '997330849', '30327189', 'zézinho@gmail.com', 'Oslo', '108', '29103120', 'Araças', 'Vila Velha', 'Casa');

select * from tabelaclientes;

create table orcamento(

Ordem int primary key auto_increment,
materiais varchar(250) not null,
quantidade varchar(250) not null,
servico varchar(250) not null,
prazodeobra varchar(250) not null,
total varchar(250) not null,
idclientes int not null,
foreign key (idclientes) references tabelaclientes(idclientes)
);
insert into orcamento( idclientes, materiais, quantidade, servico, prazodeobra, total)
values ('1', 'Vergalhao', '15', 'Fazer Coluna', '1 semana', '5000');
describe orcamento;
select * from orcamento;




/*create table TabelaOS(
Ordem int primary key auto_increment,
dataOrdem timestamp default current_timestamp,
Servico varchar(250),
-- decimal serve para limitar quantas casas decimais o numero vai ter após a virgula, sendo assim, é bem usado para lidar com dinheiro
Preco  decimal(10,2) not null,
tempoObra varchar(50) not null,
Endereco varchar(250),
idclientes int not null,
foreign key (idclientes) references tabelaclientes(idclientes)
);*/

-- drop table tabelaOS;
-- DROP TABLE serve para excluir a tabela toda
/*describe TabelaOS;

insert into TabelaOS(Servico, Preco, tempoObra, Endereco, idclientes)
values ('Reformar Parede', '1000', '1 semana', 'Araças', 1);

select * from TabelaOS;*/

create table Materiais(
idprod int primary key auto_increment,
produto varchar(100)not null,
preco int not null,
quantidade varchar (250) not null,
loja varchar(100),
cidade varchar(100),
bairro varchar(100)
);
select * from Materiais;

insert into Materiais( produto, preco, quantidade, loja, cidade, bairro)

values ('lajota', 0.79, 20, 'DB', 'Vila Velha', 'garrido');

-- o codigo abaixo me tras 1 campo da tabela materias e multiplica outros 2 campos me mostrando como uma linha "total"
select produto, preco * quantidade as 'TOTAL'
from Materiais;
-- update Materiais set quantidade=15 where idprod= 2;

-- o codigo a seguir traz informações de 2 tabelas
/*select
Servico, tempoObra, Preco,
C.nome, Cel, cpf
from tabelaclientes as C
inner join TabelaOS as O
on (O.idclientes=C.idclientes);*/

create table fornecedores(
idemp int primary key auto_increment,
empresa_nome varchar(100) not null,
cidade varchar(100),
bairro varchar(100),
email varchar(100),
telefone varchar(45) not null,
celular varchar(45) not null
);
-- drop table fornecedores;


insert into fornecedores(empresa_nome, cidade, bairro, email, telefone, celular)
values('Casadoconstrutor', 'Vila Velha', 'Novo mexico', 'casadoconstrutor@gmail.com', '30327189', '998100372');
select * from fornecedores;

create table terceirizados(
idt int primary key auto_increment,
nome varchar(100) not null,
endereco varchar(100) not null,
funcao varchar (100) not null,
telefone varchar (45) not null
);


insert into terceirizados(nome, endereco, funcao, telefone)
values('joão', 'rua 81', 'pedreiro', '9999999');

create table contratoTer(
nomeT varchar(45) not null,
endereco varchar(45) not null,
funcao varchar(45) not null,
descricao varchar(250) not null
);

-- drop table contratoTer;

insert into contratoTer(nomeT, endereco, descricao, funcao)
values ('João', 'rua 183','fumar droga', 'pedreiro');

create table contratocli(
idcontrato int primary key auto_increment not null,
nome varchar(50) not null,
endereco varchar(100) not null,
enderecoObra varchar(100) not null,
idclientes int not null,
foreign key (idclientes) references tabelaclientes(idclientes));

-- drop table contratocli;

insert into contratocli(nome, endereco,enderecoObra, idclientes)
values ('zé aldo', 'rua 183', 'rua 183', 1);

select * from contratocli;
