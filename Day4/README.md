# Day 4

## Setting up a Windows Ansible Node
1. You need a VM with Windows 2019 Server or similar OS
2. Windows Node Ansible Requirments	
     - PowerShell 3.0 or latest
     - .Net Framework 4.5 or latest

### Finding PowerShell version
```
$PSVersionTable
```

### Finding .Net Framework Version
1. Open regedit
2. HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\NET Framework Setup\NDP\v4\Full

### Configuring WinRM on Windows machine
```
$url = "https://raw.githubusercontent.com/ansible/ansible/devel/examples/scripts/ConfigureRemotingForAnsible.ps1"

$file = "$env:temp\ConfigureRemotingForAnsible.ps1"

(New-Object -TypeName System.Net.WebClient).DownloadFile($url, $file)

powershell.exe -ExecutionPolicy ByPass -File $file
```

### Configuring Windows node with Basic authentication
```
Set-Item -Path WSMan:\localhost\Service\Auth\Basic -Value $true
```

### Verify if WinRM Listeners are running ( 2 listerners one for Http and other for Https expected )
```
winrm enumerate winrm/config/Listener
```

### On the Ansible Controller machine, make sure pywinrm is installed
```
pip install "pywinrm>=0.3.0"
```

## 🔆 Demo - Ansible ping Window 2019 Server 
```
cd ~/devops-sep-2022
git pull
cd Day4/windows_node
ansible -i hosts all -m win_ping
```

Expected output
<pre>
[jegan@tektutor.org windows-node]$ <b>ansible -i hosts all -m win_ping</b>

windows2019 | SUCCESS => {
    "changed": false,
    "ping": "pong"
}
</pre>

## ⛹️‍♀️ Lab - Cloning Private GitHub Repository with credentials stored in Ansible vault
When the below playbook prompts for password, type root@123 as vault password.

```
cd ~/devops-sep-2022
git pull

cd Day4/playbooks
ansible-playbook -i inventory clone-private-repo-playbook.yml --ask-vault-pass
```

Expected output
<pre>
[jegan@tektutor.org playbooks]$ <b>ansible-playbook -i inventory clone-private-repo-playbook.yml --ask-vault-pass</b>

Vault password: 

PLAY [Demonstrates cloning from public GitHub Repository] ***************************************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [localhost]

TASK [Clone TekTutor public GitHub Repo] ********************************************************************************
changed: [localhost]

PLAY RECAP **************************************************************************************************************
localhost                  : ok=2    changed=1    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   

[jegan@tektutor.org playbooks]$ ls -lha /tmp/ansible
total 4.0K
drwxrwxr-x.  3 jegan jegan   21 Sep 21 14:51 .
drwxrwxrwt. 25 root  root  4.0K Sep 21 14:51 ..
drwxrwxr-x.  8 jegan jegan   95 Sep 21 14:51 private
[jegan@tektutor.org playbooks]$ ls -lha /tmp/ansible/private
total 4.0K
drwxrwxr-x. 8 jegan jegan  95 Sep 21 14:51 .
drwxrwxr-x. 3 jegan jegan  21 Sep 21 14:51 ..
drwxrwxr-x. 6 jegan jegan 106 Sep 21 14:51 Day1
drwxrwxr-x. 5 jegan jegan  80 Sep 21 14:51 Day2
drwxrwxr-x. 5 jegan jegan 102 Sep 21 14:51 Day3
drwxrwxr-x. 2 jegan jegan  23 Sep 21 14:51 Day4
drwxrwxr-x. 2 jegan jegan  23 Sep 21 14:51 Day5
drwxrwxr-x. 8 jegan jegan 180 Sep 21 14:51 .git
-rw-rw-r--. 1 jegan jegan 381 Sep 21 14:51 README.md
</pre>

## ⛹️‍♀️ Lab - Passing extra arguments to Ansible Playbook
```
cd ~/devops-sep-2022
git pull
cd Day4/playbooks

ansible-playbook passing-extra-args-playbook.yml -e @my-vars.yml
```

