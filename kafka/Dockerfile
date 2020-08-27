FROM openjdk:8
#CMD [ "echo", "2" ]

#RUN apt-get update

COPY . /opt/source-code

RUN chmod +x /opt/source-code/docker-start.sh
#CMD [ "ls", "/opt/source-code" ]
ENTRYPOINT [ "/opt/source-code/docker-start.sh" ]