-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: signupdb
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addon_item1`
--

DROP TABLE IF EXISTS `addon_item1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item1` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item1`
--

LOCK TABLES `addon_item1` WRITE;
/*!40000 ALTER TABLE `addon_item1` DISABLE KEYS */;
INSERT INTO `addon_item1` VALUES ('栏目1',NULL),('栏目2',NULL),('栏目3',NULL);
/*!40000 ALTER TABLE `addon_item1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addon_item2`
--

DROP TABLE IF EXISTS `addon_item2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item2` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item2`
--

LOCK TABLES `addon_item2` WRITE;
/*!40000 ALTER TABLE `addon_item2` DISABLE KEYS */;
INSERT INTO `addon_item2` VALUES ('栏目1','栏目1'),('栏目2','栏目2'),('栏目3','栏目3');
/*!40000 ALTER TABLE `addon_item2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addon_item3`
--

DROP TABLE IF EXISTS `addon_item3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item3` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item3`
--

LOCK TABLES `addon_item3` WRITE;
/*!40000 ALTER TABLE `addon_item3` DISABLE KEYS */;
INSERT INTO `addon_item3` VALUES ('栏目1','栏目1'),('栏目2','栏目2'),('栏目3','栏目3');
/*!40000 ALTER TABLE `addon_item3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addon_item4`
--

DROP TABLE IF EXISTS `addon_item4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item4` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item4`
--

LOCK TABLES `addon_item4` WRITE;
/*!40000 ALTER TABLE `addon_item4` DISABLE KEYS */;
INSERT INTO `addon_item4` VALUES ('栏目1','栏目1'),('栏目2','栏目2'),('栏目3','栏目3');
/*!40000 ALTER TABLE `addon_item4` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addon_item5`
--

DROP TABLE IF EXISTS `addon_item5`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item5` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item5`
--

LOCK TABLES `addon_item5` WRITE;
/*!40000 ALTER TABLE `addon_item5` DISABLE KEYS */;
INSERT INTO `addon_item5` VALUES ('栏目a',NULL),('栏目b',NULL);
/*!40000 ALTER TABLE `addon_item5` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `addon_item6`
--

DROP TABLE IF EXISTS `addon_item6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addon_item6` (
  `addon_name` varchar(45) NOT NULL,
  `addon_value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addon_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addon_item6`
--

LOCK TABLES `addon_item6` WRITE;
/*!40000 ALTER TABLE `addon_item6` DISABLE KEYS */;
INSERT INTO `addon_item6` VALUES ('栏目a','栏目a'),('栏目b','栏目b');
/*!40000 ALTER TABLE `addon_item6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `common_items`
--

DROP TABLE IF EXISTS `common_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `common_items` (
  `student_no` varchar(45) NOT NULL,
  `addon_id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `class` varchar(45) DEFAULT NULL,
  `report_year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`student_no`,`addon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common_items`
--

LOCK TABLES `common_items` WRITE;
/*!40000 ALTER TABLE `common_items` DISABLE KEYS */;
INSERT INTO `common_items` VALUES ('学号1',2,'姓名1','计科','2016'),('学号2',3,'姓名2','计科','2015'),('学号3',4,'姓名3','软件','2015'),('学号4',6,'姓名4','计科','2017');
/*!40000 ALTER TABLE `common_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `title_to_id`
--

DROP TABLE IF EXISTS `title_to_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `title_to_id` (
  `subject_title` varchar(80) NOT NULL,
  `addon_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`addon_id`,`subject_title`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title_to_id`
--

LOCK TABLES `title_to_id` WRITE;
/*!40000 ALTER TABLE `title_to_id` DISABLE KEYS */;
INSERT INTO `title_to_id` VALUES ('蓝桥杯报名',1),('蓝桥杯报名',2),('蓝桥杯报名',3),('蓝桥杯报名',4),('天梯赛报名',5),('天梯赛报名',6);
/*!40000 ALTER TABLE `title_to_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'signupdb'
--

--
-- Dumping routines for database 'signupdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-04 18:51:50
