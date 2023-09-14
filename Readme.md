# HNG Stage 2 Task by Meysdays
This is the source code showing the tools use to build a CRUD application.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Installation](#installation)
    - [Configuration](#configuration)
- [Deployment](#deployment)
- [Usage & Testing](#usage--testing)
    - [Endpoints](#endpoints)


## Prerequisites

- Java 17 or higher
- Spring boot 3
- PostgreSQL 15 database
- Maven

## Getting Started

Get a copy of this repo by using the git clone command.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/meysdays/hng.git

2. Build the project using Maven:
   ```bash
   mvn clean install

### Configuration
1. All required dependencies are added to the pom.xml file for successful building of the application.
2. The required database connection is also set up in the src/main/resources/application.properties file. You can set up your own database using:
    ```bash
    spring.datasource.url=jdbc:postgresql://your-db-host:your-db-port/your-db-name
    spring.datasource.username=your-db-username
    spring.datasource.password=your-db-password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true

## Deployment
This application was deployed on Render.

## Usage & Testing of Endpoints
Postman was used for testing of this application, which the collection was tested. Check the json file "Stage-two.postman_test_run.json" to see the results.
The published documentation of the expected requests and response can be found in this link: https://documenter.getpostman.com/view/27935491/2s9YC5xXVj

