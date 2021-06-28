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
-- Table structure for table `Questao`
--

DROP TABLE IF EXISTS `Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Questao` (
  `idQuestao` int NOT NULL AUTO_INCREMENT,
  `descricaoQuestao` varchar(45) NOT NULL,
  `alternativaA` varchar(45) DEFAULT NULL,
  `alternativaB` varchar(45) DEFAULT NULL,
  `alternativaC` varchar(45) DEFAULT NULL,
  `alternativaD` varchar(45) DEFAULT NULL,
  `alternativaE` varchar(45) DEFAULT NULL,
  `questaoCorreta` char(1) DEFAULT NULL,
  `estadoQuestao` tinyint DEFAULT NULL,
  `TipoQuestao_idTipoQuestao` int NOT NULL,
  PRIMARY KEY (`idQuestao`),
  KEY `fk_Questao_TipoQuestao1_idx` (`TipoQuestao_idTipoQuestao`),
  CONSTRAINT `fk_Questao_TipoQuestao` FOREIGN KEY (`TipoQuestao_idTipoQuestao`) REFERENCES `TipoQuestao` (`idTipoQuestao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questao`
--

LOCK TABLES `Questao` WRITE;
/*!40000 ALTER TABLE `Questao` DISABLE KEYS */;
INSERT INTO `Questao` VALUES (1,'Quanto é 2+2?','1','2','3','4','5','D',1,2),(2,'Qual a melhor linguagem de programação?','JavaScript','C','Java (Com certeza não é essa)','C#','Cobol','A',1,2),(3,'Qual o melhor time do mundo?','','','','','',NULL,1,1),(4,'Quem arranhou as costas do Matheus?','O Xuxu','O entregador de hambúguer','O hambúrguer','Os esquilos','A ex dele','E',1,2),(5,'Qts hrs dura o relacionamento do Matheus?','','','','','',NULL,1,1);
/*!40000 ALTER TABLE `Questao` ENABLE KEYS */;
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
