CREATE DATABASE  IF NOT EXISTS `progetto_fine_corso_scuola_cucina` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `progetto_fine_corso_scuola_cucina`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: progetto_fine_corso_scuola_cucina
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
-- Table structure for table `amministratore`
--

DROP TABLE IF EXISTS `amministratore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `amministratore` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `data_nascita` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `amministratore`
--

LOCK TABLES `amministratore` WRITE;
/*!40000 ALTER TABLE `amministratore` DISABLE KEYS */;
INSERT INTO `amministratore` VALUES (1,'admin','admin','Andrea','Bianchi','1975-02-25','administratorSC@gmail.com',3331234567),(2,'marco81','marco','Marco','Rossi','1957-11-22','admScuolaCucina@tiscali.it',3332456178);
/*!40000 ALTER TABLE `amministratore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Antipasti'),(2,'Primi piatti'),(3,'Secondi piatti'),(4,'Contorni'),(5,'Frutta'),(6,'Dolci'),(7,'Cucina amatoriale'),(8,'Cucina professionale(corsi per cuochi)');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `corso` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codice` int(11) NOT NULL,
  `titolo` varchar(255) NOT NULL,
  `id_categoria` bigint(20) NOT NULL,
  `max_partecipanti` int(11) NOT NULL,
  `costo` double NOT NULL,
  `descrizione` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `codice` (`codice`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` VALUES (1,890,'Sfiziosità di carne',3,15,100,'Squisiti bocconcini, piccole preparazioni classiche e ricette innovative. Un appetitoso viaggio attraverso i tanti modi di preparare e gustare la carne rossa e bianca, tra fantasia e tradizione, semplicità e raffinatezza.\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \'Calendario Corsi\' e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\nPro: poche calorie, colorati, facili da preparare, appetitosi…\r\nContro: una volta assaggiati vi richiederanno sempre porzioni abbondanti. da realizzare…\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n\r\n'),(2,891,'Sfiziosi primi… vegetariani',2,20,70,'Pro: poche calorie, colorati, facili da preparare, appetitosi…\r\nContro: una volta assaggiati vi richiederanno sempre porzioni abbondanti. da realizzare…\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n\r\n'),(3,892,'Dessert al piatto',6,20,75,'Un dolce deve essere bello, sorprendente, affascinante, intrigante, profumato……al primo boccone dobbiamo desiderare subito il secondo. Ci saranno combinazioni di sapore mai forzate ma che sorprenderanno le vostre papille gustative. Otterrete da semplici ingredienti e da preparazioni del tutto tradizionali, ottimi e innovativi dessert.\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n'),(4,893,'Antipastini di mare',1,20,130,'Sfiziosi antipasti, pieni di sapore e profumi, ricette facilmente realizzabili, insolite e gustosissime.\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n'),(5,894,'Paste con verdure',2,15,80,'La primavera regala alla pasta soluzioni divertenti di sapore, all\'insegna dell\'originalità. Fave, melanzane, piselli, asparagi e tanti altri si sposeranno con garganelli, orecchiette, tagliolini... un gustoso matrimonio di sapori.\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n\r\n\r\n'),(6,895,'Corso di cucina (base)',7,20,250,'Un corso fondamentale, a cadenza settimanale, un vero e proprio punto di partenza per conoscere i procedimenti e le lavorazioni indispensabili per cucinare. Ogni incontro sarà l\'occasione per apprendere, attraverso la realizzazione di un menu completo, piccoli segreti sull\'esecuzione di piatti basilari o sull\'acquisto e la scelta degli alimenti, la loro lavorazione e infine i \"trucchi\" dello chef che saranno il vostro asso nella manica. Un corso importante attraverso cui capire e \"provare\" la cucina, che degusterete con l\'abbinamento dei vini. Possibilità di esercitarsi, nel corso della lezione, accanto allo chef. A fine corso sarà rilasciato un attestato.\r\n\r\nImportante!!!\r\nIl  presente corso verrà erogato con una cadenza settimanale a partire dal giorno\r\nindicato nel \"Calendario Corsi\"  e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n\r\n'),(7,896,'Corso di cucina\r\n(avanzato)\r\n',8,20,260,'Accontentando le numerose richieste di chi ha già superato il livello di base, cinque incontri (a cadenza settimanale) in cui approfondire quegli argomenti che escono dalla conoscenza di base e si avvicinano maggiormente all\'alta cucina. Spazieremo nel mondo delle salse, della cottura a vapore per una cucina leggera ma piena di sapore, dei bolliti fatti ad arte, della pasta fatta in casa con creatività, del cous cous, del pan di Spagna e molte altre ghiottonerie.\r\n\r\nImportante!!!\r\nIl  presente corso verrà erogato con una cadenza settimanale a partire dal giorno\r\nindicato nel \"Calendario Corsi\"  e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n'),(8,897,'Corso di cucina per cuochi',8,15,500,'Un corso ben strutturato con teoria e pratica. E\' una guida per acquisire le tecniche base di cucina e apprendere l\'aspetto merceologico degli alimenti, l\'organizzazione di una cucina e le sue figure professionali. Un corso ideato per permettere a tutti, in tempi ristretti, di conoscere attraverso l\'esecuzione di ricette base le nozioni fondamentali del cucinare, la costruzione di un menu e la presentazione del piatto. Ogni argomento verrà trattato con la massima cura e correlato da utili dispense, dalle paste alle verdure, dal pesce alla carne, dagli antipasti alla pasticceria e tante altre informazioni, tutte finalizzate a formare una valida figura professionale. Consegna dell\'attestato di partecipazione con valutazione. La Direzione si riserva, a suo insindacabile giudizio, di far frequentare agli allievi più meritevoli stages formativi gratuiti presso aziende della ristorazione.\r\n\r\nImportante!!!\r\nIl presente corso verrà erogato nel/i giorno/i\r\nindicato/i nel \"Calendario Corsi\" e osserverà la durata di quattro ore (ore 18.00-22.00) per ogni giorno indicato.\r\n\r\n'),(9,898,'Corso di cucina indiana',7,25,750,'Un corso da non perdere');
/*!40000 ALTER TABLE `corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edizione`
--

DROP TABLE IF EXISTS `edizione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `edizione` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_corso` bigint(20) NOT NULL,
  `data_inizio` date NOT NULL,
  `durata` int(11) NOT NULL,
  `aula` varchar(255) DEFAULT NULL,
  `docente` varchar(255) NOT NULL,
  `terminata` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_corso` (`id_corso`),
  CONSTRAINT `edizione_ibfk_1` FOREIGN KEY (`id_corso`) REFERENCES `corso` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edizione`
--

LOCK TABLES `edizione` WRITE;
/*!40000 ALTER TABLE `edizione` DISABLE KEYS */;
INSERT INTO `edizione` VALUES (1,1,'2010-05-07',2,'Aula 1','C. Amato',0),(2,2,'2010-05-11',1,'Aula 2','F. Beatini',0),(3,4,'2010-05-19',1,'Aula 3','T. Mita',0),(4,5,'2010-05-03',1,'Aula 2','D.Priori',0),(5,6,'2010-05-28',1,'Aula 1','C. Amato',0),(6,7,'2010-05-30',7,'Aula 3','C. Amato',0),(7,8,'2010-06-01',5,'Aula 2','D. Priori',0),(8,9,'2010-05-30',14,'Aula 1','F. Beatini',0),(9,4,'2010-04-28',7,'Aula3','M. Moretti',0);
/*!40000 ALTER TABLE `edizione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descrizione` varchar(255) NOT NULL,
  `voto` int(11) NOT NULL,
  `id_edizione` bigint(20) NOT NULL,
  `id_utente` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_edizione` (`id_edizione`,`id_utente`),
  KEY `id_utente` (`id_utente`),
  CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`id_edizione`) REFERENCES `edizione` (`id`),
  CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'da consigliare!!!',8,1,1),(2,'veramente interessante.',9,1,2),(3,'ottimi contenuti, ottimo insegnante',10,2,3),(4,'breve ma ben strutturato',7,3,4),(5,'esaustivo!!!',8,4,5);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscritto`
--

DROP TABLE IF EXISTS `iscritto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `iscritto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_edizione` bigint(20) NOT NULL,
  `id_utente` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_edizione` (`id_edizione`,`id_utente`),
  KEY `id_utente` (`id_utente`),
  CONSTRAINT `iscritto_ibfk_1` FOREIGN KEY (`id_edizione`) REFERENCES `edizione` (`id`),
  CONSTRAINT `iscritto_ibfk_2` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscritto`
