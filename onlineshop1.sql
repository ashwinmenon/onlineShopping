

CREATE TABLE commande 
(
  id number(11) NOT NULL,

  idUser number(11) NOT NULL,

  commande varchar(3000) NOT NULL,

  totale number NOT NULL,

  PRIMARY KEY (id)
) 
;

CREATE TABLE produit
 (
  id number(11) NOT NULL ,
 
 nom varchar(200) NOT NULL,

  description varchar(400) NOT NULL,
 
 prix varchar(200) NOT NULL,
 
 image varchar(400) DEFAULT NULL,

  PRIMARY KEY (id)
)
 ;

CREATE TABLE utilisateur
 (
  id number(11) NOT NULL ,

  username varchar(20) NOT NULL,

  first_name varchar(20) NOT NULL,

  last_name varchar(20) NOT NULL,
 
 password varchar(20) NOT NULL,

  email varchar(200) NOT NULL,
 
 role varchar(20) NOT NULL,

  photo varchar(600) DEFAULT NULL,
 
 PRIMARY KEY (id)
) 
  ;

CREATE TABLE panier
 (
  id number(11) NOT NULL,

  idProduit number(11) NOT NULL,

  idUser number(11) NOT NULL,

  qte number(11) NOT NULL,

  nom varchar(200) NOT NULL,

  description varchar(400) NOT NULL,

  prix number NOT NULL,

 image varchar(200) DEFAULT NULL,

  PRIMARY KEY (id)
) 
 ;

INSERT INTO produit (id, nom, description, prix, image) VALUES

 (4, 'Canon', 'Canon Pro', '1120', './images/prod2.jpg');

INSERT INTO utilisateur (id, username, first_name, last_name, password, email, role, photo) VALUES
(9, 'admin', 'Ashwin', 'Menon', 'admin', 'AR00478687@techmahindra.com', 'admin', './images/user.jpg'),
(11, 'user', 'user', 'user', 'user', 'salem.said.ing@gmail.com', 'user', './images/user.jpg'),
(12, 'salem', 'salem', 'said', 'salem', 'salem.said.ing@gmail.com', 'admin', './images/user.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

INSERT INTO commande (id, idUser, commande, totale) VALUES
(5, 11, ' \r\n Produit: Sumsung Galaxy S44 || Qunatité: 1\r\n \r\n Produit: HP Pavillon || Qunatité: 1\r\n', 2576),

(6, 11, ' \r\n Produit: HP Pavillon || Qunatité: 1\r\n \r\n Produit: Nokia Lumia 520 || Qunatité: 1\r\n \r\n Produit: Canon || Qunatité: 1\r\n', 3768.23);


CREATE TABLE users
 (
  id number(11) NOT NULL ,

  username varchar(20) NOT NULL,

  fname varchar(20) NOT NULL,

  lname varchar(20) NOT NULL,
 
 password varchar(20) NOT NULL,

  email varchar(200) NOT NULL,
 
 role varchar(20) NOT NULL,

  status number(2) DEFAULT 1,
 
 PRIMARY KEY (id)
) 
  ;


CREATE TABLE products
 (
  id number(11) NOT NULL ,
 
 name varchar(200) NOT NULL,

  description varchar(400) NOT NULL,
 
 price number(20) NOT NULL,

 category varchar(11) NOT NULL,
 rate number(11) DEFAULT 0, 
 image varchar(400) DEFAULT NULL,

  PRIMARY KEY (id)
)
 ;


CREATE TABLE transactions
 (
  id number(11) NOT NULL,

  idProduct number(11) NOT NULL,

  idUser number(11) NOT NULL,

  qty number(11) NOT NULL,

  type number(1) NOT NULL,
  name varchar(200) NOT NULL,

  description varchar(400) NOT NULL,

  price number NOT NULL,

 image varchar(200) DEFAULT NULL,

  PRIMARY KEY (id)
) 
 ;

CREATE TABLE orders
(
id number(11) NOT NULL,
idUser number(11) NOT NULL,
pay varchar(200),
orders varchar(300) NOT NULL,
total number NOT NULL,
PRIMARY KEY(id))
; 

insert into products values(1,'canon','camera',5000,'mobile',default,'./images/prod2.jpg');
insert into products values(2,'Hp Passion','Laptop',35000,'mobile',default,'./images/prod3.png');
insert into products values(3,'Nokia','Phone',7000,'mobile',default,'./images/prod4.png');

insert into users values(user_id.nextval,'admin','admin','admin','admin','admin@gmail.com','admin',default);


