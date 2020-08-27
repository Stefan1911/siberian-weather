#!/bin/sh
/opt/source-code/bin/zookeeper-server-start.sh /opt/source-code/config/zookeeper.properties &
/opt/source-code/bin/kafka-server-start.sh /opt/source-code/config/server.properties
# export TERM=xterm
# echo hello!
# top