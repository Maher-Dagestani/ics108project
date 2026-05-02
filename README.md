# KFUPM Event & Venue Management System

A robust, console-based Java application designed to streamline event scheduling and venue management. This project adheres to core Object-Oriented Programming (OOP) principles, including **Encapsulation**, **Abstraction**, **Inheritance**, and **Polymorphism**.


## stars
![GitHub stars](https://img.shields.io/github/stars/Maher-Dagestani/ics108project?style=social)

## 🌟 Features

- **Dual User Roles**: Specialized experiences for **Organizers** (with administrative privileges) and **Students**.
- **Venue Management**: Support for various venue types, including Sports Areas, Lecture Halls, Conference Halls, and Public Spaces.
- **Event Scheduling**: Create and manage events with detailed classifications (Sports, Social, Religious, Academic).
- **Conflict Resolution**: Built-in `OverlapChecker` ensures no two events are scheduled in the same venue at the same time.
- **Participation System**: Students can browse and enroll in events, maintaining their own personalized schedules with overlap protection.
- **Data Persistence**: Automatic saving and loading of system state via `database.txt`.
- **Intuitive UI**: A clean, interactive command-line interface with step-by-step prompts.

## 🛠️ Architecture

The project is built using a clean OOP architecture:
- **Inheritance**: `OrganizerMenue` extends `StudentExperience`, leveraging shared UI logic while adding administrative capabilities.
- **Encapsulation**: Private fields with public getters/setters (e.g., in `Event` and `person` classes) maintain data integrity.
- **Utility Classes**: Dedicated logic for `Time` management, `OverlapChecker`, and `Database` operations.

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher.

### Installation & Running
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the application:
   ```bash
   java Main
   ```

## 📖 Usage

### For Organizers 👔
- **Manage Venues**: Create new locations or use existing ones.
- **Schedule Events**: Enter event names, sponsor departments, and supervisors.
- **Smart Scheduling**: The system validates time slots and prevents double-booking of venues.

### For Students 🎓
- **Browse**: View all upcoming events organized by venue.
- **Enroll**: Join events; the system automatically checks for conflicts in your personal schedule.
- **Personal List**: View a list of all events you are currently registered for.

## 📁 Project Structure

- `Main.java`: The entry point and main application loop.
- `person.java`: Handles user profiles and permissions.
- `Event.java`: Core class for event details and timing.
- `Venue.java`: Base class for all event locations.
- `Time.java`: Handles custom date and time formatting and comparisons.
- `Database.java`: Manages file I/O for persistent storage.
- `OverlapChecker.java`: The logic engine for preventing scheduling conflicts.
- `UserInteraction.java`: Base class for handling console inputs and outputs.

---
*Developed by 𝔐𝔞𝔥𝔢𝔯 𝔇𝔞𝔤𝔢𝔰𝔱𝔞𝔫𝔦 and mohamad wael*
