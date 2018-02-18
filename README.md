# Basic CRUD WebApp for learning purposes!

Spring Boot + Spring MVC backend Server

Hibernate used as ORM-Tool for administration of MySQL DB

Submodule [Healthapp-Angular](https://github.com/Lockoo/HealthApp-Angular) frontend to make calls to the App



# Running the App with Docker Compose

Running the App is as simple as running 'docker-compose up' in the root directory! (pulling the image from locko/healthapp-spring)


A MySQL-Server will be started and initialized with a scheme.
The embedded Tomcat-Server will wait for the Database to be initialized and then fire up the Spring Boot Application listening on localhost:8080