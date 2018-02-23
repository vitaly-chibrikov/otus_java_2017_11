#!/usr/bin/env bash

mvn clean package

# linux
cp target/L13.1.3-spring.war ~/apps/jetty/webapps/root.war
# windows
# copy target/L13.1.3-spring.war $JETTY_HOME/webapps/root.war