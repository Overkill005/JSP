CREATE TABLE `order_book`.`order_master` (`OrderID` INT NOT NULL AUTO_INCREMENT , `OrderDate` DATE NOT NULL DEFAULT CURRENT_TIMESTAMP , `ProdID` INT NOT NULL , `ProdRate` INT NOT NULL , `OrderQty` INT NOT NULL , `OrderValue` INT NOT NULL , PRIMARY KEY (`OrderID`)) ENGINE = InnoDB;