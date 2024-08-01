use DBProject_tapan

CREATE TABLE Donors (
    DonorID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Gender VARCHAR(10),
    BirthDate DATE,
    BloodType VARCHAR(3) NOT NULL,
    ContactNumber VARCHAR(15),
    Email VARCHAR(50),
    Address VARCHAR(100),
    LastDonationDate DATE
);

CREATE TABLE BloodUnits (
    UnitID INT IDENTITY(1,1) PRIMARY KEY,
    BloodType VARCHAR(3) NOT NULL,
    CollectionDate DATE NOT NULL,
    ExpiryDate DATE NOT NULL,
    DonorID INT,
    Status VARCHAR(20) DEFAULT 'Available',
    FOREIGN KEY (DonorID) REFERENCES Donors(DonorID)
);

CREATE TABLE Recipients (
    RecipientID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Gender VARCHAR(10),
    BirthDate DATE,
    BloodType VARCHAR(3) NOT NULL,
    ContactNumber VARCHAR(15),
    Email VARCHAR(50),
    Address VARCHAR(100)
);

CREATE TABLE Transactions (
    TransactionID INT IDENTITY(1,1) PRIMARY KEY,
    UnitID INT NOT NULL,
    DonorID INT,
    RecipientID INT,
    TransactionType VARCHAR(20) NOT NULL, -- 'Donation' or 'Transfusion'
    TransactionDate DATE NOT NULL,
    FOREIGN KEY (UnitID) REFERENCES BloodUnits(UnitID),
    FOREIGN KEY (DonorID) REFERENCES Donors(DonorID),
    FOREIGN KEY (RecipientID) REFERENCES Recipients(RecipientID)
);



CREATE TABLE Employees (
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    FirstName VARCHAR(50) NOT NULL,
    LastName VARCHAR(50) NOT NULL,
    Gender VARCHAR(10),
    BirthDate DATE,
    ContactNumber VARCHAR(15),
    Email VARCHAR(50),
    Address VARCHAR(100),
    Position VARCHAR(50),
    HireDate DATE
);


ALTER TABLE Recipients
ADD EmployeeID INT;

ALTER TABLE Recipients
ADD CONSTRAINT FK_Recipients_Employees
FOREIGN KEY (EmployeeID) REFERENCES Employees(EmployeeID);

INSERT INTO Donors (FirstName, LastName, Gender, BirthDate, BloodType, ContactNumber, Email, Address, LastDonationDate)
VALUES
('John', 'Doe', 'Male', '1980-01-15', 'O+', '1234567890', 'john.doe@example.com', '123 Elm Street', '2023-06-01'),
('Jane', 'Smith', 'Female', '1990-02-20', 'A-', '2345678901', 'jane.smith@example.com', '456 Oak Street', '2023-05-15'),
('Mike', 'Johnson', 'Male', '1985-03-25', 'B+', '3456789012', 'mike.johnson@example.com', '789 Pine Street', '2023-07-10'),
('Sara', 'Williams', 'Female', '1995-04-30', 'AB-', '4567890123', 'sara.williams@example.com', '321 Maple Street', '2023-06-20'),
('Tom', 'Brown', 'Male', '1975-05-10', 'O-', '5678901234', 'tom.brown@example.com', '654 Birch Street', '2023-07-01');

select * from Donors

INSERT INTO BloodUnits (BloodType, CollectionDate, ExpiryDate, DonorID, Status)
VALUES
('O+', '2023-06-01', '2023-09-01', 1, 'Available'),
('A-', '2023-05-15', '2023-08-15', 2, 'Available'),
('B+', '2023-07-10', '2023-10-10', 3, 'Available'),
('AB-', '2023-06-20', '2023-09-20', 4, 'Available'),
('O-', '2023-07-01', '2023-10-01', 5, 'Available');


select * from BloodUnits

