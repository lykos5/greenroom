package com.lykos.httpclient.login;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;


/**
 * Created by liujun on 16/11/18.
 */
public class UniversityHttpClientTest {
    @Test
    public void login() throws Exception{
        UniversityHttpClient client = new UniversityHttpClient();
        CloseableHttpClient httpClient = client.getInstance();
        HttpGet httpGet = new HttpGet("");
        HttpResponse response = httpClient.execute(httpGet);
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));
        client.clientContext.getCookieStore().getCookies().forEach(it->{
            System.out.println(it.getName()+":"+it.getValue());
        });
        client.cookieStore.getCookies().stream().forEach(it->{
            System.out.println(it.getName()+":"+it.getValue());
        });
    }

    @Test
    public void TestThread(){
        Thread tt = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().isDaemon());
                System.out.println("----------------");
            }
        });
        tt.start();
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static void main(String[] args) {
        Thread tt = new Thread(()->{
            while (true){
                System.out.println(Thread.currentThread().isDaemon());
                System.out.println("----------------");
            }
        });
        tt.start();
        System.out.println(Thread.currentThread().isDaemon());

    }
}