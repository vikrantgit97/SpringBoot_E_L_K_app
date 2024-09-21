# Error-Logging-Elk Application Development
SpringBoot 3.1.2 Application Development with Docker using ElasticSearch Logstash and Kibana.
<img src="https://www.svgrepo.com/show/354380/spring-icon.svg" style="height: 40px">

* [Install Ubuntu or any LINUX OS for Development(Recommended)   ](https://releases.ubuntu.com/jammy/)<img src="https://assets.ubuntu.com/v1/a7e3c509-Canonical%20Ubuntu.svg" style="height: 40px">

## Springboot_E_L_K_Application (project structure)
````
SpringBoot_E_L_K
.
├── HELP.md
├── Readme.md
├── config
│ └── logstash.conf
├── docker-compose.yml
├── mvnw
├── mvnw.cmd
├── pom.xml
└── src
    ├── main
    │ ├── java
    │ │ └── com
    │ │     └── elk
    │ │         ├── SpringBootELKApplication.java
    │ │         ├── controller
    │ │         │ ├── SchoolController.java
    │ │         │ └── StudentController.java
    │ │         ├── entity
    │ │         │ ├── School.java
    │ │         │ └── Student.java
    │ │         ├── exception
    │ │         │ ├── ApiErrorResponse.java
    │ │         │ ├── ApiValidationErrorResponse.java
    │ │         │ └── ExceptionHandler.java
    │ │         ├── repo
    │ │         │ ├── SchoolRepo.java
    │ │         │ └── StudentRepo.java
    │ │         └── service
    │ │             ├── SchoolService.java
    │ │             └── StudentService.java
    │ └── resources
    │     ├── application.properties
    │     ├── logback-spring.xml
    │     ├── static
    │     │ └── img.png
    │     └── templates
    └── test
        └── java
            └── com
                └── elk
                    └── SpringBootELKApplicationTests.java
 ````
## ELK Stack
Any application will be deployed in a location that provides a log message to a Logfile.
A text type internally ,Searching details (Error, Warning) is a bit complex task So,we are using ELK for easy search of log file data.

* ElasticSearch-https://www.elastic.co/elasticsearch <br>
* Logstash-https://www.elastic.co/logstash <br>
* Kibana-https://www.elastic.co/kibana <br>

````
    1)ElasticSearch :    Search Engine (based on JSON) Distributed even ,Supports Analytics.

    2)Logstash :         Logstash is an open source data collection engine with real-time pipelining capabilities.
       Logstash can dynamically unify data from disparate sources and normalize the data into destinations of your choice. 
       Cleanse and democratize all your data for diverse advanced downstream analytics and visualization use cases.

    3)Kibana :           UI where it will display our file data 
````

## ELK Integration with springboot application
![img.png](src/main/resources/static/img.png)

## Requirements
Make sure to have the followings installed:
<img src="https://www.freepnglogos.com/uploads/logo-mysql-png/logo-mysql-mysql-logo-png-images-are-download-crazypng-21.png" style="height: 40px">
<img src="https://www.svgrepo.com/show/331370/docker.svg" style="height: 40px">

* To run locally
    - MySQL Server

* To run with Docker
    - Docker (Ubuntu 22.04 [Installation guide](https://docs.docker.com/engine/install/ubuntu/))
    - Docker-compose (Ubuntu 22.04 [Installation guide](https://docs.docker.com/compose/install/)))
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+

## Build and Run the project, follow these steps
* Locally
    - Clone the repository: git clone [SpringBoot_E_L_K](https://github.com/vikrantgit97/SpringBoot_E_L_K.git)
    - Navigate to the project directory
    - Create a database in MySql `spring_elk`
    - Build the project: `mvn clean install`
    - Run `mvn clean package spring-boot:run` to build the artifact and run the application

* Docker
    - Run `docker-compose up --build -d` to run the docker services

## Run Spring Boot application directly
```
mvn spring-boot:run
```
