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
            ObjectName mxBeanName = new ObjectName("myapp:type=这是type,name=这是name");
            ObjectName mxBeanName1 = new ObjectName("myapp:type=这是type,name=这是name1");
            MessageEngineMXBean mxBean = new MessageEngine();
            MessageEngineMXBean mxBean2 = new MessageEngine();
            mbs.registerMBean(mxBean, mxBeanName);
            mbs.registerMBean(mxBean2, mxBeanName1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
