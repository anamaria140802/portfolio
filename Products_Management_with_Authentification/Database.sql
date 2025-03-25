CREATE DATABASE  IF NOT EXISTS `proiect3` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proiect3`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: proiect3
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
-- Table structure for table `clienti`
--

DROP TABLE IF EXISTS `clienti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clienti` (
  `idclient` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `idutilizator` bigint DEFAULT NULL,
  PRIMARY KEY (`idclient`),
  KEY `fk1_cl_idx` (`idutilizator`),
  CONSTRAINT `fk1_cl` FOREIGN KEY (`idutilizator`) REFERENCES `utilizatori` (`idutilizator`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clienti`
--

LOCK TABLES `clienti` WRITE;
/*!40000 ALTER TABLE `clienti` DISABLE KEYS */;
INSERT INTO `clienti` VALUES (1,'dragomir','mircea','brasov','anamariad147',NULL),(3,'Dumitru','Ana','Bucuresti','anamariad147@yahoo.com',NULL),(4,'Dumitru','Ana','Bucuresti','anamariad147@yahoo.com',NULL),(5,'feri3242','drago','miercurea ciuc','ama',NULL),(9,'tudor','cristian','calarasi','cristi@emal.com',NULL),(10,'marinescu','ilinca','madrid','ilina@yahoo.com',NULL),(11,'d','a','adfs','fdsfd',NULL),(12,'nicolau','andrei','bacau','na@gmail.com',NULL),(13,'nitulescu','violeta','bucuresti','nitulescuvioleta@gmail.com',NULL),(14,'ionescu','ioana','pitesti','ioana@gmail.com',NULL),(15,'leanca','laura','bucuresti','laura@gmail.com',NULL),(16,'Nedelcu','Antonia','estonia','nedant@gmail.com',NULL);
/*!40000 ALTER TABLE `clienti` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_clienti_insert` AFTER INSERT ON `clienti` FOR EACH ROW BEGIN
    IF NEW.idutilizator IS NOT NULL THEN
        UPDATE utilizatori
        SET rol = 'client'
        WHERE idutilizator = NEW.idutilizator;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_clienti_update` AFTER UPDATE ON `clienti` FOR EACH ROW BEGIN
    IF OLD.idutilizator IS NULL AND NEW.idutilizator IS NOT NULL THEN
        UPDATE utilizatori
        SET rol = 'client'
        WHERE idutilizator = NEW.idutilizator;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `comenzi`
--

DROP TABLE IF EXISTS `comenzi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comenzi` (
  `idcomanda` bigint unsigned NOT NULL AUTO_INCREMENT,
  `idfurnizor` bigint unsigned DEFAULT NULL,
  `idclient` bigint unsigned DEFAULT NULL,
  `dataComanda` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `valoareComanda` decimal(19,6) DEFAULT NULL,
  PRIMARY KEY (`idcomanda`),
  KEY `fr_key1_idx` (`idclient`),
  KEY `fr_key2_idx` (`idfurnizor`),
  CONSTRAINT `fr_key1` FOREIGN KEY (`idclient`) REFERENCES `clienti` (`idclient`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fr_key2` FOREIGN KEY (`idfurnizor`) REFERENCES `furnizori` (`idfurnizor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comenzi`
--

LOCK TABLES `comenzi` WRITE;
/*!40000 ALTER TABLE `comenzi` DISABLE KEYS */;
INSERT INTO `comenzi` VALUES (1,1,1,'2024-12-09','livrata',70000.000000),(17,1,1,'2025-09-09','in pregatire',999.000000),(19,3,4,'2024-12-09','in pregatire',400.000000),(21,3,4,'2024-12-09','in pregatire',999.000000),(22,3,15,'2024-05-09','in pregatire',2323.000000),(23,2,5,'2024-09-09','livrata',1213.000000);
/*!40000 ALTER TABLE `comenzi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distribuitor`
--

DROP TABLE IF EXISTS `distribuitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distribuitor` (
  `iddistribuitor` bigint unsigned NOT NULL AUTO_INCREMENT,
  `idprodus` bigint unsigned DEFAULT NULL,
  `idfurnizor` bigint unsigned DEFAULT NULL,
  `numeDistribuitor` varchar(45) DEFAULT NULL,
  `pretUnitar` decimal(19,6) DEFAULT NULL,
  `stocDisponibil` int DEFAULT NULL,
  PRIMARY KEY (`iddistribuitor`),
  KEY `fk1_idx` (`idprodus`),
  KEY `fk2_idx` (`idfurnizor`),
  CONSTRAINT `fk1` FOREIGN KEY (`idprodus`) REFERENCES `produse` (`idprodus`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`idfurnizor`) REFERENCES `furnizori` (`idfurnizor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distribuitor`
--

LOCK TABLES `distribuitor` WRITE;
/*!40000 ALTER TABLE `distribuitor` DISABLE KEYS */;
INSERT INTO `distribuitor` VALUES (1,1,1,'carrefour',13500.000000,23),(2,1,2,'carrefour',12.090000,3),(3,1,1,'libris',23.200000,3212),(4,2,1,'libris',23.000000,3212),(6,2,1,'carturesti',23.000000,2);
/*!40000 ALTER TABLE `distribuitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `furnizori`
--

DROP TABLE IF EXISTS `furnizori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `furnizori` (
  `idfurnizor` bigint unsigned NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `prenume` varchar(45) DEFAULT NULL,
  `adresa` varchar(45) DEFAULT NULL,
  `idutilizator` bigint DEFAULT NULL,
  PRIMARY KEY (`idfurnizor`),
  KEY `fk1_fr_idx` (`idutilizator`),
  CONSTRAINT `fk1_fr` FOREIGN KEY (`idutilizator`) REFERENCES `utilizatori` (`idutilizator`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `furnizori`
--

LOCK TABLES `furnizori` WRITE;
/*!40000 ALTER TABLE `furnizori` DISABLE KEYS */;
INSERT INTO `furnizori` VALUES (1,'marin','ilie','cluj',NULL),(2,'nicolae','alexandru','ploiesti',NULL),(3,'nicolae','alexandru','ploiesti',NULL),(4,'mircea','marin','bratislava',NULL);
/*!40000 ALTER TABLE `furnizori` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_furnizori_insert` AFTER INSERT ON `furnizori` FOR EACH ROW BEGIN
    IF NEW.idutilizator IS NOT NULL THEN
        UPDATE utilizatori
        SET rol = 'admin'
        WHERE idutilizator = NEW.idutilizator;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `after_furnizori_update` AFTER UPDATE ON `furnizori` FOR EACH ROW BEGIN
    IF OLD.idutilizator IS NULL AND NEW.idutilizator IS NOT NULL THEN
        UPDATE utilizatori
        SET rol = 'admin'
        WHERE idutilizator = NEW.idutilizator;
    END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `produse`
--

DROP TABLE IF EXISTS `produse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produse` (
  `idprodus` bigint unsigned NOT NULL AUTO_INCREMENT,
  `denumire` varchar(45) DEFAULT NULL,
  `descriere` varchar(45) DEFAULT NULL,
  `cantitate` int DEFAULT NULL,
  PRIMARY KEY (`idprodus`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produse`
--

LOCK TABLES `produse` WRITE;
/*!40000 ALTER TABLE `produse` DISABLE KEYS */;
INSERT INTO `produse` VALUES (1,'lapotptop','lenovo',23),(2,'carte','beletristica',3);
/*!40000 ALTER TABLE `produse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utilizatori`
--

DROP TABLE IF EXISTS `utilizatori`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilizatori` (
  `idutilizator` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `parola` varchar(60) DEFAULT NULL,
  `rol` enum('client','admin') DEFAULT NULL,
  PRIMARY KEY (`idutilizator`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilizatori`
--

LOCK TABLES `utilizatori` WRITE;
/*!40000 ALTER TABLE `utilizatori` DISABLE KEYS */;
INSERT INTO `utilizatori` VALUES (1,'mirunad','$2a$10$IK6M1OAIetblD4HYYCH9DuVOYvXWh1czM1fsPy07sj6QxC1aqX7ni','client'),(2,'anad','$2a$10$Euh0Ifz8U4z154ku1SgXzODP/2YFSXXF3iMqHDfYrbRXtGAvfMs1C','client'),(3,'nic','$2a$10$TXEHg.q9HfvUTjnmVYavp.uZfsuVh3eBRc3jdqrflUkIRDf9ge.Ta','client'),(4,'darian','$2a$10$pnLFjhYOpHs8mnILtU4X1Ori/HaqYbouO37lc5Di.Ye3qszc4o0Pu','client'),(5,'paultaifas','$2a$10$zaQEo2ulyKGpR3oY0YPqVuF6odUNJI1g5UcWlBn3c7vPXlsFNS5X2','client'),(6,'violeta','$2a$10$nHnLWtVWog6YqnvZutkm1uT25766s32RUVe.7byBGOJefm1/dFYti','client'),(7,'ioana','$2a$10$OnYk0mM8oevLnSLDdvSrZeE4cmgnOqsGpz.kfFVnZiCxOFV0Q0LDi','client'),(8,'laura','$2a$10$foY0MivECL1mUzdQa9cQme0bPfLqYnSX2H93.oyDtYj0P/wWboglK','client'),(9,'alex','$2a$10$EnA5/oty4mzTDjsglHyYw.ZLYsus9nGB9izkIYqlfyEwghAYcEvKm','admin');
/*!40000 ALTER TABLE `utilizatori` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'proiect3'
--

--
-- Dumping routines for database 'proiect3'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-25 10:46:02
