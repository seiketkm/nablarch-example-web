#!/bin/bash

yes "yes" | redis-cli -h 172.30.19.93 -p 7011 \
    --cluster create \
    172.30.19.93:7011 \
    172.30.19.93:7021 \
    172.30.19.93:7031

redis-cli -h 172.30.19.93 -p 7011 \
 --cluster add-node \
 --cluster-slave 172.30.19.93:7012 172.30.19.93:7011

redis-cli -h 172.30.19.93 -p 7011 \
 --cluster add-node \
 --cluster-slave 172.30.19.93:7022 172.30.19.93:7021

redis-cli -h 172.30.19.93 -p 7011 \
 --cluster add-node \
 --cluster-slave 172.30.19.93:7032 172.30.19.93:7031

