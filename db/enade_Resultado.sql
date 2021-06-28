-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: enade
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `Resultado`
--

DROP TABLE IF EXISTS `Resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Resultado` (
  `idResultado` int NOT NULL AUTO_INCREMENT,
  `valorObtido` double NOT NULL,
  `Usuario_idUsuario` int NOT NULL,
  `Prova_idProva` int NOT NULL,
  PRIMARY KEY (`idResultado`),
  KEY `fk_Resultado_Usuario1_idx` (`Usuario_idUsuario`),
  KEY `fk_Resultado_Prova1_idx` (`Prova_idProva`),
  CONSTRAINT `fk_Resultado_Prova1` FOREIGN KEY (`Prova_idProva`) REFERENCES `Prova` (`idProva`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Resultado_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Resultado`
--

LOCK TABLES `Resultado` WRITE;
/*!40000 ALTER TABLE `Resultado` DISABLE KEYS */;
INSERT INTO `Resultado` VALUES (2,8,2,1),(3,6,3,1),(4,10,5,1),(5,4,8,1),(6,10,12,1),(7,4,13,1),(8,8,6,1),(9,8,4,1),(10,6,9,1),(11,8,11,1),(12,8,15,1);
/*!40000 ALTER TABLE `Resultado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-28 19:28:17
