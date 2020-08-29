#!/bin/sh
docker run -d --rm --name command_service --network=host dandolo/command_service