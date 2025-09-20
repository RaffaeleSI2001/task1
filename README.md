# task1

A basic CRUD webapp that allows CRUD operations on a single table.

## Components

- Java servlets
- Tomcat
- JSP + JSTL
- Hibernate + HQL
- MySQL
- Maven
- Git
- Docker

## Build

1. Clone the repo
2. Change directory into `./demo` and run `build.sh`
3. Start the containers with Docker Compose from the IDE or manually with `run.sh`

To stop the containers, run `stop.sh`

The `docker-compose.yaml` starts a MySQL container, an optional Adminer DB interface container and
a Tomcat container that takes the `.war` archive.
