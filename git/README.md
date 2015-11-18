[Git Help](http://www.git-scm.com/docs)  
=========  

[文档](http://git-scm.com/book/zh/v1)  
=========

### git config 

``` 
git config --global user.name "[name]" 
git config --global user.email "[email address]"  
git config --global color.ui auto  
美化git log
gitlog='git log --graph --pretty=format:'\''%Cred%h%Creset -%C(yellow)%d%Creset %s %Cgreen(%cr) %C(bold blue)<%an>%Creset'\'' --abbrev-commit --date=relative'    
```  

### ssk key  
  
``` 
ssh-keygen -t rsa -P ""  
连续键入Enter即可  
cat ~/.ssh/id_rsa.pub 
config to online 
```  

### make changes 

* 查看当前状态 
* 查看修改  
* 添加&提交&回退 

``` 
git status 
git diff 
git add [file|-A]
git diff --staged 
git reset [file] 
git commit -m "[descriptive message]"  
```

### gitignore   

* 忽略所有，仅仅提交.sh文件:  
 
``` 
*
!.gitignore
!*.sh
!*/  
```

### branch  

* 创建分支   
* 切换分支  
* 分支查看  
* 分支合并  
* 分支删除  


```  
git checkout -b test  
git branch -a   
git checkout master  
git merge test
git branch -d test  
```

### remote 

* 查看remote 
* 添加remote
* 删除remote
* 修改名称 

``` 
git remote -v  
git remote add [name] [url]  
git remote remove origin 
git remote rename [old] [new]
```

### auto push 

``` 
#!/bin/bash

COMMIT_DESC="$1"
if [ -z "$COMMIT_DESC" ]; then 
    echo "Usage: ./git.sh <commit_desc>"
    exit 1
fi 

git stash
git pull --rebase
git stash pop
git add -A
git commit -m "$COMMIT_DESC"
git push origin master   
```




