CREATE SCHEMA IF NOT EXISTS `BookStore` DEFAULT CHARACTER SET utf8mb3 ;
USE `BookStore` ;

CREATE TABLE IF NOT EXISTS `BookStore`.`book_ganre` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 29
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`author` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 9
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) NOT NULL,
    `username` VARCHAR(45) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `passwordconfirm` VARCHAR(255) NULL DEFAULT NULL,
    `email` VARCHAR(200) NULL DEFAULT NULL,
    `mobile` VARCHAR(45) NULL DEFAULT NULL,
    `registered_at` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 23
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`myorder` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NULL DEFAULT NULL,
    `status` VARCHAR(45) NULL DEFAULT NULL,
    `grand_total` DECIMAL(10,0) NULL DEFAULT NULL,
    `dateoforder` DATE NULL DEFAULT NULL,
    `description` VARCHAR(100) NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `myorder_ibfk_1_idx` (`user_id` ASC) VISIBLE,
    CONSTRAINT `myorder_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `BookStore`.`user` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 24
    DEFAULT CHARACTER SET = utf8mb3;


CREATE TABLE IF NOT EXISTS `BookStore`.`supplier` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 6
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`book` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `supplier_id` INT NULL DEFAULT NULL,
    `name` VARCHAR(100) NULL DEFAULT NULL,
    `book_ganre_id` INT NULL DEFAULT NULL,
    `description` VARCHAR(1000) NULL DEFAULT NULL,
    `image` VARCHAR(2000) NULL DEFAULT NULL,
    `author_id` INT NULL DEFAULT NULL,
    `price` DECIMAL(10,0) NULL DEFAULT NULL,
    `quantity` INT NULL DEFAULT NULL,
    `rating` INT NULL DEFAULT NULL,
    `usersvote` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `supplier_id` (`supplier_id` ASC) VISIBLE,
    INDEX `author_id` (`author_id` ASC) VISIBLE,
    INDEX `book_ganre_id` (`book_ganre_id` ASC) VISIBLE,
    CONSTRAINT `book_ibfk_1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `BookStore`.`supplier` (`id`),
    CONSTRAINT `book_ibfk_4`
    FOREIGN KEY (`author_id`)
    REFERENCES `BookStore`.`author` (`id`),
    CONSTRAINT `book_ibfk_5`
    FOREIGN KEY (`book_ganre_id`)
    REFERENCES `BookStore`.`book_ganre` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 16
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`basket` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `book_id` INT NULL DEFAULT NULL,
    `order_id` INT NULL DEFAULT NULL,
    `quantity` INT NULL DEFAULT NULL,
    `price` DECIMAL(10,0) NULL DEFAULT NULL,
    `orderid` INT NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `book_id` (`book_id` ASC) VISIBLE,
    INDEX `basket_ibfk_2_idx` (`order_id` ASC) VISIBLE,
    CONSTRAINT `basket_ibfk_1`
    FOREIGN KEY (`book_id`)
    REFERENCES `BookStore`.`book` (`id`),
    CONSTRAINT `basket_ibfk_2`
    FOREIGN KEY (`order_id`)
    REFERENCES `BookStore`.`myorder` (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 27
    DEFAULT CHARACTER SET = utf8mb3;


CREATE TABLE IF NOT EXISTS `BookStore`.`review` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `book_id` INT NULL DEFAULT NULL,
    `users_id` INT NULL DEFAULT NULL,
    `title` VARCHAR(100) NULL DEFAULT NULL,
    `content` VARCHAR(500) NULL DEFAULT NULL,
    `created_at` DATE NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    INDEX `users_id` (`users_id` ASC) VISIBLE,
    INDEX `book_id` (`book_id` ASC) VISIBLE,
    CONSTRAINT `review_ibfk_1`
    FOREIGN KEY (`users_id`)
    REFERENCES `BookStore`.`user` (`id`),
    CONSTRAINT `review_ibfk_3`
    FOREIGN KEY (`book_id`)
    REFERENCES `BookStore`.`book` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;


CREATE TABLE IF NOT EXISTS `BookStore`.`role` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB
    AUTO_INCREMENT = 3
    DEFAULT CHARACTER SET = utf8mb3;

CREATE TABLE IF NOT EXISTS `BookStore`.`user_roles` (
    `user_id` INT NULL DEFAULT NULL,
    `roles_id` INT NULL DEFAULT NULL,
     INDEX `user_roles_ibfk_1_idx` (`user_id` ASC) VISIBLE,
    INDEX `user_roles_ibfk_2_idx` (`roles_id` ASC) VISIBLE,
    CONSTRAINT `user_roles_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `BookStore`.`user` (`id`),
    CONSTRAINT `user_roles_ibfk_2`
    FOREIGN KEY (`roles_id`)
    REFERENCES `BookStore`.`role` (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb3;
