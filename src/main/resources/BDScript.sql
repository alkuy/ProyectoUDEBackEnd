-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: bpa
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

create database BPA;
use BPA;

--
-- Table structure for table `armamento`
--

DROP TABLE IF EXISTS `armamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `armamento` (
  `codPartida` int(11) NOT NULL DEFAULT '0',
  `codNave` int(11) NOT NULL DEFAULT '0',
  `nombre` varchar(10) NOT NULL DEFAULT '',
  `calibre` varchar(10) DEFAULT NULL,
  `descp` varchar(50) DEFAULT NULL,
  `municion` int(11) DEFAULT NULL,
  PRIMARY KEY (`codPartida`,`codNave`,`nombre`),
  KEY `armamento_fk_2_idx` (`codNave`),
  CONSTRAINT `armamento_ibfk_1` FOREIGN KEY (`codPartida`) REFERENCES `partida` (`codP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `armamento`
--

LOCK TABLES `armamento` WRITE;
/*!40000 ALTER TABLE `armamento` DISABLE KEYS */;
INSERT INTO `armamento` VALUES (1,1,'cañonDes','127mm','Cañones de cubierta automaticos',16),(1,1,'carga','S/N','Cargas de profundidad para destruir submarinos',10),(1,2,'cañonSub','105mm','Cañones de cubierta automaticos',16),(1,2,'torpedo','S/N','Torpedos submarinos para objetivos maritimos',10),(2,1,'cañonDes','127mm','Cañones de cubierta automaticos',5),(2,1,'carga','S/N','Cargas de profundidad para destruir submarinos',1),(2,2,'cañonSub','105mm','Cañones de cubierta automaticos',8),(2,2,'torpedo','S/N','Torpedos submarinos para objetivos maritimos',10);
/*!40000 ALTER TABLE `armamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nave`
--

DROP TABLE IF EXISTS `nave`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nave` (
  `codNaveInt` int(11) NOT NULL AUTO_INCREMENT,
  `codP` int(11) NOT NULL DEFAULT '0',
  `codNave` int(11) NOT NULL DEFAULT '0',
  `clase` varchar(10) DEFAULT NULL,
  `vida` int(11) DEFAULT NULL,
  `posX` float DEFAULT NULL,
  `posY` float DEFAULT NULL,
  PRIMARY KEY (`codNaveInt`,`codP`,`codNave`),
  KEY `constraint_FK1_idx` (`codP`),
  CONSTRAINT `constraint_FK1` FOREIGN KEY (`codP`) REFERENCES `partida` (`codP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nave`
--

LOCK TABLES `nave` WRITE;
/*!40000 ALTER TABLE `nave` DISABLE KEYS */;
INSERT INTO `nave` VALUES (1,1,0,'Liberty',100,0,0),(2,1,0,'Liberty',100,0,0),(3,1,0,'Liberty',100,0,0),(4,1,0,'Liberty',100,0,0),(5,1,0,'Liberty',100,0,0),(6,1,0,'Liberty',100,0,0),(7,1,1,'Fletcher',100,0,0),(8,1,2,'UBoat',100,0,0),(81,2,0,'Liberty',100,3,2),(82,2,0,'Liberty',100,0,0),(83,2,0,'Liberty',100,6,3),(84,2,0,'Liberty',100,1,2),(85,2,0,'Liberty',30,0,0),(86,2,0,'Liberty',70,0,0),(87,2,1,'Fletcher',50,3.5,4),(88,2,2,'UBoat',80,2,0);
/*!40000 ALTER TABLE `nave` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partida`
--

DROP TABLE IF EXISTS `partida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `partida` (
  `codP` int(11) NOT NULL DEFAULT '0',
  `fecha` timestamp NULL DEFAULT NULL,
  `ganador` varchar(10) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partida`
--

LOCK TABLES `partida` WRITE;
/*!40000 ALTER TABLE `partida` DISABLE KEYS */;
INSERT INTO `partida` VALUES (1,'2022-02-20 19:59:44','Alvarito','finalizada'),(2,'2022-02-22 03:00:00','S/N','pausada');
/*!40000 ALTER TABLE `partida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-23 10:52:04
