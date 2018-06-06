#!/bin/bash

docker pull mysql/mysql-server

docker run --name=simoncat_taobao_mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=simoncat_test -e MYSQL_USER=simoncat -e MYSQL_PASSWORD=root -e MYSQL_ROOT_HOST=% -p 3306:3306 -d mysql/mysql-server 

# docker logs mysql1
# shell> docker logs mysql1 2>&1 | grep GENERATED
# GENERATED ROOT PASSWORD: Axegh3kAJyDLaRuBemecis&EShOs
# docker exec -it mysql1 mysql -uroot -p
# mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'newpassword';

docker exec -it simoncat_taobao_mysql mysql -usimoncat -proot