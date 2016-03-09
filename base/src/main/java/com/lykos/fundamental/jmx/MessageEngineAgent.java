package com.lykos.fundamental.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by Lykos on 16/3/8.
 */
public class MessageEngineAgent {
    public void start(){
        try {
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            ObjectName mxBeanName = new ObjectName("com.lykos.fundamental.jmx:type=MessageEngine");
            MessageEngineMXBean mxBean = new MessageEngine();
            mbs.registerMBean(mxBean, mxBeanName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
