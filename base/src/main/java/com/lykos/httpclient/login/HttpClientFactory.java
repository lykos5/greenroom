package com.lykos.httpclient.login;

import com.lykos.httpclient.ContentType;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * Created by liujun on 16/11/18.
 */
public abstract class HttpClientFactory {

    public HttpClientContext clientContext = HttpClientContext.create();
    public CookieStore cookieStore = new BasicCookieStore();

    protected void login(CloseableHttpClient closeableHttpClient){

    }

    public CloseableHttpClient getInstance(){
//        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        CloseableHttpClient closeableHttpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        login(closeableHttpClient);
        return closeableHttpClient;
    }

    protected void setDefaultHeader(HttpPost post) {
       // post.setHeader("Host", "sqladmin.tuniu.org");
        //post.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.98 Safari/537.36");
//        post.setHeader("Accept",
//                "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
    }

    protected UrlEncodedFormEntity getUrlEncodedFormEntity(Object param, String encoding) {
        try {
            if (encoding == null) {
                encoding = "utf-8";
            }
            List<NameValuePair> formparams = new ArrayList();
            if (param != null) {
                Map map = (Map) param;
                Set set = map.keySet();
                Iterator iterator = set.iterator();
                while (iterator.hasNext()) {
                    Object key = iterator.next();
                    Object value = map.get(key);
                    if (value == null) {
                        continue;
                    }
                    formparams.add(new BasicNameValuePair(key.toString(), value.toString()));
                }
                UrlEncodedFormEntity httpEntity = new UrlEncodedFormEntity(formparams, encoding);
                httpEntity.setContentType(ContentType.FORM_URLENCODED.getEn());
                httpEntity.setContentEncoding(encoding);

                return httpEntity;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