--

LOCK TABLES `iscritto` WRITE;
/*!40000 ALTER TABLE `iscritto` DISABLE KEYS */;
INSERT INTO `iscritto` VALUES (1,1,1),(2,1,2),(3,2,3),(4,3,4),(5,4,5);
/*!40000 ALTER TABLE `iscritto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mail`
--

DROP TABLE IF EXISTS `mail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `subject` varchar(255) NOT NULL,
  `data` date NOT NULL,
  `body` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mail`
--

LOCK TABLES `mail` WRITE;
/*!40000 ALTER TABLE `mail` DISABLE KEYS */;
/*!40000 ALTER TABLE `mail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `data_nascita` date NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'davide','davide','Davide','Precetti','1982-08-12','davide.precetti@gmail.com',3391448087),(2,'fausto','fausto','Fausto','Paniccia','1982-03-03','pncfausto@libero.it',3201916480),(3,'francesco','francesco','Francesco','Valerio','1982-04-13','francesco.valerio@gmail.com',3386965410),(4,'Ing_Ruben','password','Ruben','Giaccotto','1981-03-17','ruben@giaccotto.it',3477011366),(5,'mar81','81','Marco','Rossi','1981-04-01','marcobrucchietti@gmail.com',33325854118),(6,'mauro','mauro','Mauro','Bove','1981-08-19','bove.mauro@gmail.com',3387972613),(7,'michele','michele','Michele','Fiorentino','1988-01-09','mike.fiorentino@tiscali.it',3402286606),(8,'veronica','veronica','Veronica','Romani','1983-07-24','veve-83@hotmail.it',3336448818);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-11 14:32:45
