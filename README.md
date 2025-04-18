# spring-core-examples 🚀

The `spring-core-examples` is a collection of simple Spring Framework examples demonstrating IoC, DI, beans, and other fundamental concepts. 📘💉

---

## Project Architecture 📂

- **hello-spring-greeting**
  - Simple Spring application demonstrating XML-based configuration
  - Shows basic IoC (Inversion of Control) and DI (Dependency Injection)

- **employee-department-xml-di**
  - Demonstrates Spring's XML-based DI with `Employee`-`Department` relationship.
  - Uses `spring.xml` for bean definitions with setter injection (primitives) and reference injection (objects).
  - Shows IoC via `ClassPathXmlApplicationContext` and object composition. Pure XML approach without annotations.

- **book-management-system-with-spring**
  - Implemented Book, User, Admin, and Record Module CRUD operations in the `book-management-system-with-spring` project.
  - Demonstrates Spring's IoC and DI for managing books, users, and records using XML-based configuration.
  - Includes all layers: Controller, Service, and Repository for Book, User, Admin, and Record modules.
  - Uses manual JDBC (`PreparedStatement` and `DataSource`) for database operations.
  - In the `MainApp.java`, implemented user input for:
    - **Admin Login**: Only after successful admin login can module operations be performed.
    - **Module Selection**: After login, the admin can choose between Book, User, and Record operations.
    - **Book Operations**:
      - Add, view, update, and delete books.
      - View all books or search for a specific book by ID.
    - **User Operations**:
      - Add, view, update, and delete users.
      - View all users or search for a user by ID.
      - User has reference to `College` enum with name and address fields.
    - **Record Operations**:
      - Add new record (borrow book).
      - View all records or search for a record by ID.
      - Update or delete a record.
      - **Search Records by Username**: Filter borrowed records by specific user's name using `getRecordsByUserName`.

  - Uses Spring's XML configuration for MySQL database connection, Repository, Service, and Controller beans.

---

### **Technologies Used** 💻🔧

#### **Backend Technologies**
- **Java (JDK 21)** ☕️: Core programming language for the application logic.
- **Spring Framework (Core)** 🌱: For IoC, DI, and managing beans using XML-based configuration.
- **JDBC** 📡: To connect and interact with the MySQL database.
- **MySQL** 🗄️: Stores data for books, users, admins, and borrow records.
- **Maven** 🧰: For dependency management and project building.

---

### **Prerequisites** 🛠️

Before you begin, make sure the following are installed:

- **Java JDK 21 or later**: Download from [Oracle](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) or [OpenJDK](https://jdk.java.net/21/).
- **IntelliJ IDEA for Enterprise Java**: Download from [IntelliJ IDEA Download](https://www.jetbrains.com/idea/download/)
- **MySQL Server**: Install from [MySQL Community](https://dev.mysql.com/downloads/installer/).
- **Maven**: [Install Maven](https://maven.apache.org/install.html) if not bundled with your IDE.
