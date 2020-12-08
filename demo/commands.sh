#!/bin/bash
# Name: commands.sh
# Date: Mon 07 Dec 2020 02:39:40 PM CET
# Version: 0.1.0
# Description: Commands to run when starting container [default: docker-entrypoint.sh]
# Author: Nikolina Tomic

#Build jar file
/usr/bin/mvn -f /home/app/pom.xml clean package

#Run the app
java -jar /home/app/target/demo-0.0.1-SNAPSHOT.jar

