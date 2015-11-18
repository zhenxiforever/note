
* MySQL 企业版安装后，root密码自动生成在: `/root/.mysql_secret`  

* mysqldump 导出表结构到指定库  

``` 
$ mysqldump -hIP -uroot -ppassword --compact --skip-lock-tables --no-data database tableName > mysqldumpTmp.sql
$ mysql -hIP -uroot -ppassword -Ddatabase < mysqldumpTemp.sql
$ mysqldump -hIP -uroot -ppassword --compact --skip-lock-tables --no-data database tableName | mysql -uroot -ppassword databases 
``` 

* MySQL 创建指定用户，并授权  

``` 
$ CREATE USER 'dw_tools'@'localhost' IDENTIFIED BY 'dw_tools';
$ GRANT ALL ON *.* TO 'dw_tools'@'localhost';
$ FLUSH PRIVILEGES;
``` 

* 查看进程信息

``` 
$ SELECT * FROM information_schema.processlist WHERE state = 'locked';
``` 

