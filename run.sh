#!/usr/bin/bash
cd demo || exit
./build.sh
sudo docker-compose up -d
