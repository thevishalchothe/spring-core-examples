# spring-core-examples 🚀

The `spring-core-examples` is a collection of simple Spring Framework examples demonstrating IoC, DI, beans, and other fundamental concepts. 📘💉

---

## Project Architecture 📂

- **hello-spring-greeting**
  - Simple Spring application demonstrating XML-based configuration
  - Shows basic IoC (Inversion of Control) and DI (Dependency Injection)

-  **hello-spring-with-annotation**
    -  Demonstrates basic Spring configuration using annotations instead of XML.
    - Uses `@Component`, `@Autowired`, and `@Configuration` for defining beans and injecting dependencies.
    - Uses `AnnotationConfigApplicationContext` to bootstrap the application to understand annotation-driven Spring development.
      
- **employee-department-xml-di**
  - Demonstrates Spring's XML-based DI with `Employee`-`Department` relationship.
  - Uses `spring.xml` for bean definitions with setter injection (primitives) and reference injection (objects).
  - Shows IoC via `ClassPathXmlApplicationContext` and object composition. Pure XML approach without annotations.

- **book-management-spring-xml**
  
  A fully functional **Book Management System** using **Spring xml-based configuration**.
  - Implemented Book, User, Admin, and Record Module CRUD operations in the `book-management-system-with-spring` project.
  - Demonstrates Spring's IoC and DI for managing books, users, and records using XML-based configuration.
  - Includes all layers: Controller, Service, and Repository for Book, User, Admin, and Record modules.
  - Uses manual JDBC (`PreparedStatement` and `DataSource`) for database operations.
  - **MainApp.java** handles:
    - Admin Login (authentication required before accessing modules),
    - Book Module: Add, view, update, delete, and search books by ID,
    - User Module: Add, view, update, delete users, search by ID, and associate with `College` enum,
    - Record Module: Borrow books, view/update/delete records, and filter by username (`getRecordsByUserName`).
  - Uses Spring's XML configuration for MySQL database connection, Repository, Service, and Controller beans.

- **library-management-spring-annotation**

  A fully functional **Library Management System** using **Spring annotation-based configuration**.

  - Implements CRUD operations for:
    - Admin: Admin registration and login authentication before accessing the system.
    - Book Module: Add, view, update, delete, and search books.
    - User Module: Manage user data with a reference to a `College` enum (containing name and address).
    - Record Module: Track borrowed books, view/update/delete borrow records, and filter records by username.

  -  Uses: 

      - `@Component`, `@Service`, `@Repository`, `@Configuration`  
      → Annotation-based bean management and dependency injection.

      - `DriverManagerDataSource`  
      → For **MySQL** DB connectivity using **manual JDBC** with `PreparedStatement`.

      - `AnnotationConfigApplicationContext`  
      → To bootstrap and run the Spring application.

- Follows layered architecture with clear separation of **Controller**, **Service**, and **Repository** layers.

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

---

## **Installation** 🛠️

### **Clone the Repository**

   ```bash
   git clone https://github.com/thevishalchothe/spring-core-examples.git

   cd spring-core-examples
   ```

---

## **Contributing** 💡

We welcome contributions to the **spring-core-examples**! Here's how you can contribute:

1. Fork the repository and create a new branch for your feature or bug fix.
2. Implement your changes and commit them with clear messages.
3. Submit a pull request for review.

If you have any questions or need help, feel free to contact me at [vishalchothe134@gmail.com](mailto:vishalchothe134@gmail.com).

---

## **Conclusion & License** 📜

Using an open-source license encourages collaboration and contributions from the community, leading to continuous improvement.

See the [LICENSE](https://github.com/thevishalchothe) file for more information.

---

## **Thank You and Best Regards!** 🙏🎉


