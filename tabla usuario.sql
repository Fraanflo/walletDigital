-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: alke_wallet
-- ------------------------------------------------------
-- Server version	8.3.0

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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `clave` varchar(100) DEFAULT NULL,
  `saldo` int NOT NULL,
  `fecha_de_creacion` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juanita Pérez','jperez@gmail.com','1234',4000,'2024-03-20 00:13:17'),(2,'Gabriel Dominguez','gtorres@gmail.com','4567',6000,'2024-01-20 14:00:00'),(3,'Manuel Guevara','gmanuel@correo.cl','7890',10000,'2024-01-19 14:00:00'),(4,'Anabelle Rodriguez','arodriguez@example.com','4567',7500,'2023-07-05 09:30:00'),(5,'Carlos Sánchez','csanchez@example.com','1234',8500,'2022-11-12 18:45:00'),(6,'Laura Martínez','lmartinez@example.com','2345',5500,'2023-02-28 11:15:00'),(7,'Pedro López','plopez@example.com','9876',9200,'2022-09-20 15:20:00'),(8,'María Fernández','mfernandez@example.com','5678',6300,'2023-04-14 10:00:00'),(9,'Alberto','sgonzalez@example.com','3456',4800,'2024-05-30 13:45:00'),(10,'Juan Hernández','jhernandez@example.com','8765',7200,'2023-10-08 16:55:00'),(11,'Isabella Ruiz','iruiz@example.com','6543',9200,'2022-12-25 07:40:00'),(12,'Diego García','dgarcia@example.com','4321',6800,'2024-02-17 14:30:00'),(13,'Marta Pérez','mperez@example.com','7890',5500,'2023-08-03 09:10:00'),(14,'Francisca Flores','fran@mail.com','1234',5000000,'2024-05-03 14:19:22'),(16,'Felipe Muñoz','fm@mail.com','1234',200000,'2024-05-10 00:12:11'),(42,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-21 22:08:25'),(43,'Blanca Guajardo','bguajardo@mail.com','1234',200000,'2024-05-21 22:11:30'),(45,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-21 22:38:09'),(46,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-21 22:39:53'),(48,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-21 22:41:56'),(49,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-21 22:42:11'),(51,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-21 23:24:48'),(52,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-21 23:25:56'),(53,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-21 23:33:06'),(54,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-24 00:14:31'),(55,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-24 00:14:32'),(56,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-24 00:14:33'),(57,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-24 00:15:42'),(58,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-24 00:15:42'),(59,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-24 00:15:43'),(60,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-24 00:16:38'),(61,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-24 00:16:39'),(62,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-24 00:16:40'),(63,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-24 00:17:31'),(64,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-24 00:17:32'),(65,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-24 00:17:32'),(66,'Hugo López','hlopez@mail.com','hola123',100000,'2024-05-24 00:17:55'),(67,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-24 00:17:56'),(68,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-24 00:17:57'),(69,'Ursula Herrera','uherrera@mail.com','1234',120000,'2024-05-24 00:29:55'),(70,'Karina Guevara','kg@mail.com','1234',1,'2024-05-24 23:38:10'),(71,'Hector Salazar','hsalazar@mail.com','hola123',10000,'2024-05-25 00:08:47'),(72,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:09:20'),(73,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:11:22'),(74,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:11:35'),(75,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:12:15'),(76,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:13:53'),(77,'Hector Salazar','hsalazar@mail.com','hola123',0,'2024-05-25 00:22:58'),(78,'Jeannete Fuentes','jfuentes@mail.com','123456',200000,'2024-05-25 00:56:54');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-25  1:34:24
