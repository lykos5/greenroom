package com.lykos.thread;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/**
 * Created by Lykos on 16/1/6.
 */
public class ThreadLocalTest{

    public static void main(String [] args) throws Exception{
        ExecutorService executorService = ThreadPoolFactory.getExecutorService();
        for(int i=0;i<5;i++){
            MessageCallable call1 = new MessageCallable(i);
            executorService.submit(call1);
        }
        executorService.shutdown();
        while (!executorService.isTerminated()){
            //System.out.println(ThreadLocalUtil.localMap);
        }
    }
}

class MessageCallable implements Callable {
    private int index;
    public MessageCallable(int index){
        this.index = index;
    }
    @Override
    public Object call() throws Exception {
        try{
            System.out.println("这是线程："+index+"开始,输入任意结束");
            ThreadLocalUtil.localMap.set("threadlocal:"+index);
            BufferedReader br  = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
            br.readLine();
            System.out.print(ThreadLocalUtil.localMap.get());
            System.out.println("------这是线程："+index+"结束");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return index;
    }
}

class ThreadLocalUtil{
    public static ThreadLocal<String> localMap = new ThreadLocal();
}
