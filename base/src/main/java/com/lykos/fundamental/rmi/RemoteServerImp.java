package com.lykos.fundamental.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程服务接口的实现
 * Created by Lykos on 16/3/9.
 */
public class RemoteServerImp extends UnicastRemoteObject implements RemoteServer {

    public RemoteServerImp() throws RemoteException {
        super();
    }

    @Override
    public int say() throws RemoteException{
        System.out.println("this is say method");
        return 1;
    }
}
