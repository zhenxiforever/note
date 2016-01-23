Create proxy 
============


* use ssh  
```bash  
ssh -f -N -D 0.0.0.0:8081 localhost 
``` 

* use node.js  
  * app.js
  * index.html
```js 
var express = require('express');
var path = require('path');
var app = express();


app.use(express.static(path.join(__dirname, 'public')));

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
});

``` 
```js
function FindProxyForURL(url, host) {
  if (host.indexOf('10.') == 0 ||
    host.indexOf('tjtx-') == 0 ||
    host.indexOf('db20-') == 0 ||
    host.indexOf('ods10-') == 0
    ) {
    return "SOCKS 10.249.14.41:8081;";
  }
    return "SOCKS 10.249.14.41:8081;";
}   
```

* use supervisor

```bash 
[program:app]
directory = /home/saboloh/dwetl/socks
command = /home/saboloh/developer/node-v5.1.0-linux-x64/bin/node app.js
user = root
stdout_logfile = /home/saboloh/dwetl/socks/log
redirect_stderr = true
```

* done & use

```
http://10.249.14.41:3000
```




