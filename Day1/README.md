# Day 1

## Git Commands


### ⛹️‍♂️ Lab - Creating a new git repository locally
```
cd ~
mkdir test
cd test
git init
```

### ⛹️‍♂️ Lab - Git config username and email
```
cd ~
cd test
git config user.name "Jeganathan Swaminathan"
git config user.email "mail2jegan@gmail.com"
```

### ⛹️‍♂️ Lab - Listing the git configurations 
```
cd ~/test
git config --list
```

### ⛹️‍♂️ Lab - Finding the current active branch
```
cd ~/test
git branch
```

### ⛹️‍♂️ Lab -  Creating a dev branch from master branch and switching to it
```
cd ~/test
git checkout -b dev
```

### ⛹️‍♂️ Lab -  Switching to a particular branch
```
cd ~/test
git checkout master
git checkout dev
```

### ⛹️‍♂️ Lab -  Staging changes ( updated a file, deleted a folder/file, added a new file, etc )
```
cd ~/test
git add *
git add <file-1> <file-2>
```

### ⛹️‍♂️ Lab -  Merging changes from dev to master branch
```
cd ~/test
git checkout master
git merge dev
git add *
git commit -m "Resolved merge conflicts."
```

### ⛹️‍♂️ Lab -  Clone a GitHub repo to local
```
cd ~
git clone https://github.com/tektutor/devops-sep-2022.git
cd devops-sep-2022
tree 
```

### ⛹️‍♂️ Lab -  Finding the remote repository url
```
cd ~
git remote -v
```

### ⛹️‍♂️ Lab -  Pulling the delta changes from GitHub to local after cloning
```
cd ~
git pull
```

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

## Maven Dependencies
- These are the third-party libraries your project depends on

## Maven Plugins

## Maven Repositories

- has all opensource libraries

- Local Repository
- Private Repository
- Central/Remote Repository

## ⛹️‍♂️ Lab -  Cloning TekTutor GitHub repository for this training
```
cd ~
git clone https://github.com/tektutor/devops-sep-2022.git
cd devops-sep-2022
```

## ⛹️‍♂️ Lab -  Pulling delta changes from TekTutor GitHub Repository to local repo
```
cd ~/devops-sep-2022
git pull
```

## ⛹️‍♂️ Lab -  Compiling your first maven project
```
cd ~/devops-sep-2022
git pull
cd Day1/hello
mvn compile
```

Expected output
<pre>
[jegan@tektutor.org hello]$ <b>mvn compile</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< org.tektutor:tektutor-helloworld-app >----------------
[INFO] Building tektutor-helloworld-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ tektutor-helloworld-app ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/jegan/devops-sep-2022/Day1/hello/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ tektutor-helloworld-app ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jegan/devops-sep-2022/Day1/hello/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.955 s
[INFO] Finished at: 2022-09-19T02:51:01-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## ⛹️‍♂️ Lab -  Printing the effective pom of your hello world project
```
cd ~/devops-sep-2022
git pull

cd Day1/hello
mvn help:effective-pom
```

