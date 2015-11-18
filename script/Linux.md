* 文件查找 

``` 
$ find ~/dwetl/ -name "*.sh" -exec grep "dw_hadoop_summary_touch_city_sd" -l {} \;
$ find ~/dwetl/ -name "*.mxm" -exec grep "dw_hadoop_summary_touch" -l {} \;
``` 

* 查看端口 

```
$ lsof -n -P | grep 8018
$ netstat -an | grep 80  
$ netstat -nltp 
``` 

* sftp向服务器上传文件 

``` 
$ sftp host@ip
> put file 
``` 

* 查看JVM 情况

```
$ jstat -gcutil $pid 1s
看看 E 那一列是否一直 hang 在100， 或者hang在一个值不变
如果hang住，去看看 jvm 的进程
```

* 查找文件并删除 

``` 
$ [sudo] find /path/ -name ".DS_Store" -depth -exec rm {} \;
$ [sudo] find . -name "*.DS_Store" -type f -delete
``` 

* 配置ssh  

```
$ ssh-keygen -t rsa                             //生成key
$ ssh-add                                       //秘钥加入ssh-agent 
$ ssh-add -l                                    //查看
$ cat ~/.ssh/id_rsa.pub >> authorized_keys
$ vim ~/.ssh/config
Host mid
     User saboloh                              //配置默认用户
``` 


