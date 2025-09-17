# Customer Application

1. Create Customer Class (Entity)
2. Create Repository: CustomerRepository @Repository
    - implement business logic using ArrayList
    - CreateCustomer
    - Retrieve All Customers
    - Update Customer Id
    - Retrieve Customer By Id
    - Delete Customer By Id
3. Service Layer
    - CustomerService interface
    - CustomerServiceImpl @Service
4. Controller Layer
    - CustomerController
    - AddCustomer (@RequestBody)
    - getById (@PathVariable)
    - Mapping (@RequestMapping)
    - get method (@GetMapping)
    - post (@PostMapping)
5. To Test using Swagger add below dependency to pom.xml
```xml
        <dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.8.13</version>
		</dependency>
```
6. check swagger URL:
[Swagger URL](http://localhost:8080/swagger-ui/index.html#/)