Expected output
<pre>
[jegan@tektutor.org playbooks]$ <b>ansible-playbook passing-extra-args-playbook.yml -e @my-vars.yml</b>
[WARNING]: provided hosts list is empty, only localhost is available. Note that the implicit localhost does not match
'all'

PLAY [This playbook will demonstrate passing arguments to your playbook] ************************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [localhost]

TASK [debug] ************************************************************************************************************
ok: [localhost] => {
    "msg": "message --> Hello DevOps; jdk_path --> /usr/lib/jdk1.8/bin; maven home --> /usr/share/maven "
}

PLAY RECAP **************************************************************************************************************
localhost                  : ok=2    changed=0    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
</pre>

## 🔆 Demo Installing softwares on Windows 2019 Server using Ansible playbook
```
cd ~/devops-sep-2022
git pull
cd Day4/windows-node

ansible-playbook -i hosts install-adobereader-playbook.yml
```

Expected output
<pre>
[jegan@tektutor.org windows-node]$ <b>ansible-playbook -i hosts install-adobereader-playbook.yml</b>

PLAY [This playbook will install notepad++ on aws windows 2019 server] ********************************************

TASK [Gathering Facts] **************************************************************************************************
ok: [windows2019]

TASK [Install Adobe Acrobat Reader tool] ********************************************************************************
changed: [windows2019]

TASK [Install VLC Media Player] *****************************************************************************************
changed: [windows2019]

PLAY RECAP **************************************************************************************************************
windows2019                : ok=3    changed=2    unreachable=0    failed=0    skipped=0    rescued=0    ignored=0   
</pre>

## XLR/XLD
- XebiaLabs Release (CI/CD) Platform 
  - helps in creating CI/CD Pipeline
- XebiaLabs Deploy (XLD)
- now acquired by Digital ai

## CI/CD Build Server/Tools
- XLR/XLD ( Commercial Product )
- Jenkins ( Opensource ) - Very Popular
- CloudBees ( Enterprise version of Jenkins ) - Very Popular
- TeamCity
- Bamboo
- Microsoft Team Foundation Server (TFS)

## Ansible vs Terraform vs Cloudformation

### CloudFormation
- this only works in AWS
- this tools is a proprietary scripting tool from Amazon(AWS)
- helps in automating complex environment setup in AWS

## Terraform
- helps in infrastructure automation provisioning 
- i.e provisiong a Virtual Machine locally or in AWS or in Azure, etc
- Terraform once it has provisioned an ec2 instance in AWS or a local VM, it can
  trigger Ansible Playbook to further configure the machine with the required softwares

### Ansible
- Configuration Management Tool
  - helps in automating software installation and configurations
  - can manage softwares installations on-prem servers (unix,linux,mac), cloud vms (aws, azure, gcp, digital ocean, etc.,)
  - can also CISCO routers/switches, etc.,
- given a infrastructure, ansible can helps in installating and configuring the infrastructure provisioned by either cloudformation or terraform

# DevOps

## What is Agile?
- fail-fast approach
- Agile Frameworks
   - SCRUM
   - Kanban
   - XP
- SCRUM Ceremonies
   - Daily stand-up meeting
       - inspect and adapt meeting
       - fail fast meeting
       - 
## How Agile is connected/related to CI/CD?
- self-managing team
- team believes in Agile/SCRUM
- clean coding practices
- adding automated test as part build is critical for CI/CD to work effectively

## What is Continuous Integration(CI)?
- several times a day all the teams members should integrate their changes to the version control
- automated build with automated test cases

## What is Continuous Deployment(CD)?
- once all automated build has thoroughly test the binaries with all automated test cases covering all scenarios, from dev the binaries could be deployed automatically to QA environment for further testing

## What is Continuous Delivery(CD)?
- continuously delivering the tested releases to customer's environment
- it could a staging environment

