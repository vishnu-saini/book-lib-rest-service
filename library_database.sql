create database library;
drop database library;
use library;

show tables;
desc book_author;

insert into book_author (email,first_name,last_name,pen_name) 
values ("author1@gmail.com","Author1_fname","Author1_lname","Author1_pname"),
("author2@gmail.com","Author2_fname","Author2_lname","Author2_pname"),
("author3@gmail.com","Author3_fname","Author3_lname","Author3_pname"),
("author4@gmail.com","Author4_fname","Author4_lname","Author4_pname");

select * from book_author;

desc publisher;

insert into publisher (creation_date,name) values(current_timestamp(),"Publisher1");

select * from publisher;

desc book_category;

insert into book_category (name) values("Science fiction"),("Satire"),("Drama"),("Action and Adventure"),("Romance"),("Mystery"),("Horror"),("Other");

select * from book_category;


desc student;

insert into book (edision,name,number_of_book_available,author_id,category_id,publisher_id) 
values ("Edision1","Java in Practice",15,1,1,1),
("Edision2","Database",45,1,1,1),
("Edision1","Database",6,1,1,1),
("Edision3","Database",4,1,1,1),
("Edision5","Database",9,2,1,1);


select * from student;

drop table student;

select book0_.isbn as isbn1_0_,
 book0_.author_id as author_i5_0_,
 book0_.category_id as category6_0_,
 book0_.edision as edision2_0_,
 book0_.name as name3_0_,
 book0_.number_of_book_available as number_o4_0_,
 book0_.publisher_id as publishe7_0_
 from book book0_ 
 where book0_.author_id=1 
 limit 2, 2;
 
 desc student;

desc book_loan;


select * from student;
select * from library_employee;

insert into library_employee (email,first_name,last_name,password,role) 
values ("employee1@gmail.com","employee1_fname","employee1_lname","password","librarian");
select * from book_loan;

insert into book_loan (status,book_id,loan_by_employee_id,student_id) 
values ("issued",6,1,1);