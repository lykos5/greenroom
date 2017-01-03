package com.lykos.socket;


import com.oracle.tools.packager.IOUtils;

import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by liujun on 16/11/24.
 * 模仿tomcat服务
 */
public class ServerSocketDemo {

    private static ServerSocket serverSocket;
    //端口
    private static int port = 8080;
    //队列最大等待数
    private static int backlog = 2;

    public static void main(String[] args) throws Exception {
        serverSocket = new ServerSocket(port,backlog,InetAddress.getByName("127.0.0.1"));
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(()->{
                try {
                    BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                    OutputStream out = socket.getOutputStream();
                    PrintWriter printWriter = new PrintWriter(out);
                    int i = 2048;
                    StringBuffer sb = new StringBuffer("");
                    byte[] mess = new byte[i];
                    while(i==2048){
                        i = bis.read(mess);
                        sb.append(new String(mess,0,i, "utf-8"));
                    }
                    printWriter.println("你好hello");
                    printWriter.flush();
                    printWriter.close();
                    System.out.println(sb.toString());
                    socket.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }).start();

        }
    }
}
