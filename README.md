Basic CRUD Project for learning purposes!


-Webapp for Doctors&Patients using Spring5 for the Backend and Angular4 for Frontend

-Hibernate used as ORM-Tool for administering a MySQL DB

-HealthApp-Angular Frontend as Submodule



# Running the App with Docker Compose

Running the App is as simple as running docker-compose up in the root directory! (pulling the image from locko/healthapp-spring)


A MySQL-Server will be started and initialized with a scheme.
The embedded Tomcat-Server will wait for the Database to be initialized and then fire up the Spring Boot Application listening on localhost:8080