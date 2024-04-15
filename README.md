# Shopping Experience
The project provides API for data uploader and data retrieval services.

## Requirements

For building and running the application you need:

- JDK v17
- Gradle v8.7

## Running the application locally

Need a DB Configured with the following credentials ( The DB connection credentials can be overridden by updating /resource/application.properties)
* RDBMS Implementation : MySQL
* Database Name : shopex
* Username : root
* Password : pass@123
* spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
* spring.jpa.show-sql= true
* spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
* spring.jpa.properties.hibernate.event.merge.entity_copy_observer=allow

### Running the spring boot application

```shell
gradle bootRun
```
## OpenAPI Spec 3.0.1
* ShoppingExperience [Swagger UI](http://localhost:8080/swagger-ui/index.html)
* ShoppingExperience [Swagger JSON format](http://localhost:8080/openApi)



## Internal APIs
Data loader API supports the loading of Catalog and User Selections the system

## External API
High performant API for the quick and efficient data retrieval.