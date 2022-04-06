-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema chmod777_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema chmod777_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `chmod777_db` DEFAULT CHARACTER SET utf8 ;
USE `chmod777_db` ;

-- -----------------------------------------------------
-- Table `chmod777_db`.`Products`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Products` (
  `idProducts` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `price` FLOAT NOT NULL,
  `thumbnail` VARCHAR(400) NOT NULL,
  `descriptions` VARCHAR(450) NOT NULL,
  `category` VARCHAR(20) NOT NULL COMMENT '1:',
  PRIMARY KEY (`idProducts`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chmod777_db`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Client` (
  `idClient` INT NOT NULL AUTO_INCREMENT,
  `fristName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(25) NOT NULL,
  `role` VARCHAR(15) NOT NULL,
  `cellphone` INT NOT NULL,
  `password` VARCHAR(25) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chmod777_db`.`Buys`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Buys` (
  `idBuys` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `Client_idClient` INT NOT NULL,
  PRIMARY KEY (`idBuys`, `Client_idClient`),
  INDEX `fk_Buys_Client_idx` (`Client_idClient` ASC) VISIBLE,
  CONSTRAINT `fk_Buys_Client`
    FOREIGN KEY (`Client_idClient`)
    REFERENCES `chmod777_db`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chmod777_db`.`Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Orders` (
  `idorders` INT NOT NULL AUTO_INCREMENT,
  `date` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `thumbnail` VARCHAR(400) NULL,
  `description` VARCHAR(450) NOT NULL,
  `amount` INT NOT NULL,
  `total` FLOAT NOT NULL,
  `Buys_idBuys` INT NOT NULL,
  `Buys_Client_idClient` INT NOT NULL,
  `Products_idProductos` INT NOT NULL,
  PRIMARY KEY (`idorders`, `Buys_idBuys`, `Buys_Client_idClient`, `Products_idProductos`),
  INDEX `fk_Orders_Buys1_idx` (`Buys_idBuys` ASC, `Buys_Client_idClient` ASC) VISIBLE,
  INDEX `fk_Orders_Products1_idx` (`Products_idProductos` ASC) VISIBLE,
  CONSTRAINT `fk_Orders_Buys1`
    FOREIGN KEY (`Buys_idBuys` , `Buys_Client_idClient`)
    REFERENCES `chmod777_db`.`Buys` (`idBuys` , `Client_idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Orders_Products1`
    FOREIGN KEY (`Products_idProductos`)
    REFERENCES `chmod777_db`.`Products` (`idProducts`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chmod777_db`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Admin` (
  `idAdmin` INT NOT NULL AUTO_INCREMENT,
  `fristName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `cellphone` INT NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdmin`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `chmod777_db`.`Contact`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `chmod777_db`.`Contact` (
  `idContact` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  `cellphone` INT NOT NULL,
  PRIMARY KEY (`idContact`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
