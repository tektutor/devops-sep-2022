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
