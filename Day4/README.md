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