Expected output
```
[jegan@tektutor.org hello]$<b>mvn help:effective-pom</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< org.tektutor:tektutor-helloworld-app >----------------
[INFO] Building tektutor-helloworld-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.3.0:effective-pom (default-cli) @ tektutor-helloworld-app ---
[INFO] 
Effective POMs, after inheritance, interpolation, and profiles are applied:

<?xml version="1.0" encoding="UTF-8"?>
<!-- ====================================================================== -->
<!--                                                                        -->
<!-- Generated by Maven Help Plugin                                         -->
<!-- See: https://maven.apache.org/plugins/maven-help-plugin/               -->
<!--                                                                        -->
<!-- ====================================================================== -->
<!-- ====================================================================== -->
<!--                                                                        -->
<!-- Effective POM for project                                              -->
<!-- 'org.tektutor:tektutor-helloworld-app:jar:1.0.0'                       -->
<!--                                                                        -->
<!-- ====================================================================== -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>org.tektutor</groupId>
  <artifactId>tektutor-helloworld-app</artifactId>
  <version>1.0.0</version>
  <properties>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
  <repositories>
    <repository>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <id>central</id>
      <name>Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
    </repository>
  </repositories>
  <pluginRepositories>
    <pluginRepository>
      <releases>
        <updatePolicy>never</updatePolicy>
      </releases>
      <snapshots>
        <enabled>false</enabled>
      </snapshots>
      <id>central</id>
      <name>Central Repository</name>
      <url>https://repo.maven.apache.org/maven2</url>
    </pluginRepository>
  </pluginRepositories>
  <build>
    <sourceDirectory>/home/jegan/devops-sep-2022/Day1/hello/src/main/java</sourceDirectory>
    <scriptSourceDirectory>/home/jegan/devops-sep-2022/Day1/hello/src/main/scripts</scriptSourceDirectory>
    <testSourceDirectory>/home/jegan/devops-sep-2022/Day1/hello/src/test/java</testSourceDirectory>
    <outputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/classes</outputDirectory>
    <testOutputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/test-classes</testOutputDirectory>
    <resources>
      <resource>
        <directory>/home/jegan/devops-sep-2022/Day1/hello/src/main/resources</directory>
      </resource>
    </resources>
    <testResources>
      <testResource>
        <directory>/home/jegan/devops-sep-2022/Day1/hello/src/test/resources</directory>
      </testResource>
    </testResources>
    <directory>/home/jegan/devops-sep-2022/Day1/hello/target</directory>
    <finalName>tektutor-helloworld-app-1.0.0</finalName>
    <pluginManagement>
      <plugins>
        <plugin>
          <artifactId>maven-antrun-plugin</artifactId>
          <version>1.3</version>
        </plugin>
        <plugin>
          <artifactId>maven-assembly-plugin</artifactId>
          <version>2.2-beta-5</version>
        </plugin>
        <plugin>
          <artifactId>maven-dependency-plugin</artifactId>
          <version>2.8</version>
        </plugin>
        <plugin>
          <artifactId>maven-release-plugin</artifactId>
          <version>2.5.3</version>
        </plugin>
      </plugins>
    </pluginManagement>
    <plugins>
      <plugin>
        <artifactId>maven-clean-plugin</artifactId>
        <version>2.5</version>
        <executions>
          <execution>
            <id>default-clean</id>
            <phase>clean</phase>
            <goals>
              <goal>clean</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-resources-plugin</artifactId>
        <version>2.6</version>
        <executions>
          <execution>
            <id>default-testResources</id>
            <phase>process-test-resources</phase>
            <goals>
              <goal>testResources</goal>
            </goals>
          </execution>
          <execution>
            <id>default-resources</id>
            <phase>process-resources</phase>
            <goals>
              <goal>resources</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-jar-plugin</artifactId>
        <version>2.4</version>
        <executions>
          <execution>
            <id>default-jar</id>
            <phase>package</phase>
            <goals>
              <goal>jar</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.1</version>
        <executions>
          <execution>
            <id>default-compile</id>
            <phase>compile</phase>
            <goals>
              <goal>compile</goal>
            </goals>
          </execution>
          <execution>
            <id>default-testCompile</id>
            <phase>test-compile</phase>
            <goals>
              <goal>testCompile</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>2.12.4</version>
        <executions>
          <execution>
            <id>default-test</id>
            <phase>test</phase>
            <goals>
              <goal>test</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-install-plugin</artifactId>
        <version>2.4</version>
        <executions>
          <execution>
            <id>default-install</id>
            <phase>install</phase>
            <goals>
              <goal>install</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-deploy-plugin</artifactId>
        <version>2.7</version>
        <executions>
          <execution>
            <id>default-deploy</id>
            <phase>deploy</phase>
            <goals>
              <goal>deploy</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-site-plugin</artifactId>
        <version>3.3</version>
        <executions>
          <execution>
            <id>default-site</id>
            <phase>site</phase>
            <goals>
              <goal>site</goal>
            </goals>
            <configuration>
              <outputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/site</outputDirectory>
              <reportPlugins>
                <reportPlugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-project-info-reports-plugin</artifactId>
                </reportPlugin>
              </reportPlugins>
            </configuration>
          </execution>
          <execution>
            <id>default-deploy</id>
            <phase>site-deploy</phase>
            <goals>
              <goal>deploy</goal>
            </goals>
            <configuration>
              <outputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/site</outputDirectory>
              <reportPlugins>
                <reportPlugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-project-info-reports-plugin</artifactId>
                </reportPlugin>
              </reportPlugins>
            </configuration>
          </execution>
        </executions>
        <configuration>
          <outputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/site</outputDirectory>
          <reportPlugins>
            <reportPlugin>
              <groupId>org.apache.maven.plugins</groupId>
              <artifactId>maven-project-info-reports-plugin</artifactId>
            </reportPlugin>
          </reportPlugins>
        </configuration>
      </plugin>
    </plugins>
  </build>
  <reporting>
    <outputDirectory>/home/jegan/devops-sep-2022/Day1/hello/target/site</outputDirectory>
  </reporting>
</project>


[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.738 s
[INFO] Finished at: 2022-09-19T02:53:25-07:00
[INFO] ------------------------------------------------------------------------
```

## ⛹️‍♂️ Lab -  Using archetype plugin to create a Java web application in interactive mode
```
mvn archetype:generate
```

## ⛹️‍♂️ Lab -  Using archetype plugin to create a Java web application in batch mode
```
mvn archetype:generate -DgroupId=org.tektutor -DartifactId=tektutor-web-app -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-webapp
-DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeVersion=1.4 -DinteractiveMode=false
```

