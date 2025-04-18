# spring-core-examples 🚀
The `spring-core-examples` is a collection of simple spring framework (core) examples demonstrating IoC, DI, beans, and other fundamental concepts. 💉🌱

## Project Architecture 📂

- **hello-spring-greeting**
  - Simple Spring application demonstrating XML-based configuration
  - Shows basic IoC (Inversion of Control) and DI (Dependency Injection)

-  **employee-department-xml-di**
   -  Demonstrates Spring's XML-based DI with `Employee`-`Department` relationship.
   -  Uses `spring.xml` for bean definitions with setter injection (primitives) and reference injection (objects).
   -  Shows IoC via `ClassPathXmlApplicationContext` and object composition. Pure XML approach without annotations.

- **book-management-system-with-spring**
  - Added `AdminController` with register, login, and show all admins functionality using setter-based DI in Spring.
  - Demonstrates Spring's IoC and DI for admin management using XML-based configuration.
  - Includes all layers: Controller, Service, and Repository.
  - In the `MainApp.java`, implemented user input for:
    - Registering a new admin with admin name, username, and password.
    - Login functionality to authenticate admins.
    - Option to display all registered admins.
  - Uses Spring's XML configuration for MySQL database connection, Admin Repository, Service, and Controller beans.
