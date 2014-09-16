DROP TABLE IF EXISTS USERS; 
 
CREATE TABLE USERS ( 
 userId varchar(12) NOT NULL, 
 password varchar(12) NOT NULL, 
 name varchar(20) NOT NULL, 
 PRIMARY KEY (userId) 
); 
