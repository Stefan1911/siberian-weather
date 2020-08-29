#!/bin/sh
docker run -d --rm --name gateway_service --network=host soa/gateway_service