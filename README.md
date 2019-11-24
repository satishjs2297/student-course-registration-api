
# student-course-registration-api

####  Student Course registration api used to add, delete and register students and courses and vice versa

## Getting Started

Please follow the below steps to setup and run student-course-registration-api

### Prerequisites

- This project requires Java 8 need to be installed.
- Install any Java IDE (Eclipse, STS, Intellij etc..) and ensure you are able to launch
-  Clone/Checkout the project from version control system (git) and follow below steps

```
$ cd student-course-registration-api
$ mvn clean install 
$ mvn spring-boot:run -e
$ Open web browser & hit the swagger url: http://localhost:8080/student-course/swagger-ui.html
```
## Development Setup

- Clone student-course-registration-api project. (git clone <repo url>)
- Open eclipse and import this project under (Existing Maven project)

## Tech stack

- Java 8
- Spring Boot: 2.1.7.RELEASE
- H2 In-Memory DB
- Swagger2 - For API Local Testing

## Testing API
- Open http://localhost:8080/student-course/swagger-ui.html
- Click on addCourse/addStudent or any one of the endPoint.
- Click on Try it out and fill the input payload as per the contract.
- Finally Click on Excetue and ensure to see the 200 response with response message.
- Also Open http://localhost:8080/student-course/h2/ from web browser to view the data persisted by this api.

## Developer(s)

*  Mahesh Boggala

## Acknowledgments

* [Enable Swagger UI api-docs](https://www.vojtechruzicka.com/documenting-spring-boot-rest-api-swagger-springfox/)
* [Spring Boot Rest API](https://spring.io/guides/gs/rest-service/)
