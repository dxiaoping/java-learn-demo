查看centos版本:cat /etc/redhat-release

mysql启动： systemctl start mysqld.service

mysql 修改密码：https://blog.csdn.net/fannyoona/article/details/106203748

服务器文件上传：https://www.cnblogs.com/yellowgg/p/11686050.html

nacos启动：https://blog.csdn.net/cww2010/article/details/117535607 ./startup.sh -m standalone
###redis常用命令：
* redis连接命令： redis-cli -h xxx.xxx.xx.x -p 6376
* redis启动： redis-server redis.conf
* redis停止：redis-cli -h 127.0.0.1 -p 6379 shutdown
* 查看redis运行状况：ps aux |grep redis
* 创建集群：./redis-cli -a Dxp@123 --cluster create --cluster-replicas 1 47.101.72.84:6301 47.101.72.84:6311 47.101.72.84:6321 47.101.72.84:6302 47.101.72.84:6312 47.101.72.84:6322
    