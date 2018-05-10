create table bs_user(
  id int primary key auto_increment,
  username varchar(50) not null,
  pwd varchar(30),
  name varchar(255),
  tel varchar(30),
  gender varchar(1)
)
insert into bs_user(username,pwd,name,tel,gender)values("xixi","123456","xixi","653727","m")
select * from bs_employee
create table bs_employee(
  id varchar(50) primary key not null,
  name varchar(50),
  gender varchar(10),
  age varchar(10),
  tel varchar(50),
  id_card varchar(50),
  address varchar(50),
  other varchar(50)
)
insert into  bs_employee(id,name,gender,age,tel,id_card,address,other)values("1","1","1","1","1","1","1","1")