create table register (reg_no int PRIMARY KEY,nam varchar(25),age int,par_nam varchar(25),phone varchar(10),prio_rem varchar(25),prio_no int,stat varchar(5));

create table staff(id int PRIMARY KEY,nam varchar(25),rno int,phone varchar(10),dept varchar(20),spec varchar(20));

create table access(uname varchar(25) PRIMARY KEY,pass varchar(10),id int,dept varchar(20),FOREIGN KEY (id) REFERENCES staff(id));

create table slot (sl_no int PRIMARY KEY, descr varchar(50));

create table app(app_id int PRIMARY KEY,doc_id int,dat date,reg_no int,sl_no int,stat varchar(5),book varchar(5),approve varchar(5),FOREIGN KEY (doc_id) REFERENCES staff(id),FOREIGN KEY (reg_no) REFERENCES register(reg_no),FOREIGN KEY (sl_no) REFERENCES slot(sl_no));