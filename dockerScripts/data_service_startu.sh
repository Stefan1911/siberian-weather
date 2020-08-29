#!/bin/sh
docker run -d --rm --name data_service --network=host soa/data_service