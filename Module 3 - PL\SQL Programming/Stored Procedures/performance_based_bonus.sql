DELIMITER //

CREATE PROCEDURE UpdateEmployeeBonus(IN minPerformance INT, IN bonusPercent DECIMAL(5,2))
BEGIN
    UPDATE bank
    SET Balance = Balance + (Balance * bonusPercent / 100)
    WHERE Performance >= minPerformance;
END //

DELIMITER ;

CALL UpdateEmployeeBonus(4, 10);
CALL UpdateEmployeeBonus(2, 5);