# Git

## 配置
* git config --global user.name "xxx"
* git config --global user.email "xxx@xxx.com"
* ssh-keygen -t rsa -C "xxx@xxx.com" -f 目录/.ssh/github_rsa
* 上传Key, 拷贝github_rsa.pub中内容到github.com上
* 测试： ssh -T git@github.com
* 对于多个ssh key：
    1. 在.ssh目录下添加config文件：
```
    #github
    Host github.com
        HostName github.com
        PreferredAuthentications publickey
        IdentityFile 目录/.ssh/github_rsa
```
    2. ssh-agent bash
        ssh-add 目录/.ssh/github_rsa
        ssh-add -l ：列出私钥列表
        ssh-add -D : 清空私钥列表

## 使用
* 建立仓库
> git init

* 新建分支
> git checkout -b develop
> git branch develop
> git checkout develop

* 查看当前分支
> git status

* 查看所有分支
> git branch

* 删除分支
> git branch -d develop

* 提交
> git commit -m ""

* 添加远程仓库地址
> git remote add origin xxx

* 首次推送
> git push -u origin master

* 提交, 推送修改的问件
> git add 文件名

> git commit -m ""

> git push origin master

------
