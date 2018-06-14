#!/usr/bin/env bash

PROJECT_PATH=$1

javac -cp $PROJECT_PATH/src:$PROJECT_PATH/src/compute.jar $PROJECT_PATH/src/client/ComputeClient.java

java -cp $PROJECT_PATH/src:$PROJECT_PATH/src/compute.jar -Djava.rmi.server.codebase=file:$PROJECT_PATH/src/client/ -classpath $PROJECT_PATH/src/ client.ComputeClient localhost