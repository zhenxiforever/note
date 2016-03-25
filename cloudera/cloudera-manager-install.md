[Cloudera Manager Install](http://www.cloudera.com/documentation/enterprise/latest/topics/cm_ig_install_path_a.html#cmig_topic_6_5_unique_2)
==========================

* 查看系统版本 

```
$ lsb_release -a
No LSB modules are available.
Distributor ID: Ubuntu
Description:    Ubuntu 12.04.4 LTS
Release:    12.04
Codename:   precise

```

* 下载对应[parcel](http://archive.cloudera.com/cdh5/parcels/)

```
找到对应自己系统的parcels
$ wget http://archive.cloudera.com/cdh5/parcels/5.4.7/CDH-5.4.7-1.cdh5.4.7.p0.3-precise.parcel
$ wget wget http://archive.cloudera.com/cdh5/parcels/5.4.7/CDH-5.4.7-1.cdh5.4.7.p0.3-precise.parcel.sha1
$ wget http://archive.cloudera.com/cdh5/parcels/5.4.7/manifest.json

sha1需修改成sha
$ mv CDH-5.4.7-1.cdh5.4.7.p0.3-precise.parcel.sha1 CDH-5.4.7-1.cdh5.4.7.p0.3-precise.parcel.sha
```

* 下载安装[Cloudera Manager](https://archive.cloudera.com/cm5/installer/)

``` 
$ wget https://archive.cloudera.com/cm5/installer/5.4.7/cloudera-manager-installer.bin
```