## What is TDD?
- Test Driven Development
- No Code is written by Developer without first writing a test case
- Only the code required to satisfy the test case alone can be written, no more or no less
- TDD Test cases only Developers or technical team members can understand
- TDD test cases need not be understood by cusomer or business folks

## What is BDD?
- Behavior Driven Development
- Non technical business folks ie customers can also understand and review these cases as they look like plain english
- Cucumber it uses a Gherkin which uses plain english words, also supports many spoken languages

## What is Infrastructure as a Service (IaaS)?
- In cloud service providers, they offer the hardware as a service
- Meaning, we don't need to invest on Server hardwares, we could rent servers with different configuration from the cloud providers and pay for the time we used it
- 


## What is Platform as a Service (PaaS)?

## What is Software as a Service (Saas)?

## What is Jenkins?
- CI/CD Build Server
- opensource
- language agnostic(independent) CI/CD Build Server

## For detailed instruction on configuring Jenkins, refer my medium article 
<pre>
https://medium.com/tektutor/ci-cd-with-maven-github-docker-jenkins-aca28c252fec
</pre>

## Downloading Jenkins LTS 
```
cd ~/Downloads
wget https://get.jenkins.io/war-stable/2.361.1/jenkins.war
```

## Executing Jenkins
```
cd ~/Downloads
java -jar ./jenkins.war
```

## Troubleshooting JDK version mismatch while running Jenkins
1. Edit /home/rps/.bashrc
2. The last line looks as shown below
   PATH=$PATH:$JAVA_HOME/bin
3. The last line must be modified as shown below
   PATH=$JAVA_HOME/bin:$PATH
4. Save and Close the ./bashrc file
5. source /home/rps/.bashrc

You should be able start jenkins without any error
```
cd /home/rps/Downloads
java -jar ./jenkins.war
```


## Configuring Docker to activate WebSocket (REST API)
```
sudo systemctl status docker
```

Expected output
<pre>
[jegan@tektutor.org ~]$ <b>sudo systemctl status docker</b>
[sudo] password for jegan: 
● docker.service - Docker Application Container Engine
   Loaded: loaded (<b>/usr/lib/systemd/system/docker.service</b>; enabled; vendor preset: disabled)
   Active: active (running) since Tue 2022-09-20 02:13:00 PDT; 2 days ago
     Docs: https://docs.docker.com
 Main PID: 1350 (dockerd)
    Tasks: 67
   Memory: 1.2G
   CGroup: /system.slice/docker.service
           ├─ 1350 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
           ├─61983 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8001 -container-ip 172.17.0.3 -contain...
           ├─61990 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8001 -container-ip 172.17.0.3 -container-po...
           ├─62004 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 2001 -container-ip 172.17.0.3 -contain...
           ├─62011 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 2001 -container-ip 172.17.0.3 -container-po...
           ├─62057 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 8002 -container-ip 172.17.0.2 -contain...
           ├─62065 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 8002 -container-ip 172.17.0.2 -container-po...
           ├─62091 /usr/bin/docker-proxy -proto tcp -host-ip 0.0.0.0 -host-port 2002 -container-ip 172.17.0.2 -contain...
           └─62098 /usr/bin/docker-proxy -proto tcp -host-ip :: -host-port 2002 -container-ip 172.17.0.2 -container-po...

