INSERT INTO customers (`NAME`, `ADDRESS`, `PHONE_NUMBER`)
VALUES
('Alex', 'Address', 'Number');

INSERT INTO brands (`BRAND_NAME`, `PUFF_COUNT`, `PRICE`)
VALUES
('AromaKing', 7000, 15.00);

INSERT INTO flavours (`FLAVOUR_NAME`, `BRAND_NAME`, `QUANTITY`)
VALUES
('CottonCandy', 'AromaKing', 15);

INSERT INTO orders (`BRANDID`, `BRAND_NAME`, `FLAVOURID`, `FLAVOUR_NAME`, `ITEM_QUANTITY`, `ORDER_PRICE`)
VALUES
(1, 'AromaKing', 1L, 'CottonCandy', 2, 30.00);

INSERT INTO order_info (`CUSTOMERID`, `ORDERID`, `DATE_PLACED`, `DELIVERY_DATE`)
VALUES
(1L, 1L, '2022-03-15', '2022-03-18');