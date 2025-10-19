# 🧠 SkillVault

**SkillVault** is a **Java console-based skill tracker** that helps users manage and organize their skills efficiently.  
It provides full **CRUD (Create, Read, Update, Delete)** operations through a **command-line interface (CLI)**  
and stores all data persistently in a **PostgreSQL** database.

---

## 🚀 Tech Stack

| Component           | Technology     |
| ------------------- | -------------- |
| **Language**        | Java 24        |
| **Build Tool**      | Maven          |
| **Database**        | PostgreSQL     |
| **Database Access** | JDBC (DAO pattern) |
| **Interface**       | Command Line (CLI) |

---

## 🗃️ Database Schema

**Table:** `skills`

| Column          | Type     | Description              |
| ---------------- | -------- | ------------------------ |
| `id`             | INT      | Primary key (auto-increment) |
| `name`           | VARCHAR  | Skill name               |
| `category`       | VARCHAR  | Skill category           |
| `difficulty`     | INT      | Difficulty (1–5)         |
| `mastery_level`  | INT      | Mastery level (1–100)    |

---

## ⚙️ Features

- ➕ **Add Skill** – Add a new skill with name, category, difficulty, and mastery level  
- 👀 **View All Skills** – Display all stored skills  
- 🔍 **View Skill by ID** – Retrieve a skill by its unique ID  
- ✏️ **Update Skill** – Modify existing skill details  
- ❌ **Delete Skill** – Remove a skill from the database  
- 🚪 **Exit** – Close the application gracefully  

---

## 🧩 Workflow

1. Run `SkillApp`
2. CLI menu is displayed
3. User selects an action (Add / View / Update / Delete)
4. `SkillApp` calls `SkillDAO`, which interacts with PostgreSQL via JDBC
5. Output is displayed in the CLI

---

## 💪 Strengths

- Clean **DAO + Model** structure  
- Fully functional **CRUD operations**  
- Persistent storage using **PostgreSQL**  
- Simple, menu-driven **CLI interface**

---

## 🔮 Future Improvements

- Connection pooling for better performance  
- User login & skill ownership tracking  
- Input validation and sorting/filtering in CLI  
- Skill progress tracking and reporting  

---

## 🧰 How to Run

### Prerequisites
- Java 24+
- Maven
- PostgreSQL (database named `skillvault`)

### Steps
```bash
# 1. Clone the repository
git clone https://github.com/your-username/skillvault.git
cd skillvault

# 2. Configure your database connection in DbConnection.java

# 3. Build and run the project
mvn clean compile exec:java
