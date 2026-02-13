# SWE7302-OmniStore
MCS AI Advance Software Developmnet Project
Omni-Store Legacy System 

This repository will contain the development and refactoring of a legacy
Omni-Store system as part of SWE7302 Advanced Software Development.

The project will demonstrate object-oriented principles and the application
of creational, structural, and behavioral design patterns.
To start with: 
Omni-Store Legacy System – SWE7302


Problem Overview
Omni-Store is a simple retail system that allows customers to place orders
for products, make payments using different payment methods, and update
inventory levels accordingly. The system supports basic order processing,
pricing, and inventory management.

Legacy System Description
The initial version of Omni-Store is intentionally designed as a legacy
system. It follows a monolithic structure where a single class is
responsible for handling most of the system’s functionality, including
order processing, payment handling, and inventory updates.

This design results in:
- Tight coupling between components
- Long conditional (if/else) statements for business logic
- Poor separation of concerns
- Difficulty in extending the system with new features

These issues make the system hard to maintain and violate several object-
oriented design principles.

Project Aim
The aim of this project is to refactor the legacy Omni-Store system using
object-oriented principles and appropriate design patterns (Creational,
Structural, and Behavioral) in order to improve maintainability,
flexibility, and code quality.

13/02/2026
Refactoring Phase

This branch begins the refactoring of the legacy OmniStore system.
The goal is to improve code structure by applying:

- Creational Pattern (Factory)
- Behavioral Pattern (Strategy)
- Structural Pattern (Decorator)

The legacy system will remain unchanged in the main branch.
First Refactor = Payment → Factory Pattern

One pattern at a time.
One commit per pattern.

