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


