# spring-core-examples 🚀
The `spring-core-examples` is a collection of simple spring framework (core) examples demonstrating IoC, DI, beans, and other fundamental concepts. 📘💉

## Project Architecture 📂

- **hello-spring-greeting**
  - Simple Spring application demonstrating XML-based configuration
  - Shows basic IoC (Inversion of Control) and DI (Dependency Injection)

- **employee-department-xml-di**
  - Demonstrates Spring's XML-based DI with `Employee`-`Department` relationship.
  - Uses `spring.xml` for bean definitions with setter injection (primitives) and reference injection (objects).
  - Shows IoC via `ClassPathXmlApplicationContext` and object composition. Pure XML approach without annotations.

- **book-management-system-with-spring**
  - Implemented Book and User Module CRUD operations in the `book-management-system-with-spring` project.
  - Demonstrates Spring's IoC and DI for managing books and users using XML-based configuration.
  - Includes all layers: Controller, Service, and Repository for both Book and User modules.
  - In the `MainApp.java`, implemented user input for:
    - **Admin Login**: Only after successful admin login can book/user operations be performed.
    - **Module Selection**: After login, the admin can choose between Book Operations or User Operations.
    - **Book Operations**:
      - Add, view, update, and delete books.
      - View all books or search for a specific book by ID.
    - **User Operations**:
      - Add, view, update, and delete users.
      - View all users or search for a user by ID.
      - User has reference to `College` enum with name and address fields.
  - Uses Spring's XML configuration for MySQL database connection, Repository, Service, and Controller beans.
