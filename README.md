# Employee Management System (Java + Swing + JDBC)

A simple desktop application built using **Java Swing**, **JDBC**, and **MySQL** to manage employee records.

## Features
- Add Employee  
- View Employees  
- Update Employee  
- Delete Employee  

## Tech Stack
- Java  
- Swing  
- MySQL  
- JDBC  

## How to Run

### 1. Create Database
```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(100),
  department VARCHAR(100),
  designation VARCHAR(100),
  salary DOUBLE
);
```

### 2. Compile
```bash
javac -cp ".;../lib/mysql-connector-j-9.6.0.jar" gui/*.java model/*.java dao/*.java service/*.java Main.java
```

### 3. Run
```bash
java -cp ".;../lib/mysql-connector-j-9.6.0.jar" gui.MainGUI
```

## Project Structure
```
src/
 ├── Main.java
 ├── model/
 ├── dao/
 ├── service/
 └── gui/
lib/
```

## Author
VSaiVardhan
