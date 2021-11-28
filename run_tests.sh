#!/usr/bin/env bash
java \
    -jar sbt-assembly-scalatest-docker-*.jar\
    -o \
    -R sbt-assembly-scalatest-docker-*.jar \
    -m io.sandratskyi.scalatest.example