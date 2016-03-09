package com.lykos.fundamental.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Lykos on 16/3/9.
 */
public class RemoteServerMain {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(9099);

            //创建远程对象实例
            RemoteServer remoteServer = new RemoteServerImp();

            //把对象实例注册到rmi服务器上
            Naming.bind("rmi://localhost:9099/myremote",remoteServer);
            System.out.println("remote server is ready");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
