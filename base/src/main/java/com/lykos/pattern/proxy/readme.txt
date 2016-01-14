

---------------------------------------代理模式--------------------
动态代理:
   1.代理类与被代理类都实现同一个接口(主题)
   2.新建一个实现InvocationHander接口类,并实现其invoke方法
        a.invoke方法三个参数:proxy-代理类  method-接口方法  args[]--方法参数
        b.一般代理方法去掉Object方法
   3.利用jdk  Proxy.newProxyInstance生成代理类