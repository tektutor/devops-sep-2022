# Day 2

## Lab - Creating JFrog Artifactory container
```
docker run -d --name artifactory --hostname artifactory -p 8081:8081 -p 8082:8082 docker.bintray.io/jfrog/artifactory-oss:latest
```

Troubleshooting Permission Denied error
```
sudo usermod -aG docker rps
newgrp docker
```

## Checking the JFrog Artifactory logs
```
docker logs -f artifactory
```

## Accessing JFrog Artifactory from your RPS CentOS Lab Machine ( Use Google Chrome browser )
``` 
http://localhost:8081
```
When promptfor login credentials, use the below
<pre>
username - admin
password - password
</pre>

Once you have logged in, change the password to 'Admin@123' or to your preferred password.


## Creating a Maven repository within JFrog artifactory
1. You need to login to JFrog artifactory
2. Change the password to 'Admin@123' or some pasword that your prefer.
3. You need to create local maven repository with name 'tektutor' as that is the name used in the pom.xml.  If you prefer to name the repository differently, you need to update the distributionManagement tag url accordingly.

## Deploying application artifacts to JFrog artifactory

You need to edit your settings.xml file under the maven install folder/conf directory with the below servers tag

```
<servers>
   <server>
       <id>artifactory</id>
       <username>admin</username>
       <password>Admin@123</password>
   </server>
</servers>
```

In the above server tag, the id string shoul match the id mentioned in the pom.xml.  Feel free to update the password with your JFrog Artifactory password.


```
cd ~/devops-sep-2022
git pull
cd Day2/hello

mvn deploy
```

# Docker

## What is Hypervisor?
- is another way to refer to the virtualization technology
- helps us run many Virtual Machines side by side on the same Desktop/Laptop/Server/Workstation
- Heavy weight Virtualization
  - each Virtual Machines need to be allocated with dedicated hardware resources
      - dedicated CPU Cores
      - dedicated RAM
      - dedicated Storage (HDD/SSD)
- the max number of Guest OS we can run on a Laptop/Desktop/Workstation/Server depends on the System Configuration
    - Primary factor is CPU Cores, RAM and Storage
- Examples
  VMWare
     - VMWare Workstation ( Windows, Linux and Mac ) - Type 2
     - VMWare Fusion ( Mac OS-X ) - Type 2
     - VMWare vSphere - Bare Metal Hypervisor ( Type 1 )
  Type 1 Hypervisor
     - this can be installed directly on a Server without OS
     - meant for Severs/Workstations
  Type 2 Hypervisor
     - this can only be installed on top a an Operating System 
     - The OS on which the Hypervisor is installed is called Host OS
     - The OSs that are deployed on top of Hypervisor are called Virtual Machine(VM) or Guest OS
     - is meant to be used in Laptop/Desktops
   
## What is Docker?
- a light-weight application virtualization technology
- Containers runs a single application
- though container might appear like a OS, they are nothing but application process not an OS
- alternates
   - Podman
   - Containerd
   - LXC
- client/server architecture
- client ( docker )
- server ( dockerd - runs as a background service )

## Hypervisor High-Level Architecture

## Docker High-level Architecture

### Docker Image

### Docker Container

### Docker Registry
- has a collection of many Docker Images
- There are 3 types of Docker Registry
  1. Local Docker Registry ( Its a folder on your system )
  2. Private Docker Registry ( You can setup optionally using JFrog Artifactory or Sonatype Nexus )
  3. Remote Registry - Docker Hub ( website maintained by Docker Inc organization that developed Docker )

# Docker Commands

