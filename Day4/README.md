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

## Passing extra arguments to Ansible Playbook
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