Expected output
<pre>
[jegan@tektutor.org Day1]$ <b>mvn archetype:generate -DgroupId=org.tektutor -DartifactId=tektutor-web-p -Dversion=1.0.0 -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeVersion=1.4 -DinteractiveMode=false</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.2.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.2.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] 
[INFO] --- maven-archetype-plugin:3.2.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Batch mode
[INFO] Archetype repository not defined. Using the one from [org.apache.maven.archetypes:maven-archetype-webapp:1.4] found in catalog remote
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: maven-archetype-webapp:1.4
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: org.tektutor
[INFO] Parameter: artifactId, Value: tektutor-web-app
[INFO] Parameter: version, Value: 1.0.0
[INFO] Parameter: package, Value: org.tektutor
[INFO] Parameter: packageInPathFormat, Value: org/tektutor
[INFO] Parameter: package, Value: org.tektutor
[INFO] Parameter: version, Value: 1.0.0
[INFO] Parameter: groupId, Value: org.tektutor
[INFO] Parameter: artifactId, Value: tektutor-web-app
[INFO] Project created from Archetype in dir: /home/jegan/devops-sep-2022/Day1/tektutor-web-app
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.156 s
[INFO] Finished at: 2022-09-19T03:33:35-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## Maven Lifecycle
- is a chain commands invoked from top to bottom in the sequence the phases appear in a lifecycle

- Maven supports 3 Lifecycles
  1. default
  2. clean
  3. site

## Printing the default life-cycle phases
```
mvn help:describe -Dcmd=compile
```

Expected output
<pre>
[jegan@tektutor.org hello]$ <b>mvn help:describe -Dcmd=compile</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< org.tektutor:tektutor-helloworld-app >----------------
[INFO] Building tektutor-helloworld-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.3.0:describe (default-cli) @ tektutor-helloworld-app ---
[INFO] 'compile' is a phase corresponding to this plugin:
org.apache.maven.plugins:maven-compiler-plugin:3.1:compile

It is a part of the lifecycle for the POM packaging 'jar'. This lifecycle includes the following phases:
* validate: Not defined
* initialize: Not defined
* generate-sources: Not defined
* process-sources: Not defined
* generate-resources: Not defined
* process-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:resources
* compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:compile
* process-classes: Not defined
* generate-test-sources: Not defined
* process-test-sources: Not defined
* generate-test-resources: Not defined
* process-test-resources: org.apache.maven.plugins:maven-resources-plugin:2.6:testResources
* test-compile: org.apache.maven.plugins:maven-compiler-plugin:3.1:testCompile
* process-test-classes: Not defined
* test: org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test
* prepare-package: Not defined
* package: org.apache.maven.plugins:maven-jar-plugin:2.4:jar
* pre-integration-test: Not defined
* integration-test: Not defined
* post-integration-test: Not defined
* verify: Not defined
* install: org.apache.maven.plugins:maven-install-plugin:2.4:install
* deploy: org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.619 s
[INFO] Finished at: 2022-09-19T04:26:03-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## Printing clean life-cycle phases
```
mvn help:describe -Dcmd=clean
```

Expected output
<pre>
[jegan@tektutor.org hello]$ <b>mvn help:describe -Dcmd=clean</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< org.tektutor:tektutor-helloworld-app >----------------
[INFO] Building tektutor-helloworld-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.3.0:describe (default-cli) @ tektutor-helloworld-app ---
[INFO] 'clean' is a phase within the 'clean' lifecycle, which has the following phases: 
* pre-clean: Not defined
* clean: org.apache.maven.plugins:maven-clean-plugin:2.5:clean
* post-clean: Not defined

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.690 s
[INFO] Finished at: 2022-09-19T04:31:24-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## Printing site lifecycle phases
```
mvn help:describe -Dcmd=site
```

Expected output
<pre>
[jegan@tektutor.org hello]$ <b>mvn help:describe -Dcmd=site</b>
[INFO] Scanning for projects...
[INFO] 
[INFO] ----------------< org.tektutor:tektutor-helloworld-app >----------------
[INFO] Building tektutor-helloworld-app 1.0.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-help-plugin:3.3.0:describe (default-cli) @ tektutor-helloworld-app ---
[INFO] 'site' is a phase within the 'site' lifecycle, which has the following phases: 
* pre-site: Not defined
* site: org.apache.maven.plugins:maven-site-plugin:3.3:site
* post-site: Not defined
* site-deploy: org.apache.maven.plugins:maven-site-plugin:3.3:deploy

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.618 s
[INFO] Finished at: 2022-09-19T04:32:53-07:00
[INFO] ------------------------------------------------------------------------
</pre>

## Creating a custom maven plugin
```
```
