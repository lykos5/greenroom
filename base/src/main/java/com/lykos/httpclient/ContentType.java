package com.lykos.httpclient;

/**
 *
 * 客户端请求,方式
 * http  contentType
 * Created by Lykos on 16/1/21.
 */
public enum ContentType {
    APPLICATION_JSON("application/json","json请求"),FORM_URLENCODED("application/x-www-form-urlencoded","表单提交"),
    TEXT_HTML("text/html","html数据");

    private String cn;
    private String en;

    ContentType(String en,String cn){
        this.cn = cn;
        this.en = en;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }


    public static ContentType getContentType(String contentType){
        if(contentType.equals(APPLICATION_JSON.getEn())){
            return APPLICATION_JSON;
        }else if(contentType.equals(FORM_URLENCODED.getEn())){
            return FORM_URLENCODED;
        }else if(contentType.equals(TEXT_HTML.getEn())){
            return TEXT_HTML;
        }
        return null;
    }
}
