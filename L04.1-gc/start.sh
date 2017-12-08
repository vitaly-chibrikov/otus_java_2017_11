#!/usr/bin/env bash

REMOTE_DEBUG="-agentlib:jdwp=transport=dt_socket,address=14025,server=y,suspend=n"
MEMORY="-Xms512m -Xmx512m -XX:MaxMetaspaceSize=256m"
GC="-XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:+ScavengeBeforeFullGC -XX:+CMSScavengeBeforeRemark -XX:+UseParNewGC"
GC_LOG=" -verbose:gc -Xloggc:./logs/gc_pid_%p.log -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"
JMX="-Dcom.sun.management.jmxremote.port=15025 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"
DUMP="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=./dumps/"

#-XX:OnOutOfMemoryError="kill -3 %p"

java $REMOTE_DEBUG $MEMORY $GC $GC_LOG $JMX $DUMP -jar target/L04.1-gc.jar > jvm.out
