#! /bin/bash
app_path=$(cd `dirname $0`; cd ..; pwd)
nohup java -jar ${app_path}/garden-restaurant-0.0.1-SNAPSHOT.jar &