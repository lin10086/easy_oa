#!/usr/bin/env bash
# ------------------------------------
# 项目运行脚本
# 1. git pull 更新远程代码
# 2. mvn clean package ->  project.war 在远程把项目拉下来，打包，
# 3. stop 停止tomcat
# 5. mv ROOT.war  ROOT-back.war 把老包移动经性保存
# 4. rm -rf  ROOT/* 清空老包
# 5. mv project.war ROOT.war 把新包放到ROOT.war 里
# 6. start启动tomcat
#
#
#
# -----------------------------------


#!/bin/bash
echo =================================
echo  interactive自动化部署脚本启动
echo =================================

echo 进入/data/interactive
cd /usr/git
cd /data/interactive

echo 开始pull版本
git pull

echo 开始编译文件
mvn clean package -Dmaven.test.skip=true

echo 进入编译完成文件
cd /data/interactive/interactive-web/target

echo 文件重命名
mv interactive-web.war ROOT.war

echo 关闭tomcat服务器
sh /data/software/tomcat/bin/shutdown.sh

echo 删除以往文件
rm -rf /data/software/tomcat/webapps/ROOT

echo 移动文件
mv ROOT.war /data/software/tomcat/webapps/

echo 重启服务器
sh /data/software/tomcat/bin/startup.sh

作者：song先生
链接：http://www.imooc.com/article/20056
来源：慕课网
本文原创发布于慕课网 ，转载请注明出处，谢谢合作