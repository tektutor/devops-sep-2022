# devops-sep-2022

## Installing git locally
```
sudo yum install -y git
```

## Installing Open JDK 11
```
sudo yum install -y epel-release
sudo yum install java-11-openjdk-devel -y
```

## Installing maven
```
sudo yum install -y maven
```

## Java Build Tools
- Apache Ant
    - doesn't support dependency management
    - doesn't enforce any standards
- Apache Maven

- Gradle

## What is Maven?
- is an opensource build tool from Apache Foundation
- Convention over Configuration
- supports dependency management


## Maven Convention over Configuration
- 80-20 Priniciple
- the most common use cases should easy 
  - compiling a stand-alone java application or a web application
- advanced scenearios should be possible
  For example - compiling a C++ project using Maven
  
## Maven co-ordinates
- supports 3 co-ordinates
  - groupId ( it is a string that refers to your organization reverse domain name - helps in avoid name collision)
  - artifactId - optionally has multiple words separated by . ( represents the name of the jar/war/ear/zip/exe, etc )
  - version
      x.y.z
      x - major
      y - minor
      z - incremental version
 - tektutor.org is my startup's domanin name, hence groupId in my case would be org.tektutor
 - tektutor-helloword-app - this would be application bin name ( jar/war/ear/zip/exe )
 - version - 1.0.0

## 
