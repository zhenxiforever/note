#### 对于配置了LZO压缩的表，在使用“项目开发”的“Hive脚本”任务时，需要做以下工作   

* 生成数据时增加三个配置参数  

``` 
set mapred.output.compress=true;
set mapred.output.compression.codec=com.hadoop.compression.lzo.LzopCodec;
set hive.exec.compress.output=true;

INSERT OVERWRITE TABLE dw_stage.page_staytime
PARTITION (cal_dt = ${dealDate})
SELECT ...
``` 

* 使用以下语句进行索引 

``` 
LZOINDEXER
/user/hive/warehouse/dw_stage.db/page_staytime/cal_dt=${outFileSuffix}/; 
```

