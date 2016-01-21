package com.lykos.httpclient;

/**
 * Created by Lykos on 16/1/21.
 */
public class ContentTypeVO {
    private ContentType contentType;
    private String charset;

    public ContentTypeVO(String contentType, String charset) {
        this.contentType = ContentType.getContentType(contentType);
        this.charset = charset;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public String getCharset() {
        return charset;
    }
}
