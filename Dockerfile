FROM registry.Clientes/openjdk11:1.0.1


USER root

RUN mkdir -p /logs/Clientes/

RUN chown -R tqi_mcampos:tqi_mcampos /logs

RUN chown -R tqi_mcampos:tqi_mcampos /application

USER tqi_mcampos

COPY build/libs/*.jar /application

CMD $JAVA_HOME/bin/java -jar -Dspring.profiles.active=qa /application/Clientes
