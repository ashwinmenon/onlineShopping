
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
 status number(1) DEFAULT 0,
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


