# hello-spring-boot
## is a project designed to test end-to-end integration and delivery of a spring boot RESTful web service.



This uses *Spring Boot Web Services** and **Spring Data JPA** to access a **PostgreSQL** Database. It manages `Assets` which can be related to one other Asset. They contain a name and a boolean value for `is_promoted`.
This webservice allows CRUD based operations against Assets. When an Asset is promoted it will reflect that change against all other Assets related (children and ancestors).

Check out my other project [react-asset-client](https://github.com/cjhetzle/react-asset-client/) meant to work as an interface to this project! :)

```
Asset {
  id: int
  name: string
  is_promoted: boolean
  parent_asset_id: int
}
```

## Requirements
```
Java ^17.x
PostgreSQL
Docker (recomended)
```

## Installation
```
git clone git@github.com:cjhetzle/hello-spring-boot.git
cd hello-spring-boot
```

## Setup
```
edit -> ./src/main/resources/application.properties
spring.datasource.url= ? # format jdbc:postgresql://{hostname}:{port}/{database-name}
spring.datasource.username= ?
spring.datasource.password= ?
```

## Execution
```
./mvnw spring-boot:run
```

## Running tests
```
edit -> ./src/test/resources/application.properties
spring.datasource.url= ? # format jdbc:postgresql://{hostname}:{port}/{database-name}
spring.datasource.username= ?
spring.datasource.password= ?

# Optional
You have the option of using ./compose-postgres.yaml
cd {project root} && docker-compose -f compose-postgres.yaml up -d;
edit -> ./src/test/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.username=myuser
spring.datasource.password=secret

# Lastly
./mvnw run tests
```

## Running checkstyle
```
find checkstyle exceptions
./mvnw checkstyle:check

create a checkstyle report
./mvnw checkstyle:checkstyle
```

## Deploying test env
```
this will provide a portable environment to run and test the rest interface
with its own portable database that persists data locally under ./database

edit -> ./src/main/resources/application.properties
or
if using env variables to manage application.properties you will need
to pass env vars into the docker container through the compose-test.yaml file.

./docker-compose up -d
```

## Deploying prod env
```
via jar exec

./mvnw -f pom.xml clean package -DskipTests
builds to ./target/*.jar

run via
$JAVA_HOME/bin/java -jar ./target/*.jar
```

```
via docker (recomended)
docker build -t {image-name}:{tag} -f ./Dockerfile .
docker tag {image-name}:{tag} {cr-host}/{container-registry}/{image-name}
docker push {cr-host}/{container-registry}/{image-name}:{tag}

from here deploy as necessary
```

## Documentation
You may want to visit the `{hostname}/swagger-ui/index.html` endpoint, provided by springdoc-openapi to get an understanding of the RESTful interface.
