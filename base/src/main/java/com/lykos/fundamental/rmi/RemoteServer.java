package com.lykos.fundamental.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * 远程服务接口
 * Created by Lykos on 16/3/9.
 */
public interface RemoteServer extends Remote {
    public int say() throws RemoteException;
}
