# Day 3

## Volume mounting - storing data in external storage
```
mkdir -p /tmp/mysql
docker run -d --name mysql --hostname mysql -e MYSQL_ROOT_PASSWORD=root@123 -v /tmp/mysql:/var/lib/mysql mysql:latest
docker exec -it mysql sh
mysql -u root -p
CREATE DATABASE tektutor;
USE tektutor;
CREATE TABLE training ( id INT, name VARCHAR(50), duration VARCHAR(50) );
INSERT INTO training VALUES ( 1, "DevOps", "5 Days" );
SELECT * FROM training;
exit
exit

docker rm -f mysql
docker run -d --name mysql --hostname mysql -e MYSQL_ROOT_PASSWORD=root@123 -v /tmp/mysql:/var/lib/mysql mysql:latest
docker exec -it mysql sh
mysql -u root -p
SHOW DATABASES;
USE tektutor;
SELECT * FROM training;
```
