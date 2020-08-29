#!/bin/sh
docker run -d --rm --name temperature_device --network=host --env collector_type=TEMPERATURE --env service_port=1910 dandolo/device_service
docker run -d --rm --name wind_device --network=host --env collector_type=WIND --env service_port=1911 dandolo/device_service