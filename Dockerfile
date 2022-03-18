FROM adoptopenjdk/openjdk11:alpine-slim

WORKDIR /tests

COPY target/build/*.jar /tests
COPY run_tests.sh /tests

ENTRYPOINT ["/bin/bash", "./run_tests.sh"]