/*
SQLyog Enterprise - MySQL GUI v8.12 
MySQL - 5.5.27 : Database - mumscrum
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`mumscrum` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mumscrum`;

/*Table structure for table `employeevacation` */

DROP TABLE IF EXISTS `employeevacation`;

CREATE TABLE `employeevacation` (
  `leaveId` int(11) NOT NULL AUTO_INCREMENT,
  `availabeleave` int(11) NOT NULL,
  `enddate` date DEFAULT NULL,
  `startdate` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `leavetype_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`leaveId`),
  KEY `FK_pgewjmd9gkxn1y6ycdj589wav` (`employee_id`),
  KEY `FK_np6jy4v53hhdwpbttvxgpw2yc` (`leavetype_Id`),
  CONSTRAINT `FK_np6jy4v53hhdwpbttvxgpw2yc` FOREIGN KEY (`leavetype_Id`) REFERENCES `leavetype` (`Id`),
  CONSTRAINT `FK_pgewjmd9gkxn1y6ycdj589wav` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `employeevacation` */

insert  into `employeevacation`(`leaveId`,`availabeleave`,`enddate`,`startdate`,`employee_id`,`leavetype_Id`) values (2,34,'2016-09-05','2016-08-05',1,2);

/*Table structure for table `insurance` */

DROP TABLE IF EXISTS `insurance`;

CREATE TABLE `insurance` (
  `inId` int(11) NOT NULL AUTO_INCREMENT,
  `enddate` date DEFAULT NULL,
  `payAmount` double NOT NULL,
  `startdate` date DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `insurancetype_typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`inId`),
  KEY `FK_ny7h43tykl9xbwfr1l9k86feg` (`employee_id`),
  KEY `FK_92kaba9eswu7kuejxu57nd0ax` (`insurancetype_typeId`),
  CONSTRAINT `FK_92kaba9eswu7kuejxu57nd0ax` FOREIGN KEY (`insurancetype_typeId`) REFERENCES `insurancetype` (`typeId`),
  CONSTRAINT `FK_ny7h43tykl9xbwfr1l9k86feg` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `insurance` */

insert  into `insurance`(`inId`,`enddate`,`payAmount`,`startdate`,`employee_id`,`insurancetype_typeId`) values (1,'2016-04-05',34,'2016-01-05',1,1);

/*Table structure for table `insurancetype` */

DROP TABLE IF EXISTS `insurancetype`;

CREATE TABLE `insurancetype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) DEFAULT NULL,
  `typeName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `insurancetype` */

insert  into `insurancetype`(`typeId`,`companyName`,`typeName`) values (1,'Alico','Health Insurance'),(2,'SateFarm','Dental Insurance');

/*Table structure for table `leavetype` */

DROP TABLE IF EXISTS `leavetype`;

CREATE TABLE `leavetype` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `defaultvalue` int(11) NOT NULL,
  `typename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `leavetype` */

insert  into `leavetype`(`Id`,`defaultvalue`,`typename`) values (1,10,'Sick Leave'),(2,15,'Casual Leave'),(3,5,'Earned Leave');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
