#!/bin/sh
docker run -d --rm --name analytics_service --network=host soa/analytics_service