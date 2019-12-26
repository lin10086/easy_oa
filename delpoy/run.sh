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
echo  自动化部署脚本启动
echo =================================

echo 进入项目文件夹
cd /usr/git/testRepository.git/easy_oa

echo 开始pull版本
git pull

echo 开始编译文件
mvn clean package -Dmaven.test.skip=true

echo 进入编译号的包文件
cd /usr/git/testRepository.git/easy_oa/target
echo 对新包进行重命名
mv oasys-0.0.1-SNAPSHOT.war ROOT.war

echo 关闭tomcat服务器
sh /usr/tomcat/server/bin/shutdown.sh

echo 删除以往文件
rm -rf /usr/tomcat/apache-tomcat-8.5.50/webapps/ROOT

echo 移动老war包
mv /usr/tomcat/apache-tomcat-8.5.50/webapps/ROOT.war /usr/gitback

echo 把新包移动到webapps下
mv /usr/git/testRepository.git/easy_oa/target/ROOT.war /usr/tomcat/apache-tomcat-8.5.50/webapps
echo 重启服务器
sh /usr/tomcat/server/bin/startup.sh

echo 查看项目日志
tail -f /usr/tomcat/apache-tomcat-8.5.50/logs/catalina.out