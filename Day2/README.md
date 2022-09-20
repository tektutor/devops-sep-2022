# Day 2

## Lab - Creating JFrog Artifactory container
```
docker run -d --name artifactory --hostname artifactory -p 8081:8081 docker.bintray.io/jfrog/artifactory-oss:latest
```

Expected output
<pre>
</pre>

## Checking the JFrog Artifactory logs
```
docker logs -f artifactory
```

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
