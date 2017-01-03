package com.lykos.httpclient.login;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.*;

/**
 * Created by liujun on 16/11/18.
 */
public class UniversityHttpClient extends HttpClientFactory {

    @Override
    protected void login(CloseableHttpClient closeableHttpClient) {
        try {
            super.login(closeableHttpClient);
            HttpPost httpPost = new HttpPost("http://localhost:8080/login");
            setDefaultHeader(httpPost);
            Map r = new HashMap<>();
            r.put("username", "lykos");
            r.put("password", "1234");
            httpPost.setEntity(getUrlEncodedFormEntity(r, null));
            HttpResponse response = closeableHttpClient.execute(httpPost,clientContext);
//            HttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(response.getStatusLine().getStatusCode()==302){
                Arrays.stream(response.getAllHeaders()).forEach(it->{
                    System.out.println(it.getName()+":"+it.getValue());
                });
            }
            System.out.println(EntityUtils.toString(entity));
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
