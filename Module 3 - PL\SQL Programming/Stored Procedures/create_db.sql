-- Create Table
CREATE TABLE bank (
    CustomerID INT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Balance DECIMAL(12,2),
    Performance INT CHECK (Performance BETWEEN 0 AND 5)
);

-- Populate Table
INSERT INTO bank
(CustomerID, CustomerName, Balance, Performance)
VALUES
(101, 'Amit Sharma', 8500.00, 2),
(102, 'Priya Singh', 15000.00, 3),
(103, 'Rahul Verma', 22000.00, 5),
(104, 'Neha Gupta', 5000.00, 1),
(105, 'Sanjay Kumar', 30000.00, 4),
(106, 'Anita Roy', 9800.00, 3),
(107, 'Rohit Das', 12000.00, 2),
(108, 'Sneha Patel', 2500.00, 5),
(109, 'Vikram Mehta', 45000.00, 3),
(110, 'Kavita Nair', 18000.00, 4),
(111, 'Arjun Bose', 7600.00, 2),
(112, 'Meera Choudhury', 50000.00, 1),
(113, 'Deepak Jain', 10500.00, 4),
(114, 'Pooja Sen', 6700.00, 3),
(115, 'Manoj Iyer', 27500.00, 2);