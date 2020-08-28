#!/bin/sh
sudo docker run -d --rm --name mongo_soa --network=host mongo
sudo docker run -d --rm --name kafka_soa --network=host dandolo/kafka_soa
sudo docker run -d --rm --name mongo_express_soa --network=host -e ME_CONFIG_MONGODB_SERVER=localhost -p 8081:8081 mongo-express 