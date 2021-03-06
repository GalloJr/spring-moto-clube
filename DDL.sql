create schema motoclube;
use motoclube;
create table usr_usuario (
usr_id bigint unsigned not null auto_increment,
usr_nome varchar(20) not null,
usr_email varchar(100) not null,
usr_senha varchar(100) not null,
	primary key (usr_id),
	unique key uni_usuario_nome (usr_nome),
	unique key uni_usuario_email (usr_email)
);
create table aut_autorizacao (
aut_id bigint unsigned not null auto_increment,
aut_nome varchar(20) not null,
	primary key (aut_id),
	unique key uni_aut_nome (aut_nome)
);
create table uau_usuario_autorizacao (
usr_id bigint unsigned not null,
aut_id bigint unsigned not null,
	primary key (usr_id, aut_id),
	foreign key uau_usr_fk (usr_id)
	references usr_usuario (usr_id)
	on delete restrict on update cascade,
	foreign key uau_aut_fk (aut_id)
	references aut_autorizacao (aut_id)
	on delete restrict on update cascade
);
create table mem_membro (
mem_id bigint unsigned not null auto_increment,
mem_nome varchar(20) not null,
mem_apelido varchar(20) not null,
mem_data_ingresso date not null,
mem_patente varchar(20) unsigned,
	primary key (mem_id),
	unique key uni_mem_apelido (mem_apelido)
	
);

create  table vei_veiculo(
	vei_id bigint unsigned not null auto_increment,
    vei_mem_id bigint unsigned not null,
    vei_marca varchar(20) not null,
    vei_modelo varchar(20) not null,
    vei_placa varchar(20) not null,
	primary key (vei_id),
    foreign key vei_usr_fk (vei_mem_id)
	references mem_membro (mem_id)
	on delete restrict on update cascade,
	unique key uni_vei_placa(vei_placa)
);
