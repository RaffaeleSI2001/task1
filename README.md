# task1

TODO: brief intro

## Build

1. Clone the repo
2. Change directory into `./demo` and run `mvn clean` and `mvn package` (`build.sh` does this)
3. Start the containers with Docker Compose from the IDE or manually (`run.sh` does this)

The `docker-compose.yaml` starts a MySQL container, an optional Adminer DB interface container and
a Tomcat container that takes the `.war` archive.
