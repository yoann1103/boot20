# 说明
## chapter02
### https配置
> jdk（1.8）的数字证书管理工具keytool，该工具在$JAVA_HOME/bin下，通过这个工具可以生成一个数字证书，生成命令如下：
> ```bat
> keytool -genkey -alias tomcathttps -keyalg RSA -keysize 2048 -keystore sang.p12 -validity 365
> ```
> * -genkey表示要创建一个新的密钥
> * -alias表示keystore的别名
> * -keyalg表示使用的加密算法是RSA，一种非对称加密算法
> * -keysize表示密钥的长度
> * -keystore表示生成密钥存放位置
> * -validity表示密钥的有效时间，单位为天