Sep 21 05:38:57 tektutor.org dockerd[1350]: time="2022-09-21T05:38:57.010917356-07:00" level=info msg="Container ...3a914
Sep 21 05:38:57 tektutor.org dockerd[1350]: time="2022-09-21T05:38:57.237053403-07:00" level=info msg="ignoring e...lete"
Sep 21 06:04:46 tektutor.org dockerd[1350]: time="2022-09-21T06:04:46.957565009-07:00" level=info msg="ignoring e...lete"
Sep 21 06:04:46 tektutor.org dockerd[1350]: time="2022-09-21T06:04:46.978737989-07:00" level=info msg="ignoring e...lete"
Sep 21 06:06:31 tektutor.org dockerd[1350]: time="2022-09-21T06:06:31.729835740-07:00" level=info msg="ignoring e...lete"
Sep 21 06:06:31 tektutor.org dockerd[1350]: time="2022-09-21T06:06:31.739164242-07:00" level=info msg="ignoring e...lete"
Sep 21 06:07:08 tektutor.org dockerd[1350]: time="2022-09-21T06:07:08.244353879-07:00" level=info msg="ignoring e...lete"
Sep 21 06:07:08 tektutor.org dockerd[1350]: time="2022-09-21T06:07:08.253769281-07:00" level=info msg="ignoring e...lete"
Sep 21 06:09:29 tektutor.org dockerd[1350]: time="2022-09-21T06:09:29.729644549-07:00" level=info msg="ignoring e...lete"
Sep 21 06:09:29 tektutor.org dockerd[1350]: time="2022-09-21T06:09:29.745506183-07:00" level=info msg="ignoring e...lete"
Hint: Some lines were ellipsized, use -l to show in full.
</pre>

Now we need edit the docker service file as shown below
```
sudo gedit /usr/lib/systemd/system/docker.service
```

In the above file, locate the line with the below content
<pre>
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock
</pre>

We need to edit the above line as shown below
<pre>
ExecStart=/usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock -H tcp://0.0.0.0:4243
</pre>

To apply the above config changes, we need to restart docker 
```
sudo systemctl daemon-reload
sudo systemctl restart docker
sudo systemctl status docker
```

Expected output
<pre>
[jegan@tektutor.org ~]$ sudo systemctl daemon-reload
[sudo] password for jegan: 
Sorry, try again.
[sudo] password for jegan: 
[jegan@tektutor.org ~]$ sudo systemctl restart docker
[jegan@tektutor.org ~]$ sudo systemctl status docker
● docker.service - Docker Application Container Engine
   Loaded: loaded (/usr/lib/systemd/system/docker.service; enabled; vendor preset: disabled)
   <b>Active: active (running) since Thu 2022-09-22 02:47:00 PDT; 37s ago</b>
     Docs: https://docs.docker.com
 Main PID: 118389 (dockerd)
    Tasks: 11
   Memory: 30.0M
   CGroup: /system.slice/docker.service
           └─118389 /usr/bin/dockerd -H fd:// --containerd=/run/containerd/containerd.sock <b>-H tcp://0.0.0.0:4243</b>

Sep 22 02:46:59 tektutor.org dockerd[118389]: time="2022-09-22T02:46:59.117071151-07:00" level=info msg="Firewall...ning"
Sep 22 02:46:59 tektutor.org dockerd[118389]: time="2022-09-22T02:46:59.176959993-07:00" level=info msg="Firewall...ning"
Sep 22 02:46:59 tektutor.org dockerd[118389]: time="2022-09-22T02:46:59.632914869-07:00" level=info msg="Default ...ress"
Sep 22 02:46:59 tektutor.org dockerd[118389]: time="2022-09-22T02:46:59.870527950-07:00" level=info msg="Firewall...ning"
Sep 22 02:47:00 tektutor.org dockerd[118389]: time="2022-09-22T02:47:00.093714976-07:00" level=info msg="Loading ...one."
Sep 22 02:47:00 tektutor.org dockerd[118389]: time="2022-09-22T02:47:00.134589458-07:00" level=info msg="Docker d...10.18
Sep 22 02:47:00 tektutor.org dockerd[118389]: time="2022-09-22T02:47:00.134943776-07:00" level=info msg="Daemon h...tion"
Sep 22 02:47:00 tektutor.org systemd[1]: Started Docker Application Container Engine.
Sep 22 02:47:00 tektutor.org dockerd[118389]: time="2022-09-22T02:47:00.184173236-07:00" level=info msg="API list...sock"
Sep 22 02:47:00 tektutor.org dockerd[118389]: time="2022-09-22T02:47:00.189653966-07:00" level=info msg="API list...4243"
Hint: Some lines were ellipsized, use -l to show in full.
</pre>
