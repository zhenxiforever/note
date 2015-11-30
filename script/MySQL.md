
* MySQL 企业版安装后，root密码自动生成在: `/root/.mysql_secret`  

* mysqldump 导出表结构到指定库  

```bash 
$ mysqldump -hIP -uroot -ppassword --compact --skip-lock-tables --no-data database tableName > mysqldumpTmp.sql
$ mysql -hIP -uroot -ppassword -Ddatabase < mysqldumpTemp.sql
$ mysqldump -hIP -uroot -ppassword --compact --skip-lock-tables --no-data database tableName | mysql -uroot -ppassword databases 
``` 

* MySQL 创建指定用户，并授权  

```bash 
$ CREATE USER 'dw_tools'@'localhost' IDENTIFIED BY 'dw_tools';
$ GRANT ALL ON *.* TO 'dw_tools'@'localhost';
$ FLUSH PRIVILEGES;
``` 

* 查看进程信息

```sql 
$ SELECT * FROM information_schema.processlist WHERE state = 'locked';
``` 

* 切换MySQL 文件目录 

1 . Stop MySQL using the following command:  

```bash 
sudo /etc/init.d/mysql stop
```
2 . Copy the existing data directory (default located in `/var/lib/mysql`) using the following command: 

```bash
sudo cp -R -p /var/lib/mysql /newpath
```
3 . edit the MySQL configuration file with the following command:  

```bash
sudo gedit /etc/mysql/my.cnf
```
4 . Look for the entry for datadir, and change the path (which should be `/var/lib/mysql`) to the new data directory.

5 . In the terminal, enter the command:  

```bash
sudo gedit /etc/apparmor.d/usr.sbin.mysqld
```
6 . Look for lines beginning with `/var/lib/mysql`. Change `/var/lib/mysql` in the lines with the new path.

7 . Save and close the file.

8 . Restart the AppArmor profiles with the command:  

```bash 
sudo /etc/init.d/apparmor reload
```
9 . Restart MySQL with the command:  

```bash 
sudo /etc/init.d/mysql restart
```
10 . Now login to MySQL and you can access the same databases you had before.





