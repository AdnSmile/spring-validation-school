# Spring Boot RESTful API with validation  
This is a sample of how implements validation for RESTful API in Spring Boot Kotlin and also with relation database in the entity.

## Prerequisite
- Java JDK (v8+)
- Maven (v3+)
- PostgreSQL (optional pgAdmin) / MySQL (optional MySQL Workbench)

## Framework used
- Spring boot
- Spring Web
- Spring validation
- Jpa

## Instructions
1. Clone repository locally using

   `git clone https://github.com/AdnSmile/spring-validation-school.git`
2. Setup database at `application.properties` file
      - PostgreSQL

        ```
        spring.datasource.url=jdbc:postgresql://YOUR_DATABASE_URL:5432/YOUR_DATABASE_NAME
        spring.datasource.username=YOUR_DATABASE_USERNAME
        spring.datasource.password=YOUR_DATABASE_PASSWORD
        spring.datasource.driver-class-name=org.postgresql.Driver
        spring.datasource.hikari.maximum-pool-size=10
        
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
        spring.jpa.properties.hibernate.ddl-auto=update
        ```
        
      - MySQL
  
        ```
        spring.datasource.url=jdbc:mysql://YOUR_DATABASE_URL:3306/YOUR_DATABASE_NAME
        spring.datasource.username=YOUR_DATABASE_USERNAME
        spring.datasource.password=YOUR_DATABASE_PASSWORD
        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.hikari.maximum-pool-size=10
        
        spring.jpa.properties.hibernate.format_sql=true
        spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
        spring.jpa.hibernate.ddl-auto=update
        ```
  3. Install dependencies and run test

     `mvn clean install`

  4. Start your server using

     `mvn spring-boot:run` 
  
