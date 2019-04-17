CREATE SCHEMA 'Library';
CREATE TABLE `Library`.`items2` (
	  `ID` INT NULL,
	  `Author` VARCHAR(256) NULL,
	  `ISBN10` VARCHAR(17) NULL,
	  `ISBN13` VARCHAR(17) NULL,
	  `Title` VARCHAR(256) NULL,
	  `PubDate` VARCHAR(64) NULL,
	  `PageCount` INT NULL,
	  `Lang` VARCHAR(8) NULL,
	  `Format` VARCHAR(45) NULL,
	  `SubTitle` VARCHAR(256) NULL,
	  `url` VARCHAR(512) NULL,
	  `Publisher` VARCHAR(96) NULL,
	  `Subject` VARCHAR(256) NULL,
	  `SubSubject` VARCHAR(256) NULL,
	  PRIMARY KEY (`ID`));
  
  
CREATE TABLE 'Library'.'Person' (
	`ID` INT NOT NULL,
	`Name` VARCHAR(128) NULL,
	`password` VARCHAR(128) NULL,
	`type` INT NULL,
	`DOB` DATETIME NULL,
	`gender` VARCHAR(64) NULL,
	`email` VARCHAR(256) NULL,
	`phone` VARCHAR(24) NULL, 
	`fees` DOUBLE NULL,
	  PRIMARY KEY (`ID`));
