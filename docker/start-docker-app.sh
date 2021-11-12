#!/usr/bin/env bash
set -eu


mv application-docker.yml application.yml
# setting variables
DROPWIZARD_START_TASK=${DROPWIZARD_START_TASK:-server}
JVM_MEMORY_MAX=${JVM_MEMORY_MAX:-4G}
JVM_MEMORY_MIN=${JVM_MEMORY_MIN:-512m}
JVM_OPTS="-Xms${JVM_MEMORY_MIN} -Xmx${JVM_MEMORY_MAX}"

echo "Starting approval-service"
exec java ${JVM_OPTS} -jar approval-service.jar ${DROPWIZARD_START_TASK} application.yml