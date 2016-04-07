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
     User saboloh                               //配置默认用户
``` 

* 查看占用空间  

``` 
ls / | grep -vP '(proc)' | awk '{print "du -s -h /" $1}' | bash  
``` 

* 查看源  

```bash  
$ ldd /usr/bin/nginx
$ ldconfig -p | grep odbc
$ vim /etc/ld.so.conf.d/usr.conf 

# 编译
$ export CFLAGS=-m32 LDFLAGS=-m32 CXXFLAGS=-m32
$ ./configure
$ vim libtool
$ make -j 4 
$ make install 
```

# 同步目录

```bash 
$ rsync -a -f"+ */" -f"- *" /data/ root@10.126.92.72:/data/
``` 

# wget 下载JDK

```bash  
$ wget --no-check-certificate --no-cookies --header "Cookie: oraclelicense=accept-securebackup-cookie" http://download.oracle.com/otn-pub/java/jdk/8u77-b03/jdk-8u77-linux-x64.tar.gz
```

# JDK环境变量 

```bash 
$ sudo vim /etc/profile.d/jdk7.sh
#!/bin/bash
export JAVA_HOME=/usr/lib/jvm/java-7-oracle-cloudera
export JRE_HOME=$JAVA_HOME/jre
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib/rt.jar

//或者采用update-alternatives
$ update-alternatives --display|--config java   //可查看已有的信息（列表，优先级）
$ update-alternatives --install /usr/bin/java java /usr/lib/jvm/java-7-oracle-cloudera/bin/java 316  // 316-优先级
$ update-alternatives --config java  // 回车通过序列号选择
```


