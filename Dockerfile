FROM adoptopenjdk/openjdk11

WORKDIR /tests

COPY target/build/*.jar /tests
COPY run_tests.sh /tests

ENTRYPOINT ["/bin/bash", "./run_tests.sh"]