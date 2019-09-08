# spring-mvc-jpa-junit-crud

The following development implements a REST-JSON API that performs the CRUD operations of the Employees entity using Spring MVC, JPA and maven-compiler-plugin.

# It has used the follow tecnologies.

• Java 8 • Spring MVC • Spring DATA-JPA • Junit4 • Hibernate • Maven • Jackson Library • H2 as a database

The Employees entity is related to the Departments entity with a cardinality 1 Department has N Employees, and 1 Employee belongs to 1 Department.

The API implements the funcionalities:

- Create an department
- Create an employee
- Show a department list
- Show a employee list
- Show a list of employees by department
- Delete an employee
- Update an employee

# configuration will start the embedded Tomcat instance on port 9090. You can change the port as required.

Build the project
mvn clean install

# Start the embedded Tomcat server.
mvn tomcat7:run
