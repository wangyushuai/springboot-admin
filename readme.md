# SpringBoot2.x 整合 SpringBoot-Admin 监控
author: yushuai_w@163.com

内容：
1. SpringBoot2.x 整合 SpringBoot-Admin 监控
2. 包含client及Server


更新日志：
1. 当前节点： 单体实例监控
2. Demo download : https://github.com/wangyushuai/springboot-admin

效果预览：
![Server](https://img-blog.csdnimg.cn/20181206103724864.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NodWFpX3d5,size_16,color_FFFFFF,t_70)

![Server](https://img-blog.csdnimg.cn/20181206103619156.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NodWFpX3d5,size_16,color_FFFFFF,t_70)


## 1.1 新建Mavne聚合工程

### 1.1.1 新建一个SpringBoot 父级项目
注意事项：
- 删除porm.xml 文件中的 	<relativePath/>
- 将父级项目打包成pom 
```
<groupId>com.example</groupId>
<artifactId>springboot-admin</artifactId>
<version>0.0.1-SNAPSHOT</version>
<packaging>pom</packaging>
```

### 1.2 新建子模块(new Module)
1. 新建SpringBoot子项目
2. 并将子项目的porm文件中的父级配置为 1步骤建好的父级项目(这样就实现了由负极项目控制个版本号)
```
<parent>
    <groupId>com.example</groupId>
    <artifactId>springboot-admin</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</parent>
```

## 1.3 配置Server端
1. 引入依赖

```

	<dependency>
		<groupId>de.codecentric</groupId>
		<artifactId>spring-boot-admin-starter-server</artifactId>
		 <version>2.1.1</version>
	</dependency>

```

3. 设置端口号
```
server.port = 8090
```
4. 添加启动类注解
```
@Configuration
@EnableAutoConfiguration
@EnableAdminServer
```

## 1.4 配置Client端
1. 添加依赖
```
  <dependency>
       <groupId>de.codecentric</groupId>
       <artifactId>spring-boot-admin-starter-client</artifactId>
       <version>2.1.1</version>
   </dependency>
```

2. 配置文件
```$xslt
# 服务端监控地址
spring.boot.admin.client.url=http://127.0.0.1:8090
# 本机IP
spring.boot.admin.client.instance.service-base-url=http://127.0.0.1:8080/
# 开放监控内容
management.endpoints.web.exposure.include=*  
# health/detail 细节（）
management.endpoint.health.show-details = always



