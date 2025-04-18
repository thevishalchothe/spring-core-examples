# spring-core-examples 🚀
The `spring-core-examples` is a collection of simple spring framework (core) examples demonstrating IoC, DI, beans, and other fundamental concepts. 📘💉

## Project Architecture 📂

- **hello-spring-greeting**
  - Simple Spring application demonstrating XML-based configuration
  - Shows basic IoC (Inversion of Control) and DI (Dependency Injection)

- **employee-department-xml-di**
   -  Demonstrates Spring's XML-based DI with `Employee`-`Department` relationship.
   -  Uses `spring.xml` for bean definitions with setter injection (primitives) and reference injection (objects).
   -  Shows IoC via `ClassPathXmlApplicationContext` and object composition. Pure XML approach without annotations.

- **book-management-system-with-spring**
  - Implemented Book Module CRUD operations in the `book-management-system-with-spring` project.
  - Demonstrates Spring's IoC and DI for managing books using XML-based configuration.
  - Includes all layers: Controller, Service, and Repository.
  - In the `MainApp.java`, implemented user input for:
    - Adding, viewing, updating, and deleting books.
    - View all books or search for a specific book by ID.
  - Uses Spring's XML configuration for MySQL database connection, Book Repository, Service, and Controller beans.
