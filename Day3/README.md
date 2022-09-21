# Day 3

## ⛹️‍♂️ Lab - Volume mounting - storing data in external storage
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
## Generating key pair
```
ssh-keygen
```
When it prompts for file name paths, passphrase just hit enter to accept the defaults.


## Building custom docker image to use it as an Ansible node

Copy your public key into the Day3/AnsibleUbuntuCustomDockerImage folder
```
cd ~/devops-sep-2022
git pull
cd Day3/AnsibleUbuntuCustomDockerImage
cp /home/jegan/.ssh/id_rsa.pub authorized_keys
```

Now you may proceed witht the docker custom image build procedure
```
cd ~/devops-sep-2022
git pull

cd Day3/AnsibleUbuntuCustomDockerImage
docker build -t tektutor/ubuntu-ansible-node:latest .
```

Expected output
<pre>
[jegan@tektutor.org AnsibleUbuntuCustomDockerImage]$ <b>docker build -t tektutor/ubuntu-ansible-node:latest .</b>
Sending build context to Docker daemon  3.584kB
Step 1/12 : FROM ubuntu:16.04
 ---> b6f507652425
Step 2/12 : MAINTAINER Jeganathan Swaminathan <jegan@tektutor.org>
 ---> Running in ecd543c1f217
Removing intermediate container ecd543c1f217
 ---> a25a02c64eae
Step 3/12 : RUN apt-get update && apt-get install -y openssh-server python3
 ---> Running in 171da3ccf837
Get:1 http://security.ubuntu.com/ubuntu xenial-security InRelease [99.8 kB]
Get:2 http://archive.ubuntu.com/ubuntu xenial InRelease [247 kB]
Get:3 http://security.ubuntu.com/ubuntu xenial-security/main amd64 Packages [2051 kB]
Get:4 http://archive.ubuntu.com/ubuntu xenial-updates InRelease [99.8 kB]
Get:5 http://archive.ubuntu.com/ubuntu xenial-backports InRelease [97.4 kB]
Get:6 http://archive.ubuntu.com/ubuntu xenial/main amd64 Packages [1558 kB]
Get:7 http://security.ubuntu.com/ubuntu xenial-security/restricted amd64 Packages [15.9 kB]
Get:8 http://security.ubuntu.com/ubuntu xenial-security/universe amd64 Packages [984 kB]
Get:9 http://security.ubuntu.com/ubuntu xenial-security/multiverse amd64 Packages [8820 B]
Get:10 http://archive.ubuntu.com/ubuntu xenial/restricted amd64 Packages [14.1 kB]
Get:11 http://archive.ubuntu.com/ubuntu xenial/universe amd64 Packages [9827 kB]
Get:12 http://archive.ubuntu.com/ubuntu xenial/multiverse amd64 Packages [176 kB]
Get:13 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 Packages [2560 kB]
Get:14 http://archive.ubuntu.com/ubuntu xenial-updates/restricted amd64 Packages [16.4 kB]
Get:15 http://archive.ubuntu.com/ubuntu xenial-updates/universe amd64 Packages [1544 kB]
Get:16 http://archive.ubuntu.com/ubuntu xenial-updates/multiverse amd64 Packages [26.2 kB]
Get:17 http://archive.ubuntu.com/ubuntu xenial-backports/main amd64 Packages [10.9 kB]
Get:18 http://archive.ubuntu.com/ubuntu xenial-backports/universe amd64 Packages [12.7 kB]
Fetched 19.3 MB in 5s (3683 kB/s)
Reading package lists...
Reading package lists...
Building dependency tree...
Reading state information...
The following additional packages will be installed:
  ca-certificates dh-python file krb5-locales libbsd0 libedit2 libexpat1
  libgssapi-krb5-2 libidn11 libk5crypto3 libkeyutils1 libkrb5-3
  libkrb5support0 libmagic1 libmpdec2 libpython3-stdlib libpython3.5-minimal
  libpython3.5-stdlib libsqlite3-0 libssl1.0.0 libwrap0 libx11-6 libx11-data
  libxau6 libxcb1 libxdmcp6 libxext6 libxmuu1 mime-support ncurses-term
  openssh-client openssh-sftp-server openssl python3-chardet python3-minimal
  python3-pkg-resources python3-requests python3-six python3-urllib3 python3.5
  python3.5-minimal ssh-import-id tcpd wget xauth
Suggested packages:
  libdpkg-perl krb5-doc krb5-user ssh-askpass libpam-ssh keychain monkeysphere
  rssh molly-guard ufw python3-doc python3-tk python3-venv python3-setuptools
  python3-ndg-httpsclient python3-openssl python3-pyasn1 python3.5-venv
  python3.5-doc binutils binfmt-support
The following NEW packages will be installed:
  ca-certificates dh-python file krb5-locales libbsd0 libedit2 libexpat1
  libgssapi-krb5-2 libidn11 libk5crypto3 libkeyutils1 libkrb5-3
  libkrb5support0 libmagic1 libmpdec2 libpython3-stdlib libpython3.5-minimal
  libpython3.5-stdlib libsqlite3-0 libssl1.0.0 libwrap0 libx11-6 libx11-data
  libxau6 libxcb1 libxdmcp6 libxext6 libxmuu1 mime-support ncurses-term
  openssh-client openssh-server openssh-sftp-server openssl python3
  python3-chardet python3-minimal python3-pkg-resources python3-requests
  python3-six python3-urllib3 python3.5 python3.5-minimal ssh-import-id tcpd
  wget xauth
