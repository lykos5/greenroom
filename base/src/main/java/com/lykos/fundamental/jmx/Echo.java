package com.lykos.fundamental.jmx;

/**
 * Created by Lykos on 16/3/8.
 */
public class Echo {
    public static Message message = new Message();
    public static boolean running = true;
    public static boolean pause = false;

    public static void main(String[] args) {
        System.out.println(args[0]);
        // 开启JMX Agent。如果不需要JMX,只是单独运行程序，请屏蔽掉下面这行代码。
        System.out.println(System.getProperty("com.sun.management.jmxremote.port"));
        new MessageEngineAgent().start();
        while(running) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!pause) message.echo();
        }
    }
}
