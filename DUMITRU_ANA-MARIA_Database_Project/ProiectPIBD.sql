-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: schemax
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `elevi`
--

DROP TABLE IF EXISTS `elevi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `elevi` (
  `idelevi` bigint NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `clasa` varchar(45) DEFAULT NULL,
  `media` int DEFAULT NULL,
  PRIMARY KEY (`idelevi`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elevi`
--

LOCK TABLES `elevi` WRITE;
/*!40000 ALTER TABLE `elevi` DISABLE KEYS */;
INSERT INTO `elevi` VALUES (18,'Nedelcu','Antonia','434A',9),(19,'Ismail','Miruna','11C',3),(21,'Baciu','Irina','434A',9),(22,'Ionescu','Georgiana','9E',11);
/*!40000 ALTER TABLE `elevi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `realizare`
--

DROP TABLE IF EXISTS `realizare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `realizare` (
  `idrealizare` bigint(20) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `idelevi` bigint DEFAULT NULL,
  `idteme` bigint DEFAULT NULL,
  `termen` varchar(45) DEFAULT NULL,
  `tip` varchar(45) DEFAULT NULL,
  `format` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrealizare`),
  KEY `fr_key1_idx` (`idelevi`),
  KEY `fr_key2_idx` (`idteme`),
  CONSTRAINT `fr_key1` FOREIGN KEY (`idelevi`) REFERENCES `elevi` (`idelevi`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fr_key2` FOREIGN KEY (`idteme`) REFERENCES `teme` (`idteme`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `realizare`
--

LOCK TABLES `realizare` WRITE;
/*!40000 ALTER TABLE `realizare` DISABLE KEYS */;
INSERT INTO `realizare` VALUES (00000000000000000011,19,10,'12/09','grup','fizic'),(00000000000000000012,18,10,'12.11.2024','test2','test2'),(00000000000000000014,21,6,'10/10/.2024','grup','prezentare orala'),(00000000000000000017,18,6,'15','grup','powerpoint');
/*!40000 ALTER TABLE `realizare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teme`
--

DROP TABLE IF EXISTS `teme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teme` (
  `idteme` bigint NOT NULL AUTO_INCREMENT,
  `materie` varchar(45) DEFAULT NULL,
  `subiect` varchar(45) DEFAULT NULL,
  `punctaj` int DEFAULT NULL,
  PRIMARY KEY (`idteme`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teme`
--

LOCK TABLES `teme` WRITE;
/*!40000 ALTER TABLE `teme` DISABLE KEYS */;
INSERT INTO `teme` VALUES (6,'cid','fsm',10),(10,'mate','geometrie',10);
/*!40000 ALTER TABLE `teme` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-08 21:27:08
