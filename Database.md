Harshal Borase
<br><br>
Airline Management System (Java Project)
<br><br>
<br>
-------------------------------------------------------<br>
Execute these queries one by one in your MySQL Console<br>
-------------------------------------------------------<br>
<br>
<br>
1 - Create a database with name airlinemanagementsystem;<br>
<br>
create database airlinemanagementsystem;<br>
<br>
2 - Use the database you have just created<br>
<br>
use airlinemanagementsystem;<br>
<br>
3 - Create first table login inside the airlinemanagementsystem database;<br>
<br>
create table login(username varchar(20), password varchar(20));<br>
<br>
4 - Insert value in the login table for the admin to login<br>
<br>
insert into login values('admin', 'admin');<br>
<br>
5 - Create next table passenger to store user values;<br>
<br>
create table passenger (name varchar(20), nationality varchar(20), phone varchar(15), address varchar(50), aadhar varchar(20), gender varchar(20));<br>
<br>
6 - Create table to store flight information<br>
<br>
create table flight(f_code varchar(20), f_name varchar(20), source varchar(40), destination varchar(40));<br>
<br>
7 - Insert some flight information in the flight table<br>
<br>
insert into flight values("1001", "AI-1212", "Delhi", "Mumbai");<br>
insert into flight values("1002", "AI-1453", "Delhi", "Goa");<br>
insert into flight values("1003", "AI-1112", "Mumbai", "Chennai");<br>
insert into flight values("1004", "AI-3222", "Delhi", "Amritsar");<br>
insert into flight values("1005", "AI-1212", "Delhi", "Ayodhya");<br>
<br>
<br>
8 - Create reservation table to store user ticket booking information<br>
<br>
create table reservation(PNR varchar(15), TICKET varchar(20), aadhar varchar(20), name varchar(20), nationality varchar(30), flightname varchar(15), flightcode varchar(20), src varchar(30), des varchar(30), ddate varchar(30));<br>
<br>
9 - Create table cancel to store cancel tickets information<br>
<br>
create table cancel(pnr varchar(20), name varchar(40), cancelno varchar(20), fcode varchar(20), ddate varchar(30));<br>
