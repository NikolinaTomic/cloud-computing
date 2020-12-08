FROM openjdk:11
LABEL maintainer="Nikolina Tomic"
LABEL description="Docker image for building and running Java Spring App using Java 11"
# Install Maven
RUN apt-get update -y && apt-get install -y curl tar
ARG MAVEN_VERSION=3.3.9
ARG USER_HOME_DIR="/root"
RUN mkdir -p /usr/share/maven && \
curl -fsSL http://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz | tar -xzC /usr/share/maven --strip-components=1 && \
ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
# speed up Maven JVM a bit
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
COPY commands.sh /home/app/scripts/commands.sh

RUN ["chmod", "+x", "/home/app/scripts/commands.sh"]
ENTRYPOINT ["/home/app/scripts/commands.sh"]
