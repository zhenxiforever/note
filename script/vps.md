* vps config

```bash
$ dpkg-reconfigure tzdata //时区
// 字符编码
$ apt-get install locales
$ 
```


* prepare 

```bash 
$ apt-get install vim

$ grep -v ^PasswordAuthentication /etc/ssh/sshd_config | grep -v Port  > /tmp/sshd_config
$ echo "Port 50070" >> /tmp/sshd_config
$ echo "PasswordAuthentication no" >> /tmp/sshd_config
$ service ssh restart

$ apt-get install python-pip
$ pip install shadowsocks 
$ apt-get install supervisor
```

* config server

```bash 
$ vim /etc/supervisor/conf.d/ss.conf 

[program:ss]
command=/usr/local/bin/ssserver -c /root/ss.conf -vv --user nobody
stdout_logfile=/var/log/ss.log
stderr_logfile=/var/log/ss.err
stdout_logfile_maxbytes=50MB
stderr_logfile_maxbytes=50MB
autorestart=true
autostart=true

$ vim /root/ss.conf

{
    "server_port":8080,
    "password":"{$yourpassword}",
    "method":"aes-256-cfb"
}
``` 

* config local

``` 
$ sudo apt-get install shadowscoks
$ sslocal  -c ss.conf -b 0.0.0.0 -d start --pid-file /tmp/ss.pid --log-file /tmp/ss.log

$ cat ss.conf
{
    "server":"${serverip}",
    "server_port":8080,
    "local_port":1080,
    "password":"${yourpassword}",
    "method":"aes-256-cfb"
}

```


