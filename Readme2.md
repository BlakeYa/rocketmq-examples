##注意： 此程序可以正常跑起来：

如果跑起来，发送消息失败。则需要检查本地的RocketMQ服务是否正确启动，建议先关掉RocketMQ

的nameSpaces、borker进程。 然后重新启动， 一定要看到启动成功的日志。  



[RocketMQ 官网](https://rocketmq.apache.org/docs/quickStart/01quickstart/)

### start namesrv
$ nohup sh bin/mqnamesrv &

### verify namesrv 
$ tail -f ~/logs/rocketmqlogs/namesrv.log
The Name Server boot success...



### start broker
$ nohup sh bin/mqbroker -n localhost:9876   &

### verify broker
$ tail -f ~/logs/rocketmqlogs/proxy.log 
The broker[broker-a,192.169.1.2:10911] boot success...



## Send and Receive Messages with tools

$ export NAMESRV_ADDR=localhost:9876
$ sh bin/tools.sh org.apache.rocketmq.example.quickstart.Producer
 SendResult [sendStatus=SEND_OK, msgId= ...

$ sh bin/tools.sh org.apache.rocketmq.example.quickstart.Consumer
 ConsumeMessageThread_%d Receive New Messages: [MessageExt...



## Shutdown Servers

$ sh bin/mqshutdown broker
The mqbroker(36695) is running...
Send shutdown request to mqbroker(36695) OK

$ sh bin/mqshutdown namesrv
The mqnamesrv(36664) is running...
Send shutdown request to mqnamesrv(36664) OK