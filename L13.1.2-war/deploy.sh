#!/usr/bin/env bash

mvn clean package

# linux
cp target/L13.1.2-war.war ~/apps/jetty/webapps/root.war

# windows
# copy target/L13.1.3-war.war $JETTY_HOME/webapps/root.war
