#!/usr/bin/env bash

rmiregistry &

PROJECT_PATH=$1

# /home/mahoma/unicamp/mc833/mc833-rmi

javac -cp $PROJECT_PATH/src/compute.jar $PROJECT_PATH/src/engine/ComputeEngine.java

java -cp $PROJECT_PATH/src:$PROJECT_PATH/src/compute.jar -Djava.rmi.server.codebase=file:$PROJECT_PATH/src/compute.jar -Djava.rmi.server.hostname=localhost -classpath $PROJECT_PATH/src/ engine.ComputeEngine