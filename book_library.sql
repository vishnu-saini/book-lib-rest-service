-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `isbn` int(11) NOT NULL AUTO_INCREMENT,
  `edision` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_of_book_available` int(11) DEFAULT NULL,
  `author_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `genre_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`isbn`),
  KEY `FK_4sac2ubmnqva85r8bk8fxdvbf` (`author_id`),
  KEY `FK_8tbqyqnmcls0mij52knnk1ojr` (`category_id`),
  KEY `FK_19ss4s5ji828yqdpgm0otr93s` (`publisher_id`),
  KEY `FK_lwwyu1h28alv6nnnb31qnfq` (`genre_id`),
  CONSTRAINT `FK_19ss4s5ji828yqdpgm0otr93s` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`),
  CONSTRAINT `FK_4sac2ubmnqva85r8bk8fxdvbf` FOREIGN KEY (`author_id`) REFERENCES `book_author` (`id`),
  CONSTRAINT `FK_8tbqyqnmcls0mij52knnk1ojr` FOREIGN KEY (`category_id`) REFERENCES `book_category` (`id`),
  CONSTRAINT `FK_lwwyu1h28alv6nnnb31qnfq` FOREIGN KEY (`genre_id`) REFERENCES `book_genre` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (6,'Edision1','Java in Practice',14,1,1,1,14),(7,'Edision2','Database',45,1,1,1,14),(8,'Edision1','Database',4,1,1,1,14),(9,'Edision3','Database',1,1,1,1,14),(10,'Edision5','Database',9,2,1,1,14),(11,'1','The God of Small Things ',14,1,1,1,14),(12,'2','A Fine Balance',44,1,1,1,14),(13,'3','The White Tiger',5,1,1,1,14),(14,'6','Midnight\'s Children',3,1,1,1,14),(15,'2','The Namesake ',9,2,1,1,14),(16,'fourth','Book 1',40,2,10,1,NULL),(17,'4th','java',83,1,10,7,NULL);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_author`
--

DROP TABLE IF EXISTS `book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `pen_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_author`
--

LOCK TABLES `book_author` WRITE;
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` VALUES (1,'author1@gmail.com','Author1_fname','Author1_lname','Author1_pname'),(2,'author2@gmail.com','Author2_fname','Author2_lname','Author2_pname'),(3,'author3@gmail.com','Author3_fname','Author3_lname','Author3_pname'),(4,'author4@gmail.com','Author4_fname','Author4_lname','Author4_pname');
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_category`
--

DROP TABLE IF EXISTS `book_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_category`
--

LOCK TABLES `book_category` WRITE;
/*!40000 ALTER TABLE `book_category` DISABLE KEYS */;
INSERT INTO `book_category` VALUES (1,'Novel'),(9,'Fiction'),(10,'Nonfiction'),(11,'NA'),(12,'YA');
/*!40000 ALTER TABLE `book_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_genre`
--

DROP TABLE IF EXISTS `book_genre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_genre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_genre`
--

LOCK TABLES `book_genre` WRITE;
/*!40000 ALTER TABLE `book_genre` DISABLE KEYS */;
INSERT INTO `book_genre` VALUES (1,'Comedy'),(2,'Drama'),(3,'Horror'),(4,'Realistic'),(5,'Romantic'),(6,'Satire'),(7,'Tragedy'),(8,'Tragicomedy'),(9,'Fantasy'),(10,'Science fiction'),(11,'Action and Adventure'),(12,'Mystery'),(13,'Horror'),(14,'Other');
/*!40000 ALTER TABLE `book_genre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_loan`
--

DROP TABLE IF EXISTS `book_loan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `loan_by_employee_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `dateOfIssue` datetime DEFAULT NULL,
  `isReturned` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4wc6aop19gka9cx7wicu6c2ql` (`book_id`),
  KEY `FK_bjnf8v9fy2akluh2qysvbao3f` (`loan_by_employee_id`),
  KEY `FK_5ful455qb58xqigv7hd84ov2x` (`student_id`),
  CONSTRAINT `FK_4wc6aop19gka9cx7wicu6c2ql` FOREIGN KEY (`book_id`) REFERENCES `book` (`isbn`),
  CONSTRAINT `FK_5ful455qb58xqigv7hd84ov2x` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `FK_bjnf8v9fy2akluh2qysvbao3f` FOREIGN KEY (`loan_by_employee_id`) REFERENCES `library_employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_loan`
--

LOCK TABLES `book_loan` WRITE;
/*!40000 ALTER TABLE `book_loan` DISABLE KEYS */;
INSERT INTO `book_loan` VALUES (35,9,1,1,'2017-07-07 11:22:31',''),(36,9,1,1,'2017-07-07 11:22:34',''),(37,9,1,1,'2017-07-07 11:22:38',''),(39,8,1,1,'2017-07-07 12:56:01',''),(40,6,1,1,'2017-07-10 15:16:59',''),(44,9,1,2,'2017-07-11 13:18:29',''),(47,11,1,2,'2017-06-18 18:41:42','\0'),(48,12,1,2,'2017-07-19 22:38:11','\0'),(49,13,1,3,'2017-07-20 12:20:00','\0'),(50,14,1,4,'2017-07-20 12:20:14','\0');
/*!40000 ALTER TABLE `book_loan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `library_employee`
--

DROP TABLE IF EXISTS `library_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `library_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `library_employee`
--

LOCK TABLES `library_employee` WRITE;
/*!40000 ALTER TABLE `library_employee` DISABLE KEYS */;
INSERT INTO `library_employee` VALUES (1,'employee1@gmail.com','employee1_fname','employee1_lname','password','librarian');
/*!40000 ALTER TABLE `library_employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publisher`
--

DROP TABLE IF EXISTS `publisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publisher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `creation_date` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publisher`
--

LOCK TABLES `publisher` WRITE;
/*!40000 ALTER TABLE `publisher` DISABLE KEYS */;
INSERT INTO `publisher` VALUES (1,NULL,'My Publisher'),(2,NULL,'Publisher2'),(3,NULL,'sfvef'),(4,NULL,'verve'),(5,NULL,'Surbhi Publications'),(6,NULL,'Parkash Press'),(7,NULL,'Vedanta'),(8,NULL,'vfdsbfsfsd');
/*!40000 ALTER TABLE `publisher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fe0i52si7ybu0wjedj6motiim` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'vishnu@abc.com','Vishnu','Saini','$2a$12$XTNaZqgm87/z.mCVaS01UeFUcY4Wb2TlFj6wn8t4/vmJ84QD9AoOi','123456789'),(2,'vishnu1@abc.com','Vishnu1','Saini1','$2a$12$fIrfpMgV7yCe9ci/7qSdleunTwIjsR.xbvSxxJj3OLYau5kE/0lsi','123456789'),(3,'rahul@abc.com','Rahul','Jain','$2a$12$hyDVHNQBXXSrDrMZ/iN7UekSI37hfoUDC7HowvtZzKwxUClwsE4V.','123456789'),(4,'akash@abc.com','Akash','Sharma','$2a$12$2sp14mLS3SSyEG/ZNuq/r.6uoTUPoPvEPxeLKTbSNbdOptUb.v5da','123456789');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-09 12:19:26
