# micronaut-labmda-example

A sample AWS Lambda Function which returns a list of yummy or not yummy food, depending on your request parameter.

### Prerequisites

* JDK 1.8 or greater installed with JAVA_HOME configured appropriately
* [AWS Account](https://aws.amazon.com/?nc1=h_ls)
* [SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/what-is-sam.html)
* [Micronaut CLI](https://docs.micronaut.io/latest/guide/index.html)

```
$ java -version
  java version "1.8.0_144"
  Java(TM) SE Runtime Environment (build 1.8.0_144-b01)
  Java HotSpot(TM) 64-Bit Server VM (build 25.144-b01, mixed mode)

$ sam --version
  SAM CLI, version 0.21.0
  
$ mn --version
  | Micronaut Version: 1.2.1
  | JVM Version: 1.8.0_144  
```

## Tesiting with SAM CLI

1. Clone this repository.

2. Run these commands.
```
$ cd micronaut-labmda-example

$ gradlew shadowJar

$ sam local invoke "FoodFunction" -e event.json
```

## Built With

* [Micronaut](https://micronaut.io/) - JVM based Framework

## Misc

**Sushi is overrated!**