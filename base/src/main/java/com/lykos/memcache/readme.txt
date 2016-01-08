memcache有关操作

------------------------------------memcache----------------------------
memcache 是一套分布式的高速缓存系统,在内存中维护一个巨大的HashTable(K-V)，但内存空间总是有限的，当内存

- 不够用的时候，会使用LRU(Latest Recently Used)算法,即将不常用的删除掉，留下常用数据.
- 客户端与服务器采用TCP协议之上的memcache协议
- 发送数据类型：文本行和非结构数据
- memcache存储是以键来唯一标识的，最大长度250个字符
- memcache本身不是一种分布式缓存，它的分布式是由访问它的客户端来实现的
- memcache-session-manager高可用Tomcat session共享解决方案

memcache安装

由于memcache使用的libevent来进行高效的网络连接处理，因此安装memcache之前必须先安装 libevent

安装步骤：
    1.解压下载的.tar.gz  (tar-xf)
     2.配置、编译、安装  ./configure
     3.make
     4.sudo make install

重启：
memcached -d -p 11211

-d 表示启动一个守护进程
-m指定分配的内在数量，单位Mb
-p监听端口，默认11211
-P  pid文件保存位置




MemcacheUtil  xmemcache工具应用