package com.lykos.fundamental.rmi;

import java.rmi.Naming;

/**
 * Created by Lykos on 16/3/9.
 */
public class RemoteClientMain {

    public static void main(String[] args) throws Exception {
        String url = "rmi://localhost:9099/myremote";
        RemoteServer remoteServer;
        remoteServer = (RemoteServer) Naming.lookup(url);
        System.out.println(remoteServer.say());
    }
}
