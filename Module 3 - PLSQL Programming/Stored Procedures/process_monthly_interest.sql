DELIMITER //

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    SELECT * FROM bank;
    UPDATE bank SET Balance = Balance * 1.01;
    SELECT * FROM bank;
END //

DELIMITER ;

CALL ProcessMonthlyInterest();