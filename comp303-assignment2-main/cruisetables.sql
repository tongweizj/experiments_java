-- 1. create cruisedb
DROP DATABASE IF EXISTS cruisereservation;
CREATE DATABASE cruisereservation;
USE cruisereservation;

-- 2. Customer table
CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE, 
    password VARCHAR(255) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    address VARCHAR(255),
    city VARCHAR(50),
    postalCode VARCHAR(20)
);

-- 3. Cruise table
CREATE TABLE Cruise (
    cruise_id INT AUTO_INCREMENT PRIMARY KEY,
    cruise_name VARCHAR(100) NOT NULL,
    departure_time TIME,
    arrival_time TIME,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- 4. Booking table
CREATE TABLE Booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL, 
    cruise_id INT NOT NULL, 
    booking_date DATE NOT NULL,
    departure_date DATE NOT NULL,
    no_of_passengers INT NOT NULL,
    total_price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20) DEFAULT 'Confirmed', 
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id) ON DELETE CASCADE,
    FOREIGN KEY (cruise_id) REFERENCES Cruise(cruise_id) ON DELETE CASCADE
);