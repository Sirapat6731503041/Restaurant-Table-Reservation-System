# Restaurant-Table-Reservation-System
Object-Oriented Design and Programming Project 
Object-Oriented Design and Programming Project Document
Project Information
- Project Group No.: 6
- Project Name: Restaurant Table Reservation System
- Course: 1305104 Object Oriented Design and Programming
- Instructor: Wacharawan Intayoad (Aj. Ying)

# Project Members
-6631503124 Jutatip Sriputhon section 1

-6731503008 Yanon Laiphukum section 1

-6731503039 Suphanat Aekmongkolsakul section 1

-6731503041 Sirapat Ketmek section 1

-6731503113 Firdao Masae section 2

# Project Background
Project Title: Restaurant Table Reservation System
Overview:
The Restaurant Table Reservation System is a console-based Java application designed to help a restaurant efficiently manage its table reservations. The system allows customers to book VIP or Regular tables for dinner and provides the ability for staff or customers to view, cancel, and save reservations. It is built using Object-Oriented Programming (OOP) concepts, such as inheritance, encapsulation, and polymorphism, and uses Java’s built-in collections (HashMap) and file I/O for data storage.
Purpose:
The purpose of this project is to streamline the reservation process, reduce human error in table allocation, and ensure a better dining experience by managing available tables and service fees efficiently. The system distinguishes between regular and VIP tables, making it more flexible for various customer preferences and business tiers.
Motivation:
Manual reservation processes are time-consuming, error-prone, and difficult to track. This project was developed to automate the reservation workflow, simplify data handling, and support better customer service while also demonstrating core programming and software design skills.
Problem Statement:
Traditional reservation methods often lack real-time availability tracking and data persistence. This can lead to issues like overbooking or losing customer information. This system aims to solve these problems by:
1.Automatically tracking which tables are booked or available
2.Differentiating between table types (VIP vs. Regular)
3.Allowing data to be saved and reloaded between program runs
4.Validating input to prevent invalid data entry

Functional List
1. Show Available Tables
Displays a list of unbooked tables, categorized by VIP (1–5) and Regular (6–20).
2. Add Reservation
Allows the user to select a table type (VIP or Regular), choose an available table, and enter their name to create a reservation.
3. Cancel Reservation
Cancels an existing reservation by specifying the table number.
4. View Reservations
Displays reservation details (ID, table number, capacity, service fee) for a given customer name.
5. Save Reservations
Writes current reservation data to a file (reservations.txt) to maintain data across sessions.
6. Load Reservations
Reads and restores reservation data from a file when the system starts.


7. VIP Reservation Count
Calculates and returns the total number of VIP reservations currently stored.


8. Validate User Input
Ensures that all inputs (names and numbers) meet specified formats and are within allowed ranges.
