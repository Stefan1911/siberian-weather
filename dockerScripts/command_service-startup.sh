#!/bin/sh
docker run -d --rm --name command_service --network=host soa/command_service