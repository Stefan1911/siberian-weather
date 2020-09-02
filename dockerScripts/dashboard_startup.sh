#!/bin/sh
docker run --rm -d --name dashboard  -p 80:80/tcp dandolo/weatherdashboard:latest