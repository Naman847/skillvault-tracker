# SkillVault

**SkillVault** is a **Java console-based skill tracking system** that allows users to manage, track, and update their skills. It uses **Java 24** and **PostgreSQL** for persistent storage. The application is designed with clean architecture principles using **DAO and POJO models**, providing a simple CLI for interaction.

---

## **Table of Contents**

- [Features](#features)  
- [Architecture](#architecture)  
- [Database Schema](#database-schema)  
- [Installation & Setup](#installation--setup)  
- [How to Run](#how-to-run)  
- [Usage](#usage)  
- [Potential Improvements](#potential-improvements)  
- [Technologies Used](#technologies-used)  
- [License](#license)  

---

## **Features**

- Add new skills with attributes:
  - ID, Name, Category, Difficulty, Mastery Level
- View all skills in the database
- View a skill by its ID
- Update existing skill details
- Delete a skill by ID
- Menu-driven CLI interface for easy navigation

---

## **Architecture**

+----------------+ +-----------------+ +------------------+
| SkillApp (CLI) | --> uses | SkillDAO | --> uses | DbConnection |
| | | (CRUD methods) | | (JDBC, PostgreSQL)|
+----------------+ +-----------------+ +------------------+
^ ^
| |
+--------------------- Skill Model ----------------------+

pgsql
Copy code

- **SkillApp:** Main program handling user interaction via CLI  
- **SkillDAO:** Performs all CRUD operations on the database  
- **Skill:** Represents the skill entity  
- **DbConnection:** Utility class to establish a connection to PostgreSQL  

---

## **Database Schema**

**Table: `skills`**

| Column        | Type     | Description                      |
|---------------|---------|----------------------------------|
| id            | INT     | Primary Key                      |
| name          | VARCHAR | Name of the skill                |
| category      | VARCHAR | Skill category (e.g., Programming, Design) |
| difficulty    | INT     | Difficulty level (1–5)           |
| mastery_level | INT     | Mastery level (1–100)            |

**SQL Example:**

```sql
CREATE TABLE skills (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(100),
    difficulty INT,
    mastery_level INT
);
