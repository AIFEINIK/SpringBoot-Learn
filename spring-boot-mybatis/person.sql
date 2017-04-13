DROP TABLE IF EXISTS person;
CREATE TABLE person(
	id INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	age INT NOT NULL,
	address VARCHAR(100) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO person(name, age, address) values ('feinik1', 26, '广州');
INSERT INTO person(name, age, address) values ('feinik2', 25, '北京');
INSERT INTO person(name, age, address) values ('feinik3', 24, '上海');