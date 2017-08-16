USE internet_shop;
CREATE TABLE `customers` (
  `customerNumber`   INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `customerName`     VARCHAR(50)  NOT NULL,
  `contactLastName`  VARCHAR(50)  NOT NULL,
  `contactFirstName` VARCHAR(50)  NOT NULL,
  PRIMARY KEY (`customerNumber`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `products` (
  `productCode`     VARCHAR(15)            NOT NULL,
  `productName`     VARCHAR(70)            NOT NULL,
  `quantityInStock` SMALLINT               NOT NULL, -- Allow negative
  `buyPrice`        DECIMAL(8, 2) UNSIGNED NOT NULL,
  PRIMARY KEY (`productCode`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE `orders` (
  `orderNumber`    INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `orderDate`      DATE         NOT NULL,
  `shippedDate`    DATE                  DEFAULT NULL,
  `customerNumber` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`orderNumber`),
  INDEX (`orderDate`),
  INDEX (`customerNumber`),
  FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `orderdetails` (
  `orderNumber` INT UNSIGNED  NOT NULL,
  `productCode` VARCHAR(15)   NOT NULL,
  `priceEach`   DECIMAL(7, 2) NOT NULL,
  PRIMARY KEY (`orderNumber`, `productCode`),
  FOREIGN KEY (`orderNumber`) REFERENCES `orders` (`orderNumber`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  FOREIGN KEY (`productCode`) REFERENCES `products` (`productCode`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;


CREATE TABLE `payments` (
  `customerNumber` INT UNSIGNED           NOT NULL,
  `checkNumber`    VARCHAR(50)            NOT NULL,
  `paymentDate`    DATE                   NOT NULL,
  `amount`         DECIMAL(8, 2) UNSIGNED NOT NULL,
  PRIMARY KEY (`customerNumber`, `checkNumber`),
  FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

INSERT INTO `customers` (`customerName`, `contactLastName`, `contactFirstName`)
VALUES ('anton', 'Anton', 'Hohlov'),
  ('ivan', 'Ivan', 'Ivanov'),
  ('petr', 'Petr', 'Petrov'),
  ('sidor', 'Sidor', 'Sidorov'),
  ('serg', 'Sergey', 'Sergeev');


INSERT INTO `products` (`productCode`, `productName`, `quantityInStock`, `buyPrice`)
VALUES ('1a', 'shoes', 10, 50),
  ('2a', 'short', 20, 25),
  ('3a', 't-shirt', 50, 15),
  ('4a', 'cap', 30, 7);

INSERT INTO `orders` (`orderDate`, `shippedDate`, `customerNumber`)
VALUES (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 1),
  (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 2),
  (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 3),
  (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 4),
  (NOW(), DATE_ADD(NOW(), INTERVAL 14 DAY), 5);


INSERT INTO `orderdetails` (`orderNumber`, `productCode`, `priceEach`)
VALUES (1, '1a', 50),
  (2, '2a', 25),
  (3, '3a', 15),
  (4, '4a', 7);

INSERT INTO `payments` (`customerNumber`, `checkNumber`, `paymentDate`, `amount`)
VALUES (1, '11a', NOW(), 50),
  (2, '12a', NOW(), 25),
  (3, '13a', NOW(), 15),
  (4, '14a', NOW(), 7);



