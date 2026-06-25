DELIMITER //

CREATE PROCEDURE TransferFunds(IN sourceCustomer INT, IN destinationCustomer INT, IN transferAmount DECIMAL(12,2))
BEGIN

    DECLARE sourceBalance DECIMAL(12,2);

    SELECT Balance INTO sourceBalance FROM bank WHERE CustomerID = sourceCustomer;

    IF sourceBalance >= transferAmount THEN
        UPDATE bank SET Balance = Balance - transferAmount WHERE CustomerID = sourceCustomer;
        UPDATE bank SET Balance = Balance + transferAmount WHERE CustomerID = destinationCustomer;
    END IF;

END //

DELIMITER ;

CALL TransferFunds(101, 102, 5000);