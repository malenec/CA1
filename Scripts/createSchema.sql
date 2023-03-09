-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema CA1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CA1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CA1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `CA1` ;

-- -----------------------------------------------------
-- Table `CA1`.`cityinfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`cityinfo` (
                                                `ZipCode` INT NOT NULL,
                                                `City` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`ZipCode`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA1`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`Address` (
                                               `Address_id` INT NOT NULL AUTO_INCREMENT,
                                               `Street` VARCHAR(45) NOT NULL,
    `AdditionalInfo` VARCHAR(45) NOT NULL,
    `cityinfo_ZipCode` INT NOT NULL,
    PRIMARY KEY (`Address_id`, `cityinfo_ZipCode`),
    INDEX `fk_Address_cityinfo_idx` (`cityinfo_ZipCode` ASC) VISIBLE,
    CONSTRAINT `fk_Address_cityinfo`
    FOREIGN KEY (`cityinfo_ZipCode`)
    REFERENCES `CA1`.`cityinfo` (`ZipCode`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA1`.`Hobby`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`Hobby` (
                                             `Hobby_id` INT NOT NULL AUTO_INCREMENT,
                                             `name` VARCHAR(45) NOT NULL,
    `wikiLink` VARCHAR(1000) NOT NULL,
    `category` VARCHAR(45) NOT NULL,
    `type` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`Hobby_id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 452
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA1`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`Person` (
                                              `Person_id` INT NOT NULL AUTO_INCREMENT,
                                              `Firstname` VARCHAR(45) NOT NULL,
    `Lastname` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `Address_Address_id` INT NOT NULL,
    PRIMARY KEY (`Person_id`, `Address_Address_id`),
    INDEX `fk_Person_Address1_idx` (`Address_Address_id` ASC) VISIBLE,
    CONSTRAINT `fk_Person_Address1`
    FOREIGN KEY (`Address_Address_id`)
    REFERENCES `CA1`.`Address` (`Address_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA1`.`Hobby_person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`Hobby_person` (
                                                    `Hobby_person_id` INT NOT NULL,
                                                    `Hobby_id` INT NOT NULL,
                                                    `Person_id` INT NOT NULL,
                                                    PRIMARY KEY (`Hobby_person_id`),
    INDEX `fk_Hobby_person_Person1_idx` (`Person_id` ASC) VISIBLE,
    INDEX `fk_Hobby_person_Hobby1_idx` (`Hobby_id` ASC) VISIBLE,
    CONSTRAINT `fk_Hobby_person_Hobby1`
    FOREIGN KEY (`Hobby_id`)
    REFERENCES `CA1`.`Hobby` (`Hobby_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT `fk_Hobby_person_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `CA1`.`Person` (`Person_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `CA1`.`Phone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CA1`.`Phone` (
                                             `Number` INT NOT NULL,
                                             `description` VARCHAR(45) NOT NULL,
    `Person_id` INT NOT NULL,
    PRIMARY KEY (`Number`, `Person_id`),
    UNIQUE INDEX `Number_UNIQUE` (`Number` ASC) VISIBLE,
    INDEX `fk_Phone_Person1_idx` (`Person_id` ASC) VISIBLE,
    CONSTRAINT `fk_Phone_Person1`
    FOREIGN KEY (`Person_id`)
    REFERENCES `CA1`.`Person` (`Person_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
