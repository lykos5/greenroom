package com.lykos.fundamental.jmx;

/**
 *
 * 定义MXBean的接口，注意命名规则，必须以MXBean结尾。
 * Created by Lykos on 16/3/8.
 */
public interface MessageEngineMXBean {
    void stop();//结束进程
    boolean isPaused();//判断进程是否暂停
    void pause(boolean pause);//暂停或者继续进行
    Message getMessage();
    void setMessage(Message message);//修改message
    String getName();
    void setName(String name);
}
