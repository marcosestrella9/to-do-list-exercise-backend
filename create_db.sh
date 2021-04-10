#!/bin/bash


mysql -u root -p <<MYSQL_SCRIPT
CREATE DATABASE todo;
MYSQL_SCRIPT

echo "TABLE created."
