set @@global.time_zone = '+00:00';
set @@session.time_zone = '+00:00';

create table userTest(
	login varchar(255) primary key,
	motdepasse varchar(255) not null,
	authorities varchar(500) default null,
	non_expired tinyint(1) default null,
	non_locked tinyint(1) default null,
	credentials_non_expired tinyint(1) default null,
	enabled tinyint(1) default null,
	nom varchar(255) not null,
	prenom varchar(255) not null,
	numtel varchar(10),
	email varchar(255),
	rue varchar(255) not null,
	localite varchar(255) not null,
	codepostal int not null,
	numrue varchar(5) not null
);

create table produit(
	numproduit integer auto_increment primary key,
	prixcatalogue double not null,
	tvaappliquee double not null,
	urlimg varchar(255) not null,
);

create table commande(
	id int auto_increment primary key,
	datecommande date not null,
	clientid varchar(255) not null,
	foreign key(clientid) references user(login)
);

create table lignecommande(
	id int auto_increment primary key,
	quantite int not null,
	prix float not null,
	commandeid int not null,
	produitid int not null,
	foreign key(commandeid) references commande(id),
    foreign key(produitid) references produit(numproduit)
);

create table langue(
	id varchar(255) primary key
);

create table traduction(
	id integer auto_increment primary key,
	nom varchar(255) not null,
	descrip varchar(255) not null,
	numproduit int not null,
	langueid varchar(255) not null,
	foreign key(numproduit) references produit(numproduit),
    foreign key(langueid) references langue(id)
);
