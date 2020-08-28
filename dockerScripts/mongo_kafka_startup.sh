#!/bin/sh
sudo docker run -d --rm --name mongo_soa --network=host mongo
sudo docker run -d --rm --name kafka_soa --network=host dandolo/kafka_soa