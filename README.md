# Basic CRUD WebApp for learning purposes!

Hibernate used as ORM-Tool for administration of MySQL DB

Spring Boot/MVC for a RESTful Webservice

Submodule [Healthapp-Angular](https://github.com/Lockoo/HealthApp-Angular) frontend to make calls to the Webservice



# Running the App with Docker Compose

Running the App is as simple as running 'docker-compose up' in the root directory!

At first a MySQL-Server will be started and initialized with a SQL-Scheme.
The embedded Tomcat-Server will wait for the Database to be initialized and then fire up the Spring Boot Application listening on localhost:8080.
Last but not least if everything is ready the Angular-App will be started and is accessible via your browser on localhost:4200