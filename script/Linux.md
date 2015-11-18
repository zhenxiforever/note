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



