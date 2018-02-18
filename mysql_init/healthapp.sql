CREATE DATABASE IF NOT EXISTS healthapp DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE healthapp;

DROP TABLE IF EXISTS doctor;
CREATE TABLE IF NOT EXISTS doctor (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  speciality varchar(100) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS `user` (
  id int(11) NOT NULL AUTO_INCREMENT,
  email varchar(50) NOT NULL,
  password varchar(50) NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  role int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `user` (id, email, `password`, first_name, last_name, role) VALUES
(1, 'a@z.de', 'pw', 'fn', 'ln', 0);

