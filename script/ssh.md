
* ssh 端口转发 

```bash
$ /usr/bin/ssh -f -N -Llocalhost:10000:10.126.215.131:10000 root@10.126.97.98
$ ssh -fNg -L 3309:10.126.81.130:3306 hadoop@10.126.81.130
$ /usr/bin/ssh -f -N -D 0.0.0.0:8081 localhost

本地查看端口：
$ telnet localhost 10000

如果服务器报错：
open failed: administratively prohibited: open failed

这是由于代理机器的ssh服务部支持转发 换过一台机子

```
