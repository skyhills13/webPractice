DROP TABLE IF EXISTS USERS; 
 
CREATE TABLE USERS ( 
 id varchar(10) NOT NULL, 
 password varchar(10) NOT NULL, 
 name varchar(20) NOT NULL, 
 PRIMARY KEY (id) 
); 
