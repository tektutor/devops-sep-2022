# Day 5

## Creating Prometheus container
```
docker run -d --name prometheus --hostname prometheus -p 9090:9090 prom/prometheus:latest
docker ps
```

Expected output
<pre>
[jegan@tektutor.org static-inventory]$ <b>docker run -d --name prometheus --hostname prometheus -p 9090:9090 prom/prometheus:latest</b>
Unable to find image 'prom/prometheus:latest' locally
latest: Pulling from prom/prometheus
50783e0dfb64: Pull complete 
daafb1bca260: Pull complete 
6a18f22881e7: Pull complete 
908edf85c90a: Pull complete 
e78c9da65e59: Pull complete 
e8d6aed2bf27: Pull complete 
7e589198f733: Pull complete 
1412cd7e7ed0: Pull complete 
3ccfb34ae500: Pull complete 
ce0dc444d1d9: Pull complete 
3504a6fc290d: Pull complete 
545a2c134fa7: Pull complete 
Digest: sha256:b591915dad4ee2375fbb24cd019c50a546aae561bc63510516efec70d69b4292
Status: Downloaded newer image for prom/prometheus:latest
a090a9b707699dceda189aa6d508b8adf03823eb0ad28aab19abf805969c7e93
[jegan@tektutor.org static-inventory]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED         STATUS        PORTS                                                                          NAMES
<b>a090a9b70769   prom/prometheus:latest                           "/bin/prometheus --c…"   3 seconds ago   Up 1 second   0.0.0.0:9090->9090/tcp, :::9090->9090/tcp                                      prometheus</b>
7ad30345b12b   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   40 hours ago    Up 17 hours   0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp                  artifactory
a753bfb10625   tektutor/ubuntu-ansible-node:latest              "/usr/sbin/sshd -D"      44 hours ago    Up 16 hours   0.0.0.0:2002->22/tcp, :::2002->22/tcp, 0.0.0.0:8002->80/tcp, :::8002->80/tcp   ubuntu2
1cab14c8bbf7   tektutor/ubuntu-ansible-node:latest              "/usr/sbin/sshd -D"      44 hours ago    Up 16 hours   0.0.0.0:2001->22/tcp, :::2001->22/tcp, 0.0.0.0:8001->80/tcp, :::8001->80/tcp   ubuntu1
</pre>

### Accessing Prometheus dashboard from your CentOS Chrome Web browser
```
http://localhost:9090
```


## Creating Grafana container
```
docker run -d --name=grafana --hostname grafna -p 3000:3000 grafana/grafana:latest
```

Expected output
<pre>
Unable to find image 'grafana/grafana:latest' locally
latest: Pulling from grafana/grafana
9621f1afde84: Pull complete 
e03d6bcc116d: Pull complete 
6b07796a9f54: Pull complete 
6ecc0cc0aece: Pull complete 
fb50528d925c: Pull complete 
d21b325364c1: Pull complete 
27a9431c4f6a: Pull complete 
2de189b678b6: Pull complete 
1c02e278629f: Pull complete 
Digest: sha256:ff68ed4324e471ffa269aa5308cdcf12276ef2d5a660daea95db9d629a32a7d8
Status: Downloaded newer image for grafana/grafana:latest
be3708989217ba724ad59d444d62e159175c88da178121017ad995823040886b

[jegan@tektutor.org static-inventory]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                            COMMAND                  CREATED         STATUS         PORTS                                                                          NAMES
<b>be3708989217   grafana/grafana:latest                           "/run.sh"                2 minutes ago   Up 2 minutes   0.0.0.0:3000->3000/tcp, :::3000->3000/tcp                                      grafana</b>
<b>a090a9b70769   prom/prometheus:latest                           "/bin/prometheus --c…"   5 minutes ago   Up 5 minutes   0.0.0.0:9090->9090/tcp, :::9090->9090/tcp                                      prometheus</b>
7ad30345b12b   docker.bintray.io/jfrog/artifactory-oss:latest   "/entrypoint-artifac…"   40 hours ago    Up 17 hours    0.0.0.0:8081-8082->8081-8082/tcp, :::8081-8082->8081-8082/tcp                  artifactory
a753bfb10625   tektutor/ubuntu-ansible-node:latest              "/usr/sbin/sshd -D"      44 hours ago    Up 16 hours    0.0.0.0:2002->22/tcp, :::2002->22/tcp, 0.0.0.0:8002->80/tcp, :::8002->80/tcp   ubuntu2
1cab14c8bbf7   tektutor/ubuntu-ansible-node:latest              "/usr/sbin/sshd -D"      44 hours ago    Up 16 hours    0.0.0.0:2001->22/tcp, :::2001->22/tcp, 0.0.0.0:8001->80/tcp, :::8001->80/tcp   ubuntu1
</pre>

### Accessing Grafana dashboard from your CentOS Chrome Web browser
```
http://localhost:3000
```

