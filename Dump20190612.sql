CREATE DATABASE  IF NOT EXISTS `smokdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `smokdb`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smokdb
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admins` (
  `a_id` int(11) NOT NULL,
  `a_pwsaltedhash` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (91,NULL),(111,NULL),(160,NULL),(209,NULL),(160000,NULL),(878979,NULL),(9999991,NULL),(21231828,NULL),(123456789,'$2a$12$gZua23TxV7eyldSASUU8muJDrozrWIgzz1nrjfNtnq/2IY7y6iOIO');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allusers`
--

DROP TABLE IF EXISTS `allusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `allusers` (
  `id` int(11) NOT NULL,
  `saltedhashpw` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allusers`
--

LOCK TABLES `allusers` WRITE;
/*!40000 ALTER TABLE `allusers` DISABLE KEYS */;
INSERT INTO `allusers` VALUES (160714,'$2a$12$CXcvS6SuX9NGOBN6S23ObeMNSy5eGTyEcsbev4TzymzIp.e3Ov8FC'),(290100,'$2a$12$QS7BMSZMEhHNXDFAR9l/RuFICvbE.Q3OMn33H0ezOLyrMJMWecvwe'),(910900,'$2a$12$o7lBJGbYI5DJfR3KDfggKeBBw3tXnvipNn6XJbM7Z5jM9iciUtRMO');
/*!40000 ALTER TABLE `allusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postimet`
--

DROP TABLE IF EXISTS `postimet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postimet` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `post_titulli` varchar(45) NOT NULL,
  `post_lenda` varchar(80) NOT NULL,
  `post_dataora` varchar(50) NOT NULL,
  `post_salla` char(5) NOT NULL,
  `post_pershkrimi` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postimet`
--

LOCK TABLES `postimet` WRITE;
/*!40000 ALTER TABLE `postimet` DISABLE KEYS */;
INSERT INTO `postimet` VALUES (1,'','sdfgh','2019-06-11T13:34:35.284','qq','w'),(2,'t','l','2019-06-11T13:48:52.714','s','p'),(3,'provim','aok','2019-06-11T16:46:48.380','714','qwertyu'),(4,'Konsulltimet per K1','Komunikimi Njeri-Kompjuter','2019-06-12T12:47:58.397','717','Vini nga \n ora 11-30 \ndhe 12-30 neser '),(5,'Konsulltimet per provimin ','Arkitektura e Kompjutereve','2019-06-12T13:58:33.707','700','Ora 12:00\n'),(6,'Konsultimet per provim','Matematike 3K','2019-06-12T16:15:31.412','615','Ejani neser\nne ora 12:00'),(7,'titulli','Sinjale','2019-06-12T18:46:00.233','s','ppp'),(8,'','','2019-06-12T18:55:38.975','',''),(9,'Konsultimet per k2','Elektronike','2019-06-12T18:56:28.905','a411','Ejani\npasdite \nneeser ne ora 16:00'),(10,'Konsultimet per projekte','Programii ne INternet','2019-06-12T18:57:21.369','700',''),(11,'Konsultimet rreth provimit','Inxhinieri Softuerike','2019-06-12T22:05:28.594','500','Kandidatet nen 50 pike\nte vijne neser ne ora 15:00\n. Te tjeret ne ora 16:00');
/*!40000 ALTER TABLE `postimet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professors`
--

DROP TABLE IF EXISTS `professors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `professors` (
  `p_id` int(11) NOT NULL,
  `p_emri` varchar(45) NOT NULL,
  `p_mbiemri` varchar(45) NOT NULL,
  `p_email` varchar(45) NOT NULL,
  `p_saltedhashpw` varchar(250) NOT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professors`
--

LOCK TABLES `professors` WRITE;
/*!40000 ALTER TABLE `professors` DISABLE KEYS */;
INSERT INTO `professors` VALUES (1,'Sinan','Dobreva','sinani@sinani','$2a$12$eol2by6Dg8xIcxKkp07n.Oeo6fjQeTdnXdoMsCo4q536bwH1E5yBG'),(2,'Profa1','pppp','fgh@ddda','$2a$12$w2og1JpGHTmrswjt0/1LlelVm/EtyYBAO74r3iTGcR3C6R1Lxqtaq'),(222,'Filanus','Fistekus','testest@testtest','$2a$12$fwOx4un16S1k4.8BJf3gqOUGoiAa6omI9DjwPxeDIy7SMxcsfq6V6'),(280100,'Isak ','Shabani','test@123test','$2a$12$O37xYClnmEWvgZmvptB7nuB/Z2XkizjZ7FyDnz697kigdZRT8v0xK'),(290100,'Endrit','Ilazi','test@1t','$2a$12$QS7BMSZMEhHNXDFAR9l/RuFICvbE.Q3OMn33H0ezOLyrMJMWecvwe');
/*!40000 ALTER TABLE `professors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `s_id` int(11) NOT NULL,
  `s_emri` varchar(45) NOT NULL,
  `s_mbiemri` varchar(45) NOT NULL,
  `s_email` varchar(45) NOT NULL,
  `s_saltedhashpw` varchar(250) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (34,'milot','rashica','m.r@aaskkfma.com','$2a$12$3JF41PLRPCkNg7lIhgPeoeltBGM79zThV4ps3K7pl1RMksQdxQNp6'),(710,'Cristiano ','Ronaldo','cristianoronaldo@smok.edu','v8JJiPUw'),(9798,'podepo','yesyeys','ad@ssdsd.com','$2a$12$cGz5Lav5vl69ypfMYhrRt.Ttb/d4uT67i9leGf4C.Ob4Mmkf7tn.S'),(11101,'kosova','albania','smok.unipr@gmail.com','$2a$12$Coi7FT7CLBqsDPNjY1hhCOJYZhZMBbkgvQVx17loWbJrhdaBMfU82'),(11111,'pppo','qoqoqoq','djdhsfhe','$2a$12$hpzMUinBCfd32jWEcNpWqeSQSrKNv29nDVc5PwMKmyQx7.Jj34aoC'),(160714,'Muhamed','Zeqiri','test@t','$2a$12$CXcvS6SuX9NGOBN6S23ObeMNSy5eGTyEcsbev4TzymzIp.e3Ov8FC'),(11111111,'Ndriqim','Muhadri','adsd@mgmggmm.com','$2a$12$nfJcT8pkAaeOMDnHqi6F7eah00F4yot.uq1zJNgC1TYgY72vOson6'),(11972334,'Lionel ','Messi','smok.unipr@gmail.com','uLGfmVEm'),(67898795,'Filan','Fisteku','filanfisteku@smok.edu','ende ne testim'),(77987878,'Muhamed','Zeqiri','muhamed@smok.edu','ende ne testim');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-12 23:23:05
