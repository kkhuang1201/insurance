SELECT * FROM customers;

INSERT INTO customers values(DEFAULT,'kenny','huang',1,29,'1991-12-01');
UPDATE customers SET add_id = 1 WHERE cust_id = 1;



SELECT * FROM addresses;

INSERT INTO addresses values(DEFAULT,'2027 coyle st','','NY','Brooklyn','11229','USA');
INSERT INTO addresses values(DEFAULT,'abc','','NY','Brooklyn','11220','USA');



SELECT * FROM policies;

INSERT INTO policies values(DEFAULT,'stander','NY',10000,'2021-06-10','2022-06-10',1);
UPDATE policies SET cust_id = 8 WHERE pol_number = 2;


