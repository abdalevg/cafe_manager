# V3S REST API
REST API for V3S application

## Development

### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `cz.cvut.vvvs.rest.VvvsRestApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
#### REST API Documentation
Documentation in swagger is available at http://localhost:8080/swagger-ui.html

### Production build

##### Build as JAR with embedded Tomcat
```
mvn package -P JAR
```

##### Build as WAR
```
mvn package -P WAR
```

