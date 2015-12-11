####  map join 的字段不一致，主要是 string 和 int 的列做 join

日志里面看 job 长期 hang 在以下位置：



查看你 map 的时候，map 的状态为 FAILED， 查看 map 的日志，最后有以下类似的信息：
``` 
 2015-12-11 04:26:06,119 INFO [main] org.apache.hadoop.hive.ql.exec.MapJoinOperator: Load back 1 hashtable file from tmp file uri:file:/hadoop3/yarn/nm/usercache/hadoop/appcache/application_1449142557781_73597/container_e11_1449142557781_73597_01_000002/Stage-9.tar.gz/MapJoin-mapfile11--.hashtable
``` 

*解决方法*： 保证用于 join 的列一致，cast 或者直接修改表的结构。

如果还不能解决，先手动禁用掉 map join ：

```sql
set hive.auto.convert.join=false;
```


#### hive 使用的新的序列化方法后偶尔出现的问题。

这种问题一般是代码里面设置了 `set hive.exec.parallel=true;` 运行的时候，偶尔会报以下错误，重跑有可能成功：
``` 
 aliasToWork (org.apache.hadoop.hive.ql.plan.MapWork)
     at org.apache.hive.com.esotericsoftware.kryo.util.DefaultClassResolver.readClass(DefaultClassResolver.java:119)
     at org.apache.hive.com.esotericsoftware.kryo.Kryo.readClass(Kryo.java:656)
     at org.apache.hive.com.esotericsoftware.kryo.serializers.ObjectField.read(ObjectField.java:99)
     at org.apache.hive.com.esotericsoftware.kryo.serializers.FieldSerializer.read(FieldSerializer.java:507)
     at org.apache.hive.com.esotericsoftware.kryo.Kryo.readClassAndObject(Kryo.java:776)
``` 

如果有这种情况，解决的方法是先更换序列化的方法，即加入：
```
set hive.plan.serialization.format=javaXML;
``` 
