package com.lykos.httpclient;

import com.lykos.common.annotation.HttpParam;
import com.lykos.httpclient.parse.ApplicationJsonParse;
import com.lykos.httpclient.parse.StringParse;
import com.lykos.jackson.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.*;

/**
 * Created by Lykos on 16/1/21.
 */
public class HttpUtil {


    public static final String DEFAULT_CHARSET = "UTF-8";

    private static HttpUtil httpUtil = null;

    private HttpUtil(){}

    private static HttpUtil getInstance(){
        if(httpUtil==null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public static Object execute(String baseUrl, HttpParam httpParam, Object param){
        HttpUtil httpUtil = getInstance();
        if(StringUtils.isNotBlank(httpParam.value())){
            baseUrl+= "/"+httpParam.value();
        }
        switch (httpParam.method()){
            case GET:
                return httpUtil.executeGet(baseUrl,param, httpParam);
            case PUT:
                return httpUtil.executePut(baseUrl,param, httpParam);
            default:
                return httpUtil.executePost(baseUrl,param, httpParam);
        }
    }


    private Object executeGet(String url,Object param, HttpParam httpParam){
        Map<String,Object> map = (Map)param;
        CloseableHttpClient httpClient = getHttpClient();
        try{

            if(param != null){
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    params.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
                }

                if (params.size() > 0) {
                    url += "?" + URLEncodedUtils.format(params, "UTF-8");
                }
            }


            HttpGet httpget = new HttpGet(url);
            addHeader(httpget,httpParam.headers());

            // 执行get请求.
            CloseableHttpResponse response = httpClient.execute(httpget);

            try{
                statusCodeHandle(response.getStatusLine().getStatusCode());
                return parseResponseBody(response.getEntity());
            }finally {
                response.close();
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用http请求出错[ " + e.getMessage() + "]");
        } finally {

            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭http连接出错[ " + e.getMessage() + "]");
            }
        }
    }


    private Object executePost(String url,Object param,HttpParam httpParam){
        return execute(param,httpParam,new HttpPost(url));
    }

    private Object executePut(String url,Object param,HttpParam httpParam){
        return execute(param,httpParam,new HttpPut(url));
    }

    private HttpEntity getStringEntity(Object params,String encoding){
        if(params != null){
            StringEntity entity = new StringEntity(JsonUtil.serialize(params), encoding);//解决中文乱码问题

            entity.setContentEncoding(encoding);
            entity.setContentType(ContentType.APPLICATION_JSON.getEn());
            return entity;
        }
        return null;
    }


    private UrlEncodedFormEntity getUrlEncodedFormEntity(Object param, String encoding) throws Exception {
        List<NameValuePair> formparams = new ArrayList();
        if(param != null){
            Map map = (Map) param;
            Set set = map.keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Object key = iterator.next();
                Object value = map.get(key);
                if(value==null){
                    continue;
                }
                formparams.add(new BasicNameValuePair(key.toString(), value.toString()));
            }
            UrlEncodedFormEntity httpEntity =  new UrlEncodedFormEntity(formparams, encoding);
            httpEntity.setContentType(ContentType.FORM_URLENCODED.getEn());
            httpEntity.setContentEncoding(encoding);

            return httpEntity;
        }

        return null;
    }




    private Object execute(Object param,HttpParam httpParam,HttpEntityEnclosingRequestBase httpPost){
        CloseableHttpClient httpClient = getHttpClient();
        try{
            HttpEntity entity = null;
            switch (httpParam.contentType()){
                case APPLICATION_JSON:
                    entity = getStringEntity(param,httpParam.charset());
                case FORM_URLENCODED:
                    entity = getUrlEncodedFormEntity(param,httpParam.charset());

            }
            if(entity != null)
                httpPost.setEntity(entity);

            CloseableHttpResponse response = httpClient.execute(httpPost);

            try{
                statusCodeHandle(response.getStatusLine().getStatusCode());

                return parseResponseBody(response.getEntity());
            }finally {
                response.close();
            }

        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("调用http请求出错[ " + e.getMessage() + "]");
        } finally {

            // 关闭连接,释放资源
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭http连接出错[ " + e.getMessage() + "]");
            }
        }
    }



    /**
     * 添加header
     * @param httpRequestBase
     */
    private void addHeader(HttpRequestBase httpRequestBase,String headers []){
        if(headers != null && headers.length > 0){
            for(String header : headers){
                int mIndex = header.indexOf(":");
                if(mIndex<0){
                    continue;
                }
                httpRequestBase.addHeader(header.substring(0,mIndex),header.substring(mIndex+1));
            }

        }

    }

    /**
     * 处理状态码
     *
     * @param statusCode
     */
    private void statusCodeHandle(int statusCode) {
        if (statusCode > 300) {
            throw new RuntimeException("返回状态码为[ " + String.valueOf(statusCode) + "]");
        }

    }

    /**
     * 解析返回的body
     * @param httpEntity
     * @return
     * @throws Exception
     */
    private Object parseResponseBody(HttpEntity httpEntity) throws Exception {
        Header header = httpEntity.getContentType();
        ContentTypeVO contentTypeObj = parseContentType(header.getValue());
        switch (contentTypeObj.getContentType()){
            case APPLICATION_JSON:
                return new ApplicationJsonParse().parse(httpEntity,contentTypeObj.getCharset());
            default :
                return new StringParse().parse(httpEntity,contentTypeObj.getCharset());
        }
    }


    /**
     * 解析返回的contenttype
     * @param contentTypeStr
     * @return
     */
    private ContentTypeVO parseContentType(String contentTypeStr){
        int dotIndex = contentTypeStr.indexOf(";");
        ContentTypeVO contentTypeObj;
        if(dotIndex > 0){
            String contentType = contentTypeStr.substring(0,dotIndex);

            int charsetIndex = contentTypeStr.indexOf("=");
            String charset = DEFAULT_CHARSET;

            if(charsetIndex > 0)
                charset= contentTypeStr.substring(charsetIndex+1);


            contentTypeObj = new ContentTypeVO(contentType,charset);
        }else {
            contentTypeObj = new ContentTypeVO(contentTypeStr,DEFAULT_CHARSET);
        }


        return contentTypeObj;
    }




    /**
     * 创建httpclient 对象
     * @return
     */
    private CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }

}

