FROM amazoncorretto:11
MAINTAINER manage-view-blr@khoros.com

# Push over files
RUN mkdir -p /opt/lithium/approval-service
COPY target/approval-service-* /opt/lithium/approval-service/approval-service.jar
COPY docker/start-docker-app.sh /opt/lithium/approval-service/start-docker-app.sh
COPY docker/application-docker.yml /opt/lithium/approval-service/application-docker.yml
WORKDIR /opt/lithium/approval-service

RUN chmod 755 start-docker-app.sh
RUN mkdir /var/log/approval-service

ENTRYPOINT ./start-docker-app.sh
