-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: bdcondominio
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
-- Table structure for table `apartamento`
--

DROP TABLE IF EXISTS `apartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartamento` (
  `Apt_Numero` int(11) NOT NULL AUTO_INCREMENT,
  `Apt_Andar` int(11) NOT NULL,
  `Bloco_idBloco` int(11) NOT NULL,
  PRIMARY KEY (`Apt_Numero`,`Bloco_idBloco`),
  KEY `fk_Apartamento_Bloco1_idx` (`Bloco_idBloco`),
  CONSTRAINT `fk_Apartamento_Bloco1` FOREIGN KEY (`Bloco_idBloco`) REFERENCES `bloco` (`idBloco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='O relacionamento Ã© de n apartamentos para um bloco. Cada bloco tem 4 andares e cada andar tem trÃªs apartamentos.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartamento`
--

LOCK TABLES `apartamento` WRITE;
/*!40000 ALTER TABLE `apartamento` DISABLE KEYS */;
INSERT INTO `apartamento` VALUES (1,1,1),(2,1,1),(3,1,1),(4,2,1),(5,2,1),(6,2,1),(7,3,1),(8,3,1),(9,3,1),(10,4,1),(11,4,1),(12,4,1),(13,1,2),(14,1,2),(15,1,2),(16,2,2),(17,2,2),(18,2,2),(19,3,2),(20,3,2),(21,3,2),(22,4,2),(23,4,2),(24,4,2);
/*!40000 ALTER TABLE `apartamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartamentos_ocupados`
--

DROP TABLE IF EXISTS `apartamentos_ocupados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `apartamentos_ocupados` (
  `Morador_CPF` char(11) NOT NULL,
  `Apartamento_Apt_Numero` int(11) NOT NULL,
  PRIMARY KEY (`Apartamento_Apt_Numero`),
  KEY `fk_Apartamentos_ocupados_Morador1_idx` (`Morador_CPF`),
  KEY `fk_Apartamentos_ocupados_Apartamento1_idx` (`Apartamento_Apt_Numero`),
  CONSTRAINT `fk_Apartamentos_ocupados_Apartamento1` FOREIGN KEY (`Apartamento_Apt_Numero`) REFERENCES `apartamento` (`Apt_Numero`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Apartamentos_ocupados_Morador1` FOREIGN KEY (`Morador_CPF`) REFERENCES `morador` (`CPF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartamentos_ocupados`
--

LOCK TABLES `apartamentos_ocupados` WRITE;
/*!40000 ALTER TABLE `apartamentos_ocupados` DISABLE KEYS */;
INSERT INTO `apartamentos_ocupados` VALUES ('12342343234',1),('21312312321',2),('21312312323',3),('24234809093',4),('34655465547',5),('35345323424',6),('42354365767',7),('54312342334',8),('54365423409',9),('54586789700',10),('55475567557',11),('64576734523',12),('65464545656',13),('75634523409',14),('75634523409',20),('75656745634',15),('87656734556',16),('87656734556',19),('97745645309',17),('97864523434',18);
/*!40000 ALTER TABLE `apartamentos_ocupados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `area` (
  `idAREA` int(11) NOT NULL AUTO_INCREMENT,
  `Area_Descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idAREA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES (1,'Piscina'),(2,'Ã�rea A'),(3,'Ã�rea B'),(4,'Churrasqueira');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bloco`
--

DROP TABLE IF EXISTS `bloco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bloco` (
  `idBloco` int(11) NOT NULL AUTO_INCREMENT,
  `Bloco_Letra` char(1) NOT NULL,
  PRIMARY KEY (`idBloco`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bloco`
--

LOCK TABLES `bloco` WRITE;
/*!40000 ALTER TABLE `bloco` DISABLE KEYS */;
INSERT INTO `bloco` VALUES (1,'A'),(2,'B');
/*!40000 ALTER TABLE `bloco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `Empresa_Nome` varchar(45) NOT NULL,
  `Empresa_Cnpj` varchar(45) DEFAULT NULL,
  `Empresa_Fone` varchar(9) DEFAULT NULL,
  `Endereco_idEndereco` int(11) NOT NULL,
  PRIMARY KEY (`idEmpresa`,`Endereco_idEndereco`),
  KEY `fk_Empresa_Endereco1_idx` (`Endereco_idEndereco`),
  CONSTRAINT `fk_Empresa_Endereco1` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='Tabela de empresas que prestam serviÃ§os para o condomÃ­nio. EX: Ã�gua - CAGECE, Energia ElÃ©trica - COELCE ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Inovar Ar Condicionado','89.875.948/8934-90','3236-3243',1),(2,'CAGECE','07.040.108/0001-57','3254-3445',5),(3,'COELCE','07.047.251/0001-70','3542-2343',6),(4,'OI - TELEFONE/INTERNET','04.164.616/0006-63','3422-3335',2),(5,'Reparos Aquecedores','34.354.643/3406-63','3534-5345',3),(6,'Empresa Resolve - Reparos e Reformas','21.234.213/4123-12','3213-6787',4),(7,'ManutenÃ§Ã£o de Elevadores','23.423.423/2342-23','3242-5346',13);
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `idEndereco` int(11) NOT NULL AUTO_INCREMENT,
  `Endereco_Rua` varchar(45) NOT NULL,
  `Endereco_Num` varchar(10) NOT NULL,
  `Endereco_Cep` varchar(13) NOT NULL,
  `Endereco_Bairro` varchar(45) NOT NULL,
  `Endereco_Cidade` varchar(45) NOT NULL,
  PRIMARY KEY (`idEndereco`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='Tabela usada para identificar os endereÃ§os das entidades "funcionÃ¡rio" e "empresa".';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `endereco` VALUES (1,'Rua SÃ£o Francisco','1234','23.423.423-23','Aldeota','Fortaleza'),(2,'Rua Dois','536','43.645.656-90','Parangaba','Fortaleza'),(3,'Rua Treze de Maio','53','12.343.433-27','FÃ¡tima','Fortaleza'),(4,'Rua Duque de Caxias','432','65.453.453-54','Centro','Fortaleza'),(5,'Rua TibÃºrcio Cavalcante','342','32.345.657-65','DionÃ­nio Torres','Fortaleza'),(6,'Rua Padre Valdevino','150','23.534.645-45','Aldeota','Fortaleza'),(7,'Rua TrÃªs','123','12.234.536-67','Conjunto CearÃ¡','Fortaleza'),(8,'Rua MacÃ­lio Dias','4321','12.333.242-53','Messejana','Fortaleza'),(9,'Av. Silas Mungumba','343','54.634.345-23','Parangaba','Fortaleza'),(10,'Rua Primeiro de Janeiro','355','12.544.645-12','Maraponga','Fortaleza'),(11,'Av. Washington Soares','7655','15.564.345-23','Edson Queiroz','Fortaleza'),(12,'Rua Gustavo Sampaio','756','43.234.543-34','ParquelÃ¢ndia','Fortaleza'),(13,'Rua Gurgel','533','12.543.345-34','Cidade dos FuncionÃ¡rios','Fortaleza');
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `idEvento` int(11) NOT NULL AUTO_INCREMENT,
  `Area_idAREA` int(11) NOT NULL,
  `Evento_Data` date NOT NULL,
  `Morador_CPF` char(11) NOT NULL,
  PRIMARY KEY (`idEvento`),
  KEY `fk_Evento_Area1_idx` (`Area_idAREA`),
  KEY `fk_Evento_Morador1_idx` (`Morador_CPF`),
  CONSTRAINT `fk_Evento_Area1` FOREIGN KEY (`Area_idAREA`) REFERENCES `area` (`idAREA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Evento_Morador1` FOREIGN KEY (`Morador_CPF`) REFERENCES `morador` (`CPF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='Cada evento estÃ¡ relacionado a uma Ã¡rea especÃ­fica do condomÃ­nio. Ex: piscina, salÃ£o de festas, salÃ£o de jogos, etc.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,1,'2016-04-12','55475567557'),(2,2,'2016-04-12','55475567557'),(3,3,'2016-04-09','34655465547'),(4,2,'2016-04-20','35345323424'),(5,4,'2016-04-12','55475567557'),(6,2,'2016-05-06','75656745634'),(7,3,'2016-05-23','75634523409'),(8,1,'2016-05-20','64576734523'),(9,3,'2016-05-20','64576734523'),(10,2,'2016-05-11','24234809093'),(11,2,'2016-04-30','21312312323'),(12,3,'2016-05-01','75656745634'),(13,4,'2016-05-06','97745645309'),(14,3,'2016-05-06','97745645309');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `CPF` char(14) NOT NULL,
  `Funcionario_Nome` varchar(45) NOT NULL,
  `Funcionario_Salario` float NOT NULL,
  `Funcionario_DataNascimento` date NOT NULL,
  `Funcionario_Sexo` char(1) NOT NULL,
  `Funcionario_Vencimento` int(11) NOT NULL,
  `Endereco_idEndereco` int(11) NOT NULL,
  `Setor_idSetor` int(11) NOT NULL,
  PRIMARY KEY (`CPF`,`Endereco_idEndereco`,`Setor_idSetor`),
  KEY `fk_Funcionario_Endereco1_idx` (`Endereco_idEndereco`),
  KEY `fk_Funcionario_Setor1_idx` (`Setor_idSetor`),
  CONSTRAINT `fk_Funcionario_Endereco1` FOREIGN KEY (`Endereco_idEndereco`) REFERENCES `endereco` (`idEndereco`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Funcionario_Setor1` FOREIGN KEY (`Setor_idSetor`) REFERENCES `setor` (`idSetor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabela que representa os funcionÃ¡rios do condomÃ­nio, e cada funcionÃ¡rio tem relacionamento com um setor de serviÃ§o do condomÃ­nio. Cada funcionÃ¡rio estÃ¡ relacionado a um endereÃ§o.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES ('123.234.345-34','JoÃ£o Gomes',900,'1989-03-29','M',1,12,4),('123.423.423-43','Vivian Cordeiro',900,'1988-03-12','F',1,7,1),('234.756.765-76','Ronaldo Garcia',900,'1969-07-18','M',1,11,1),('423.534.234.12','Ivone Xavier',900,'1966-04-23','F',1,9,1),('534.345.654-34','Gabriela dos Santos',1900,'1979-12-01','F',1,10,3),('645.645.654-45','Carlos Almeida',900,'1975-05-11','M',1,8,2);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gasto`
--

DROP TABLE IF EXISTS `gasto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gasto` (
  `idGasto` int(11) NOT NULL AUTO_INCREMENT,
  `Gasto_Func` float NOT NULL,
  `Gasto_Serv` float NOT NULL,
  `Gasto_Data` date NOT NULL,
  PRIMARY KEY (`idGasto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='SerÃ¡ o somatÃ³rio dos valores da prestaÃ§Ã£o de serviÃ§os no mÃªs e da folha mensal de funcionÃ¡rios. Os valores serÃ£o armazenados em "Gasto_Func" e "Gasto_Serv" e a Data servirÃ¡ para agrupar os gastos por mÃªs.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gasto`
--

LOCK TABLES `gasto` WRITE;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
INSERT INTO `gasto` VALUES (1,6400,12440,'2016-01-01'),(2,6400,11340,'2016-02-01'),(3,6400,9340,'2016-03-01'),(4,6400,8940,'2016-04-01');
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensalidade_condominio`
--

DROP TABLE IF EXISTS `mensalidade_condominio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mensalidade_condominio` (
  `idMensalidade_Condominio` int(11) NOT NULL AUTO_INCREMENT,
  `Mensalidade_Valor` float NOT NULL,
  `Morador_CPF` char(11) NOT NULL,
  `Mensalidade_Pago` tinyint(1) NOT NULL,
  `Mensalidade_Vencimento` date NOT NULL,
  PRIMARY KEY (`idMensalidade_Condominio`,`Morador_CPF`),
  KEY `fk_Mensalidade_condominio_Morador1_idx` (`Morador_CPF`),
  CONSTRAINT `fk_Mensalidade_condominio_Morador1` FOREIGN KEY (`Morador_CPF`) REFERENCES `morador` (`CPF`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8 COMMENT='Cada morador tem n mensalidades. Existe o atributo booleano para indicar se determinada mensalidade estÃ¡ paga ou nÃ£o (servirÃ¡ para filtrar a inadimplÃªncia).';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensalidade_condominio`
--

LOCK TABLES `mensalidade_condominio` WRITE;
/*!40000 ALTER TABLE `mensalidade_condominio` DISABLE KEYS */;
INSERT INTO `mensalidade_condominio` VALUES (1,2000,'12342343234',0,'2016-01-01'),(2,2000,'12342343234',0,'2016-02-01'),(3,2000,'12342343234',0,'2016-03-01'),(4,2000,'12342343234',0,'2016-04-01'),(5,2000,'21312312321',0,'2016-01-01'),(6,2000,'21312312321',0,'2016-02-01'),(7,2000,'21312312321',0,'2016-03-01'),(8,2000,'21312312321',0,'2016-04-01'),(9,2000,'21312312323',0,'2016-01-01'),(10,2000,'21312312323',0,'2016-02-01'),(11,2000,'21312312323',0,'2016-03-01'),(12,2000,'21312312323',0,'2016-04-01'),(13,2000,'24234809093',0,'2016-01-01'),(14,2000,'24234809093',0,'2016-02-01'),(15,2000,'24234809093',0,'2016-03-01'),(16,2000,'24234809093',0,'2016-04-01'),(17,2000,'34655465547',0,'2016-01-01'),(18,2000,'34655465547',0,'2016-02-01'),(19,2000,'34655465547',1,'2016-03-01'),(20,2000,'34655465547',1,'2016-04-01'),(125,2000,'35345323424',0,'2016-01-01'),(126,2000,'35345323424',0,'2016-02-01'),(127,2000,'35345323424',0,'2016-03-01'),(128,2000,'35345323424',1,'2016-04-01'),(129,2000,'42354365767',0,'2016-01-01'),(130,2000,'42354365767',0,'2016-02-01'),(131,2000,'42354365767',0,'2016-03-01'),(132,2000,'42354365767',0,'2016-04-01'),(133,2000,'54312342334',0,'2016-01-01'),(134,2000,'54312342334',0,'2016-02-01'),(135,2000,'54312342334',0,'2016-03-01'),(136,2000,'54312342334',0,'2016-04-01'),(137,2000,'54365423409',0,'2016-01-01'),(138,2000,'54365423409',0,'2016-02-01'),(139,2000,'54365423409',0,'2016-03-01'),(140,2000,'54365423409',0,'2016-04-01'),(141,2000,'54586789700',0,'2016-01-01'),(142,2000,'54586789700',0,'2016-02-01'),(143,2000,'54586789700',0,'2016-03-01'),(144,2000,'54586789700',0,'2016-04-01'),(145,2000,'55475567557',0,'2016-01-01'),(146,2000,'55475567557',0,'2016-02-01'),(147,2000,'55475567557',0,'2016-03-01'),(148,2000,'55475567557',0,'2016-04-01'),(149,2000,'64576734523',0,'2016-01-01'),(150,2000,'64576734523',1,'2016-02-01'),(151,2000,'64576734523',1,'2016-03-01'),(152,2000,'64576734523',1,'2016-04-01'),(153,2000,'65464545656',0,'2016-01-01'),(154,2000,'65464545656',0,'2016-02-01'),(155,2000,'65464545656',0,'2016-03-01'),(156,2000,'65464545656',1,'2016-04-01'),(157,2000,'75634523409',0,'2016-01-01'),(158,2000,'75634523409',0,'2016-02-01'),(159,2000,'75634523409',0,'2016-03-01'),(160,2000,'75634523409',0,'2016-04-01'),(161,2000,'75656745634',0,'2016-01-01'),(162,2000,'75656745634',0,'2016-02-01'),(163,2000,'75656745634',0,'2016-03-01'),(164,2000,'75656745634',0,'2016-04-01'),(165,2000,'87656734556',0,'2016-01-01'),(166,2000,'87656734556',0,'2016-02-01'),(167,2000,'87656734556',0,'2016-03-01'),(168,2000,'87656734556',0,'2016-04-01'),(169,2000,'97745645309',0,'2016-01-01'),(170,2000,'97745645309',0,'2016-02-01'),(171,2000,'97745645309',0,'2016-03-01'),(172,2000,'97745645309',1,'2016-04-01'),(173,2000,'97864523434',0,'2016-01-01'),(174,2000,'97864523434',0,'2016-02-01'),(175,2000,'97864523434',0,'2016-03-01'),(176,2000,'97864523434',0,'2016-04-01');
/*!40000 ALTER TABLE `mensalidade_condominio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `morador`
--

DROP TABLE IF EXISTS `morador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `morador` (
  `CPF` char(11) NOT NULL,
  `Morador_Nome` varchar(45) NOT NULL,
  `Morador_Email` varchar(45) DEFAULT NULL,
  `Morador_DataNascimento` date NOT NULL,
  `Morador_Sindico` tinyint(1) NOT NULL DEFAULT '0',
  `Morador_Telefone` varchar(9) DEFAULT NULL,
  `Morador_Adimplente` tinyint(1) DEFAULT NULL,
  `Tipo_morador_idTipo_morador` varchar(12) NOT NULL,
  `Morador_Senha_Hash` varchar(255) NOT NULL,
  PRIMARY KEY (`CPF`),
  UNIQUE KEY `Morad_Nome_UNIQUE` (`Morador_Nome`),
  UNIQUE KEY `Morad_DataNascimento_UNIQUE` (`Morador_DataNascimento`),
  UNIQUE KEY `Morad_Email_UNIQUE` (`Morador_Email`),
  KEY `fk_Morador_Tipo_morador1_idx` (`Tipo_morador_idTipo_morador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Na tabela morador tem as informações fundamentais e inclusive um booleano para saber se ele é sindico e outro para saber se ele está adimplente ou não. Essa tabela está relacionada com a "Tipo_morador" que indica se ele é proprietário ou locatário.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `morador`
--

LOCK TABLES `morador` WRITE;
/*!40000 ALTER TABLE `morador` DISABLE KEYS */;
INSERT INTO `morador` VALUES ('12342343234','João Santos','joao@hotmail.com','1987-12-09',0,'3235-2423',0,'1'),
('21312312321','Ramon Santos','ramon@gmail.com','1988-05-12',0,'3234-2342',0,'1'),
('21312312323','Augusto Oliveira','aug@hotmail.com','1965-03-12',0,'3213-1231',0,'1'),
('24234809093','Paula Holanda','paulah@gmail.com','1980-04-08',0,'3242-2342',0,'2'),
('34655465547','Lucas Holanda','lucas@gmail.com','1978-12-24',0,'3242-3453',1,'1'),
('35345323424','Amanda Rodrigues','amanda@hotmail.com','1960-01-23',0,'3213-1231',1,'1'),
('42354365767','Ana Paula Maia','ana@gmail.com','1993-01-15',0,'3209-2983',0,'2'),
('54312342334','MÃ¡rio Pontes','mario@hotmail.com','1983-09-07',1,'3212-2323',0,'1'),
('54365423409','Mariana BrandÃ£o','mari@yahoo.com','1988-10-31',0,'3242-4322',0,'2'),
('54586789700','Carlos Alberto','carlos@gmail.com','1966-11-12',0,'3213-3532',0,'2'),
('55475567557','Marilia Mendes','mar@gmail.com','1988-12-11',0,'3234-2342',0,'1'),
('64576734523','Matheus Gomes','mat@yahoo.com','1979-05-27',0,'3209-3453',1,'1'),
('65464545656','Leonardo Sousa','leo@hotmail.com','1980-04-19',0,'3222-1233',1,'2'),
('75634523409','Melissa Soares','mel@yahoo.com','1960-03-20',0,'3213-4564',0,'2'),
('75656745634','Victor Alves','vic@hotmail.com','1985-03-18',0,'3234-5345',0,'2'),
('87656734556','JosÃ© Fernandes de Medeiros','jose@hotmail.com','1984-10-22',0,'3324-3453',0,'1'),
('97745645309','Paula Neves','paula@gmail.com','1991-07-26',0,'3234-3245',1,'2'),
('97864523434','Jaqueline de Santos Moura','jaq@gmail.com','1989-06-29',0,'3335-4564',0,'1');
/*!40000 ALTER TABLE `morador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `saldomes`
--

DROP TABLE IF EXISTS `saldomes`;
/*!50001 DROP VIEW IF EXISTS `saldomes`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `saldomes` AS SELECT 
 1 AS `ID`,
 1 AS `DATA`,
 1 AS `RECEITAS`,
 1 AS `SALÃ�RIOS`,
 1 AS `SERVIÃ‡OS`,
 1 AS `DESPESAS`,
 1 AS `RESTO`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `servico`
--

DROP TABLE IF EXISTS `servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servico` (
  `idServico` int(11) NOT NULL AUTO_INCREMENT,
  `Servico_Nome` varchar(45) NOT NULL,
  `Servico_Valor` float NOT NULL,
  `Servico_Data` date NOT NULL,
  `Empresa_idEmpresa` int(11) NOT NULL,
  PRIMARY KEY (`idServico`),
  KEY `fk_Servico_Empresa1_idx` (`Empresa_idEmpresa`),
  CONSTRAINT `fk_Servico_Empresa1` FOREIGN KEY (`Empresa_idEmpresa`) REFERENCES `empresa` (`idEmpresa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COMMENT='Cada serviÃ§o estÃ¡ relacionado a uma empresa. E o somatorio dos valores dos serviÃ§os serÃ¡ armazenado na tabela "gasto".';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servico`
--

LOCK TABLES `servico` WRITE;
/*!40000 ALTER TABLE `servico` DISABLE KEYS */;
INSERT INTO `servico` VALUES (1,'MANUTENÃ‡ÃƒO DE ELEVADORES',1000,'2016-01-01',7),(2,'Ã�GUA',3500,'2016-01-01',2),(3,'ENERGIA ELÃ‰TRICA',4600,'2016-01-01',3),(4,'TELEFONIA/INTERNET',240,'2016-01-01',4),(5,'REPAROS GERAIS',500,'2016-01-01',6),(6,'REPAROS AR-CONDICIONADO',2600,'2016-01-01',1),(7,'MANUTENÃ‡ÃƒO DE ELEVADORES',1000,'2016-02-01',7),(8,'Ã�GUA',3600,'2016-02-01',2),(9,'ENERGIA ELÃ‰TRICA',4000,'2016-02-01',6),(10,'TELEFONIA-INTERNET',240,'2016-02-01',4),(11,'REPAROS GERAIS',500,'2016-02-01',6),(12,'REPAROS AR-CONDICIONADO',2000,'2016-02-01',1),(13,'REPAROS AQUECEDORES',700,'2016-03-01',3),(14,'MANUTENÃ‡ÃƒO DE ELEVADORES',1500,'2016-03-01',7),(15,'Ã�GUA',3000,'2016-03-01',2),(16,'ENERGIA ELÃ‰TRICA',3900,'2016-03-01',6),(17,'TELEFONIA/INTERNET',240,'2016-03-01',4),(18,'REPAROS GERAIS',500,'2016-04-01',6),(19,'REPAROS AR-CONDICIONADO',1200,'2016-04-01',1),(31,'Ã�GUA',3200,'2016-04-01',2),(32,'ENERGIA ELÃ‰TRICA',3800,'2016-04-01',6),(33,'TELEFONIA/INTERNET',240,'2016-04-01',4);
/*!40000 ALTER TABLE `servico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setor` (
  `idSetor` int(11) NOT NULL AUTO_INCREMENT,
  `Setor_Descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`idSetor`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Setores de serviÃ§os do condomÃ­nio, ex: ServiÃ§os Gerais, Portaria, etc. ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'ServiÃ§os Gerais'),(2,'Portaria'),(3,'AdministraÃ§Ã£o'),(4,'Jardineiro');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_morador`
--

DROP TABLE IF EXISTS `tipo_morador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_morador` (
  `idTipo_morador` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo_Descricao` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`idTipo_morador`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='PoderÃ¡ ser locatÃ¡rio ou proprietÃ¡rio.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_morador`
--

LOCK TABLES `tipo_morador` WRITE;
/*!40000 ALTER TABLE `tipo_morador` DISABLE KEYS */;
INSERT INTO `tipo_morador` VALUES (1,'proprietÃ¡rio'),(2,'locatÃ¡rio');
/*!40000 ALTER TABLE `tipo_morador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vaga` (
  `idVaga` int(11) NOT NULL AUTO_INCREMENT,
  `Bloco_Num` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVaga`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
INSERT INTO `vaga` VALUES (1,NULL),(2,NULL),(3,NULL),(4,NULL),(5,NULL),(6,NULL),(7,NULL),(8,NULL),(9,NULL),(10,NULL),(11,NULL),(12,NULL),(13,NULL),(14,NULL),(15,NULL),(16,NULL),(17,NULL),(18,NULL),(19,NULL),(20,NULL),(21,NULL),(22,NULL),(23,NULL),(24,NULL);
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `veiculo` (
  `Veiculo_PLACA` varchar(8) NOT NULL,
  `Veiculo_Modelo` varchar(45) NOT NULL,
  `Veiculo_Cor` varchar(45) NOT NULL,
  `Veiculo_Ano` int(11) DEFAULT NULL,
  `Morador_CPF` char(11) NOT NULL,
  `Vaga_idVaga` int(11) NOT NULL,
  PRIMARY KEY (`Veiculo_PLACA`),
  KEY `fk_Veiculo_Morador1_idx` (`Morador_CPF`),
  KEY `fk_Veiculo_Vaga1_idx` (`Vaga_idVaga`),
  CONSTRAINT `fk_Veiculo_Morador1` FOREIGN KEY (`Morador_CPF`) REFERENCES `morador` (`CPF`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Veiculo_Vaga1` FOREIGN KEY (`Vaga_idVaga`) REFERENCES `vaga` (`idVaga`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
INSERT INTO `veiculo` VALUES ('AFK-3242','Fox','Branco',2014,'21312312321',17),('ASA-3252','Prisma','Verde',2001,'97745645309',9),('ASD-1412','Corsa','Preto',2001,'12342343234',1),('ASD-5464','Sandero','Cinza',2010,'54365423409',5),('ASD-6456','Fit','Azul',2009,'54312342334',4),('ASF-2134','Gol','Amarelo',2015,'35345323424',16),('BVN-6786','Strada','Preto',2016,'65464545656',7),('DFD-2253','Corsa Sedan','Preto',2012,'24234809093',18),('DFG-3534','Celta','Vermelho',2014,'34655465547',13),('DFG-4353','Gol','Branco',2000,'42354365767',3),('FFD-5354','Uno','Prata',2016,'55475567557',14),('GJH-4654','Fiesta','Vermelho',2015,'64576734523',6),('JGH-3453','Fit','Preto',2013,'97864523434',12),('RET-1234','Palio','Azul',2015,'21312312323',2),('SAD-4564','Siena','Prata',2015,'75634523409',11),('SAF-4353','Civic','Preto',2005,'87656734556',10),('SDG-6575','Ka','Branco',2000,'75656745634',8),('SFS-4564','Voyage','Preto',2014,'64576734523',15);
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `saldomes`
--

/*!50001 DROP VIEW IF EXISTS `saldomes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `saldomes` AS select `m`.`idMensalidade_Condominio` AS `ID`,`m`.`Mensalidade_Vencimento` AS `DATA`,sum(`m`.`Mensalidade_Valor`) AS `RECEITAS`,`g`.`Gasto_Func` AS `SALÃ�RIOS`,`g`.`Gasto_Serv` AS `SERVIÃ‡OS`,(`g`.`Gasto_Func` + `g`.`Gasto_Serv`) AS `DESPESAS`,(sum(`m`.`Mensalidade_Valor`) - (`g`.`Gasto_Func` + `g`.`Gasto_Serv`)) AS `RESTO` from (`mensalidade_condominio` `m` join `gasto` `g`) where ((`m`.`Mensalidade_Pago` = 0) and (`m`.`Mensalidade_Vencimento` = `g`.`Gasto_Data`)) group by `m`.`Mensalidade_Vencimento` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-12  9:17:17
