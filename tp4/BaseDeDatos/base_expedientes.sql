-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema_expedientes
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `checklistrequisitocomercio`
--

DROP TABLE IF EXISTS `checklistrequisitocomercio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checklistrequisitocomercio` (
  `idChecklist` int NOT NULL AUTO_INCREMENT,
  `idExpediente` int NOT NULL,
  `idRequisito` int NOT NULL,
  `cumplido` tinyint(1) DEFAULT '0',
  `observaciones` text,
  PRIMARY KEY (`idChecklist`),
  KEY `idExpediente` (`idExpediente`),
  KEY `idRequisito` (`idRequisito`),
  CONSTRAINT `checklistrequisitocomercio_ibfk_1` FOREIGN KEY (`idExpediente`) REFERENCES `expediente` (`idExpediente`) ON DELETE CASCADE,
  CONSTRAINT `checklistrequisitocomercio_ibfk_2` FOREIGN KEY (`idRequisito`) REFERENCES `requisito` (`idRequisito`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checklistrequisitocomercio`
--

LOCK TABLES `checklistrequisitocomercio` WRITE;
/*!40000 ALTER TABLE `checklistrequisitocomercio` DISABLE KEYS */;
INSERT INTO `checklistrequisitocomercio` VALUES (41,9,1,1,''),(42,9,2,1,''),(43,9,3,1,''),(44,9,4,1,''),(45,9,5,1,''),(46,9,6,1,''),(47,9,7,1,''),(48,9,8,1,''),(49,9,9,0,''),(50,9,10,0,''),(61,7,1,0,''),(62,7,2,0,''),(63,7,3,0,''),(64,7,4,0,''),(65,7,5,0,''),(66,7,6,0,''),(67,7,7,0,''),(68,7,8,0,''),(69,7,9,0,''),(70,7,10,0,''),(91,1,1,1,''),(92,1,2,1,''),(93,1,3,1,''),(94,1,4,0,''),(95,1,5,0,''),(96,1,6,0,''),(97,1,7,0,''),(98,1,8,0,''),(99,1,9,0,''),(100,1,10,0,''),(111,4,1,1,''),(112,4,2,1,''),(113,4,3,1,''),(114,4,4,1,''),(115,4,5,1,''),(116,4,6,1,''),(117,4,7,1,''),(118,4,8,1,''),(119,4,9,0,''),(120,4,10,0,''),(131,11,1,1,''),(132,11,2,1,''),(133,11,3,1,''),(134,11,4,1,''),(135,11,5,1,''),(136,11,6,1,''),(137,11,7,1,''),(138,11,8,1,''),(139,11,9,0,''),(140,11,10,0,''),(151,12,1,1,'Bien'),(152,12,2,1,'Bien'),(153,12,3,1,'Bien'),(154,12,4,1,'Bien'),(155,12,5,1,'Bien'),(156,12,6,1,'Bien'),(157,12,7,1,'Bien'),(158,12,8,1,'Bien'),(159,12,9,1,'Bien'),(160,12,10,1,'Bien'),(161,12,9,0,''),(212,14,1,0,''),(213,14,2,0,''),(214,14,3,0,''),(215,14,4,0,''),(216,14,5,0,''),(217,14,6,0,''),(218,14,7,0,''),(219,14,8,0,''),(220,14,9,0,''),(221,14,10,0,''),(222,14,10,0,''),(223,14,9,0,''),(224,14,10,0,''),(225,14,9,0,''),(226,13,1,1,''),(227,13,2,1,''),(228,13,3,1,''),(229,13,4,1,''),(230,13,5,1,''),(231,13,6,1,''),(232,13,7,1,''),(233,13,8,1,''),(234,13,9,0,''),(235,13,10,1,'');
/*!40000 ALTER TABLE `checklistrequisitocomercio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contribuyente`
--

DROP TABLE IF EXISTS `contribuyente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contribuyente` (
  `idContribuyente` int NOT NULL AUTO_INCREMENT,
  `tipoContribuyente` enum('Físico','Jurídico') NOT NULL,
  `dni` varchar(10) DEFAULT NULL,
  `cuit` varchar(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `razonSocial` varchar(100) DEFAULT NULL,
  `domicilio` varchar(100) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correoElectronico` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idContribuyente`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contribuyente`
--

LOCK TABLES `contribuyente` WRITE;
/*!40000 ALTER TABLE `contribuyente` DISABLE KEYS */;
INSERT INTO `contribuyente` VALUES (1,'Físico',NULL,'20345678901','Gonzalo','Benítez',NULL,'Av. San Martín 123','3755432100','gonzalo@example.com'),(3,'Físico','29299299','27292992990','María Lucía','Giménez','','Av. San Martín 29','3754292929','lmgimenez@correo.com.ar'),(4,'Físico','90999999','20909999993','Silvio','Felipao','','M. Moreno 90','3754909090','sfelipao@correo.com.ar'),(5,'Jurídico','73333333','30733333331','','','Le Pain SRL','Av. Las Heras 73','3754737373','lepainsrl@correo.com'),(6,'Jurídico','55555555','30555555558','','','Super Chango','Rivadavia 55','3754555555','superchango@correo.com.ar'),(7,'Físico','99999999','27999999990','Zulma','Candia','','Mbororé 99','3754999999','zcandia@correo.com'),(8,'Jurídico','90999999','30909999998','','','Super Compras SRL','Av. Las Heras 90','3754909999','supercompras@correo.com.ar');
/*!40000 ALTER TABLE `contribuyente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expediente` (
  `idExpediente` int NOT NULL AUTO_INCREMENT,
  `idContribuyente` int NOT NULL,
  `idRubro` int NOT NULL,
  `idTipoTramite` int NOT NULL,
  `numero` int NOT NULL,
  `letra` char(1) DEFAULT NULL,
  `anio` year DEFAULT NULL,
  `fechaHoraIngreso` datetime DEFAULT NULL,
  `estado` enum('En proceso','Cerrado','Baja') DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`idExpediente`),
  KEY `idContribuyente` (`idContribuyente`),
  KEY `idRubro` (`idRubro`),
  KEY `idTipoTramite` (`idTipoTramite`),
  CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`idContribuyente`) REFERENCES `contribuyente` (`idContribuyente`),
  CONSTRAINT `expediente_ibfk_2` FOREIGN KEY (`idRubro`) REFERENCES `rubro` (`idRubro`),
  CONSTRAINT `expediente_ibfk_3` FOREIGN KEY (`idTipoTramite`) REFERENCES `tipotramite` (`idTipoTramite`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
INSERT INTO `expediente` VALUES (1,1,1,1,1245,'S',2025,'2025-05-18 18:45:55','En proceso','Expediente de habilitación inicial'),(4,3,1,1,0,'G',2025,'2025-06-14 00:42:53','En proceso',NULL),(7,4,5,3,0,'F',2025,'2025-06-14 20:25:20','En proceso',NULL),(8,3,5,1,1246,'X',2025,'2025-06-14 21:56:57','En proceso',NULL),(9,4,1,1,1247,'X',2025,'2025-06-15 21:38:33','En proceso',NULL),(10,3,4,1,1248,'G',2025,'2025-06-15 21:46:59','En proceso',NULL),(11,5,5,1,1249,'L',2025,'2025-06-15 21:54:37','En proceso',NULL),(12,6,7,1,1250,'S',2025,'2025-06-22 12:10:07','En proceso',NULL),(13,7,9,1,1251,'C',2025,'2025-06-22 20:52:14','En proceso',NULL),(14,8,7,1,1252,'S',2025,'2025-06-27 18:48:44','En proceso',NULL);
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requisito`
--

DROP TABLE IF EXISTS `requisito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `requisito` (
  `idRequisito` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `obligatorio` tinyint(1) DEFAULT '0',
  `esJuridico` tinyint(1) DEFAULT '0',
  `requiereRiesgoAlto` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idRequisito`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requisito`
--

LOCK TABLES `requisito` WRITE;
/*!40000 ALTER TABLE `requisito` DISABLE KEYS */;
INSERT INTO `requisito` VALUES (1,'Nota solicitud al intendente','Carta dirigida al intendente solicitando la habilitación comercial.',1,0,0),(2,'Ficha de inscripción','Formulario de inscripción con datos del local y del titular.',1,0,0),(3,'Ficha de edificación y mensura','Ficha con información catastral del inmueble.',1,0,0),(4,'Fotocopia del DNI','Documento de identidad del titular o apoderado.',1,0,0),(5,'Constancia de CUIT','Constancia de CUIT del titular o apoderado.',1,0,0),(6,'Inscripción ARCA','Constancia de inscripción en ARCA.',1,0,0),(7,'Inscripción IIBB','Constancia de inscripción en Ingresos Brutos.',1,0,0),(8,'Inscripción Comercio Interior','Registro en Comercio Interior.',1,0,0),(9,'Contrato Social y Balance de Constitución','Documentación obligatoria para sociedades.',1,1,0),(10,'Plan de contingencia','Plan requerido para habilitaciones de rubros de riesgo como supermercados, industrias, etc.',0,0,1);
/*!40000 ALTER TABLE `requisito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rubro`
--

DROP TABLE IF EXISTS `rubro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rubro` (
  `idRubro` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text,
  `actividad` enum('Comercial','Industrial','Servicios') DEFAULT NULL,
  `esRubroEspecial` tinyint(1) DEFAULT NULL,
  `requiereBromatologia` tinyint(1) DEFAULT NULL,
  `esDeAltoRiesgo` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`idRubro`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rubro`
--

LOCK TABLES `rubro` WRITE;
/*!40000 ALTER TABLE `rubro` DISABLE KEYS */;
INSERT INTO `rubro` VALUES (1,'Kiosko','Venta minorista de productos varios','Comercial',0,1,0),(3,'Carnicería','Venta de carne y derivados','Comercial',1,1,0),(4,'Librería','Venta de libros y útiles escolares','Comercial',0,0,0),(5,'Panadería','Producción y venta de pan y facturas','Comercial',1,1,0),(6,'Minimercado','Comercio minorista de productos variados','Comercial',0,1,0),(7,'Supermercado','Comercio de productos alimenticios y otros','Comercial',1,1,1),(8,'Salón de Eventos','Espacio para eventos sociales','Servicios',0,0,1),(9,'Jardín Maternal','Institución para cuidado de niños pequeños','Servicios',0,0,1),(10,'Confitería','Venta de productos de pastelería y cafetería','Comercial',1,1,1);
/*!40000 ALTER TABLE `rubro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipotramite`
--

DROP TABLE IF EXISTS `tipotramite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipotramite` (
  `idTipoTramite` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `descripcion` text,
  PRIMARY KEY (`idTipoTramite`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipotramite`
--

LOCK TABLES `tipotramite` WRITE;
/*!40000 ALTER TABLE `tipotramite` DISABLE KEYS */;
INSERT INTO `tipotramite` VALUES (1,'Nueva habilitación','Trámite de alta de un nuevo comercio'),(3,'Renovación','Trámite para extender la vigencia del expediente'),(4,'Anexo','Trámite para agregar documentación complementaria');
/*!40000 ALTER TABLE `tipotramite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-28 12:16:35
