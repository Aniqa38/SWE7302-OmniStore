# SWE7302 – OmniStore

**MCS AI, University of Greater Manchester**  
Desktop Application using **Java & JavaFX**

---

## 1. Project Overview

This repository contains the development and refactoring of the **OmniStore Legacy System** as part of the *SWE7302 – Advanced Software Development* module.

The project focuses on applying **object-oriented principles** and implementing **Creational, Structural, and Behavioral design patterns** to transform a monolithic legacy system into a maintainable, extensible, and well-structured application.

---

## 2. Problem Overview

OmniStore is a simple retail management system that allows customers to:

- Place product orders  
- Make payments using different payment methods  
- Apply discounts  
- Update inventory levels  

The system supports basic order processing, pricing, and inventory management.

---

## 3. Legacy System Description

The initial version of OmniStore was intentionally designed as a **legacy monolithic system**.

Characteristics of the legacy design:

- A single class handles most of the system functionality  
- Order processing, payment handling, and inventory updates are tightly coupled  
- Business logic relies heavily on long `if/else` conditional statements  

### Issues Identified

- Tight coupling between components  
- Poor separation of concerns  
- Difficult to extend with new features  
- Violates key object-oriented design principles  
- Hard to maintain and scale  

---

## 4. Project Aim

The aim of this project is to refactor the legacy system using:

- Object-Oriented Design Principles  
- Creational Design Patterns  
- Structural Design Patterns  
- Behavioral Design Patterns  

The goal is to improve:

- Maintainability  
- Flexibility  
- Code readability  
- Scalability  
- Overall software quality  

---

## 5. Design Patterns Implemented

This project applies the following patterns:

### Strategy Pattern
Used to handle different discount strategies dynamically.

### Factory Pattern
Used to create different payment method objects without exposing instantiation logic.

### Decorator Pattern
Used to add optional features such as gift wrapping without modifying existing classes.

---

## 6. GUI Implementation (JavaFX)

The system includes a graphical user interface built using **JavaFX**.

### Features:

- Customer-friendly order interface  
- Option to select discount (Strategy Pattern)  
- Option to select payment method (Factory Pattern)  
- Optional gift wrap feature (Decorator Pattern)  
- Order confirmation popup messages  
- Data stored in SQLite database  
- Clean and user-friendly interface  

---

## 7. Database

- SQLite database integration  
- Orders are stored persistently  
- Database operations handled separately from UI logic  

---

---

## 8. UML Modelling

- UML diagrams were created to support architectural analysis and demonstrate the transformation from the legacy system to the refactored design.

### Legacy System UML

- Class Diagram – Shows the monolithic structure where all responsibilities are centralised within a single OmniStoreManager class.
- Sequence Diagram – Demonstrates how order processing, discount calculation, payment handling, and notification logic are executed internally within one class using conditional branching.

- These diagrams highlight tight coupling, lack of abstraction, and poor separation of concerns in the original implementation.

### Refactored System UML

- Class Diagram – Shows modular package organisation (discount, order, payment, database) and the introduction of interfaces and abstraction.
- Sequence Diagram – Illustrates runtime collaboration between Strategy, Decorator, Factory, and Database components.

- The UML comparison clearly visualises the architectural evolution from a monolithic system to a modular, loosely coupled, pattern-driven design.


## 9. Running the Project

- Make sure you are in the root project folder
- Run the following command:
 mvn clean javafx:run

## 10. Technologies Used

- Java
- JavaFX
- Maven
- SQLite

## 11. Learning Outcomes

- Refactoring legacy systems
- Applying object-oriented principles
- Implementing Creational, Structural, and Behavioral design patterns
- Separating concerns between UI, business logic, and data layer
- Building desktop applications using JavaFX
