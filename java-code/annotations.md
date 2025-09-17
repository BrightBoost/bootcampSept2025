# Springboot Annotations

1. @SpringBootApplication (entry point of your app)

    @Configuration
    @EnableAutoConfiguration
    @ComponentScan 

2. @Bean: Used to define beans manually

3. @Component -> create generic Bean

    - @Reposioty - specifically for Data Access Layer
    - @Service - for service Layer
    - @Controller - Web Controller
    - @RestController - REST APIs

4. @Primary - creating a perticular Bean (object) primary to inject incase of multiple beans found.

How to Inject Dependency?

1. Constructor 
2. setter method