## Finding docker version installed on your system
```
docker --version
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker --version</b>
Docker version 20.10.18, build b40c2f6
</pre>

## Troubleshooting permission denied error while issuing Docker commands
```
sudo usermod -aG docker rps
newgrp docker
```

## Listing Docker Images on your Local Docker Registry
```
docker images
```

Expected output
<pre>
jegan@tektutor.org ~]$ <b>docker images</b>
REPOSITORY                                TAG       IMAGE ID       CREATED       SIZE
docker.bintray.io/jfrog/artifactory-oss   latest    a205933f31f6   7 weeks ago   1.24GB
</pre>

## Downloading Docker Images from Docker Hub Remote Registry to Docker Local Registry
```
docker pull mysql:latest
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker pull mysql:latest</b>
latest: Pulling from library/mysql
051f419db9dd: Pull complete 
7627573fa82a: Pull complete 
a44b358d7796: Pull complete 
95753aff4b95: Pull complete 
a1fa3bee53f4: Pull complete 
f5227e0d612c: Pull complete 
b4b4368b1983: Pull complete 
f26212810c32: Pull complete 
d803d4215f95: Pull complete 
d5358a7f7d07: Pull complete 
435e8908cd69: Pull complete 
Digest: sha256:b9532b1edea72b6cee12d9f5a78547bd3812ea5db842566e17f8b33291ed2921
Status: Downloaded newer image for mysql:latest
docker.io/library/mysql:latest
[jegan@tektutor.org ~]$ <b>docker images</b>
REPOSITORY                                TAG       IMAGE ID       CREATED       SIZE
mysql                                     latest    43fcfca0776d   5 days ago    449MB
docker.bintray.io/jfrog/artifactory-oss   latest    a205933f31f6   7 weeks ago   1.24GB
</pre>


## Creating your first container
```
docker run hello-world:lates
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker run hello-world:latest</b>
Unable to find image 'hello-world:latest' locally
latest: Pulling from library/hello-world
2db29710123e: Pull complete 
Digest: sha256:62af9efd515a25f84961b70f973a798d2eca956b1b2b026d0a4a63a3b0b6a3f2
Status: Downloaded newer image for hello-world:latest

Hello from Docker!
This message shows that your installation appears to be working correctly.

To generate this message, Docker took the following steps:
 1. The Docker client contacted the Docker daemon.
 2. The Docker daemon pulled the "hello-world" image from the Docker Hub.
    (amd64)
 3. The Docker daemon created a new container from that image which runs the
    executable that produces the output you are currently reading.
 4. The Docker daemon streamed that output to the Docker client, which sent it
    to your terminal.

To try something more ambitious, you can run an Ubuntu container with:
 $ docker run -it ubuntu bash

Share images, automate workflows, and more with a free Docker ID:
 https://hub.docker.com/

For more examples and ideas, visit:
 https://docs.docker.com/get-started/
</pre>


## Listing the currently running containers
```
docker ps
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker ps</b>
CONTAINER ID   IMAGE     COMMAND   CREATED   STATUS    PORTS     NAMES
</pre>

## Listing all containers including the exited containers
```
docker ps -a
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker ps -a</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED         STATUS                        PORTS     NAMES
3cfae5157ace   hello-world:latest                               "/hello"                 2 minutes ago   Exited (0) 2 minutes ago                suspicious_mahavira
00cdebc2c3dd   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   5 hours ago     Exited (137) 28 minutes ago             artifactory
</pre>

## Creating a mysql db server container
```
docker run -d --name mysql --hostname mysql -e MYSQL_ROOT_PASSWORD=root@123 mysql:latest 
```

Expected output
<pre>
jegan@tektutor.org ~]$ <b>docker run -d --name mysql --hostname mysql -e MYSQL_ROOT_PASSWORD=root@123 mysql:latest</b>
e4de9bb5c3a1b9a24e353d733eb565ff9d34792a2537ec243a4841ad5ea8638f
</pre>

## Getting inside the mysql container shell
```
docker exec -it mysql sh
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>docker exec -it mysql sh</b>
sh-4.4# mysql -u root -p
Enter password: 
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 8
Server version: 8.0.30 MySQL Community Server - GPL

Copyright (c) 2000, 2022, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
4 rows in set (0.01 sec)

mysql> CREATE DATABASE tektutor;
Query OK, 1 row affected (0.01 sec)

mysql> USE tektutor;
Database changed
mysql> SHOW TABLES;
Empty set (0.01 sec)

mysql> CREATE TABLE training ( id INT, name VARCHAR(50), duration VARCHAR(50) );
Query OK, 0 rows affected (0.03 sec)

mysql> INSERT INTO training VALUES ( 1, "DevOps", "5 Days" );
Query OK, 1 row affected (0.05 sec)

mysql> INSERT INTO training VALUES ( 2, "Advanced OpenShift", "5 Days" );
Query OK, 1 row affected (0.01 sec)

mysql> SELECT * FROM training;
+------+--------------------+----------+
| id   | name               | duration |
+------+--------------------+----------+
|    1 | DevOps             | 5 Days   |
|    2 | Advanced OpenShift | 5 Days   |
+------+--------------------+----------+
2 rows in set (0.00 sec)

mysql>exit
</pre>
