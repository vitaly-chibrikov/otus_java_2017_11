#!/usr/bin/env bash

sudo rm /etc/init.d/mongod*
sudo rm /etc/apt/sources.list.d/mongo*
sudo apt-get purge mongodb-org mongodb-org-mongos mongodb-org-server mongodb-org-shell mongodb-org-tools syslog-ng-mod-mongodb
echo "deb http://repo.mongodb.org/apt/debian wheezy/mongodb-org/3.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-3.0.list
sudo apt-get clean
sudo apt-get update
sudo apt-get install mongodb-org

systemctl start mongod
systemctl enable mongod