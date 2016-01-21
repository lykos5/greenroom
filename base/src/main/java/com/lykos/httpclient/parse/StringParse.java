package com.lykos.httpclient.parse;

import org.apache.http.HttpEntity;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by Lykos on 16/1/21.
 */
public class StringParse implements IResponseParse {
    @Override
    public Object parse(HttpEntity entity, String charset) throws IOException {
        return EntityUtils.toString(entity,charset);
    }
}
