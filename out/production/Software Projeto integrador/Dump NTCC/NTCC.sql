CREATE DATABASE  IF NOT EXISTS `ntcc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ntcc`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: ntcc
-- ------------------------------------------------------
-- Server version	5.5.51-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `aluno`
--

LOCK TABLES `aluno` WRITE;
/*!40000 ALTER TABLE `aluno` DISABLE KEYS */;
INSERT INTO `aluno` VALUES (1,'rubens diego','santana de oliveira','Masculino','rdsdo100@gmail.com','20151043002','sistema de informação',NULL,'499345'),(2,'Alan','Carlos','Masculino','alan@gmail.com','20161043005','sistemas de informação',NULL,'0000000'),(3,'Regis Diogo','Santana de Oliveira','Masculino','regis@gmail.com','20171043002','Engenharia da Computação',NULL,'2316546');
/*!40000 ALTER TABLE `aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'sistema de informação'),(2,'pedagogia'),(3,'Engenharia Civil'),(4,'Engenharia da Computação'),(5,'Direito');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'rubens','diego','20151043002','root','root'),(2,'rubens','diego','20151043002','rdsdo','rubens100'),(3,'camila','soares','201419324','camila','123');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `grupo_tcc`
--

LOCK TABLES `grupo_tcc` WRITE;
/*!40000 ALTER TABLE `grupo_tcc` DISABLE KEYS */;
INSERT INTO `grupo_tcc` VALUES (3,14,1),(4,14,2),(5,14,1),(6,14,2),(7,15,1),(8,15,1),(9,15,2),(10,15,1);
/*!40000 ALTER TABLE `grupo_tcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `nomedocumento`
--

LOCK TABLES `nomedocumento` WRITE;
/*!40000 ALTER TABLE `nomedocumento` DISABLE KEYS */;
/*!40000 ALTER TABLE `nomedocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (4,'rubens','diego','Masculino','rdsdo100@hotmail.com','123456','meste',NULL);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `tcc`
--

LOCK TABLES `tcc` WRITE;
/*!40000 ALTER TABLE `tcc` DISABLE KEYS */;
INSERT INTO `tcc` VALUES (14,NULL,'dd25','2017-05-12','2017-05-18',2,4,0),(15,'TCC II','dd','2017-05-12','2017-05-18',2,4,0);
/*!40000 ALTER TABLE `tcc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ntcc'
--

--
-- Dumping routines for database 'ntcc'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-22 19:46:30