INSERT INTO Recipients (FirstName, LastName, Gender, BirthDate, BloodType, ContactNumber, Email, Address, EmployeeID)
VALUES
('Tapan', 'Patel', 'Male', '1990-05-15', 'A+', '1234567890', 'tapan.patel@example.com', '123 Lakeview Street', 1),
('Sam', 'Johnson', 'Male', '1985-08-20', 'O+', '2345678901', 'sam.johnson@example.com', '456 Riverside Avenue', 2),
('Ram', 'Singh', 'Male', '1992-12-10', 'B+', '3456789012', 'ram.singh@example.com', '789 Highland Road', 3),
('John', 'Doe', 'Male', '1988-03-05', 'AB-', '4567890123', 'john.doe@example.com', '321 Mountain Drive', 4),
('Eva', 'Smith', 'Female', '1995-07-25', 'O-', '5678901234', 'eva.smith@example.com', '654 Forest Lane', 5);
Select *from Recipients



INSERT INTO Transactions (UnitID, DonorID, RecipientID, TransactionType, TransactionDate)
VALUES
(1, 1, NULL, 'Donation', '2023-06-01'),
(2, 2, NULL, 'Donation', '2023-05-15'),
(3, 3, NULL, 'Donation', '2023-07-10'),
(4, 4, NULL, 'Donation', '2023-06-20'),
(5, 5, NULL, 'Donation', '2023-07-01');

INSERT INTO Transactions (UnitID, DonorID, RecipientID, TransactionType, TransactionDate)
VALUES
(1, NULL, 2, 'Transfusion', '2023-06-05'),
(2, NULL, 3, 'Transfusion', '2023-05-20'),
(3, NULL, 4, 'Transfusion', '2023-07-15'),
(4, NULL, 5, 'Transfusion', '2023-06-25'),
(5, NULL, 6, 'Transfusion', '2023-07-05');

select * from  Transactions 

INSERT INTO Employees (FirstName, LastName, Gender, BirthDate, ContactNumber, Email, Address, Position, HireDate)
VALUES
('Emily', 'Taylor', 'Female', '1985-01-15', '1231231234', 'emily.taylor@example.com', '1234 Oak Avenue', 'Admin', '2015-05-01'),
('James', 'Anderson', 'Male', '1979-02-20', '2342342345', 'james.anderson@example.com', '5678 Maple Avenue', 'Staff', '2016-06-10'),
('Olivia', 'Thomas', 'Female', '1990-03-25', '3453453456', 'olivia.thomas@example.com', '9101 Birch Avenue', 'Staff', '2017-07-20'),
('William', 'Moore', 'Male', '1983-04-30', '4564564567', 'william.moore@example.com', '1121 Pine Avenue', 'Staff', '2018-08-15'),
('Sophia', 'Jackson', 'Female', '1995-05-10', '5675675678', 'sophia.jackson@example.com', '3141 Cedar Avenue', 'Admin', '2019-09-25');
use DBProject_tapan

select * from Employees


DELETE FROM Employees where EmployeeID=10;

 

 SELECT * FROM Transactions 
 WHERE TransactionDate > '2023-07-01'; 

SELECT Donors.FirstName, Donors.LastName, Transactions.TransactionID 
FROM Donors 
INNER JOIN Transactions ON Donors.DonorID = Transactions.DonorID; 

 

SELECT DonorID, COUNT(*) AS TotalTransactions 
FROM Transactions 
GROUP BY DonorID 
HAVING COUNT(*) < 5; 


 

SELECT * FROM BloodUnits 
ORDER BY CollectionDate DESC; 

SELECT FirstName, LastName 
FROM Donors 
WHERE DonorID IN ( 

    SELECT DonorID 
    FROM Transactions 
    WHERE TransactionType = 'Donation' 
    GROUP BY DonorID 
    HAVING COUNT(UnitID) <2 

); 

SELECT TransactionID, UnitID, DonorID, RecipientID, TransactionDate, 
       CASE  
           WHEN TransactionType = 'Donation' THEN 'Donated' 
           WHEN TransactionType = 'Transfusion' THEN 'Transfered' 
           ELSE 'Other' 
       END AS TransactionStatus 
FROM Transactions; 


 