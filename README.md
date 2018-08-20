Simple example for using JOOQ, Kotlin, Spring Boot, Gradle and two datasources with two transaction managers.
To start:
1. go to src/main/docker/postgresql and start DB docker container using command docker-compose up
2. generate JOOQ classes using command: gradle generateJooqClasses
3. start Spring Boot application

You can find endpoints into DevController class
Application listens port 8080 by default

You can check the transactional behaviour using this simple app.
