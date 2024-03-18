



use order_book;

create database order_book;
CREATE TABLE order_book.product_master (prodid INT NOT NULL , prodname VARCHAR(50) NOT NULL , prodrate INT NOT NULL , prodqty INT NOT NULL ) ENGINE = InnoDB;
drop table product_master;

CREATE TABLE order_book.order_master (orderid INT NOT NULL AUTO_INCREMENT , orderdate DATE NOT NULL DEFAULT CURRENT_TIMESTAMP , prodid INT NOT NULL , prodrate INT NOT NULL , orderqty INT NOT NULL , ordervalue INT NOT NULL , PRIMARY KEY (orderid)) ENGINE = InnoDB;
drop table order_master;


INSERT INTO order_book.product_master (prodid, prodname, prodrate, prodqty) VALUES
(1, 'To Kill a Mockingbird', 25, 100),
(2, 'The Great Gatsby', 30, 80),
(3, '1984', 20, 120),
(4, 'Pride and Prejudice', 28, 90),
(5, 'The Catcher in the Rye', 22, 110);

select * from product_master;
select * from order_master;