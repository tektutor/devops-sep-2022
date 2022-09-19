# Day 1

## Git Commands


### Creating a new git repository locally
```
cd ~
mkdir test
cd test
git init
```

### Git config username and email
```
cd ~
cd test
git config user.name "Jeganathan Swaminathan"
git config user.email "mail2jegan@gmail.com"
```

### Listing the git configurations 
```
cd ~/test
git config --list
```

### Finding the current active branch
```
cd ~/test
git branch
```

### Creating a dev branch from master branch and switching to it
```
cd ~/test
git checkout -b dev
```

### Switching to a particular branch
```
cd ~/test
git checkout master
git checkout dev
```

### Staging changes ( updated a file, deleted a folder/file, added a new file, etc )
```
cd ~/test
git add *
git add <file-1> <file-2>
```

### Merging changes from dev to master branch
```
cd ~/test
git checkout master
git merge dev
git add *
git commit -m "Resolved merge conflicts."
```

### Clone a GitHub repo to local
```
cd ~
git clone https://github.com/devops-sep-2022.git
cd devops-sep-2022
tree 
```

### Finding the remote repository url
```
cd ~
git remote -v
```

### Pulling the delta changes from GitHub to local after cloning
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

## Cloning TekTutor GitHub repository for this training
```
cd ~
git clone https://github.com/tektutor/devops-sep-2022.git
cd devops-sep-2022
```

## Pulling delta changes from TekTutor GitHub Repository to local repo
```
cd ~/devops-sep-2022
git pull
```

## Compiling your first maven project
```
cd ~/devops-sep-2022
git pull
cd Day1/hello
mvn compile
```

Expected output
<pre>
</pre>
