create database academia;
use academia;

create table cargo(
id int not null primary key,
cargo varchar(45) not null,
salario int not null
);

create table funcionarios(
id int not null primary key auto_increment,
nome varchar(45) not null,
cpf char(11) not null,
data_nascimento date not null,
id_cargo int not null,
data_admissao date not null,
data_demissao date,
ativo boolean not null default false,

foreign key (id_cargo) references cargo (id)
);


create table treino(
id int not null primary key auto_increment,
nome varchar(45) not null,
numero_divisoes int not null,
descricao varchar(100),
descricao_dias varchar(100)
);

create table grupos_musculares(
id int not null primary key,
grupo_muscular varchar(45) not null

);

create table exercicios(
id int not null primary key auto_increment,
nome varchar(45) not null,
grupo_musculares_id int not null,

foreign key (grupo_musculares_id) references grupos_musculares(id)
);


create table exercicios_treinos(
id_exercicios int default null,
id_treinos int default null,
divisao varchar(2) not null,
series int not null,
repeticoes int not null,

foreign key (id_exercicios) references exercicios (id),
foreign key (id_treinos) references treino (id)
);


create table planos(
id int not null primary key,
nome varchar(45) not null,
tempo_plano varchar(45) not null
);

create table usuarios(
id_carteirinha int not null primary key auto_increment,
nome varchar(45) not null, 
cpf char(11) not null,
data_nascimento date not null,
treino_id int,
plano_id int,
ativo boolean not null default false,

foreign key (treino_id) references treino (id),
foreign key (plano_id) references planos (id)
);

;
