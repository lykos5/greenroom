package com.lykos.fundamental.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * MXbean 实现部分
 * 在JMX中，还有一个重要的概念是Notification。构成Notification的几个接口是：
 * NotificationEmitter, 只要实现此接口，就可以发出Notification和订阅Notification. 类NotificationBroadcasterSupport则实现了NotificationEmitter.
 * NotificationListener, 实现此接口的可以订阅JMX的Notification。
 * Notification, 消息本身
 * Created by Lykos on 16/3/8.
 */
public class MessageEngine extends NotificationBroadcasterSupport implements MessageEngineMXBean {

    private final  Message message = Echo.message;
    private long sequenceNumber = 1;

    public MessageEngine(){
        addNotificationListener((n,m)->{
            System.out.println("when new MessageEngine that addNotificationListener ,this sequenceNumber="+sequenceNumber+"\n message title:"+message.getTitle());
        },null,null);
    }

    @Override
    public String getName(){
        return "哈哈";
    }

    @Override
    public void setName(String name) {
        System.out.println(name);
    }

    @Override
    public void stop() {
        Echo.running = false;
    }

    @Override
    public boolean isPaused() {
        return Echo.pause;
    }

    @Override
    public void pause(boolean pause) {
        Notification n = new AttributeChangeNotification(this,sequenceNumber++,System.currentTimeMillis(),
                "pause has changed","pause","boolean",Echo.pause,pause);
        Echo.pause = pause;
        this.sendNotification(n);
    }


    // 规定可以发送的Notification Type，不在Type list中的Notification不会被发送
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = new MBeanNotificationInfo(new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        }, name, description);
        return new MBeanNotificationInfo[]{info};
    }

    @Override
    public Message getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(Message message) {
        this.message.setName(message.getName());
        this.message.setTitle(message.getTitle());
        this.message.setDesc(message.getDesc());
    }
}