0 upgraded, 47 newly installed, 0 to remove and 0 not upgraded.
Need to get 10.5 MB of archives.
After this operation, 55.0 MB of additional disk space will be used.
Get:1 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libssl1.0.0 amd64 1.0.2g-1ubuntu4.20 [1083 kB]
Get:2 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libpython3.5-minimal amd64 3.5.2-2ubuntu0~16.04.13 [524 kB]
Get:3 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libexpat1 amd64 2.1.0-7ubuntu0.16.04.5 [71.5 kB]
Get:4 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3.5-minimal amd64 3.5.2-2ubuntu0~16.04.13 [1597 kB]
Get:5 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-minimal amd64 3.5.1-3 [23.3 kB]
Get:6 http://archive.ubuntu.com/ubuntu xenial/main amd64 mime-support all 3.59ubuntu1 [31.0 kB]
Get:7 http://archive.ubuntu.com/ubuntu xenial/main amd64 libmpdec2 amd64 2.4.2-1 [82.6 kB]
Get:8 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libsqlite3-0 amd64 3.11.0-1ubuntu1.5 [398 kB]
Get:9 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libpython3.5-stdlib amd64 3.5.2-2ubuntu0~16.04.13 [2135 kB]
Get:10 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3.5 amd64 3.5.2-2ubuntu0~16.04.13 [165 kB]
Get:11 http://archive.ubuntu.com/ubuntu xenial/main amd64 libpython3-stdlib amd64 3.5.1-3 [6818 B]
Get:12 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 dh-python all 2.20151103ubuntu1.2 [73.9 kB]
Get:13 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3 amd64 3.5.1-3 [8710 B]
Get:14 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxau6 amd64 1:1.0.8-1 [8376 B]
Get:15 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxdmcp6 amd64 1:1.1.2-1.1 [11.0 kB]
Get:16 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxcb1 amd64 1.11.1-1ubuntu1 [40.0 kB]
Get:17 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libx11-data all 2:1.6.3-1ubuntu2.2 [114 kB]
Get:18 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libx11-6 amd64 2:1.6.3-1ubuntu2.2 [572 kB]
Get:19 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxext6 amd64 2:1.3.3-1 [29.4 kB]
Get:20 http://archive.ubuntu.com/ubuntu xenial/main amd64 libwrap0 amd64 7.6.q-25 [46.2 kB]
Get:21 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libmagic1 amd64 1:5.25-2ubuntu1.4 [216 kB]
Get:22 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 file amd64 1:5.25-2ubuntu1.4 [21.2 kB]
Get:23 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libbsd0 amd64 0.8.2-1ubuntu0.1 [42.0 kB]
Get:24 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libidn11 amd64 1.32-3ubuntu1.2 [46.5 kB]
Get:25 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssl amd64 1.0.2g-1ubuntu4.20 [492 kB]
Get:26 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 ca-certificates all 20210119~16.04.1 [148 kB]
Get:27 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 krb5-locales all 1.13.2+dfsg-5ubuntu2.2 [13.7 kB]
Get:28 http://archive.ubuntu.com/ubuntu xenial/main amd64 libedit2 amd64 3.1-20150325-1ubuntu2 [76.5 kB]
Get:29 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libkrb5support0 amd64 1.13.2+dfsg-5ubuntu2.2 [31.2 kB]
Get:30 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libk5crypto3 amd64 1.13.2+dfsg-5ubuntu2.2 [81.2 kB]
Get:31 http://archive.ubuntu.com/ubuntu xenial/main amd64 libkeyutils1 amd64 1.5.9-8ubuntu1 [9904 B]
Get:32 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libkrb5-3 amd64 1.13.2+dfsg-5ubuntu2.2 [273 kB]
Get:33 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 libgssapi-krb5-2 amd64 1.13.2+dfsg-5ubuntu2.2 [120 kB]
Get:34 http://archive.ubuntu.com/ubuntu xenial/main amd64 libxmuu1 amd64 2:1.1.2-2 [9674 B]
Get:35 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-client amd64 1:7.2p2-4ubuntu2.10 [590 kB]
Get:36 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 wget amd64 1.17.1-1ubuntu1.5 [299 kB]
Get:37 http://archive.ubuntu.com/ubuntu xenial/main amd64 xauth amd64 1:1.0.9-1ubuntu2 [22.7 kB]
Get:38 http://archive.ubuntu.com/ubuntu xenial/main amd64 ncurses-term all 6.0+20160213-1ubuntu1 [249 kB]
Get:39 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-sftp-server amd64 1:7.2p2-4ubuntu2.10 [38.8 kB]
Get:40 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 openssh-server amd64 1:7.2p2-4ubuntu2.10 [335 kB]
Get:41 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-pkg-resources all 20.7.0-1 [79.0 kB]
Get:42 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-chardet all 2.3.0-2 [96.2 kB]
Get:43 http://archive.ubuntu.com/ubuntu xenial/main amd64 python3-six all 1.10.0-3 [11.0 kB]
Get:44 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3-urllib3 all 1.13.1-2ubuntu0.16.04.4 [58.6 kB]
Get:45 http://archive.ubuntu.com/ubuntu xenial-updates/main amd64 python3-requests all 2.9.1-3ubuntu0.1 [55.8 kB]
Get:46 http://archive.ubuntu.com/ubuntu xenial/main amd64 tcpd amd64 7.6.q-25 [23.0 kB]
Get:47 http://archive.ubuntu.com/ubuntu xenial/main amd64 ssh-import-id all 5.5-0ubuntu1 [10.2 kB]
debconf: delaying package configuration, since apt-utils is not installed
Fetched 10.5 MB in 4s (2488 kB/s)
Selecting previously unselected package libssl1.0.0:amd64.
(Reading database ... 4785 files and directories currently installed.)
Preparing to unpack .../libssl1.0.0_1.0.2g-1ubuntu4.20_amd64.deb ...
Unpacking libssl1.0.0:amd64 (1.0.2g-1ubuntu4.20) ...
Selecting previously unselected package libpython3.5-minimal:amd64.
Preparing to unpack .../libpython3.5-minimal_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking libpython3.5-minimal:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package libexpat1:amd64.
Preparing to unpack .../libexpat1_2.1.0-7ubuntu0.16.04.5_amd64.deb ...
Unpacking libexpat1:amd64 (2.1.0-7ubuntu0.16.04.5) ...
Selecting previously unselected package python3.5-minimal.
Preparing to unpack .../python3.5-minimal_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking python3.5-minimal (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package python3-minimal.
Preparing to unpack .../python3-minimal_3.5.1-3_amd64.deb ...
Unpacking python3-minimal (3.5.1-3) ...
Selecting previously unselected package mime-support.
Preparing to unpack .../mime-support_3.59ubuntu1_all.deb ...
Unpacking mime-support (3.59ubuntu1) ...
Selecting previously unselected package libmpdec2:amd64.
Preparing to unpack .../libmpdec2_2.4.2-1_amd64.deb ...
Unpacking libmpdec2:amd64 (2.4.2-1) ...
Selecting previously unselected package libsqlite3-0:amd64.
Preparing to unpack .../libsqlite3-0_3.11.0-1ubuntu1.5_amd64.deb ...
Unpacking libsqlite3-0:amd64 (3.11.0-1ubuntu1.5) ...
Selecting previously unselected package libpython3.5-stdlib:amd64.
Preparing to unpack .../libpython3.5-stdlib_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking libpython3.5-stdlib:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package python3.5.
Preparing to unpack .../python3.5_3.5.2-2ubuntu0~16.04.13_amd64.deb ...
Unpacking python3.5 (3.5.2-2ubuntu0~16.04.13) ...
Selecting previously unselected package libpython3-stdlib:amd64.
Preparing to unpack .../libpython3-stdlib_3.5.1-3_amd64.deb ...
Unpacking libpython3-stdlib:amd64 (3.5.1-3) ...
Selecting previously unselected package dh-python.
Preparing to unpack .../dh-python_2.20151103ubuntu1.2_all.deb ...
Unpacking dh-python (2.20151103ubuntu1.2) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Setting up libssl1.0.0:amd64 (1.0.2g-1ubuntu4.20) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Setting up libpython3.5-minimal:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Setting up libexpat1:amd64 (2.1.0-7ubuntu0.16.04.5) ...
Setting up python3.5-minimal (3.5.2-2ubuntu0~16.04.13) ...
Setting up python3-minimal (3.5.1-3) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Selecting previously unselected package python3.
(Reading database ... 5761 files and directories currently installed.)
Preparing to unpack .../python3_3.5.1-3_amd64.deb ...
Unpacking python3 (3.5.1-3) ...
Selecting previously unselected package libxau6:amd64.
Preparing to unpack .../libxau6_1%3a1.0.8-1_amd64.deb ...
Unpacking libxau6:amd64 (1:1.0.8-1) ...
Selecting previously unselected package libxdmcp6:amd64.
Preparing to unpack .../libxdmcp6_1%3a1.1.2-1.1_amd64.deb ...
Unpacking libxdmcp6:amd64 (1:1.1.2-1.1) ...
Selecting previously unselected package libxcb1:amd64.
Preparing to unpack .../libxcb1_1.11.1-1ubuntu1_amd64.deb ...
Unpacking libxcb1:amd64 (1.11.1-1ubuntu1) ...
Selecting previously unselected package libx11-data.
Preparing to unpack .../libx11-data_2%3a1.6.3-1ubuntu2.2_all.deb ...
Unpacking libx11-data (2:1.6.3-1ubuntu2.2) ...
Selecting previously unselected package libx11-6:amd64.
Preparing to unpack .../libx11-6_2%3a1.6.3-1ubuntu2.2_amd64.deb ...
Unpacking libx11-6:amd64 (2:1.6.3-1ubuntu2.2) ...
Selecting previously unselected package libxext6:amd64.
Preparing to unpack .../libxext6_2%3a1.3.3-1_amd64.deb ...
Unpacking libxext6:amd64 (2:1.3.3-1) ...
Selecting previously unselected package libwrap0:amd64.
Preparing to unpack .../libwrap0_7.6.q-25_amd64.deb ...
Unpacking libwrap0:amd64 (7.6.q-25) ...
Selecting previously unselected package libmagic1:amd64.
Preparing to unpack .../libmagic1_1%3a5.25-2ubuntu1.4_amd64.deb ...
Unpacking libmagic1:amd64 (1:5.25-2ubuntu1.4) ...
Selecting previously unselected package file.
Preparing to unpack .../file_1%3a5.25-2ubuntu1.4_amd64.deb ...
Unpacking file (1:5.25-2ubuntu1.4) ...
Selecting previously unselected package libbsd0:amd64.
Preparing to unpack .../libbsd0_0.8.2-1ubuntu0.1_amd64.deb ...
Unpacking libbsd0:amd64 (0.8.2-1ubuntu0.1) ...
Selecting previously unselected package libidn11:amd64.
Preparing to unpack .../libidn11_1.32-3ubuntu1.2_amd64.deb ...
Unpacking libidn11:amd64 (1.32-3ubuntu1.2) ...
Selecting previously unselected package openssl.
Preparing to unpack .../openssl_1.0.2g-1ubuntu4.20_amd64.deb ...
Unpacking openssl (1.0.2g-1ubuntu4.20) ...
Selecting previously unselected package ca-certificates.
Preparing to unpack .../ca-certificates_20210119~16.04.1_all.deb ...
Unpacking ca-certificates (20210119~16.04.1) ...
Selecting previously unselected package krb5-locales.
Preparing to unpack .../krb5-locales_1.13.2+dfsg-5ubuntu2.2_all.deb ...
Unpacking krb5-locales (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libedit2:amd64.
Preparing to unpack .../libedit2_3.1-20150325-1ubuntu2_amd64.deb ...
Unpacking libedit2:amd64 (3.1-20150325-1ubuntu2) ...
Selecting previously unselected package libkrb5support0:amd64.
Preparing to unpack .../libkrb5support0_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libkrb5support0:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libk5crypto3:amd64.
Preparing to unpack .../libk5crypto3_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libk5crypto3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libkeyutils1:amd64.
Preparing to unpack .../libkeyutils1_1.5.9-8ubuntu1_amd64.deb ...
Unpacking libkeyutils1:amd64 (1.5.9-8ubuntu1) ...
Selecting previously unselected package libkrb5-3:amd64.
Preparing to unpack .../libkrb5-3_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libkrb5-3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libgssapi-krb5-2:amd64.
Preparing to unpack .../libgssapi-krb5-2_1.13.2+dfsg-5ubuntu2.2_amd64.deb ...
Unpacking libgssapi-krb5-2:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Selecting previously unselected package libxmuu1:amd64.
Preparing to unpack .../libxmuu1_2%3a1.1.2-2_amd64.deb ...
Unpacking libxmuu1:amd64 (2:1.1.2-2) ...
Selecting previously unselected package openssh-client.
Preparing to unpack .../openssh-client_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-client (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package wget.
Preparing to unpack .../wget_1.17.1-1ubuntu1.5_amd64.deb ...
Unpacking wget (1.17.1-1ubuntu1.5) ...
Selecting previously unselected package xauth.
Preparing to unpack .../xauth_1%3a1.0.9-1ubuntu2_amd64.deb ...
Unpacking xauth (1:1.0.9-1ubuntu2) ...
Selecting previously unselected package ncurses-term.
Preparing to unpack .../ncurses-term_6.0+20160213-1ubuntu1_all.deb ...
Unpacking ncurses-term (6.0+20160213-1ubuntu1) ...
Selecting previously unselected package openssh-sftp-server.
Preparing to unpack .../openssh-sftp-server_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-sftp-server (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package openssh-server.
Preparing to unpack .../openssh-server_1%3a7.2p2-4ubuntu2.10_amd64.deb ...
Unpacking openssh-server (1:7.2p2-4ubuntu2.10) ...
Selecting previously unselected package python3-pkg-resources.
Preparing to unpack .../python3-pkg-resources_20.7.0-1_all.deb ...
Unpacking python3-pkg-resources (20.7.0-1) ...
Selecting previously unselected package python3-chardet.
Preparing to unpack .../python3-chardet_2.3.0-2_all.deb ...
Unpacking python3-chardet (2.3.0-2) ...
Selecting previously unselected package python3-six.
Preparing to unpack .../python3-six_1.10.0-3_all.deb ...
Unpacking python3-six (1.10.0-3) ...
Selecting previously unselected package python3-urllib3.
Preparing to unpack .../python3-urllib3_1.13.1-2ubuntu0.16.04.4_all.deb ...
Unpacking python3-urllib3 (1.13.1-2ubuntu0.16.04.4) ...
Selecting previously unselected package python3-requests.
Preparing to unpack .../python3-requests_2.9.1-3ubuntu0.1_all.deb ...
Unpacking python3-requests (2.9.1-3ubuntu0.1) ...
Selecting previously unselected package tcpd.
Preparing to unpack .../tcpd_7.6.q-25_amd64.deb ...
Unpacking tcpd (7.6.q-25) ...
Selecting previously unselected package ssh-import-id.
Preparing to unpack .../ssh-import-id_5.5-0ubuntu1_all.deb ...
Unpacking ssh-import-id (5.5-0ubuntu1) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Processing triggers for systemd (229-4ubuntu21.31) ...
Setting up mime-support (3.59ubuntu1) ...
Setting up libmpdec2:amd64 (2.4.2-1) ...
Setting up libsqlite3-0:amd64 (3.11.0-1ubuntu1.5) ...
Setting up libpython3.5-stdlib:amd64 (3.5.2-2ubuntu0~16.04.13) ...
Setting up python3.5 (3.5.2-2ubuntu0~16.04.13) ...
Setting up libpython3-stdlib:amd64 (3.5.1-3) ...
Setting up libxau6:amd64 (1:1.0.8-1) ...
Setting up libxdmcp6:amd64 (1:1.1.2-1.1) ...
Setting up libxcb1:amd64 (1.11.1-1ubuntu1) ...
Setting up libx11-data (2:1.6.3-1ubuntu2.2) ...
Setting up libx11-6:amd64 (2:1.6.3-1ubuntu2.2) ...
Setting up libxext6:amd64 (2:1.3.3-1) ...
Setting up libwrap0:amd64 (7.6.q-25) ...
Setting up libmagic1:amd64 (1:5.25-2ubuntu1.4) ...
Setting up file (1:5.25-2ubuntu1.4) ...
Setting up libbsd0:amd64 (0.8.2-1ubuntu0.1) ...
Setting up libidn11:amd64 (1.32-3ubuntu1.2) ...
Setting up openssl (1.0.2g-1ubuntu4.20) ...
Setting up ca-certificates (20210119~16.04.1) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Setting up krb5-locales (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libedit2:amd64 (3.1-20150325-1ubuntu2) ...
Setting up libkrb5support0:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libk5crypto3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libkeyutils1:amd64 (1.5.9-8ubuntu1) ...
Setting up libkrb5-3:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libgssapi-krb5-2:amd64 (1.13.2+dfsg-5ubuntu2.2) ...
Setting up libxmuu1:amd64 (2:1.1.2-2) ...
Setting up openssh-client (1:7.2p2-4ubuntu2.10) ...
Setting up wget (1.17.1-1ubuntu1.5) ...
Setting up xauth (1:1.0.9-1ubuntu2) ...
Setting up ncurses-term (6.0+20160213-1ubuntu1) ...
Setting up openssh-sftp-server (1:7.2p2-4ubuntu2.10) ...
Setting up openssh-server (1:7.2p2-4ubuntu2.10) ...
debconf: unable to initialize frontend: Dialog
debconf: (TERM is not set, so the dialog frontend is not usable.)
debconf: falling back to frontend: Readline
debconf: unable to initialize frontend: Readline
debconf: (Can't locate Term/ReadLine.pm in @INC (you may need to install the Term::ReadLine module) (@INC contains: /etc/perl /usr/local/lib/x86_64-linux-gnu/perl/5.22.1 /usr/local/share/perl/5.22.1 /usr/lib/x86_64-linux-gnu/perl5/5.22 /usr/share/perl5 /usr/lib/x86_64-linux-gnu/perl/5.22 /usr/share/perl/5.22 /usr/local/lib/site_perl /usr/lib/x86_64-linux-gnu/perl-base .) at /usr/share/perl5/Debconf/FrontEnd/Readline.pm line 7.)
debconf: falling back to frontend: Teletype
Creating SSH2 RSA key; this may take some time ...
2048 SHA256:pjzr5Biw83FjCtb/8Ue+3hkgEs2YS6fVl9E8EJmuUkc root@171da3ccf837 (RSA)
Creating SSH2 DSA key; this may take some time ...
1024 SHA256:wLkZgQ+Y+DSXkMqxU6+NPYDzc3PHADDF2eESi/TqNIM root@171da3ccf837 (DSA)
Creating SSH2 ECDSA key; this may take some time ...
256 SHA256:o9hPaN6VN5M1u7GHhWYZxbgt/UYxYcYy2Olx4Wrm+so root@171da3ccf837 (ECDSA)
Creating SSH2 ED25519 key; this may take some time ...
256 SHA256:M9W/+bIk/iHHkN4JCy8oQ4dSnhRNf8e/UlnTAztRbb8 root@171da3ccf837 (ED25519)
invoke-rc.d: could not determine current runlevel
invoke-rc.d: policy-rc.d denied execution of start.
Setting up tcpd (7.6.q-25) ...
Setting up dh-python (2.20151103ubuntu1.2) ...
Setting up python3 (3.5.1-3) ...
running python rtupdate hooks for python3.5...
running python post-rtupdate hooks for python3.5...
Setting up python3-pkg-resources (20.7.0-1) ...
Setting up python3-chardet (2.3.0-2) ...
Setting up python3-six (1.10.0-3) ...
Setting up python3-urllib3 (1.13.1-2ubuntu0.16.04.4) ...
Setting up python3-requests (2.9.1-3ubuntu0.1) ...
Setting up ssh-import-id (5.5-0ubuntu1) ...
Processing triggers for libc-bin (2.23-0ubuntu11.3) ...
Processing triggers for ca-certificates (20210119~16.04.1) ...
Updating certificates in /etc/ssl/certs...
129 added, 0 removed; done.
Running hooks in /etc/ca-certificates/update.d...
done.
Processing triggers for systemd (229-4ubuntu21.31) ...
Removing intermediate container 171da3ccf837
 ---> 1ff19117f7e8
Step 4/12 : RUN mkdir /var/run/sshd
 ---> Running in f648f7688a73
Removing intermediate container f648f7688a73
 ---> ad7cb3f8fc31
Step 5/12 : RUN echo 'root:root' | chpasswd
 ---> Running in aed44801a8db
Removing intermediate container aed44801a8db
 ---> e466e048c773
Step 6/12 : RUN sed -i 's/PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config
 ---> Running in b0bef4d933c8
Removing intermediate container b0bef4d933c8
 ---> 35abf132911e
Step 7/12 : RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd
 ---> Running in 6a0b737cd591
Removing intermediate container 6a0b737cd591
 ---> 241feff0fc46
Step 8/12 : RUN mkdir -p /root/.ssh
 ---> Running in e6a755b833e4
Removing intermediate container e6a755b833e4
 ---> 1022f2f17c92
Step 9/12 : COPY authorized_keys /root/.ssh/authorized_keys
 ---> ace4045293a6
Step 10/12 : EXPOSE 22
 ---> Running in 711bbc8c2dc9
Removing intermediate container 711bbc8c2dc9
 ---> 0cc400cb5e6b
Step 11/12 : EXPOSE 80
 ---> Running in 378f75f3ca11
Removing intermediate container 378f75f3ca11
 ---> d24de876ea54
Step 12/12 : CMD ["/usr/sbin/sshd", "-D"]
 ---> Running in 16d3682bc446
Removing intermediate container 16d3682bc446
 ---> eefd4b49e49b
Successfully built eefd4b49e49b
Successfully tagged <b>tektutor/ubuntu-ansible-node:latest</b>
</pre>

## Let's create two container using our custom docker image
```
docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ubuntu-ansible-node:latest
docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ubuntu-ansible-node:latest
```

Expected output
<pre>
[jegan@tektutor.org devops-sep-2022]$ <b>docker run -d --name ubuntu1 --hostname ubuntu1 -p 2001:22 -p 8001:80 tektutor/ubuntu-ansible-node:latest</b>
1cab14c8bbf7e15beb3ee39603add1ff1a924982f2d25a368f4c730d7a8b5166

[jegan@tektutor.org devops-sep-2022]$ <b>docker run -d --name ubuntu2 --hostname ubuntu2 -p 2002:22 -p 8002:80 tektutor/ubuntu-ansible-node:latest</b>
a753bfb10625fd37de7f25f6fcecbaabbf8a4dc2d2788ac65fb0ca347b4f51cb
</pre>

List and check if the ubuntu1 and ubuntu2 containers are running
```
docker ps
```

Expected output
<pre>
jegan@tektutor.org devops-sep-2022]$ <b>docker ps</b>
CONTAINER ID   IMAGE                                 COMMAND                  CREATED          STATUS          PORTS                                                                          NAMES
a753bfb10625   tektutor/ubuntu-ansible-node:latest   "/usr/sbin/sshd -D"      2 seconds ago    Up 1 second     0.0.0.0:2002->22/tcp, :::2002->22/tcp, 0.0.0.0:8002->80/tcp, :::8002->80/tcp   ubuntu2
1cab14c8bbf7   tektutor/ubuntu-ansible-node:latest   "/usr/sbin/sshd -D"      13 seconds ago   Up 12 seconds   0.0.0.0:2001->22/tcp, :::2001->22/tcp, 0.0.0.0:8001->80/tcp, :::8001->80/tcp   ubuntu1
</pre>

## Testing if the containers are allowing us to do ssh without prompting for password as it does key based login authentication
```
ssh -p 2001 root@localhost
ssh -p 2002 root@localhost
```

Expected output
<pre>
[jegan@tektutor.org devops-sep-2022]$ <b>ssh -p 2001 root@localhost</b>
The authenticity of host '[localhost]:2001 ([::1]:2001)' can't be established.
ECDSA key fingerprint is SHA256:o9hPaN6VN5M1u7GHhWYZxbgt/UYxYcYy2Olx4Wrm+so.
ECDSA key fingerprint is MD5:15:70:74:e4:83:fe:02:84:7d:4d:8f:3f:01:bb:80:4d.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added '[localhost]:2001' (ECDSA) to the list of known hosts.
Welcome to Ubuntu 16.04.7 LTS (GNU/Linux 3.10.0-1160.el7.x86_64 x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

root@ubuntu1:~# <b>exit</b>
logout
Connection to localhost closed.
[jegan@tektutor.org devops-sep-2022]$ <b>ssh -p 2002 root@localhost</b>
The authenticity of host '[localhost]:2002 ([::1]:2002)' can't be established.
ECDSA key fingerprint is SHA256:o9hPaN6VN5M1u7GHhWYZxbgt/UYxYcYy2Olx4Wrm+so.
ECDSA key fingerprint is MD5:15:70:74:e4:83:fe:02:84:7d:4d:8f:3f:01:bb:80:4d.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added '[localhost]:2002' (ECDSA) to the list of known hosts.
Welcome to Ubuntu 16.04.7 LTS (GNU/Linux 3.10.0-1160.el7.x86_64 x86_64)

 * Documentation:  https://help.ubuntu.com
 * Management:     https://landscape.canonical.com
 * Support:        https://ubuntu.com/advantage

The programs included with the Ubuntu system are free software;
the exact distribution terms for each program are described in the
individual files in /usr/share/doc/*/copyright.

Ubuntu comes with ABSOLUTELY NO WARRANTY, to the extent permitted by
applicable law.

root@ubuntu2:~# <b>exit</b>
logout
Connection to localhost closed.
</pre>


## Ansible ping to check if ansible can connect with the ansible nodes as expected
```
cd ~/devops-sep-2022
git pull
cd Day3/static-inventory

ansible -i inventory all -m ping
```

In the above command, 
<pre>
-i - indicates what follows is the inventory file name
inventory - is the name of the inventory file
all - is the group of machines we wish to ping
-m - indicates the ansible module
ping - is the ansible module name ( actually ping.py is a python script )
</pre>

Expected output
<pre>
[jegan@tektutor.org static-inventory]$ <b>ansible -i inventory all -m ping</b>
ubuntu1 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}
ubuntu2 | SUCCESS => {
    "ansible_facts": {
        "discovered_interpreter_python": "/usr/bin/python3"
    },
    "changed": false,
    "ping": "pong"
}
</pre>


## Ansible ad-hoc command that gathers ansible facts about the nodes
```
ansible -i inventory all -m setup
```

Expected output
<pre>
[jegan@tektutor.org static-inventory]$ <b>ansible -i inventory all -m setup</b>
[DEPRECATION WARNING]: Ansible will require Python 3.8 or newer on the controller starting with Ansible 2.12. Current 
version: 3.6.8 (default, Nov 16 2020, 16:55:22) [GCC 4.8.5 20150623 (Red Hat 4.8.5-44)]. This feature will be removed 
from ansible-core in version 2.12. Deprecation warnings can be disabled by setting deprecation_warnings=False in 
ansible.cfg.
/usr/local/lib/python3.6/site-packages/ansible/parsing/vault/__init__.py:44: CryptographyDeprecationWarning: Python 3.6 is no longer supported by the Python core team. Therefore, support for it is deprecated in cryptography and will be removed in a future release.
  from cryptography.exceptions import InvalidSignature
ubuntu2 | SUCCESS => {
    "ansible_facts": {
        "ansible_apparmor": {
            "status": "disabled"
        },
        "ansible_architecture": "x86_64",
        "ansible_bios_date": "11/12/2020",
        "ansible_bios_vendor": "Phoenix Technologies LTD",
        "ansible_bios_version": "6.00",
        "ansible_board_asset_tag": "NA",
        "ansible_board_name": "440BX Desktop Reference Platform",
        "ansible_board_serial": "None",
        "ansible_board_vendor": "Intel Corporation",
        "ansible_board_version": "None",
        "ansible_chassis_asset_tag": "No Asset Tag",
        "ansible_chassis_serial": "None",
        "ansible_chassis_vendor": "No Enclosure",
        "ansible_chassis_version": "N/A",
        "ansible_cmdline": {
            "BOOT_IMAGE": "/vmlinuz-3.10.0-1160.el7.x86_64",
            "LANG": "en_US.UTF-8",
            "crashkernel": "auto",
            "quiet": true,
            "rhgb": true,
            "ro": true,
            "root": "UUID=6509f3a8-33d1-4eec-8d24-1ca7c6177ab2",
            "spectre_v2": "retpoline"
        },
        "ansible_date_time": {
            "date": "2022-09-21",
            "day": "21",
            "epoch": "1663755420",
            "hour": "10",
            "iso8601": "2022-09-21T10:17:00Z",
            "iso8601_basic": "20220921T101700292546",
            "iso8601_basic_short": "20220921T101700",
            "iso8601_micro": "2022-09-21T10:17:00.292546Z",
            "minute": "17",
            "month": "09",
            "second": "00",
            "time": "10:17:00",
            "tz": "UTC",
            "tz_dst": "UTC",
            "tz_offset": "+0000",
            "weekday": "Wednesday",
            "weekday_number": "3",
            "weeknumber": "38",
            "year": "2022"
        },
        "ansible_device_links": {
            "ids": {},
            "labels": {},
            "masters": {},
            "uuids": {}
        },
        "ansible_devices": {
            "sda": {
                "holders": [],
                "host": "",
                "links": {
                    "ids": [],
                    "labels": [],
                    "masters": [],
                    "uuids": []
                },
                "model": "VMware Virtual S",
                "partitions": {
                    "sda1": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "614400",
                        "sectorsize": 512,
                        "size": "300.00 MB",
                        "start": "2048",
                        "uuid": null
                    },
                    "sda2": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "20971520",
                        "sectorsize": 512,
                        "size": "10.00 GB",
                        "start": "616448",
                        "uuid": null
                    },
                    "sda3": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "188127232",
                        "sectorsize": 512,
                        "size": "89.71 GB",
                        "start": "21587968",
                        "uuid": null
                    }
                },
                "removable": "0",
                "rotational": "1",
                "sas_address": null,
                "sas_device_handle": null,
                "scheduler_mode": "deadline",
                "sectors": "209715200",
                "sectorsize": "512",
                "size": "100.00 GB",
                "support_discard": "0",
                "vendor": "VMware,",
                "virtual": 1
            },
            "sr0": {
                "holders": [],
                "host": "",
                "links": {
                    "ids": [],
                    "labels": [],
                    "masters": [],
                    "uuids": []
                },
                "model": "VMware IDE CDR10",
                "partitions": {},
                "removable": "1",
                "rotational": "1",
                "sas_address": null,
                "sas_device_handle": null,
                "scheduler_mode": "deadline",
                "sectors": "2097151",
                "sectorsize": "512",
                "size": "1024.00 MB",
                "support_discard": "0",
                "vendor": "NECVMWar",
                "virtual": 1
            }
        },
        "ansible_distribution": "Ubuntu",
        "ansible_distribution_file_parsed": true,
        "ansible_distribution_file_path": "/etc/os-release",
        "ansible_distribution_file_variety": "Debian",
        "ansible_distribution_major_version": "16",
        "ansible_distribution_release": "xenial",
        "ansible_distribution_version": "16.04",
        "ansible_dns": {
            "nameservers": [
                "192.168.167.2"
            ],
            "search": [
                "localdomain",
                "org"
            ]
        },
        "ansible_domain": "",
        "ansible_effective_group_id": 0,
        "ansible_effective_user_id": 0,
        "ansible_env": {
            "HOME": "/root",
            "LANG": "C",
            "LC_ALL": "C",
            "LC_MESSAGES": "C",
            "LOGNAME": "root",
            "MAIL": "/var/mail/root",
            "PATH": "/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin",
            "PWD": "/root",
            "SHELL": "/bin/bash",
            "SHLVL": "1",
            "SSH_CLIENT": "172.17.0.1 48704 22",
            "SSH_CONNECTION": "172.17.0.1 48704 172.17.0.4 22",
            "SSH_TTY": "/dev/pts/0",
            "TERM": "xterm-256color",
            "USER": "root",
            "_": "/bin/sh"
        },
        "ansible_fibre_channel_wwn": [],
        "ansible_fips": false,
        "ansible_form_factor": "Other",
        "ansible_fqdn": "ubuntu2",
        "ansible_hostname": "ubuntu2",
        "ansible_hostnqn": "",
        "ansible_is_chroot": false,
        "ansible_iscsi_iqn": "",
        "ansible_kernel": "3.10.0-1160.el7.x86_64",
        "ansible_kernel_version": "#1 SMP Mon Oct 19 16:18:59 UTC 2020",
        "ansible_local": {},
        "ansible_lsb": {
            "codename": "xenial",
            "description": "Ubuntu 16.04.7 LTS",
            "id": "Ubuntu",
            "major_release": "16",
            "release": "16.04"
        },
        "ansible_machine": "x86_64",
        "ansible_memfree_mb": 8960,
        "ansible_memory_mb": {
            "nocache": {
                "free": 13188,
                "used": 2678
            },
            "real": {
                "free": 8960,
                "total": 15866,
                "used": 6906
            },
            "swap": {
                "cached": 0,
                "free": 10239,
                "total": 10239,
                "used": 0
            }
        },
        "ansible_memtotal_mb": 15866,
        "ansible_mounts": [
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/hosts",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            },
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/hostname",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            },
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/resolv.conf",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            }
        ],
        "ansible_nodename": "ubuntu2",
        "ansible_os_family": "Debian",
        "ansible_pkg_mgr": "apt",
        "ansible_proc_cmdline": {
            "BOOT_IMAGE": "/vmlinuz-3.10.0-1160.el7.x86_64",
            "LANG": "en_US.UTF-8",
            "crashkernel": "auto",
            "quiet": true,
            "rhgb": true,
            "ro": true,
            "root": "UUID=6509f3a8-33d1-4eec-8d24-1ca7c6177ab2",
            "spectre_v2": "retpoline"
        },
        "ansible_processor": [
            "0",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "1",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "2",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "3",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz"
        ],
        "ansible_processor_cores": 2,
        "ansible_processor_count": 2,
        "ansible_processor_nproc": 4,
        "ansible_processor_threads_per_core": 1,
        "ansible_processor_vcpus": 4,
        "ansible_product_name": "VMware Virtual Platform",
        "ansible_product_serial": "VMware-56 4d 75 41 e6 ee 45 e9-7b a4 c2 a4 db 93 db 3c",
        "ansible_product_uuid": "41754D56-EEE6-E945-7BA4-C2A4DB93DB3C",
        "ansible_product_version": "None",
        "ansible_python": {
            "executable": "/usr/bin/python3",
            "has_sslcontext": true,
            "type": "cpython",
            "version": {
                "major": 3,
                "micro": 2,
                "minor": 5,
                "releaselevel": "final",
                "serial": 0
            },
            "version_info": [
                3,
                5,
                2,
                "final",
                0
            ]
        },
        "ansible_python_version": "3.5.2",
        "ansible_real_group_id": 0,
        "ansible_real_user_id": 0,
        "ansible_selinux": {
            "status": "disabled"
        },
        "ansible_selinux_python_present": true,
        "ansible_service_mgr": "sshd",
        "ansible_ssh_host_key_dsa_public": "AAAAB3NzaC1kc3MAAACBAOVs0pj6Dav6ElHfYG1pKntQyHb0lLLZnwzWU/k6GM/kaZuSlZKL2dTNSf3BF7AVm7dKfwh+Jqx8+wsf6QwZKPVoi+T/7oqYvaOU5ba0UK7LzrtOs7cMJ/smlUDmG3dnNGhFLGM9RsCVCoBT2xmVNbsgep4nY6P6k23AKHGFmkmHAAAAFQDyNRoluouYI03BjbmxLvf12DUowQAAAIBaZ6FFHy1AKrtolf6u9p7Xd2iIivQyps31NDy5Azp+tm4wDnUtczuVBQOeiPduHOcu+sVEMnjdp1u6Y8A8cvESIQn00o7J2sNaBykz7uQ7QUcqRB1qFPKk97TZ2SzI7kJshXOATzXEtrVFvT3AR1TW9BhZu5TXXyUHzE4apgdbCwAAAIEAkC2cqFsqEQJyhktn0BNQgAbGW8T8FvlGRZ8ihPKuriSpc/gl5CiBTd+vM/PPvMQlTmVxSOhJozqL693csWjOZLhJEbn3iatS+aSxwVy73fC0JbAyYiVw0V43kNM+nNxDIOR+Achr0LaOpBNQOoj0fuodpTbS1W2FRK9AP7xMCeI=",
        "ansible_ssh_host_key_dsa_public_keytype": "ssh-dss",
        "ansible_ssh_host_key_ecdsa_public": "AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBI32cs7f6LxLo3yxRQieQKoRL22dIT4mKMzA19ZBMGjjPk6n9I9VsNnUv25by1RkngKtTSVPozQqIzBb2LlWJT4=",
        "ansible_ssh_host_key_ecdsa_public_keytype": "ecdsa-sha2-nistp256",
        "ansible_ssh_host_key_ed25519_public": "AAAAC3NzaC1lZDI1NTE5AAAAIFLiASyl7GwLEkENverw+kcR0WAhmGTBwz6xE+ewirkT",
        "ansible_ssh_host_key_ed25519_public_keytype": "ssh-ed25519",
        "ansible_ssh_host_key_rsa_public": "AAAAB3NzaC1yc2EAAAADAQABAAABAQDVfJT3NP1/hm1j1LrujSuqrozRoqi9W9iWYkoLRhnelcxecClkCeT+anv6pt0I0lw+wNsgrSaqYPuVFfY1NmpT7quwn7UUbQj6Mb1Sxt4CWEiH26ghjdYOUdVuwSuiZjyViQVpeUOcV5yW3uhGy3a76wzBaI1SJalP1/PxwFldRLuEKGcCDKj9wyEV8m0VYK0bo2I+47XA/YQIJlLzzUvAaeAw4Ui9dfQLr3DFkQ0ze1r8GT30oLkTcoXI1R4L5b9ggt5Fh/F9Ff69rdQ432PZ6kjqDWhH+vQN/tPmV5jELxf2Fl5LSUEkwbK0W3B6QI7Iz/dotH5OOSSNy8QYSpoV",
        "ansible_ssh_host_key_rsa_public_keytype": "ssh-rsa",
        "ansible_swapfree_mb": 10239,
        "ansible_swaptotal_mb": 10239,
        "ansible_system": "Linux",
        "ansible_system_capabilities": [
            "cap_chown",
            "cap_dac_override",
            "cap_fowner",
            "cap_fsetid",
            "cap_kill",
            "cap_setgid",
            "cap_setuid",
            "cap_setpcap",
            "cap_net_bind_service",
            "cap_net_raw",
            "cap_sys_chroot",
            "cap_mknod",
            "cap_audit_write",
            "cap_setfcap+ep"
        ],
        "ansible_system_capabilities_enforced": "True",
        "ansible_system_vendor": "VMware, Inc.",
        "ansible_uptime_seconds": 90255,
        "ansible_user_dir": "/root",
        "ansible_user_gecos": "root",
        "ansible_user_gid": 0,
        "ansible_user_id": "root",
        "ansible_user_shell": "/bin/bash",
        "ansible_user_uid": 0,
        "ansible_userspace_architecture": "x86_64",
        "ansible_userspace_bits": "64",
        "ansible_virtualization_role": "guest",
        "ansible_virtualization_tech_guest": [
            "container",
            "VMware",
            "docker"
        ],
        "ansible_virtualization_tech_host": [],
        "ansible_virtualization_type": "docker",
        "discovered_interpreter_python": "/usr/bin/python3",
        "gather_subset": [
            "all"
        ],
        "module_setup": true
    },
    "changed": false
}
ubuntu1 | SUCCESS => {
    "ansible_facts": {
        "ansible_apparmor": {
            "status": "disabled"
        },
        "ansible_architecture": "x86_64",
        "ansible_bios_date": "11/12/2020",
        "ansible_bios_vendor": "Phoenix Technologies LTD",
        "ansible_bios_version": "6.00",
        "ansible_board_asset_tag": "NA",
        "ansible_board_name": "440BX Desktop Reference Platform",
        "ansible_board_serial": "None",
        "ansible_board_vendor": "Intel Corporation",
        "ansible_board_version": "None",
        "ansible_chassis_asset_tag": "No Asset Tag",
        "ansible_chassis_serial": "None",
        "ansible_chassis_vendor": "No Enclosure",
        "ansible_chassis_version": "N/A",
        "ansible_cmdline": {
            "BOOT_IMAGE": "/vmlinuz-3.10.0-1160.el7.x86_64",
            "LANG": "en_US.UTF-8",
            "crashkernel": "auto",
            "quiet": true,
            "rhgb": true,
            "ro": true,
            "root": "UUID=6509f3a8-33d1-4eec-8d24-1ca7c6177ab2",
            "spectre_v2": "retpoline"
        },
        "ansible_date_time": {
            "date": "2022-09-21",
            "day": "21",
            "epoch": "1663755420",
            "hour": "10",
            "iso8601": "2022-09-21T10:17:00Z",
            "iso8601_basic": "20220921T101700167927",
            "iso8601_basic_short": "20220921T101700",
            "iso8601_micro": "2022-09-21T10:17:00.167927Z",
            "minute": "17",
            "month": "09",
            "second": "00",
            "time": "10:17:00",
            "tz": "UTC",
            "tz_dst": "UTC",
            "tz_offset": "+0000",
            "weekday": "Wednesday",
            "weekday_number": "3",
            "weeknumber": "38",
            "year": "2022"
        },
        "ansible_device_links": {
            "ids": {},
            "labels": {},
            "masters": {},
            "uuids": {}
        },
        "ansible_devices": {
            "sda": {
                "holders": [],
                "host": "",
                "links": {
                    "ids": [],
                    "labels": [],
                    "masters": [],
                    "uuids": []
                },
                "model": "VMware Virtual S",
                "partitions": {
                    "sda1": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "614400",
                        "sectorsize": 512,
                        "size": "300.00 MB",
                        "start": "2048",
                        "uuid": null
                    },
                    "sda2": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "20971520",
                        "sectorsize": 512,
                        "size": "10.00 GB",
                        "start": "616448",
                        "uuid": null
                    },
                    "sda3": {
                        "holders": [],
                        "links": {
                            "ids": [],
                            "labels": [],
                            "masters": [],
                            "uuids": []
                        },
                        "sectors": "188127232",
                        "sectorsize": 512,
                        "size": "89.71 GB",
                        "start": "21587968",
                        "uuid": null
                    }
                },
                "removable": "0",
                "rotational": "1",
                "sas_address": null,
                "sas_device_handle": null,
                "scheduler_mode": "deadline",
                "sectors": "209715200",
                "sectorsize": "512",
                "size": "100.00 GB",
                "support_discard": "0",
                "vendor": "VMware,",
                "virtual": 1
            },
            "sr0": {
                "holders": [],
                "host": "",
                "links": {
                    "ids": [],
                    "labels": [],
                    "masters": [],
                    "uuids": []
                },
                "model": "VMware IDE CDR10",
                "partitions": {},
                "removable": "1",
                "rotational": "1",
                "sas_address": null,
                "sas_device_handle": null,
                "scheduler_mode": "deadline",
                "sectors": "2097151",
                "sectorsize": "512",
                "size": "1024.00 MB",
                "support_discard": "0",
                "vendor": "NECVMWar",
                "virtual": 1
            }
        },
        "ansible_distribution": "Ubuntu",
        "ansible_distribution_file_parsed": true,
        "ansible_distribution_file_path": "/etc/os-release",
        "ansible_distribution_file_variety": "Debian",
        "ansible_distribution_major_version": "16",
        "ansible_distribution_release": "xenial",
        "ansible_distribution_version": "16.04",
        "ansible_dns": {
            "nameservers": [
                "192.168.167.2"
            ],
            "search": [
                "localdomain",
                "org"
            ]
        },
        "ansible_domain": "",
        "ansible_effective_group_id": 0,
        "ansible_effective_user_id": 0,
        "ansible_env": {
            "HOME": "/root",
            "LANG": "C",
            "LC_ALL": "C",
            "LC_MESSAGES": "C",
            "LOGNAME": "root",
            "MAIL": "/var/mail/root",
            "PATH": "/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin",
            "PWD": "/root",
            "SHELL": "/bin/bash",
            "SHLVL": "1",
            "SSH_CLIENT": "172.17.0.1 39760 22",
            "SSH_CONNECTION": "172.17.0.1 39760 172.17.0.3 22",
            "SSH_TTY": "/dev/pts/0",
            "TERM": "xterm-256color",
            "USER": "root",
            "_": "/bin/sh"
        },
        "ansible_fibre_channel_wwn": [],
        "ansible_fips": false,
        "ansible_form_factor": "Other",
        "ansible_fqdn": "ubuntu1",
        "ansible_hostname": "ubuntu1",
        "ansible_hostnqn": "",
        "ansible_is_chroot": false,
        "ansible_iscsi_iqn": "",
        "ansible_kernel": "3.10.0-1160.el7.x86_64",
        "ansible_kernel_version": "#1 SMP Mon Oct 19 16:18:59 UTC 2020",
        "ansible_local": {},
        "ansible_lsb": {
            "codename": "xenial",
            "description": "Ubuntu 16.04.7 LTS",
            "id": "Ubuntu",
            "major_release": "16",
            "release": "16.04"
        },
        "ansible_machine": "x86_64",
        "ansible_memfree_mb": 8960,
        "ansible_memory_mb": {
            "nocache": {
                "free": 13188,
                "used": 2678
            },
            "real": {
                "free": 8960,
                "total": 15866,
                "used": 6906
            },
            "swap": {
                "cached": 0,
                "free": 10239,
                "total": 10239,
                "used": 0
            }
        },
        "ansible_memtotal_mb": 15866,
        "ansible_mounts": [
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/hosts",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            },
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/resolv.conf",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            },
            {
                "block_available": 20770985,
                "block_size": 4096,
                "block_total": 23504422,
                "block_used": 2733437,
                "device": "/dev/sda3",
                "fstype": "xfs",
                "inode_available": 46742017,
                "inode_total": 47031808,
                "inode_used": 289791,
                "mount": "/etc/hostname",
                "options": "rw,seclabel,relatime,attr2,inode64,noquota,bind",
                "size_available": 85077954560,
                "size_total": 96274112512,
                "uuid": "N/A"
            }
        ],
        "ansible_nodename": "ubuntu1",
        "ansible_os_family": "Debian",
        "ansible_pkg_mgr": "apt",
        "ansible_proc_cmdline": {
            "BOOT_IMAGE": "/vmlinuz-3.10.0-1160.el7.x86_64",
            "LANG": "en_US.UTF-8",
            "crashkernel": "auto",
            "quiet": true,
            "rhgb": true,
            "ro": true,
            "root": "UUID=6509f3a8-33d1-4eec-8d24-1ca7c6177ab2",
            "spectre_v2": "retpoline"
        },
        "ansible_processor": [
            "0",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "1",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "2",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz",
            "3",
            "GenuineIntel",
            "Intel(R) Xeon(R) Silver 4214R CPU @ 2.40GHz"
        ],
        "ansible_processor_cores": 2,
        "ansible_processor_count": 2,
        "ansible_processor_nproc": 4,
        "ansible_processor_threads_per_core": 1,
        "ansible_processor_vcpus": 4,
        "ansible_product_name": "VMware Virtual Platform",
        "ansible_product_serial": "VMware-56 4d 75 41 e6 ee 45 e9-7b a4 c2 a4 db 93 db 3c",
        "ansible_product_uuid": "41754D56-EEE6-E945-7BA4-C2A4DB93DB3C",
        "ansible_product_version": "None",
        "ansible_python": {
            "executable": "/usr/bin/python3",
            "has_sslcontext": true,
            "type": "cpython",
            "version": {
                "major": 3,
                "micro": 2,
                "minor": 5,
                "releaselevel": "final",
                "serial": 0
            },
            "version_info": [
                3,
                5,
                2,
                "final",
                0
            ]
        },
        "ansible_python_version": "3.5.2",
        "ansible_real_group_id": 0,
        "ansible_real_user_id": 0,
        "ansible_selinux": {
            "status": "disabled"
        },
        "ansible_selinux_python_present": true,
        "ansible_service_mgr": "sshd",
        "ansible_ssh_host_key_dsa_public": "AAAAB3NzaC1kc3MAAACBAOVs0pj6Dav6ElHfYG1pKntQyHb0lLLZnwzWU/k6GM/kaZuSlZKL2dTNSf3BF7AVm7dKfwh+Jqx8+wsf6QwZKPVoi+T/7oqYvaOU5ba0UK7LzrtOs7cMJ/smlUDmG3dnNGhFLGM9RsCVCoBT2xmVNbsgep4nY6P6k23AKHGFmkmHAAAAFQDyNRoluouYI03BjbmxLvf12DUowQAAAIBaZ6FFHy1AKrtolf6u9p7Xd2iIivQyps31NDy5Azp+tm4wDnUtczuVBQOeiPduHOcu+sVEMnjdp1u6Y8A8cvESIQn00o7J2sNaBykz7uQ7QUcqRB1qFPKk97TZ2SzI7kJshXOATzXEtrVFvT3AR1TW9BhZu5TXXyUHzE4apgdbCwAAAIEAkC2cqFsqEQJyhktn0BNQgAbGW8T8FvlGRZ8ihPKuriSpc/gl5CiBTd+vM/PPvMQlTmVxSOhJozqL693csWjOZLhJEbn3iatS+aSxwVy73fC0JbAyYiVw0V43kNM+nNxDIOR+Achr0LaOpBNQOoj0fuodpTbS1W2FRK9AP7xMCeI=",
        "ansible_ssh_host_key_dsa_public_keytype": "ssh-dss",
        "ansible_ssh_host_key_ecdsa_public": "AAAAE2VjZHNhLXNoYTItbmlzdHAyNTYAAAAIbmlzdHAyNTYAAABBBI32cs7f6LxLo3yxRQieQKoRL22dIT4mKMzA19ZBMGjjPk6n9I9VsNnUv25by1RkngKtTSVPozQqIzBb2LlWJT4=",
        "ansible_ssh_host_key_ecdsa_public_keytype": "ecdsa-sha2-nistp256",
        "ansible_ssh_host_key_ed25519_public": "AAAAC3NzaC1lZDI1NTE5AAAAIFLiASyl7GwLEkENverw+kcR0WAhmGTBwz6xE+ewirkT",
        "ansible_ssh_host_key_ed25519_public_keytype": "ssh-ed25519",
        "ansible_ssh_host_key_rsa_public": "AAAAB3NzaC1yc2EAAAADAQABAAABAQDVfJT3NP1/hm1j1LrujSuqrozRoqi9W9iWYkoLRhnelcxecClkCeT+anv6pt0I0lw+wNsgrSaqYPuVFfY1NmpT7quwn7UUbQj6Mb1Sxt4CWEiH26ghjdYOUdVuwSuiZjyViQVpeUOcV5yW3uhGy3a76wzBaI1SJalP1/PxwFldRLuEKGcCDKj9wyEV8m0VYK0bo2I+47XA/YQIJlLzzUvAaeAw4Ui9dfQLr3DFkQ0ze1r8GT30oLkTcoXI1R4L5b9ggt5Fh/F9Ff69rdQ432PZ6kjqDWhH+vQN/tPmV5jELxf2Fl5LSUEkwbK0W3B6QI7Iz/dotH5OOSSNy8QYSpoV",
        "ansible_ssh_host_key_rsa_public_keytype": "ssh-rsa",
        "ansible_swapfree_mb": 10239,
        "ansible_swaptotal_mb": 10239,
        "ansible_system": "Linux",
        "ansible_system_capabilities": [
            "cap_chown",
            "cap_dac_override",
            "cap_fowner",
            "cap_fsetid",
            "cap_kill",
            "cap_setgid",
            "cap_setuid",
            "cap_setpcap",
            "cap_net_bind_service",
            "cap_net_raw",
            "cap_sys_chroot",
            "cap_mknod",
            "cap_audit_write",
            "cap_setfcap+ep"
        ],
        "ansible_system_capabilities_enforced": "True",
        "ansible_system_vendor": "VMware, Inc.",
        "ansible_uptime_seconds": 90255,
        "ansible_user_dir": "/root",
        "ansible_user_gecos": "root",
        "ansible_user_gid": 0,
        "ansible_user_id": "root",
        "ansible_user_shell": "/bin/bash",
        "ansible_user_uid": 0,
        "ansible_userspace_architecture": "x86_64",
        "ansible_userspace_bits": "64",
        "ansible_virtualization_role": "guest",
        "ansible_virtualization_tech_guest": [
            "container",
            "docker",
            "VMware"
        ],
        "ansible_virtualization_tech_host": [],
        "ansible_virtualization_type": "docker",
        "discovered_interpreter_python": "/usr/bin/python3",
        "gather_subset": [
            "all"
        ],
        "module_setup": true
    },
    "changed": false
}
</pre>


## Ansible help for shell module
```
ansible-doc shell
```


## Executing our first playbook
```
cd ~/devops-sep-2022.git
git pull
cd Day3/playbooks/

ansible-playbook -i inventory ping-playbook.yml --ask-vault-pass
```

When prompts for password, type 'root@123' without quotes.

Expected output
<pre>
[jegan@tektutor.org playbooks]$ <b>ansible-playbook -i inventory ping-playbook.yml --ask-vault-pass</b>

Vault password: 

PLAY [Demonstrates how you could write a simplest Ansible playbook] *****************************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [ubuntu1]
ok: [ubuntu2]

TASK [Ping the ansible node] ********************************************************************************************
ok: [ubuntu2]
ok: [ubuntu1]

TASK [debug] ************************************************************************************************************
ok: [ubuntu1] => {
    "msg": "user => xyz@gmail.com password => my-git-password@123"
}
ok: [ubuntu2] => {
    "msg": "user => xyz@gmail.com password => my-git-password@123"
}

PLAY RECAP **************************************************************************************************************
ubuntu1                    : ok=3    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
ubuntu2                    : ok=3    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
</pre>


## Cloning a public repository without credentials
```
cd ~/devops-sep-2022
git pull
cd Day3/playbooks

ansible-playbook git-clone-public-repo-playbook.yml 
```

Expected output
<pre>
[jegan@tektutor.org playbooks]$ <b>ansible-playbook git-clone-public-repo-playbook.yml</b>
[WARNING]: No inventory was parsed, only implicit localhost is available
[WARNING]: provided hosts list is empty, only localhost is available. Note that the implicit localhost does not match
'all'

PLAY [Demonstrates cloning from public GitHub Repository] ***************************************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [localhost]

TASK [Clone TekTutor public GitHub Repo] ********************************************************************************
changed: [localhost]

PLAY RECAP **************************************************************************************************************
localhost                  : ok=2    changed=1    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
</pre>


## Cloning GitHub Private Repository
```
cd ~/devops-sep-2022
git pull
cd Day3/playbooks

ansible-playbook git-clone-private-repo-playbook.yml 
```

Expected output
<pre>
[jegan@tektutor.org playbooks]$ <b>ansible-playbook git-clone-private-repo-playbook.yml</b>
[DEPRECATION WARNING]: Ansible will require Python 3.8 or newer on the controller starting with Ansible 2.12. Current 
version: 3.6.8 (default, Nov 16 2020, 16:55:22) [GCC 4.8.5 20150623 (Red Hat 4.8.5-44)]. This feature will be removed 
from ansible-core in version 2.12. Deprecation warnings can be disabled by setting deprecation_warnings=False in 
ansible.cfg.
/usr/local/lib/python3.6/site-packages/ansible/parsing/vault/__init__.py:44: CryptographyDeprecationWarning: Python 3.6 is no longer supported by the Python core team. Therefore, support for it is deprecated in cryptography and will be removed in a future release.
  from cryptography.exceptions import InvalidSignature
[WARNING]: No inventory was parsed, only implicit localhost is available
[WARNING]: provided hosts list is empty, only localhost is available. Note that the implicit localhost does not match
'all'

PLAY [Demonstrates cloning from public GitHub Repository] ***************************************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [localhost]

TASK [Clone TekTutor public GitHub Repo] ********************************************************************************
Username for 'https://github.com': jegantektutordemo
Password for 'https://jegantektutordemo@github.com': 
Username for 'https://github.com': jegantektutordemo
Password for 'https://jegantektutordemo@github.com': 
Username for 'https://github.com': jegantektutordemo
Password for 'https://jegantektutordemo@github.com': 
changed: [localhost]

PLAY RECAP **************************************************************************************************************
localhost                  : ok=2    changed=1    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
</pre>
