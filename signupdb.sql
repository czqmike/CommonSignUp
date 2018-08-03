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
-- Table structure for table `common_items`
--

DROP TABLE IF EXISTS `common_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `common_items` (
  `student_no` varchar(45) NOT NULL,
  `addon_id` varchar(45) NOT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `title_to_id`
--

LOCK TABLES `title_to_id` WRITE;
/*!40000 ALTER TABLE `title_to_id` DISABLE KEYS */;
INSERT INTO `title_to_id` VALUES ('蓝桥杯报名',1);
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

-- Dump completed on 2018-08-03 17:24:43
